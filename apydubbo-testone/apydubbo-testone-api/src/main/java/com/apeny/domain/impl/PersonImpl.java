package com.apeny.domain.impl;

import com.apeny.domain.Person;

import java.io.Serializable;

/**
 * Created by apeny on 2017/12/25.
 */
public class PersonImpl implements Person, Serializable {
    private static final long serialVersionUID = 12L;
    private String name;
    private String password;

    public PersonImpl() {
    }

    public PersonImpl(String name, String password) {
        this.name = name;
        this.password = password;
    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonImpl{");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
