package com.apeny.providertwo.main;

import com.apeny.api.service.contextservice.ContextService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by apeny on 2017/12/25.
 */
public class ProviderMain {
    public static void main(String[] args) {
//        startProvider();
        clusterForOne();
    }

    private static void startProvider() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext-dubbo-provider.xml");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clusterForOne() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/exampleconfig/applicationContext-dubbo-concurrent-provider.xml");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
