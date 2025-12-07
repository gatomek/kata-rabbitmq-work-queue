package pl.gatomek.rabbitmq.demo.producer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {
    public static final String SAVE_LOG_WORK_QUEUE = "save-log-work-queue";

    @Bean
    Queue queue() {
        return new Queue(SAVE_LOG_WORK_QUEUE);
    }
}
