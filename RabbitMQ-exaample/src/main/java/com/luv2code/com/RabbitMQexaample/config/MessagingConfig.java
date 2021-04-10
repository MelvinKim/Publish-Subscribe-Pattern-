package com.luv2code.com.RabbitMQexaample.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.luv2code.com.RabbitMQexaample.constants.constants.*;


//since it's a configuration class, we add @Configuration
@Configuration
public class MessagingConfig {

    //Queue
    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    //Topic/exchange
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE);
    }

    //Bind the topic and the queue
    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(queue)
                .to(topicExchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter() {
        //converts the messages to objects
        return new Jackson2JsonMessageConverter();
    }

    //we can publish event to queue or we can consume it
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

















}
