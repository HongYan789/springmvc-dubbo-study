package com.lppz.ehr.dubbo.provider.impl;

import com.lppz.ehr.dubbo.provider.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String say(String name) {
        return "sucesss!"+name;
    }
    @Override
    public String sayHello(String name) {
        return "Hello Dubbo,Hello " + name;
    }
}
