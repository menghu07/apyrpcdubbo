package com.apeny.consumer.annotationconfig;

import com.alibaba.dubbo.config.annotation.Reference;
import com.apeny.api.service.DemoService;
import org.springframework.stereotype.Component;

/**
 * Created by apeny on 2017/12/16.
 */
@Component
public class AnnotationDemoComponent {
    @Reference(version="1.0")
    private DemoService demoService;

    public void callDemoService() {
        System.out.println("demo service success?" + demoService.sayHello("new hello annotation"));
    }
}
