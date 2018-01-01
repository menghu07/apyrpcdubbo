package com.apeny.provider.service.impl.delayservice;

import com.apeny.api.service.HelloService;
import com.apeny.api.service.IndexService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by apeny on 2018/1/1.
 */
public class DelayHelloServiceImpl implements HelloService, ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public String limited(String limited) {
        IndexService indexService = context.getBean("index1", IndexService.class);
        System.out.println("listed indexes : " + indexService.indexes());
        System.out.println("limited delay hello service");
        return "delay hello service!";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
