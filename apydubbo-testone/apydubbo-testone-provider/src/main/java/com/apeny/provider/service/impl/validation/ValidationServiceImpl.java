package com.apeny.provider.service.impl.validation;

import com.apeny.api.service.argumentvalidation.Validation1Service;
import com.apeny.argument.ValidationParameter;

/**
 * Created by apeny on 2017/12/17.
 */
public class ValidationServiceImpl implements Validation1Service {
    @Override
    public void save(ValidationParameter parameter) {
        System.out.println("save validation service1: " + parameter);
    }

    @Override
    public void update(ValidationParameter parameter) {
        System.out.println("update validation service2: " + parameter);
    }
}
