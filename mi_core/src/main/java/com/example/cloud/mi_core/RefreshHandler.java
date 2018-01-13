package com.example.cloud.mi_core;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.example.cloud.mi_core.app.Latte;
import com.example.cloud.mi_core.net.RestClient;
import com.example.cloud.mi_core.net.callback.ISuccess;

/**
 * Created by cloud on 2018/1/10.
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout REFRESH_LAYOUT) {
        this.REFRESH_LAYOUT = REFRESH_LAYOUT;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    public void firstPage(String url) {
        RestClient.builder()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(Latte.getApplicationContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .build()
                .get();

    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
