package com.apeny.api.service.notifyservice;

import com.apeny.domain.Person;

/**
 * Created by apeny on 2017/12/30.
 */
public interface NotifyService {

    Person getPerson(String name, String password);
}
