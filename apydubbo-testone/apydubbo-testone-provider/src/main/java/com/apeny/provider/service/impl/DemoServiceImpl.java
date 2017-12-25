package com.apeny.provider.service.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.apeny.api.service.DemoService;
import com.apeny.api.service.contextservice.ContextService;

import java.util.concurrent.TimeUnit;

/**
 * Created by apeny on 2017/11/19.
 */
public class DemoServiceImpl implements DemoService {
    private ContextService contextService;
    @Override
    public String sayHello(String name)
    {
        try {
            TimeUnit.NANOSECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RpcContext rpcContext = RpcContext.getContext();
        System.out.println("consumer side: " + rpcContext.isConsumerSide() + ", provider side: " + rpcContext.isProviderSide());
        contextService.testTwo("ha ha ha");
        System.out.println("consumer side: " + rpcContext.isConsumerSide() + ", provider side: " + rpcContext.isProviderSide());
        System.out.println("say hello consume " + 5);
        return "hello from provider: " + name;
    }

    public ContextService getContextService() {
        return contextService;
    }

    public void setContextService(ContextService contextService) {
        this.contextService = contextService;
    }
}
