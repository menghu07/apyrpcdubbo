package com.apeny.provider.service.impl.validation;

import com.apeny.api.service.argumentvalidation.Validation2Service;
import com.apeny.argument.ValidationParameter;

/**
 * Created by apeny on 2017/12/17.
 */
public class ValidationService2Impl implements Validation2Service {
    @Override
    public void save(ValidationParameter parameter) {
        System.out.println("save parameter: " + parameter);
    }

    @Override
    public void update(ValidationParameter parameter) {
        System.out.println("update parameter: " + parameter);
    }
}
