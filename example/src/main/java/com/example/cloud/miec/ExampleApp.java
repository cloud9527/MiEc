package com.example.cloud.miec;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.example.cloud.mi.ec.database.DatabaseManager;
import com.example.cloud.mi.ec.icon.FontEcModule;
import com.example.cloud.mi_core.app.Latte;
import com.example.cloud.mi_core.net.MiEcUrl;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by Administrator on 2017/12/30.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost(MiEcUrl.URL_HOST)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
//                .withInterceptor(new DebugInterceptor("123", R.raw.test))
                .configure();
        DatabaseManager.getInstance().init(this);

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"zTozcvKoj68wlxfVJ0zTEUAA-gzGzoHsz","l3L8K9zmoR8TWdJRtMoOuBL8");
        AVOSCloud.setDebugLogEnabled(true);
    }

}
