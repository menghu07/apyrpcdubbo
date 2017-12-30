package com.apeny.api.service.notifyservice;

import com.apeny.domain.Person;

/**
 * Created by apeny on 2017/12/30.
 */
public interface Notify {
    void onReturn(Person person, String name, String password);

    void onThrow(Throwable throwable, String name, String password);
}
