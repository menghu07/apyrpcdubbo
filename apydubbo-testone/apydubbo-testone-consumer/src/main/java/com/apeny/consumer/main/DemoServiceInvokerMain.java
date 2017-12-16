package com.apeny.consumer.main;

import com.apeny.api.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by apeny on 2017/11/19.
 */
public class DemoServiceInvokerMain {
    public static void main(String[] args) {
        consume();
    }

    private static void consume() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext-dubbo-consumer.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
        System.out.println(" i wanna see dubbo#  " + demoService.sayHello("consumer say hello to u"));
        DemoService p2pDemoService = (DemoService) context.getBean("p2pDemoService");
        System.out.println("p2p Demo Service: " + p2pDemoService.sayHello("p2p consumer say hello to provider"));
    }
}
