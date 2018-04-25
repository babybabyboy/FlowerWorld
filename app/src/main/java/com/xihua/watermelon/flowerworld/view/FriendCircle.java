package com.xihua.watermelon.flowerworld.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xihua.watermelon.flowerworld.R;

public class FriendCircle extends Fragment{

    public FriendCircle() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.friendcircle, container, false);
    }
}
