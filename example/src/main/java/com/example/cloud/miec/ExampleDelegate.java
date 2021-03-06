package com.example.cloud.miec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.cloud.mi_core.delegates.LatteDelegate;
import com.example.cloud.mi_core.net.MiEcUrl;
import com.example.cloud.mi_core.net.RestClient;
import com.example.cloud.mi_core.net.callback.IError;
import com.example.cloud.mi_core.net.callback.IFailure;
import com.example.cloud.mi_core.net.callback.ISuccess;

/**
 * Created by cloud on 2017/12/31.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        test();
    }

    private void test() {
        RestClient.builder()
                .url(MiEcUrl.INDEX_DATA)
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Log.e("TAG", "onSuccess: HHHH");
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .build()
                .get();
    }
}
