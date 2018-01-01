package com.apeny.consumer.main;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.apeny.api.service.DemoService;
import com.apeny.api.service.HelloService;
import com.apeny.api.service.IndexService;
import com.apeny.api.service.argumentvalidation.Validation1Service;
import com.apeny.api.service.argumentvalidation.Validation2Service;
import com.apeny.api.service.asyncservice.BarService;
import com.apeny.api.service.asyncservice.FooService;
import com.apeny.api.service.callbackservice.CallbackService;
import com.apeny.api.service.notifyservice.NotifyService;
import com.apeny.argument.ValidationParameter;
import com.apeny.argument.ValidationParameter2;
import com.apeny.domain.asyncentity.Bar;
import com.apeny.domain.asyncentity.Foo;
import com.apeny.service.impl.callbackservice.CallbackListenerImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by apeny on 2017/11/19.
 */
public class DemoServiceInvokerMain {
    public static void main(String[] args) {
//        consume();
//        examples();
//        asyncExamples();
//        localServiceCall();
//        callbackService();
//        notifyService();
//        stubService();
//        mockService();
//        delayService();
        concurrentService();
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
//        person.put("class", "com.apeny.domain.impl.PersonImpl");
        person.put("name", "nike");
        person.put("password", "york");
        Object result = genericService.$invoke("findPerson", new String[]{"com.apeny.domain.Person"}, new Object[]{new com.apeny.domain.impl.PersonImpl()});
//        Object result = genericService.$invoke("findPerson", new String[]{"java.lang.String"}, new Object[]{"jjjjj"});
        System.out.println("result generic service: " + result.getClass());
    }

    /**
     * dubbo 栗子
     */
    private static void examples() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext-dubbo-consumer.xml");
        EchoService echoService = (EchoService) context.getBean("demoService");
        Object result = echoService.$echo("ok");
        System.out.println("result: " + result);
        System.out.println("consumer side: " + RpcContext.getContext().isConsumerSide());
        System.out.println("remote call before: ");
        RpcContext.getContext().setAttachment("key1", "value1");
        DemoService demoService = context.getBean("demoService", DemoService.class);
        demoService.sayHello("hi lo");
    }

    private static void asyncExamples() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext-dubbo-one-consumer.xml");
        BarService barService = context.getBean("barService", BarService.class);
        RpcContext rpcContext = RpcContext.getContext();
        long begin = System.currentTimeMillis();
        Bar bar = barService.findBar();
        System.out.println("immediate bar: " + bar + ", use time: " + (System.currentTimeMillis() - begin));
        Future<Bar> barFuture = rpcContext.getFuture();
        FooService fooService = context.getBean("fooService", FooService.class);
        long fooBegin = System.currentTimeMillis();
        Foo foo = fooService.findFoo();
        System.out.println("immediate foo " + foo + "use time: " + (System.currentTimeMillis() - fooBegin));
        Future<Foo> fooFuture = rpcContext.getFuture();
        try {
            System.out.println(new Date() + "; foo " + fooFuture.get());
            System.out.println(new Date() + "; bar " + barFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 本地服务调用
     */
    private static void localServiceCall() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext-dubbo-local-call.xml");
        context.start();
        DemoService demoService = context.getBean("demoServiceRef", DemoService.class);
        System.out.println("i wanna see demo service result : " + demoService.sayHello("ha ha ha"));
    }

    /**
     * 回调监听器添加
     */
    private static void callbackService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext-dubbo-callback-consumer.xml");
        CallbackService callbackService = context.getBean("callbackServiceRef", CallbackService.class);
        callbackService.addListener("consumer key", new CallbackListenerImpl());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void notifyService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext-dubbo-notify-consumer.xml");
        NotifyService notifyService = context.getBean("notifyServiceRef", NotifyService.class);
        com.apeny.domain.Person person = notifyService.getPerson("no name", "no password");
        System.out.println("person toString.." + person);
        ConfigurableListableBeanFactory configurableBeanFactory = context.getBeanFactory();
        notifyService = configurableBeanFactory.getBean("notifyServiceRef", NotifyService.class);
        System.out.println("notifyService from configurableBeanFactory: " + notifyService);
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serializable.txt"));
            outputStream.writeObject(configurableBeanFactory);
            outputStream.flush();
            outputStream.close();
            //deserialize
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serializable.txt"));
            ConfigurableListableBeanFactory factory = ConfigurableListableBeanFactory.class.cast(inputStream.readObject());
            notifyService = factory.getBean("notifyServiceRef", NotifyService.class);
            System.out.println("from deserialize factory: " + notifyService);
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void stubService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext-dubbo-notify-consumer.xml");
        HelloService helloService = context.getBean("stubHelloService", HelloService.class);
        String result = helloService.limited("872938");
        System.out.println("consumer has stub> " + result);
    }

    private static void mockService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext-dubbo-callback-consumer.xml");
        HelloService helloService = context.getBean("mockHelloService", HelloService.class);
        String result = helloService.limited("872938");
        System.out.println("consumer has mock> " + result);
    }

    private static void delayService() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext-dubbo-delay-consumer.xml");
                HelloService helloService = context.getBean("delayHelloService", HelloService.class);
                String result = helloService.limited("872938");
                System.out.println("consumer has delay> " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static AtomicLong count = new AtomicLong(0);
    private static void concurrentService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/exampleconfig/applicationContext-dubbo-concurrent-consumer.xml");
        ExecutorService executorService = new ThreadPoolExecutor(100, 100, 100, TimeUnit.SECONDS, new LinkedBlockingQueue());
        while (true) {
            try {
//                TimeUnit.NANOSECONDS.sleep(1);
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        HelloService helloService = context.getBean("concurrentHelloService", HelloService.class);
                        String result = helloService.limited("872938");
                        if (result != null) {
                            System.out.println("success: " + count.getAndAdd(1L));
                        }
                        System.out.println("consumer has concurent> " + result);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
