package com.lxy.hybrid.rnjava;

import android.app.Activity;
import android.text.TextUtils;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by lxy on 2017/5/6.
 */

public class ValueUtil extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;

    public ValueUtil(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {

        return "ValueUtil";
    }

    @ReactMethod
    public void getValueFromNative(Callback successCallback, Callback errorCallback) {

        try {

            Activity activity = reactContext.getCurrentActivity();
            String value = activity.getIntent().getStringExtra("value");
            if (TextUtils.isEmpty(value)) {
                value = "";
            }
            successCallback.invoke(value);
        } catch (Exception e) {
            errorCallback.invoke(e.getMessage());
        }

    }

}
