package com.example.cloud.miec;

import com.example.cloud.mi_core.activites.ProxyActivity;
import com.example.cloud.mi_core.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootLatteDelegate() {
        return new ExampleDelegate();
    }
}
