package pl.gatomek.rabbitmq.demo.producer.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.gatomek.rabbitmq.demo.producer.service.SendNotificationUserCase;

@RequiredArgsConstructor
@Component
public class ScheduledTask {

    private final SendNotificationUserCase sendNotificationUserCase;

    @Scheduled(cron = "*/15 * * * * *")
    public void task() {
        sendNotificationUserCase.sendNotification();
    }
}
