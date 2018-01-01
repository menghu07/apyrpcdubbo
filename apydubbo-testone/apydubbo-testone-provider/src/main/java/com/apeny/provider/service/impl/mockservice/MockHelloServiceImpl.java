package com.apeny.provider.service.impl.mockservice;

import com.alibaba.dubbo.rpc.RpcException;
import com.apeny.api.service.HelloService;

import java.util.concurrent.TimeUnit;

/**
 * 只有出现超时或网络失败时才会执行Mock
 * Created by apeny on 2017/12/31.
 */
public class MockHelloServiceImpl implements HelloService {
    @Override
    public String limited(String limited) {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "limit from mock service: " + limited;
    }
}
