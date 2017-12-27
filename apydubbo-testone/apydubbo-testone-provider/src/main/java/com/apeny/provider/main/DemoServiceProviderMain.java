package com.apeny.provider.main;

import com.apeny.api.service.contextservice.ContextService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by apeny on 2017/11/19.
 */
public class DemoServiceProviderMain {
    public static void main(String[] args) {
        provide();
    }

    private static void provide() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"config/applicationContext-dubbo-one-provider.xml"});
        context.start();
        try {
//            context.getBean("contextService", ContextService.class).testTwo("hai zi");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
