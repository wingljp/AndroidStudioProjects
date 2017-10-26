package com.example.wing.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private Button btnShowInfo;
    private JSKit js;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//初始化控件
        mWebView = (WebView) findViewById(R.id.wv_test);
        btnShowInfo = (Button) findViewById(R.id.btn_showmsg);

//设置参数
        mWebView.getSettings().setBuiltInZoomControls(true);
//内容的渲染需要webviewChromClient去实现，
//设置webviewChromClient基类，解决js中alert不弹出的问题和其他内容渲染问题
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.getSettings().setJavaScriptEnabled(true);

         js=new JSKit();
//把js绑定到全局的myjs上，myjs的作用域是全局的，初始化后可随处使用J
        mWebView.addJavascriptInterface(js, "myjs");
        mWebView.loadUrl("file:///android_asset/ll.html");
        btnShowInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //调用 HTML 中的javaScript 函数
                        mWebView.loadUrl("javascript:showMsg('顺便传个参数给JS！')");

                    }
                });
            }
        });
    }

    class JSKit {


        @JavascriptInterface
        public void JsCallAndroid() {

            finish();


        }

    }
}
