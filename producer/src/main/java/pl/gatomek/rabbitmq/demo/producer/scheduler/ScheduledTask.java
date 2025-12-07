package pl.gatomek.rabbitmq.demo.producer.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.gatomek.rabbitmq.demo.producer.service.SendNotificationUseCase;

@RequiredArgsConstructor
@Component
public class ScheduledTask {

    private final SendNotificationUseCase sendNotificationUseCase;

    @Scheduled(cron = "${producer.cron}")
    public void sendScheduledNotification() {
        sendNotificationUseCase.sendNotification();
    }
}
