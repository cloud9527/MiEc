package com.example.cloud.miec.generators;

import com.example.cloud.mi_core.wechat.templates.WXPayEmptyTemplate;
import com.example.miec.annotaions.PayEntryGenerator;

/**
 * Created by cloud on 2018/1/7.
 */
@PayEntryGenerator(
        packageName = "com.example.cloud.miec",
        payTemplate = WXPayEmptyTemplate.class
)
public interface WeChatPayEntry {
}
