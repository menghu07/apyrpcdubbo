package com.apeny.consumer.annotationconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by apeny on 2017/12/16.
 */
public class AnnotationDemoConsumerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"config/applicationContext-annotation-dubbo-consumer.xml"});
        AnnotationDemoComponent component = applicationContext.getBean("annotationDemoComponent", AnnotationDemoComponent.class);
        component.callDemoService();
        System.out.println("consumer: " + "demo service");
    }
}
