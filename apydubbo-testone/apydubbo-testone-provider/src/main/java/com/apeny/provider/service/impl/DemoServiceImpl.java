package com.apeny.provider.service.impl;

import com.apeny.api.service.DemoService;

import java.util.concurrent.TimeUnit;

/**
 * Created by apeny on 2017/11/19.
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name)
    {
        /*try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("say hello consume " + 15);
        return "hello from provider: " + name;
    }
}
