package com.apeny.domain.asyncentity;

import java.io.Serializable;

/**
 * Created by apeny on 2017/12/27.
 */
public class Bar implements Serializable {
    private static final long serialVersionUID = 9239L;
    private Long barId;
    private String code;
    private String name;

    public Long getBarId() {
        return barId;
    }

    public void setBarId(Long barId) {
        this.barId = barId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
