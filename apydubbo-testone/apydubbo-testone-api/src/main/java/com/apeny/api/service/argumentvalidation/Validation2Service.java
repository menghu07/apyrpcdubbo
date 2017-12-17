package com.apeny.api.service.argumentvalidation;

import com.apeny.argument.ValidationParameter;

import javax.validation.GroupSequence;

/**
 * Created by apeny on 2017/12/17.
 */
public interface Validation2Service {

    @GroupSequence({Update.class})
    @interface Save{}
    void save(ValidationParameter parameter);

    @interface Update{}
    void update(ValidationParameter parameter);
}
