package com.apeny.api.service.argumentvalidation;

import com.apeny.argument.ValidationParameter2;

import javax.validation.GroupSequence;

/**
 * Created by apeny on 2017/12/17.
 */
public interface Validation2Service {

    @GroupSequence({Update.class})
    @interface Save{}
    void save(ValidationParameter2 parameter);

    @interface Update{}
    void update(ValidationParameter2 parameter);
}
