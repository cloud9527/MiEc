package com.example.cloud.mi_core;

import android.support.v4.widget.SwipeRefreshLayout;

import com.example.cloud.mi_core.app.Latte;

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


    @Override
    public void onRefresh() {
        refresh();
    }
}
