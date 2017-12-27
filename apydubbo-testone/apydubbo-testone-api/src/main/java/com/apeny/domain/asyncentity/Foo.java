package com.apeny.domain.asyncentity;

import java.io.Serializable;

/**
 * Created by apeny on 2017/12/27.
 */
public class Foo implements Serializable {
    private static final long serialVersionUID = 939L;

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
