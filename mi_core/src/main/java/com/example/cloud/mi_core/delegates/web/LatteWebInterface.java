package com.example.cloud.mi_core.delegates.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.example.cloud.mi_core.delegates.web.event.Event;
import com.example.cloud.mi_core.delegates.web.event.EventManager;
import com.example.cloud.mi_core.util.log.LatteLogger;

/**
 * Created by cloud on 2018/1/18.
 */

public class LatteWebInterface {
    private final WebDelegate DELEGATE;

    private LatteWebInterface(WebDelegate DELEGATE) {
        this.DELEGATE = DELEGATE;
    }

    static LatteWebInterface create(WebDelegate webDelegate) {
        return new LatteWebInterface(webDelegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface
    public String event(String params) {
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        LatteLogger.d("WEB_EVENT",params);
        if (event != null) {
            event.setAction(action);
            event.setDelegate(DELEGATE);
            event.setContext(DELEGATE.getContext());
            event.setUrl(DELEGATE.getUrl());
            return event.execute(params);
        }
        return null;
    }

}
