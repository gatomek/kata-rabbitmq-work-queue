package pl.gatomek.rabbitmq.demo.listener.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.gatomek.rabbitmq.demo.listener.listener.Receiver;

@RequiredArgsConstructor
@Profile("!control")
@Configuration
public class ListenerConfig {

    private final CommonConfig commonConfig;

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(commonConfig.getWorkQueueName());
        container.setMessageListener(listenerAdapter);
        container.setPrefetchCount(1);
        return container;
    }
}
