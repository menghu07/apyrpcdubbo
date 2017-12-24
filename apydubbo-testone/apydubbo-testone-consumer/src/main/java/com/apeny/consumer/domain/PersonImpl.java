package com.apeny.consumer.domain;

import com.apeny.consumer.domain.interfacepack.Person;

/**
 * Created by apeny on 2017/12/24.
 */
public class PersonImpl implements Person {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
