package com.example.wing.demo;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by wing on 2017/10/26.
 */

public class JSKit {
    /*
        * 绑定的object对象
        * */
    private Context context;

    public JSKit(Context context) {
        this.context = context;
    }

    /*
     * JS调用android的方法
     * @JavascriptInterface仍然必不可少
     *
     * */
    @JavascriptInterface
    public String JsCallAndroid() {

        Toast.makeText(context, "JsCallAndroid", Toast.LENGTH_SHORT).show();

        return "JS call Andorid";
    }
}
