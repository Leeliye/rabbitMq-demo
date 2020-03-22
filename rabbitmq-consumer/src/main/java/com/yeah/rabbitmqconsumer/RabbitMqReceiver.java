package com.yeah.rabbitmqconsumer;


//import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RabbitMqReceiver {

    @RabbitListener(queues = "test_queue")
    public void receiver (String context, @Headers Map<String, Object> headers, Channel channel) throws Exception {
        System.out.println("消费消息：::::" + context);
//        throw new Exception("error !!!");
        // 手动ack
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // 手动签收
        channel.basicAck(deliveryTag, false);
    }

//    @RabbitListener(queues = "fanout.a")
//    public void receiver1(String message){
//        System.out.println("fanout.a:"+message);
//    }
//
//    @RabbitListener(queues = "fanout.b")
//    public void receiver2(String message){
//        System.out.println("fanout.b:"+message);
//    }
//
//    @RabbitListener(queues = "fanout.c")
//    public void receiver3(String message){
//        System.out.println("fanout.3:"+message);
//    }

    @RabbitListener(queues = "topic.a")
    public void receiver4(String message){
        System.out.println("topic.a:"+message);
    }

    @RabbitListener(queues = "topic.b")
    public void receiver5(String message){
        System.out.println("topic.b:"+message);
    }

    @RabbitListener(queues = "topic.c")
    public void receiver6(String message){
        System.out.println("topic.c:"+message);
    }


}
