package com.example.cloud.mi.ec.main;

import android.graphics.Color;

import com.example.cloud.mi.ec.main.index.IndexDelegate;
import com.example.cloud.mi.ec.main.sort.SortDelegate;
import com.example.cloud.mi_core.delegates.bottom.BaseBottomDelegate;
import com.example.cloud.mi_core.delegates.bottom.BottomItemDelegate;
import com.example.cloud.mi_core.delegates.bottom.BottomTabBean;
import com.example.cloud.mi_core.delegates.bottom.ItemBuilder;

import java.util.LinkedHashMap;

/**
 * Created by cloud on 2018/1/8.
 */

public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new IndexDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
