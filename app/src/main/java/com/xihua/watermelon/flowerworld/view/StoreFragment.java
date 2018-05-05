package com.xihua.watermelon.flowerworld.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.xihua.watermelon.flowerworld.MyComponent.MyItemDecoration;
import com.xihua.watermelon.flowerworld.R;
import com.xihua.watermelon.flowerworld.adapter.MyStoreAdapter;
import com.xihua.watermelon.flowerworld.data.JsonParse;
import com.xihua.watermelon.flowerworld.data.NewsInfo;

import java.util.List;

public class StoreFragment extends Fragment{

    private WebView store_View;

    private RecyclerView mRecyclerView;

//    private List<String> mDataList ;

    private MyStoreAdapter myAdapter;


    private List<NewsInfo> newsInfos;

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
      // initData();
        mRecyclerView.addItemDecoration(new MyItemDecoration(getContext()));
        mRecyclerView.setAdapter(myAdapter);
        fillData();
        return view;
    }



    /**
     * 初始化数据
     */
//    private void initData() {
//
//        mDataList = new ArrayList<String>();
//        for (int i=0;i<50;i++){
//            mDataList.add("内容 - "+i);
//        }
//        /*
//        设置适配器
//         */
//        myAdapter = new MyStoreAdapter(mDataList);
//        //添加装饰类
//        mRecyclerView.addItemDecoration(new MyItemDecoration(getContext()));
//        mRecyclerView.setAdapter(myAdapter);
//    }
    //使用AsyncHttpClient访问网络
    private void fillData() {

        //创建AsyncHttpClient实例
        AsyncHttpClient client = new AsyncHttpClient();
        //使用GET方式请求
        client.get("http://47.106.125.0:8080/NewInfo.json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, org.apache.http.Header[] headers, byte[] bytes) {
                //请求成功

                try {
                    String json = new String(bytes, "utf-8");
                    newsInfos = JsonParse.getNewsInfo(json);
                    if (newsInfos == null) {
                        Toast.makeText(getContext(), "解析失败", Toast.LENGTH_SHORT).show();
                    } else {
                        //更新界面
//                        loading.setVisibility(View.INVISIBLE);
                        mRecyclerView.setAdapter(new MyStoreAdapter(newsInfos));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure(int i, org.apache.http.Header[] headers, byte[] bytes, Throwable throwable) {

            }



        });
    }







}
