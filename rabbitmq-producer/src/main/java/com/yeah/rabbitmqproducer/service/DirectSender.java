package com.yeah.rabbitmqproducer.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DirectSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String queueName) {
        rabbitTemplate.convertAndSend(queueName, "hello liye");
    }
}
