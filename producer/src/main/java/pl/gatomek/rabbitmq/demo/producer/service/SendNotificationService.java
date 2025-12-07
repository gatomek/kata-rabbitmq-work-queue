package pl.gatomek.rabbitmq.demo.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.amqp.core.Queue;

@RequiredArgsConstructor
@Service
@Slf4j
class SendNotificationService implements SendNotificationUseCase {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Override
    public void sendNotification() {
        Instant instant = Instant.now();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        String message = zdt.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        log.info("Sending: <{}>", message);
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}
