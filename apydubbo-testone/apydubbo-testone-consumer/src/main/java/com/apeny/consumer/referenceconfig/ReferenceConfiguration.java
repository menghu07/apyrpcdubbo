package com.apeny.consumer.referenceconfig;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.apeny.api.service.DemoService;

/**
 * Created by apeny on 2017/12/15.
 */
public class ReferenceConfiguration {

    private static ApplicationConfig applicationConfig = new ApplicationConfig();
    private static RegistryConfig registryConfig = new RegistryConfig();
    private static ReferenceConfig<DemoService> referenceConfig = new ReferenceConfig<>();

    static {
        applicationConfig.setName("api-consumer");
        registryConfig.setAddress("multicast://224.5.6.7:1234");
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(DemoService.class);
        referenceConfig.setTimeout(10_000);
        referenceConfig.setVersion("1.0");
    }

    /**
     * 时间超时优先级:referenceMethod>serviceMethod>reference>service>consumer>provider
     *
     * @param args
     */
    public static void main(String[] args) {
        DemoService demoService = referenceConfig.get();
        System.out.println("demoService: " + demoService.sayHello("new hello."));
    }

}
