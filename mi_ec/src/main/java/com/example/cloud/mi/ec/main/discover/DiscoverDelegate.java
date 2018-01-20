package com.example.cloud.mi.ec.main.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.cloud.mi.ec.R;
import com.example.cloud.mi_core.delegates.bottom.BottomItemDelegate;
import com.example.cloud.mi_core.delegates.web.WebDelegateImpl;

/**
 * Created by cloud on 2018/1/17.
 */

public class DiscoverDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_discover;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        WebDelegateImpl webDelegate = WebDelegateImpl.create("index.html");
        webDelegate.setTopDelegate(this.getParentDelegate());
        loadRootFragment(R.id.web_discovery_container, webDelegate);
    }
}
