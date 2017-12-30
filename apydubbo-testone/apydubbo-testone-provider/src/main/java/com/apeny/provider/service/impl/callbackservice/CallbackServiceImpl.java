package com.apeny.provider.service.impl.callbackservice;

import com.apeny.api.service.callbackservice.CallbackListener;
import com.apeny.api.service.callbackservice.CallbackService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by apeny on 2017/12/30.
 */
public class CallbackServiceImpl implements CallbackService {
    private final Map<String, CallbackListener> listenerMap = new ConcurrentHashMap<>();

    public CallbackServiceImpl() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        for (Map.Entry<String, CallbackListener> entry : listenerMap.entrySet()) {
                            try {
                                entry.getValue().changed(getChanged(entry.getKey()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        TimeUnit.SECONDS.sleep(3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void addListener(String key, CallbackListener listener) {
        listenerMap.put(key, listener);
        listener.changed(getChanged(key));
    }

    private String getChanged(String key) {
        return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Override
    public String customMethod(String newName) {
        System.out.println("i receive a new Name: " + newName);
        return "new Name: " + newName;
    }
}
