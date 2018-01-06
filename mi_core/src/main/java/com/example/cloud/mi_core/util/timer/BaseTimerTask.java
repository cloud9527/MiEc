package com.example.cloud.mi_core.util.timer;

import java.util.TimerTask;

/**
 * Created by cloud on 2018/1/6.
 */

public class BaseTimerTask extends TimerTask {
    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener ITimerListener) {
        mITimerListener = ITimerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTime();
        }
    }
}
