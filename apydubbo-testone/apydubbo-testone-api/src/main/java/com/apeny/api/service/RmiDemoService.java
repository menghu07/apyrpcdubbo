package com.apeny.api.service;

import java.rmi.RemoteException;

/**
 * Created by apeny on 2017/12/17.
 */
public interface RmiDemoService {
    
    String sayHello(String name) throws RemoteException;
}
