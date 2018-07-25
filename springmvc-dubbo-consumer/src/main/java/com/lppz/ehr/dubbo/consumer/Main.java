package com.lppz.ehr.dubbo.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lppz.ehr.dubbo.provider.DemoService;
import com.lppz.ehr.util.HttpTinyClient;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        DemoService demoService = (DemoService) applicationContext.getBean("demoService");
        System.out.println(demoService.say("hongyan"));
    }
}
