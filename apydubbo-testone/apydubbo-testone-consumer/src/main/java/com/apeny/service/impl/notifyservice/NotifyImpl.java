package com.apeny.service.impl.notifyservice;

import com.apeny.api.service.notifyservice.Notify;
import com.apeny.domain.Person;

/**
 * Created by apeny on 2017/12/30.
 */
public class NotifyImpl implements Notify {
    @Override
    public void onReturn(Person person, String name, String password) {
        System.out.println("onreturn#### person = " + person + ", name=" + name + ",password=" + password);
    }

    @Override
    public void onThrow(Throwable throwable, String name, String password) {
        throwable.printStackTrace();
        System.out.println("onthrow#### name=" + name + ", password=" + password);
    }
}
