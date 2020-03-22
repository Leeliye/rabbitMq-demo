package com.yeah.rabbitmqproducer.controller;

import com.yeah.rabbitmqproducer.service.DirectSender;
import com.yeah.rabbitmqproducer.service.FanoutSender;
import com.yeah.rabbitmqproducer.service.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RabbitController {

    @Autowired
    private DirectSender directSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private TopicSender topicSender;

    @GetMapping(value = "/test/rabbit")
    public void testRabbit(){
//        this.directSender.send("test_queue");
//        this.fanoutSender.fanSender1();
//        this.fanoutSender.fanSender2();
        topicSender.topicSend1();
        topicSender.topicSend2();
        topicSender.topicSend3();
    }
}
