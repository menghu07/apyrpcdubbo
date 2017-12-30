package com.apeny.api.service.callbackservice;

/**
 * Created by apeny on 2017/12/30.
 */
public interface CallbackService {
    void addListener(String key, CallbackListener listener);

    String customMethod(String newName);
}
