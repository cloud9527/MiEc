package com.example.cloud.mi_core.recycler;

import android.text.TextUtils;

import java.util.ArrayList;

/**
 * Created by cloud on 2018/1/13.
 */

public abstract class DataConverter {

    protected final ArrayList<MultipleItemEntity> ENTITIES = new ArrayList<>();
    private String mJsonData = null;

    public abstract ArrayList<MultipleItemEntity> convert();

    public DataConverter setJsonData(String json) {
        this.mJsonData = json;
        return this;
    }

    protected String getJsonData() {
        if (TextUtils.isEmpty(mJsonData)) {
            throw new NullPointerException("JSON DATA IS NULL");
        }
        return mJsonData;
    }
}
