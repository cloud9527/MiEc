package com.example.cloud.mi.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.cloud.mi.ec.R;
import com.example.cloud.mi.ec.R2;
import com.example.cloud.mi_core.RefreshHandler;
import com.example.cloud.mi_core.delegates.bottom.BottomItemDelegate;
import com.example.cloud.mi_core.net.MiEcUrl;
import com.example.cloud.mi_core.net.RestClient;
import com.example.cloud.mi_core.net.callback.ISuccess;
import com.example.cloud.mi_core.recycler.MultipleFields;
import com.example.cloud.mi_core.recycler.MultipleItemEntity;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by cloud on 2018/1/8.
 */

public class IndexDelegate extends BottomItemDelegate {

    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;
    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;
    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan = null;
    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView = null;

    private RefreshHandler mRefreshHandler;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mRefreshHandler = new RefreshHandler(mRefreshLayout);
        RestClient.builder()
                .url(MiEcUrl.INDEX_DATA)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final IndexDataConverter indexDataConverter = new IndexDataConverter();
                        indexDataConverter.setJsonData(response);
                        final ArrayList<MultipleItemEntity> list = indexDataConverter.convert();
                        final String field = list.get(1).getField(MultipleFields.IMAGE_URL);
                        Toast.makeText(getContext(), field, Toast.LENGTH_LONG).show();

                    }
                })
                .build().get();
    }

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        mRefreshLayout.setProgressViewOffset(true, 120, 300);

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
//        mRefreshHandler.firstPage(MiEcUrl.INDEX_DATA);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }


}
