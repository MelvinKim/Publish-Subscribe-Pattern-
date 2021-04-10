package com.luv2code.com.RabbitMQexaample.publisher;

//so basically this is a endpoint, which publishes Topics to the Queue

import com.luv2code.com.RabbitMQexaample.dtos.RegistrationStatus;
import com.luv2code.com.RabbitMQexaample.dtos.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.luv2code.com.RabbitMQexaample.constants.constants.*;

import java.util.UUID;

@RestController
@RequestMapping("/signup")
public class publisher {

    //inject the RabbitTemplate
    @Autowired
    private RabbitTemplate template;

    @PostMapping
    public String signup(@RequestBody User user) {

        user.setUserId(UUID.randomUUID().toString());

        RegistrationStatus registrationStatus = new RegistrationStatus(user, "PROGRESS", "Please check your Email");

        //publish to Queue
        template.convertAndSend(EXCHANGE, ROUTING_KEY, registrationStatus);

        return "Success!!";
    }


}
