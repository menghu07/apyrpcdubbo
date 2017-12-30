package com.apeny.service.impl.callbackservice;

import com.apeny.api.service.callbackservice.CallbackListener;
import com.apeny.api.service.callbackservice.CallbackService;

/**
 * Created by apeny on 2017/12/30.
 */
public class CallbackListenerImpl implements CallbackListener {
    @Override
    public void changed(String message) {
        System.out.println("key message: " + message);
    }
}
