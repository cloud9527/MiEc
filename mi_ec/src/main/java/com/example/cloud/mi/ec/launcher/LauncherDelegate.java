package com.example.cloud.mi.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.cloud.mi.ec.R;
import com.example.cloud.mi.ec.R2;
import com.example.cloud.mi.ec.sign.SignInDelegate;
import com.example.cloud.mi_core.delegates.LatteDelegate;
import com.example.cloud.mi_core.util.storage.LattePreference;
import com.example.cloud.mi_core.util.timer.BaseTimerTask;
import com.example.cloud.mi_core.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by cloud on 2018/1/6.
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvLauncherTimer;

    private Timer mTimer = null;
    private int mCount = 5;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }
    }

    private void initTime() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTime();
    }

    /**
     * 判断是否展示滑动启动页
     */
    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            //启动新fragment
            getSupportDelegate().start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
            getSupportDelegate().start(new SignInDelegate());
        }
    }

    @Override
    public void onTime() {
        getSupportDelegate().getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvLauncherTimer != null) {
                    mTvLauncherTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShowScroll();
                        }
                    }
                }
            }
        });
    }
}
