package com.apeny.service.impl;

import com.apeny.api.service.DemoService;

/**
 * Created by apeny on 2017/12/30.
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        System.out.println("call injvm: " + name);
        return "from injvm " + name;
    }
}
