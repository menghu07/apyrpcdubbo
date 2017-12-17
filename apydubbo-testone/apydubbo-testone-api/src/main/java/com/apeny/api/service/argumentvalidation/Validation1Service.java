package com.apeny.api.service.argumentvalidation;

import com.apeny.argument.ValidationParameter;

import javax.validation.constraints.NotNull;

/**
 * Created by apeny on 2017/12/17.
 */
public interface Validation1Service {
    void save(ValidationParameter parameter);

    //参数非空
    void update(@NotNull ValidationParameter parameter);
    @interface Save{}
    @interface Update{}
}
