package com.example.cloud.mi_core.delegates.web;

import com.alibaba.fastjson.JSON;

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

    public String event(String params) {
        final String action = JSON.parseObject(params).getString("action");
        return null;
    }

}
