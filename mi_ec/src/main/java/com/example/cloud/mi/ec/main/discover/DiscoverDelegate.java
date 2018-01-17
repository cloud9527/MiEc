package com.example.cloud.mi.ec.main.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.cloud.mi.ec.R;
import com.example.cloud.mi_core.delegates.bottom.BottomItemDelegate;

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
}
