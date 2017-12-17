package com.apeny.consumer.main;

import com.apeny.api.service.DemoService;
import com.apeny.api.service.HelloService;
import com.apeny.api.service.IndexService;
import com.apeny.api.service.RmiDemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.RemoteException;

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

        //多服务,多协议
        DemoService rmiDemoServiceClient = context.getBean("rmiDemoServiceClient", DemoService.class);
        System.out.println("multiple services and multiple protocols, rmi Demo Service " + rmiDemoServiceClient.sayHello("rmi r u ok?"));

        //多引用多注册中心
        HelloService helloService = context.getBean("hello1", HelloService.class);
        System.out.println("see hello words: " + helloService.limited("88898"));
        HelloService helloService2 = context.getBean("hello2", HelloService.class);
        System.out.println("see hello words: " + helloService2.limited("registry2"));

        //服务分组
        IndexService indexService = context.getBean("index1", IndexService.class);
        System.out.println("index group index1 : " + indexService.indexes());

        IndexService index12Service = context.getBean("index12", IndexService.class);
        System.out.println("index12 group merge index: " + index12Service.indexes());
    }
}
