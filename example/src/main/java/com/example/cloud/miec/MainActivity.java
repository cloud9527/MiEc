package com.example.cloud.miec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cloud.mi_core.app.Latte;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Latte.init(this)
                .configure();
    }
}
