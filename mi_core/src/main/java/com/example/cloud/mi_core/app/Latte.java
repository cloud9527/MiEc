package com.example.cloud.mi_core.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/12/30.
 */

public class Latte {
    public static Configurator init(Context context) {
        getConfigurator().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigurator() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication() {
        return (Context) getConfigurator().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
