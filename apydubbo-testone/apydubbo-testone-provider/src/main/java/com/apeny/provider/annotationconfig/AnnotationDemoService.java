package com.apeny.provider.annotationconfig;

import com.alibaba.dubbo.config.annotation.Service;
import com.apeny.api.service.DemoService;

/**
 * Created by apeny on 2017/12/16.
 */
@Service(version = "1.0")
public class AnnotationDemoService implements DemoService {

    @Override
    public String sayHello(String name) {
        System.out.println("annotation service is called");
        return "Annotation Service " + name;
    }
}
