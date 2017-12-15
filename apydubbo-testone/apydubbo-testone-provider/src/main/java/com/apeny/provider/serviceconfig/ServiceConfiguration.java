package com.apeny.provider.serviceconfig;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.apeny.api.service.DemoService;
import com.apeny.provider.service.impl.DemoServiceImpl;

import java.util.concurrent.TimeUnit;

/**
 * Created by apeny on 2017/12/15.
 */
public class ServiceConfiguration {
    private static ServiceConfig<DemoService> SERVICE_CONFIG = new ServiceConfig<>();
    private static Object LOCK = new Object();
    private static DemoService demoService = new DemoServiceImpl();

    private static ApplicationConfig applicationConfig = new ApplicationConfig();
    private static RegistryConfig registryConfig = new RegistryConfig();
    private static ProtocolConfig protocolConfig = new ProtocolConfig();
    static {
        applicationConfig.setName("api-provider");
        registryConfig.setAddress("multicast://224.5.6.7:1234");
        //协议
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        protocolConfig.setThreads(200);
        SERVICE_CONFIG.setApplication(applicationConfig);
        SERVICE_CONFIG.setRegistry(registryConfig);
        SERVICE_CONFIG.setProtocol(protocolConfig);
        SERVICE_CONFIG.setInterface(DemoService.class);
        SERVICE_CONFIG.setRef(demoService);
        SERVICE_CONFIG.setVersion("1.0");
        SERVICE_CONFIG.export();
    }

    public static void main(String[] args) {
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
