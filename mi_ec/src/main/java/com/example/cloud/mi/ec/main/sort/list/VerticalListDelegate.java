package com.example.cloud.mi.ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.cloud.mi.ec.R;
import com.example.cloud.mi_core.delegates.LatteDelegate;

/**
 * Created by cloud on 2018/1/15.
 */

public class VerticalListDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
