package com.apeny.provider.service.impl.concurrentservice;

import com.apeny.api.service.HelloService;

import java.util.concurrent.TimeUnit;

/**
 * Created by apeny on 2018/1/1.
 */
public class ConcurrentHelloServiceImpl implements HelloService {
    @Override
    public String limited(String limited) {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("concurrent hello service");
        return "concurrent hello service";
    }
}
