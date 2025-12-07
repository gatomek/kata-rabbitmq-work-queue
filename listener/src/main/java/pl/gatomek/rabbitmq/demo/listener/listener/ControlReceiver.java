package pl.gatomek.rabbitmq.demo.listener.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.gatomek.rabbitmq.demo.listener.exception.CustomInterruptedException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

@Slf4j
@Component
@Profile("control")
public class ControlReceiver {

    public static final String THROW_EXCEPTION_WHILE_PROCESSING = "0";

    @Value("${controlfile.filepath}")
    private String controlFilePath;

    public void receiveMessage(String message) throws IOException, InterruptedException {
        log.info("Received: <{}>", message);
        Thread.sleep(Duration.ofSeconds(1));

        String content = Files.readString(Paths.get(controlFilePath));
        if (THROW_EXCEPTION_WHILE_PROCESSING.equals(content)) {
            log.info("File content: {}", content);
            log.info("Throwing custom interrupted exception");
            throw new CustomInterruptedException();
        }
    }
}
