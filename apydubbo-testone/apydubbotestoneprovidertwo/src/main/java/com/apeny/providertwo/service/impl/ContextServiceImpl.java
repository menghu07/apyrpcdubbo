package com.apeny.providertwo.service.impl;

import com.apeny.api.service.contextservice.ContextService;

/**
 * Created by apeny on 2017/12/25.
 */
public class ContextServiceImpl implements ContextService {

    @Override
    public void testTwo(String param) {
        System.out.println("i receive a parameter: " + param);
    }
}
