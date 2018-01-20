package com.example.cloud.mi_core.delegates.web.client;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.cloud.mi_core.app.Latte;
import com.example.cloud.mi_core.delegates.web.IPageLoadListener;
import com.example.cloud.mi_core.delegates.web.WebDelegate;
import com.example.cloud.mi_core.delegates.web.route.Router;
import com.example.cloud.mi_core.ui.loader.LatteLoader;
import com.example.cloud.mi_core.util.log.LatteLogger;

/**
 * Created by cloud on 2018/1/18.
 */

public class WebViewClientImpl extends WebViewClient {
    private final WebDelegate DELEGATE;

    private IPageLoadListener mIPageLoadListener;
    private static final Handler HANDLER = Latte.getHandler();

    public void setIPageLoadListener(IPageLoadListener IPageLoadListener) {
        mIPageLoadListener = IPageLoadListener;
    }

    public WebViewClientImpl(WebDelegate DELEGATE) {
        this.DELEGATE = DELEGATE;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        LatteLogger.d("shouldOverrideUrlLoading", url);
        return Router.getInstance().handleWebUrl(DELEGATE, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadStart();
        }
        LatteLoader.showLoading(view.getContext());
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadEnd();
        }
        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                LatteLoader.stopLoading();
            }
        }, 1000);

    }
}
