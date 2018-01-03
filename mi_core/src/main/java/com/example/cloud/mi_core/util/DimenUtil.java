package com.example.cloud.mi_core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.cloud.mi_core.app.Latte;

/**
 * Created by cloud on 2018/1/3.
 */

public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;

    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.heightPixels;

    }

}
