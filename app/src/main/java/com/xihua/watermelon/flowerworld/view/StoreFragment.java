package com.xihua.watermelon.flowerworld.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.xihua.watermelon.flowerworld.R;
import com.xihua.watermelon.flowerworld.adapter.MyStoreAdapter;

import java.util.ArrayList;
import java.util.List;

public class StoreFragment extends Fragment{

    private WebView store_View;

    private RecyclerView mRecyclerView;

    private List<String> mDataList ;

    private MyStoreAdapter myAdapter;

    public StoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.store, container, false);
        //找到这个Listview
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        //设置线性管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       initData();
        return view;
    }



    /**
     * 初始化数据
     */
    private void initData() {

        mDataList = new ArrayList<String>();
        for (int i=0;i<50;i++){
            mDataList.add("内容 - "+i);
        }
        /*
        设置适配器
         */
        myAdapter = new MyStoreAdapter(mDataList);
        mRecyclerView.setAdapter(myAdapter);
    }







}
