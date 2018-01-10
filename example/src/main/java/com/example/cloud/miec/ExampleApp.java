package com.example.cloud.miec;

import android.app.Application;

import com.example.cloud.mi.ec.database.DatabaseManager;
import com.example.cloud.mi.ec.icon.FontEcModule;
import com.example.cloud.mi_core.app.Latte;
import com.example.cloud.mi_core.net.interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by Administrator on 2017/12/30.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();
        DatabaseManager.getInstance().init(this);
    }

}
