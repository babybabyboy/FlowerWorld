package com.xihua.watermelon.flowerworld;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.xihua.watermelon.flowerworld.Search_icon;

public class Search_icon extends Activity {
    private ImageView backIcon;
    private EditText searcheditText;
    private ImageView searchIcon;
    private WebView searchwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_icon);
        init();
        //使用toolbar的导航栏
        /*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        */
    }

    private void init()
    {
        backIcon = (ImageView)findViewById(R.id.id_search_back_icon);
        searchIcon = (ImageView) findViewById(R.id.id_search_icon);
        searcheditText = (EditText) findViewById(R.id.id_search_edittext);
        searchwebView = (WebView) findViewById(R.id.id_search_webview);

        //网页加载
        searchwebView.getSettings().setJavaScriptEnabled(true);
        //添加一个WebViewClient类
        searchwebView.setWebViewClient(new MyWebViewClient());
        //searchwebView.loadUrl("https://m.baidu.com/s?from=1019023i&wd=xhu");
        //重写返回

        backIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        searchIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String test = searcheditText.getText().toString();
                searchwebView.loadUrl("https://m.baidu.com/s?from=1019023i&wd="+test);
                //Toast.makeText(Search_icon.this, test, Toast.LENGTH_SHORT).show();

            }
        });

    }

    /*重写返回
    * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && searchwebView.canGoBack())
        {
            searchwebView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    /*OK*/


    /*在web内部打开网页
    * */
    class MyWebViewClient extends WebViewClient
    {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            super.shouldOverrideUrlLoading(view, request);
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}
