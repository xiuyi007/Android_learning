package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWbv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWbv = findViewById(R.id.wv_1);
        //   file:///android_asset/  这个路径就定位到了asset目录
        //加载本地html
        mWbv.loadUrl("file:///android_asset/helloworld.html");
        //加载网络URL
        mWbv.getSettings().setJavaScriptEnabled(true); //设置支持js，否则网页如果需要js的支持，就显示不出来了
        mWbv.setWebViewClient(new MyWebViewClient()); //仅个人理解：配置webview的client，控制webView
        mWbv.setWebChromeClient(new MyWebChromeClient());//仅个人理解：配置webChromeView的client，对打开的浏览器进行控制
        mWbv.loadUrl("https://m.baidu.com");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWbv.canGoBack())
        {
            mWbv.goBack();
        }
        return true;
    }

    class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }


    }

    //跳转页面时，默认会希望访问浏览器以打开页面，重写这个方法使进入新页面时，载入到webview而不是用浏览器打开。
    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("webView", "onPageStarted");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("webView", "onPageFinished");
        }
    }
}