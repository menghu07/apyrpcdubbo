package com.apeny.provider.service.impl;

import com.apeny.api.service.RmiDemoService;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * Created by apeny on 2017/12/17.
 */
public class RmiDemoServiceImpl implements RmiDemoService, Serializable {

    private static final long serialVersionUID = -68494470754667710L;

    @Override
    public String sayHello(String name) throws RemoteException {
        System.out.println("i'm a rmi demo service. receive a message : " + name);
        return "hi, rmi protocol is here." + name;
    }
}
