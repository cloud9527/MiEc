package com.example.cloud.mi_core.delegates.web.client;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.cloud.mi_core.delegates.web.WebDelegate;
import com.example.cloud.mi_core.delegates.web.route.Router;
import com.example.cloud.mi_core.util.log.LatteLogger;

/**
 * Created by cloud on 2018/1/18.
 */

public class WebViewClientImpl extends WebViewClient {
    private final WebDelegate DELEGATE;

    public WebViewClientImpl(WebDelegate DELEGATE) {
        this.DELEGATE = DELEGATE;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        LatteLogger.d("shouldOverrideUrlLoading", url);
        return Router.getInstance().handleWebUrl(DELEGATE, url);
    }
}
