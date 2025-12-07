package pl.gatomek.rabbitmq.demo.listener.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
@Profile("!control")
public class Receiver {
    public void receiveMessage(String message) throws InterruptedException {
        log.info("Received <{}>", message);
        Thread.sleep(Duration.ofSeconds(1));
    }
}
