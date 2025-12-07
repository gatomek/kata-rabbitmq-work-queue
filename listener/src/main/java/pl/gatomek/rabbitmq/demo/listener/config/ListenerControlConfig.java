package pl.gatomek.rabbitmq.demo.listener.config;

import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.gatomek.rabbitmq.demo.listener.listener.ControlReceiver;

@Profile("control")
@Configuration
public class ListenerControlConfig {
    @Bean
    MessageListenerAdapter listenerAdapter(ControlReceiver controlReceiver) {
        return new MessageListenerAdapter(controlReceiver, "receiveMessage");
    }
}
