package com.apeny.provider.domain;

import com.apeny.provider.domain.interfacepack.Person;

import java.io.Serializable;

/**
 * Created by apeny on 2017/12/24.
 */
public class PersonImpl implements Person,Serializable {
    private static final long serialVersionUID = 12L;
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
