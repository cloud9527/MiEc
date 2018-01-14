package com.example.cloud.miec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.example.cloud.mi.ec.launcher.LauncherDelegate;
import com.example.cloud.mi.ec.sign.ISignListener;
import com.example.cloud.mi_core.activites.ProxyActivity;
import com.example.cloud.mi_core.delegates.LatteDelegate;

import qiu.niorgai.StatusBarCompat;

public class ExampleActivity extends ProxyActivity implements ISignListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }

        StatusBarCompat.translucentStatusBar(this, true);
    }

    @Override
    public LatteDelegate setRootLatteDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {

    }

    @Override
    public void onSignUpSuccess() {

    }
}
