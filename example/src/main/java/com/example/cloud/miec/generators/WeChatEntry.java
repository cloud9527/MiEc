package com.example.cloud.miec.generators;

/**
 * Created by cloud on 2018/1/7.
 */

import com.example.cloud.mi_core.wechat.templates.WXEmptyTemplate;
import com.example.miec.annotaions.EntryGenerator;

@EntryGenerator(
        packageName = "com.example.cloud.miec",
        entryTemplate = WXEmptyTemplate.class
)
public interface WeChatEntry {
}
