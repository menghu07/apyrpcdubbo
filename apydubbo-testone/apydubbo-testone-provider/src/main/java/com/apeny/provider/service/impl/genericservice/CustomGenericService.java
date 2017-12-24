package com.apeny.provider.service.impl.genericservice;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * Created by apeny on 2017/12/24.
 */
public class CustomGenericService implements GenericService {

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        System.out.println("custom generic service: " + method + " parameterType: " + parameterTypes + " args: " + (args != null ? args[0] : args));
        if ("findPerson".equals(method)) {
            return new com.apeny.domain.impl.PersonImpl();
        }
        return "not find a person";
    }
}
