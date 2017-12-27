package com.apeny.provider.service.impl.asyncservice;

import com.apeny.api.service.asyncservice.BarService;
import com.apeny.domain.asyncentity.Bar;

import java.util.concurrent.TimeUnit;

/**
 * Created by apeny on 2017/12/27.
 */
public class BarServiceImpl implements BarService {
    @Override
    public Bar findBar() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("sleep bar service end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Bar();
    }
}
