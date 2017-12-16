package com.apeny.consumer.referenceconfig;

import com.alibaba.dubbo.config.*;
import com.apeny.api.service.DemoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apeny on 2017/12/15.
 */
public class ReferenceConfiguration {

    private static ApplicationConfig applicationConfig = new ApplicationConfig();
    private static RegistryConfig registryConfig = new RegistryConfig();
    private static ReferenceConfig<DemoService> referenceConfig = new ReferenceConfig<>();
    private static List<MethodConfig> methodConfigList = new ArrayList<>();

    static {
        applicationConfig.setName("api-consumer");
        registryConfig.setAddress("multicast://224.5.6.7:1234");
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(DemoService.class);
//        referenceConfig.setTimeout(10_000);
        referenceConfig.setVersion("1.0");
        //方法级设置
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("sayHello");
        ArgumentConfig argumentConfig = new ArgumentConfig();
        argumentConfig.setType(String.class.getName());
        List<ArgumentConfig> argumentConfigs = new ArrayList<>();
        argumentConfigs.add(argumentConfig);
//        methodConfig.setArguments(argumentConfigs);
        methodConfig.setTimeout(10000);
//        methodConfig.setRetries(3);
        methodConfigList.add(methodConfig);
        referenceConfig.setMethods(methodConfigList);
    }

    /**
     * 时间超时优先级:referenceMethod>serviceMethod>reference>service>consumer>provider
     *
     * @param args
     */
    public static void main(String[] args) {
        long begin = System.nanoTime();
        DemoService demoService = referenceConfig.get();
        System.out.println("demoService: " + demoService.sayHello("new hello."));
        long end = System.nanoTime();
        System.out.println("use time: " + (end - begin) / 1000_000_000);
    }

}
