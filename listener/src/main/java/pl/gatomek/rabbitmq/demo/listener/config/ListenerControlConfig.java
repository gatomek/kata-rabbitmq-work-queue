package pl.gatomek.rabbitmq.demo.listener.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.gatomek.rabbitmq.demo.listener.listener.ControlReceiver;

@Profile("control")
@Configuration
public class ListenerControlConfig {

    public static final String SAVE_LOG_WORK_QUEUE = "save-log-work-queue";

    @Bean
    MessageListenerAdapter listenerAdapter(ControlReceiver controlReceiver) {
        return new MessageListenerAdapter(controlReceiver, "receiveMessage");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(SAVE_LOG_WORK_QUEUE);
        container.setMessageListener(listenerAdapter);
        container.setPrefetchCount(1);
        return container;
    }
}
