package com.apeny.consumer.main;

import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.apeny.api.service.DemoService;
import com.apeny.api.service.HelloService;
import com.apeny.api.service.IndexService;
import com.apeny.api.service.RmiDemoService;
import com.apeny.api.service.argumentvalidation.Validation1Service;
import com.apeny.api.service.argumentvalidation.Validation2Service;
import com.apeny.argument.ValidationParameter;
import com.apeny.argument.ValidationParameter2;
import com.apeny.consumer.domain.interfacepack.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        System.out.println("second call demo# " + demoService.sayHello("consumer say hello to u"));
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

        //参数校验
        //分组验证
        Validation1Service validation1Service = context.getBean("validation1", Validation1Service.class);
        ValidationParameter parameter = new ValidationParameter();
        parameter.setName("biles wiley");
        parameter.setAge(20);
        parameter.setEmail("222@qq.com");

        Validation2Service validation2Service = context.getBean("validation2", Validation2Service.class);
        ValidationParameter2 parameter2 = new ValidationParameter2();
        parameter2.setName("biles wiley");
        parameter2.setAge(89);
        parameter2.setEmail("829388494@qq.com");
        try {
            validation1Service.save(parameter);
            validation2Service.save(parameter2);
        } catch (RpcException e) {
            System.out.println(e);
            ConstraintViolationException ve = (ConstraintViolationException) e.getCause();
            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations();
            System.out.println("error size: " + violations.size());
            System.out.println("error message: " + violations);
            throw e;
        }

        //泛化参数
        GenericService genericService = (GenericService) context.getBean("customService");
        Map<String, Object> person = new HashMap<>();
        person.put("class", "com.apeny.consumer.domain.PersonImpl");
        person.put("name", "nike");
        person.put("password", "york");
        Object result = genericService.$invoke("findPerson", new String[]{"com.apeny.provider.domain.interfacepack.Person"}, new Object[]{person});
        System.out.println("result generic service: " + result);

    }
}
