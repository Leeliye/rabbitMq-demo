package com.yeah.rabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    //队列1
    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanout.a");
    }

    //队列2
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("fanout.b");
    }

    //队列3
    @Bean
    public Queue fanoutQueue3(){
        return new Queue("fanout.c");
    }

    //交换器
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    //绑定交换器和队列1
    @Bean
    Binding bindingFanout1(){
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    //绑定交换器和队列2
    @Bean
    Binding bindingFanout2(){
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    //绑定交换器和队列3
    @Bean
    Binding bindingFanout3(){
        return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange());
    }

}
