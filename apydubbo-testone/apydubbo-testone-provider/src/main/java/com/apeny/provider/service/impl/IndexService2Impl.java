package com.apeny.provider.service.impl;

import com.apeny.api.service.IndexService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by apeny on 2017/12/17.
 */
public class IndexService2Impl implements IndexService {
    @Override
    public List<String> indexes() {
        System.out.println("index2 listed......");
        return Arrays.asList(new String[]{"a", "b", "c"});
    }
}
