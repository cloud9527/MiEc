package com.example.cloud.mi_core.recycler;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * Created by cloud on 2018/1/14.
 */

public class BaseDecoration extends DividerItemDecoration {
    public BaseDecoration(@ColorInt int color, int size) {
        setDividerLookup(new DiverLookupImpl(color, size));
    }

    public static BaseDecoration create(@ColorInt int color, int size) {
        return new BaseDecoration(color, size);
    }
}
