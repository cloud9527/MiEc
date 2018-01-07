package com.example.cloud.miec.generators;

import com.example.cloud.mi_core.wechat.templates.AppRegisterTemplate;
import com.example.miec.annotaions.AppRegisterGenerator;

/**
 * Created by cloud on 2018/1/7.
 */
@AppRegisterGenerator(
        packageName = "com.example.cloud.miec",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegisterEntry {
}
