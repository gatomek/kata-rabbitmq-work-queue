package pl.gatomek.rabbitmq.demo.listener.config;

import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.gatomek.rabbitmq.demo.listener.listener.Receiver;

@Profile("!control")
@Configuration
public class ListenerConfig {
    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
