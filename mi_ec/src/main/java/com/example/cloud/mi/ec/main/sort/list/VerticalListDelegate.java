package com.example.cloud.mi.ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.cloud.mi.ec.R;
import com.example.cloud.mi.ec.R2;
import com.example.cloud.mi.ec.main.sort.SortDelegate;
import com.example.cloud.mi_core.delegates.LatteDelegate;
import com.example.cloud.mi_core.net.MiEcUrl;
import com.example.cloud.mi_core.net.RestClient;
import com.example.cloud.mi_core.net.callback.ISuccess;
import com.example.cloud.mi_core.recycler.MultipleItemEntity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by cloud on 2018/1/15.
 */

public class VerticalListDelegate extends LatteDelegate {
    @BindView(R2.id.rv_vertical_menu_list)
    RecyclerView mRecyclerView = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }

    private void initRecyclerView() {
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        //屏蔽动画效果
        mRecyclerView.setItemAnimator(null);
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initRecyclerView();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder()
                .url(MiEcUrl.SORT_LIST_DATA)
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final List<MultipleItemEntity> data = new VerticalListDataConverter().setJsonData(response)
                                .convert();
                        SortDelegate parentDelegate = getParentDelegate();
                        final SortRecyclerAdapter adapter = new SortRecyclerAdapter(data, parentDelegate);
                        mRecyclerView.setAdapter(adapter);
                    }
                })
                .build().get();
    }
}
