package com.example.cloud.mi_core.delegates.web;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by cloud on 2018/1/18.
 */

public class WebViewInitializer {
    @SuppressLint("SetJavaScriptEnabled")
    public WebView createWebView(WebView webView) {
        WebView.setWebContentsDebuggingEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setDrawingCacheEnabled(true);
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        String userAgentString = settings.getUserAgentString();
        settings.setUserAgentString(userAgentString + "Latte");
        //隐藏缩放控件
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        //禁止缩放
        settings.setSupportZoom(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowContentAccess(true);
        //缓存
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);

        return webView;
    }
}
