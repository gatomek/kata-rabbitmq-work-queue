package pl.gatomek.rabbitmq.demo.producer.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("classpath:common-config.properties")
public class CommonConfig {

    @Value("${workQueueName}")
    private String workQueueName;
}
