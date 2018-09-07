package com.andrew.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewTools {

    public static WebView webview = null;

    @SuppressLint("SetJavaScriptEnabled")
    public static void showWebView(Context context) {
        if (webview != null) {

            webview.setHorizontalScrollBarEnabled(true);
            webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);
            webview.setHapticFeedbackEnabled(false);
            WebSettings settings = webview.getSettings();
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setJavaScriptEnabled(true);

            // 放大缩小效果
            // settings.setBuiltInZoomControls(true);
            // settings.setUseWideViewPort(true);


            /***
             * 测试git上传数据。。。
             */
        }
    }

}
