package com.luv2code.com.RabbitMQexaample.consumer;

import com.luv2code.com.RabbitMQexaample.dtos.RegistrationStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import static com.luv2code.com.RabbitMQexaample.constants.constants.*;


@Component
public class User {

    @RabbitListener(queues = QUEUE)
    public void consumeMessageFromQueue(RegistrationStatus registrationStatus) {
        System.out.println("Email Received: " + registrationStatus);
    }
}
