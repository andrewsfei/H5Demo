package com.andrew.andrew.h5demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private WebView mWeb_h5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setLinster();
    }

    private void setLinster() {
    }

    private void init() {
        mWeb_h5 = (WebView)findViewById(R.id.web_h5);
        mWeb_h5.getSettings().setJavaScriptEnabled(true);
        String url = "file:///android_asset/h5.html";
        mWeb_h5.addJavascriptInterface(this,"nativeMethod");
        mWeb_h5.loadUrl(url);
    }


    @JavascriptInterface
    public void toActivity(String activityName) {
        //此处应该定义常量对应，同时提供给web页面编写者
        if(TextUtils.equals(activityName, "a")){
            startActivity(new Intent(this,PassActivity.class));
        }else{
            Toast.makeText(MainActivity.this,"难道出错了？？？",Toast.LENGTH_SHORT).show();
        }
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWeb_h5.canGoBack()) {
            mWeb_h5.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onClick(View v) {

    }
}
