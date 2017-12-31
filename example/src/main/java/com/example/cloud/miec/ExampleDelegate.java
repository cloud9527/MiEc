package com.example.cloud.miec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.cloud.mi_core.delegates.LatteDelegate;

/**
 * Created by cloud on 2017/12/31.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
