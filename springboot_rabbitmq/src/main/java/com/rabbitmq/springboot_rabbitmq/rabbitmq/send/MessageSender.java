package com.rabbitmq.springboot_rabbitmq.rabbitmq.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MessageSender {
    @Autowired
    AmqpTemplate rabbitmqTemplate;

    public void send(String message){
        System.out.println("发送消息："+message);
        rabbitmqTemplate.convertAndSend("direct",message);
    }
}
