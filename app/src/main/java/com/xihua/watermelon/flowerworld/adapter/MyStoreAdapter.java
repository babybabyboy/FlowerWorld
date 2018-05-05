package com.xihua.watermelon.flowerworld.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;
import com.xihua.watermelon.flowerworld.R;
import com.xihua.watermelon.flowerworld.data.NewsInfo;

import java.util.List;

public class MyStoreAdapter extends RecyclerView.Adapter<MyStoreAdapter.ViewHolder>{
    //private List<String> mDataList;
    private List<NewsInfo> newsInfos;
    private NewsInfo newsInfo;


    public MyStoreAdapter(List<NewsInfo> list) {
        newsInfos = list;
    }

    @Override
    public int getItemCount() {
        // 返回数据集合大小
        return newsInfos == null ? 0 : newsInfos.size();
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //获取这个TextView

        TextView tv_t= holder.tv_title;
        TextView tv_des=holder.tv_description;
        TextView tv_ty=holder.tv_type;
        SmartImageView s=holder.siv;

        //tv.setText(mDataList.get(position));
        newsInfo = newsInfos.get(position);
        //SmartImageView加载指定路径图片
        s.setImageUrl(newsInfo.getIcon(), R.drawable.ic_launcher, R.drawable.ic_launcher);
        //设置新闻标题
        tv_t.setText(newsInfo.getTitle());
        //设置新闻描述
        tv_des.setText(newsInfo.getContent());
        //1.一般新闻 2.专题 3.live
        int type = newsInfo.getType();
        switch (type) {
            //不同新闻类型设置不同的颜色和不同的内容
            case 1:
                tv_ty.setText("评论:" + newsInfo.getComment());
                break;
            case 2:
                tv_ty.setTextColor(Color.RED);
                tv_ty.setText("专题");
                break;
            case 3:
                tv_ty.setTextColor(Color.BLUE);
                tv_ty.setText("LIVE");
                break;
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private TextView tv_description;
        private TextView tv_type;
        private SmartImageView siv;



        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            siv = (SmartImageView) itemView.findViewById(R.id.siv_icon);
            tv_description = (TextView) itemView.findViewById(R.id.tv_description);
            tv_type = (TextView) itemView.findViewById(R.id.tv_type);


        }


    }
}
