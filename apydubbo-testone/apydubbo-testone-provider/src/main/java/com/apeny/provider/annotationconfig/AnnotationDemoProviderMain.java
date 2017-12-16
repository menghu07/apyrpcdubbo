package com.apeny.provider.annotationconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by apeny on 2017/12/16.
 */
public class AnnotationDemoProviderMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"config/applicationContext-annotation-dubbo-provider.xml"});
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
