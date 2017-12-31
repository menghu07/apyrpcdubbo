package com.apeny.api.service;

/**
 * Created by apeny on 2017/12/31.
 */
public class HelloServiceMock implements HelloService {
    @Override
    public String limited(String limited) {
        System.out.println("limited from hello service mock: " + limited);
        return "service mock result";
    }
}
