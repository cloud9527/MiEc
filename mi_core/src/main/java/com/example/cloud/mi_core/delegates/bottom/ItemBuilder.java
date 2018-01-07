package com.example.cloud.mi_core.delegates.bottom;

import java.util.LinkedHashMap;

/**
 * Created by cloud on 2018/1/7.
 */

public final class ItemBuilder {
    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();

    static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public final ItemBuilder addItem(BottomTabBean bottomTabBean, BottomItemDelegate bottomItemDelegate) {
        ITEMS.put(bottomTabBean, bottomItemDelegate);
        return this;
    }

    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, BottomItemDelegate> items) {
        ITEMS.putAll(items);
        return this;
    }

    public final LinkedHashMap<BottomTabBean, BottomItemDelegate> build() {
        return ITEMS;
    }

}
