package com.rabbitmq.springboot_rabbitmq.controller;

import com.rabbitmq.springboot_rabbitmq.rabbitmq.send.MessageSender;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/rabbitmq")
public class MyRabbitmqController {
    @Autowired
    MessageSender sender;

    @Autowired
    private RedisTemplate stringRedisTemplate;

    //添加
    @RequestMapping(value="/redisAdd")
    @ResponseBody
    public String saveRedis(){

        stringRedisTemplate.opsForValue().set("b","test");
        return "saveRedis";
    }

    @RequestMapping(value="/check")
    @ResponseBody
    public Boolean check(){
       return  stringRedisTemplate.hasKey("b");
    }


    //获取
    @RequestMapping(value="/redisGet")
    @ResponseBody
    public String getRedis(){
        return stringRedisTemplate.opsForValue().get("b").toString();
    }

    @RequestMapping("/sender")
    @ResponseBody
    public String sender() throws InterruptedException {
        System.out.println("send string:hello world");
        for(int i=0;i<200;i++){
            sender.send("hello world"+i);

        }
        Thread.sleep(1000);
        return "sending...";
    }

}
