package com.example.cloud.mi_core.delegates.web;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.cloud.mi_core.delegates.web.chromeclient.WebChromeClientImpl;
import com.example.cloud.mi_core.delegates.web.client.WebViewClientImpl;
import com.example.cloud.mi_core.delegates.web.route.RouteKeys;
import com.example.cloud.mi_core.delegates.web.route.Router;

/**
 * Created by cloud on 2018/1/18.
 */

public class WebDelegateImpl extends WebDelegate {
    public static WebDelegateImpl create(String url) {
        final Bundle args = new Bundle();
        args.putString(RouteKeys.URL.name(), url);
        final WebDelegateImpl webDelegate = new WebDelegateImpl();
        webDelegate.setArguments(args);
        return webDelegate;
    }

    @Override
    public Object setLayout() {
        return getWebView();
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        if (getUrl() != null) {
            Router.getInstance().loadPage(this, getUrl());
        }
    }

    @Override
    public IWebViewInitializer setInitializer() {
        return this;
    }

    @Override
    public WebView initWebView(WebView webView) {
        return new WebViewInitializer().createWebView(webView);
    }

    @Override
    public WebViewClient initWebViewClient() {
        final WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        return webViewClient;
    }

    @Override
    public WebChromeClient initWebChromeClient() {
        return new WebChromeClientImpl();
    }
}
