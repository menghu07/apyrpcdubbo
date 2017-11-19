package com.apeny.provider.main;

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
                new String[] {"config/applicationContext-dubbo-provider.xml"});
        context.start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
