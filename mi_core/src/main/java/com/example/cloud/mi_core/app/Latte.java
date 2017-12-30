package com.example.cloud.mi_core.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by Administrator on 2017/12/30.
 */

public class Latte {
    public static Configurator init(Context context) {
        getConfigurator().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String, Object> getConfigurator() {
        return Configurator.getInstance().getLatteConfigs();
    }
}
