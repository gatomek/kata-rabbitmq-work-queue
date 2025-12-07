package pl.gatomek.rabbitmq.demo.producer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class ProducerConfig {
    
    private final CommonConfig commonConfig;

    @Bean
    Queue queue() {
        return new Queue(commonConfig.getWorkQueueName());
    }
}
