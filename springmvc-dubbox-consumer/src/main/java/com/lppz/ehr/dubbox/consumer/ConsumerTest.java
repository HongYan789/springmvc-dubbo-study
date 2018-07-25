package com.lppz.ehr.dubbox.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lppz.ehr.dubbox.provider.IUserService;
import com.lppz.ehr.util.HttpTinyClient;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dubbox-consumer.xml"})
public class ConsumerTest {

    private Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void testdubbo(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dubbox-consumer.xml");
        IUserService iUserService = (IUserService) applicationContext.getBean("iUserService");
        System.out.println(String.format("dubbo方式返回rest数据：%s",iUserService.queryById(3l)));
    }

    @Test
    public void testRestGet(){
        List<Object> params = new ArrayList<Object>();
        params.add("name");
        params.add("xiaolizi");

        List<String> headers = new ArrayList<String>();
        headers.add("Content-Type");
        headers.add("application/json");

        try {
            String url = "http://127.0.0.1:20881";
            HttpTinyClient.HttpResult httpResult = HttpTinyClient.httpGet(url+"/users/register", headers, params, 3000);
            Object data = httpResult.content;
            System.out.println(String.format("第三方方式返回的rest数据为：%s",data));
        } catch (IOException e) {
            logger.error("请求异常:{}");
            throw new InternalException(String.format("请求异常:%s", e.getMessage()));
        }
    }

    @Test
    public void testRestPost(){
        JSONObject json = new JSONObject();
        json.put("id","5");
        json.put("name","xiaolizi");
        json.put("createTime",new Date());
        String params = json.toJSONString();

        List<String> headers = new ArrayList<String>();
        headers.add("Content-Type");
        headers.add("application/json");

        try {
            String url = "http://127.0.0.1:20881";
            HttpTinyClient.HttpResult httpResult = HttpTinyClient.httpPost(url+"/users/regist", headers, params, 3000);
            JSONObject data = JSON.parseObject(httpResult.content);
            System.out.println(String.format("第三方方式返回的rest数据为：%s",data));
        } catch (IOException e) {
            logger.error("请求异常:{}");
            throw new InternalException(String.format("请求异常:%s", e.getMessage()));
        }
    }
}
