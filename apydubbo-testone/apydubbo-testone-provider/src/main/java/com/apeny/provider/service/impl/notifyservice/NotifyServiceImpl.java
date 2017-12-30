package com.apeny.provider.service.impl.notifyservice;

import com.apeny.api.service.notifyservice.NotifyService;
import com.apeny.domain.Person;
import com.apeny.domain.impl.PersonImpl;

/**
 * Created by apeny on 2017/12/30.
 */
public class NotifyServiceImpl implements NotifyService {
    private NotifyServiceImpl() {
    }

    @Override
    public Person getPerson(String name, String password) {
        System.out.println("provider receive name = " + name + ", password = " + password);
//        if (name != null) {
//            throw new RuntimeException("name is not null");
//        }
        Person person = new PersonImpl(name, password);
        return person;
    }
}
