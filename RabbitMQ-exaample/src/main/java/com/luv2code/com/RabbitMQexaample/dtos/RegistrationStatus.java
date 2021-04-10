package com.luv2code.com.RabbitMQexaample.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RegistrationStatus {

    public User user;
    public String status;
    public String message;
}
