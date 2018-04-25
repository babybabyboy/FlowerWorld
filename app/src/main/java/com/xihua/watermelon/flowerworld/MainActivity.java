package com.xihua.watermelon.flowerworld;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.xihua.watermelon.flowerworld.adapter.MyFragmentPagerAdapter;
import com.xihua.watermelon.flowerworld.adapter.MyPagerAdapter;
import com.xihua.watermelon.flowerworld.view.ControlFragment;
import com.xihua.watermelon.flowerworld.view.DiscoverFragment;
import com.xihua.watermelon.flowerworld.view.FriendCircle;
import com.xihua.watermelon.flowerworld.view.StoreFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    //页面滑动图标滚动
    private TextView tvControlNormal,tvControlPress;
    private TextView tvFriendcircleNormal,tvFriendcirclePress;
    private TextView tvDiscoverNormal,tvDiscoverPress;
    private TextView tvStoreNormal,tvStorePress;
    private TextView tvControlTextNormal,tvControlTextPress;
    private TextView tvFriendcircleTextNormal,tvFriendcircleTextPress;
    private TextView tvDiscoverTextNormal,tvDiscoverTextPress;
    private TextView tvStoreTextNormal,tvStoreTextPress;
    private ViewPager viewPager;


    //页面滑动
    private ViewPager vpager_one;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;
    //滑动界面调用

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //去掉toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initView() {
        /*
        vpager_one = (ViewPager) findViewById(R.id.id_viewpager);
        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.control,null,false));
        aList.add(li.inflate(R.layout.friendcircle,null,false));
        aList.add(li.inflate(R.layout.store,null,false));
        aList.add(li.inflate(R.layout.discover,null,false));
        mAdapter = new MyPagerAdapter(aList);
        vpager_one.setAdapter(mAdapter);
        */
        tvControlNormal = (TextView) findViewById(R.id.tv_control_normal);
        tvControlPress = (TextView) findViewById(R.id.tv_control_press);
        tvFriendcircleNormal = (TextView) findViewById(R.id.tv_friendcircle_normal);
        tvFriendcirclePress = (TextView) findViewById(R.id.tv_friendcircle_press);
        tvStoreNormal = (TextView) findViewById(R.id.tv_store_normal);
        tvStorePress = (TextView) findViewById(R.id.tv_store_press);
        tvDiscoverNormal = (TextView) findViewById(R.id.tv_discover_normal);
        tvDiscoverPress = (TextView) findViewById(R.id.tv_discover_press);

        tvControlTextNormal = (TextView) findViewById(R.id.tv_control_text_normal);
        tvControlTextPress = (TextView) findViewById(R.id.tv_control_text_press);
        tvFriendcircleTextNormal = (TextView) findViewById(R.id.tv_friendcircle_text_normal);
        tvFriendcircleTextPress = (TextView) findViewById(R.id.tv_friendcircle_text_press);
        tvStoreTextNormal = (TextView) findViewById(R.id.tv_store_text_normal);
        tvStoreTextPress = (TextView) findViewById(R.id.tv_store_text_press);
        tvDiscoverTextNormal = (TextView) findViewById(R.id.tv_discover_text_normal);
        tvDiscoverTextPress = (TextView) findViewById(R.id.tv_discover_text_press);

        findViewById(R.id.ll_control).setOnClickListener(this);
        findViewById(R.id.ll_friendcircle).setOnClickListener(this);
        findViewById(R.id.ll_store).setOnClickListener(this);
        findViewById(R.id.ll_discover).setOnClickListener(this);

        //默认选中第一个
        setTransparency();
        tvControlPress.getBackground().setAlpha(255);
        tvControlTextPress.setTextColor(Color.argb(255, 69, 192, 26));

        /**ViewPager**/
        viewPager = (ViewPager) findViewById(R.id.id_viewpager);
        ControlFragment controlFragment = new ControlFragment();
        FriendCircle friendCircleFragment = new FriendCircle();
        StoreFragment storeFragment = new StoreFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();
        ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(controlFragment);
        fragmentList.add(friendCircleFragment);
        fragmentList.add(storeFragment);
        fragmentList.add(discoverFragment);

        //ViewPager设置适配器
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
        //ViewPager显示第一个Fragment
        viewPager.setCurrentItem(0);
        //ViewPager页面切换监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //根据ViewPager滑动位置更改透明度
                int diaphaneity_one = (int) (255 * positionOffset);
                int diaphaneity_two = (int) (255 * (1 - positionOffset));
                switch (position) {
                    case 0:
                        tvControlNormal.getBackground().setAlpha(diaphaneity_one);
                        tvControlPress.getBackground().setAlpha(diaphaneity_two);
                        tvFriendcircleNormal.getBackground().setAlpha(diaphaneity_two);
                        tvFriendcirclePress.getBackground().setAlpha(diaphaneity_one);
                        tvControlTextNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
                        tvControlTextPress.setTextColor(Color.argb(diaphaneity_two, 69, 192, 26));
                        tvFriendcircleTextNormal.setTextColor(Color.argb(diaphaneity_two, 153, 153, 153));
                        tvFriendcircleTextPress.setTextColor(Color.argb(diaphaneity_one, 69, 192, 26));
                        break;
                    case 1:
                        tvFriendcircleNormal.getBackground().setAlpha(diaphaneity_one);
                        tvFriendcirclePress.getBackground().setAlpha(diaphaneity_two);
                        tvStoreNormal.getBackground().setAlpha(diaphaneity_two);
                        tvStorePress.getBackground().setAlpha(diaphaneity_one);
                        tvFriendcircleTextNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
                        tvFriendcircleTextPress.setTextColor(Color.argb(diaphaneity_two, 69, 192, 26));
                        tvStoreTextNormal.setTextColor(Color.argb(diaphaneity_two, 153, 153, 153));
                        tvStoreTextPress.setTextColor(Color.argb(diaphaneity_one, 69, 192, 26));
                        break;
                    case 2:
                        tvStoreNormal.getBackground().setAlpha(diaphaneity_one);
                        tvStorePress.getBackground().setAlpha(diaphaneity_two);
                        tvDiscoverNormal.getBackground().setAlpha(diaphaneity_two);
                        tvDiscoverPress.getBackground().setAlpha(diaphaneity_one);
                        tvStoreTextNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
                        tvStoreTextPress.setTextColor(Color.argb(diaphaneity_two, 69, 192, 26));
                        tvDiscoverTextNormal.setTextColor(Color.argb(diaphaneity_two, 153, 153, 153));
                        tvDiscoverTextPress.setTextColor(Color.argb(diaphaneity_one, 69, 192, 26));
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 设置透明度
     * 把press图片、文字全部隐藏
     */
    private void setTransparency() {
        tvControlNormal.getBackground().setAlpha(255);
        tvFriendcircleNormal.getBackground().setAlpha(255);
        tvStoreNormal.getBackground().setAlpha(255);
        tvDiscoverNormal.getBackground().setAlpha(255);

        tvControlPress.getBackground().setAlpha(1);
        tvFriendcirclePress.getBackground().setAlpha(1);
        tvStorePress.getBackground().setAlpha(1);
        tvDiscoverPress.getBackground().setAlpha(1);

        tvControlTextNormal.setTextColor(Color.argb(255, 153, 153, 153));
        tvFriendcircleTextNormal.setTextColor(Color.argb(255, 153, 153, 153));
        tvStoreTextNormal.setTextColor(Color.argb(255, 153, 153, 153));
        tvDiscoverTextNormal.setTextColor(Color.argb(255, 153, 153, 153));

        tvControlTextPress.setTextColor(Color.argb(0, 69, 192, 26));
        tvFriendcircleTextPress.setTextColor(Color.argb(0, 69, 192, 26));
        tvStoreTextPress.setTextColor(Color.argb(0, 69, 192, 26));
        tvDiscoverTextPress.setTextColor(Color.argb(0, 69, 192, 26));
    }

    @Override
    public void onClick(View v) {
        setTransparency();
        tvStoreNormal.getBackground().setAlpha(255);
        switch (v.getId()){
            case R.id.ll_control:
                viewPager.setCurrentItem(0, false);
                tvControlPress.getBackground().setAlpha(255);
                tvControlTextPress.setTextColor(Color.argb(255, 69, 192, 26));
                break;
            case R.id.ll_friendcircle:
                viewPager.setCurrentItem(1, false);
                tvFriendcirclePress.getBackground().setAlpha(255);
                tvFriendcircleTextPress.setTextColor(Color.argb(255, 69, 192, 26));
                break;
            case R.id.ll_store:
                viewPager.setCurrentItem(2,false);
                //tvStoreNormal.getBackground().setAlpha(0);
                tvStorePress.getBackground().setAlpha(255);
                tvStoreTextPress.setTextColor(Color.argb(255, 69, 192, 26));
                break;
            case R.id.ll_discover:
                viewPager.setCurrentItem(3,false);
                tvDiscoverPress.getBackground().setAlpha(255);
                tvDiscoverTextPress.setTextColor(Color.argb(255, 69, 192, 26));
                break;
        }
    }



    /*
    *自定义函数
*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //toolbar事件
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id){
            case R.id.search_icon:
                Intent intent = new Intent(MainActivity.this, Search_icon.class);
                startActivity(intent);
                break;
            case R.id.plus_iocn:
                return true;
        }

        //noinspection SimplifiableIfStatement

    //  if (id == R.id.action_settings) {
    //        return true;
        // }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
