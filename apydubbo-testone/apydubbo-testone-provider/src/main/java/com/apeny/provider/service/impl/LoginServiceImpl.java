package com.apeny.provider.service.impl;

import com.apeny.api.service.LoginService;

/**
 * Created by apeny on 2017/12/17.
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public void login(String userName, String password) {
        System.out.println("userName: " + userName + ", password: " + password);
    }
}
