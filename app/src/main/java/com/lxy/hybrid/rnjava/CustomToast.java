package com.lxy.hybrid.rnjava;

import android.content.Intent;
import android.sax.StartElementListener;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.lxy.hybrid.NativeActivity;

/**
 * Created by lxy on 2017/4/11.
 * 原生模块封装，供js调用
 */

public class CustomToast extends ReactContextBaseJavaModule {

    public CustomToast(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        // 返回CustomToast 用来代表给模块，这样在前端可以用React.NativeModules.CustomToast访问到这个模块
        return "CustomToast";
    }

    @ReactMethod
    public void showToast(String content, int duration) {
        Toast.makeText(getReactApplicationContext(), content, duration).show();
    }

    @ReactMethod
    public void pageJump(){
        Intent intent = new Intent(getReactApplicationContext(), NativeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getReactApplicationContext().startActivity(intent);
    }
}
