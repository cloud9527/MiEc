package com.example.cloud.miec;

import android.app.Application;

import com.example.cloud.mi_core.app.Latte;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by Administrator on 2017/12/30.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .configure();
    }
}
