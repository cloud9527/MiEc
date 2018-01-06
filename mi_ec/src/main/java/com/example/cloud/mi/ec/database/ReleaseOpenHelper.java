package com.example.cloud.mi.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by cloud on 2018/1/6.
 */

public class ReleaseOpenHelper extends DaoMaster.OpenHelper{
    public ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }
}
