package com.apeny.provider.service.impl.asyncservice;

import com.apeny.api.service.asyncservice.FooService;
import com.apeny.domain.asyncentity.Foo;

import java.util.concurrent.TimeUnit;

/**
 * Created by apeny on 2017/12/27.
 */
public class FooServiceImpl implements FooService {
    @Override
    public Foo findFoo() {
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("sleep foo service end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Foo();
    }
}
