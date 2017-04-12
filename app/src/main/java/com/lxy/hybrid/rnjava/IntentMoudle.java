package com.lxy.hybrid.rnjava;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.lxy.hybrid.RnActivity;

/**
 * Created by lxy on 2017/4/11.
 */

public class IntentMoudle extends ReactContextBaseJavaModule {

    public IntentMoudle(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "IntentMoudle";
    }

    /**
     * @param name   类名，全路径名
     * @param params
     */
    @ReactMethod
    public void startActivityFromJs(String name, String params) {

        try {

            Activity currentActivity = getCurrentActivity();

            if (null != currentActivity) {
                Class toActivity = Class.forName(name);
                Intent intent = new Intent(currentActivity, toActivity);
                intent.putExtra("params", params);
                currentActivity.startActivity(intent);
            }

        } catch (Exception e) {
            Toast.makeText(getReactApplicationContext(), "不能打开Activity : " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @ReactMethod
    public void startActivityFromJsGetResult(String className, int requestCode, Callback successCallback, Callback errorCallback) {

        try {
            Activity currentActivity = getCurrentActivity();
            if (null != currentActivity) {
                Class toActivity = Class.forName(className);
                Intent intent = new Intent(currentActivity, toActivity);
                currentActivity.startActivityForResult(intent, requestCode);
                //进行回调数据
                successCallback.invoke(RnActivity.mQueue.take());
            }

        } catch (Exception e) {
            errorCallback.invoke(e.getMessage());
            e.printStackTrace();
        }
    }

}
