package com.apeny.provider.service.impl;

import com.apeny.api.service.OnlySubscribeService;

/**
 * Created by apeny on 2017/12/16.
 */
public class OnlySubscribeServiceImpl implements OnlySubscribeService {
    @Override
    public String sendMessage(String message) {
        System.out.println("i receive a message from " + "ipp" + message);
        return "only subscribe service: " + message;
    }
}
