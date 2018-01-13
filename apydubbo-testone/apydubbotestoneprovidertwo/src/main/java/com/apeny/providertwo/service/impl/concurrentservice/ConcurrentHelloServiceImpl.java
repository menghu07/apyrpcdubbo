package com.apeny.providertwo.service.impl.concurrentservice;

import com.apeny.api.service.HelloService;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by apeny on 2018/1/1.
 */
public class ConcurrentHelloServiceImpl implements HelloService {
    private static AtomicLong count = new AtomicLong();

    @Override
    public String limited(String limited) {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("we are not same implement, i concurrent provider two" + ", count=" + count.getAndAdd(1L));
        return "concurrent provider two,";
    }
}
