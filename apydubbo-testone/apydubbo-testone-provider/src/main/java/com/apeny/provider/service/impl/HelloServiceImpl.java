package com.apeny.provider.service.impl;

import com.apeny.api.service.HelloService;

/**
 * Created by apeny on 2017/12/17.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String limited(String limited) {
        System.out.println("i'm locating limited: " + limited);
        return "limited what? " + limited;
    }
}
