package com.apeny.api.service;

/**
 * Created by apeny on 2017/12/31.
 */
public class HelloServiceStub implements HelloService {
    private HelloService helloService;

    public HelloServiceStub(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String limited(String limited) {
        try {
            return helloService.limited(limited + ", added from stub limited: ");
        } catch (Exception ex) {
            return "stub fault tolerant";
        }
    }
}
