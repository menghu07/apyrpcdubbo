package com.apeny.provider.service.impl;

import com.apeny.api.service.DemoService;

/**
 * Created by apeny on 2017/11/19.
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "hello from provider: " + name;
    }
}
