package com.apeny.provider.main;

import com.apeny.api.service.contextservice.ContextService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by apeny on 2017/11/19.
 */
public class DemoServiceProviderMain {
    public static void main(String[] args) {
//        provide();
//        providerCallback();
//        providerNotify();
//        providerMock();
//        provideDelay();
//        provideConcurrent();
        provideTimeout();
    }

    private static void provide() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"config/applicationContext-dubbo-one-provider.xml"});
        context.start();
        try {
//            context.getBean("contextService", ContextService.class).testTwo("hai zi");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void providerCallback() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"config/applicationContext-dubbo-callback-provider.xml"});
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void providerNotify() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"config/applicationContext-dubbo-notify-provider.xml"});
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void providerMock() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"config/applicationContext-dubbo-callback-provider.xml"});
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void provideDelay() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"config/applicationContext-dubbo-delay-provider.xml"});
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void provideConcurrent() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"config/exampleconfig/applicationContext-dubbo-concurrent-provider.xml"});
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void provideTimeout() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"config/exampleconfig/applicationContext-dubbo-timeout-provider.xml"});
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}