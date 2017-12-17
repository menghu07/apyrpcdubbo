package com.apeny.api.service;

/**
 * Created by apeny on 2017/12/17.
 */
public interface HelloService {
    @interface limited{}
    String limited(String limited);
}
