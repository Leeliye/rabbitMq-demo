package com.yeah.rabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * Topic模式就相当于发布订阅模式交换机和队列之间加上了一定的匹配规则。
 * 只有符合规则的消息才能到这个队列中去从而被接收者收到
 *
 */
public class TopicConfig {
    /**
     * . 为分隔符，*代表一个，#表示0个或者多个，
     * 如上面的topic.#就可已匹配，topic，topic.z，topic.ma.z.z.z等，
     * 而topic.*.z就可以匹配topic.m.z,topic.z.z等，
     * 而topic.msg就只能匹配topic.msg条件的消息
     *
     * @return
     */
    @Bean
    public Queue topicQueue1(){
        return new Queue("topic.a");
    }
    @Bean
    public Queue topicQueue2(){
        return new Queue("topic.b");
    }
    @Bean
    public Queue topicQueue3(){
        return new Queue("topic.c");
    }

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("topic.msg");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.#");
    }

    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(topicQueue3()).to(topicExchange()).with("topic.*.z");
    }
}
