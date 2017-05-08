package com.lxy.hybrid.rnjava;

import android.app.Activity;
import android.text.TextUtils;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Created by lxy on 2017/5/6.
 */

public class ValueUtil extends ReactContextBaseJavaModule {

    public static final String MESSAGE_KEY = "android_message";
    ReactApplicationContext mReactContext;

    public ValueUtil(ReactApplicationContext mReactContext) {
        super(mReactContext);
        this.mReactContext = mReactContext;
    }

    @Override
    public String getName() {

        return "ValueUtil";
    }


    @ReactMethod  //提供给js调用的方法，异步回调
    public void getValueFromNative(Callback successCallback, Callback errorCallback) {

        try {

            Activity activity = mReactContext.getCurrentActivity();
            String value = activity.getIntent().getStringExtra("value");
            if (TextUtils.isEmpty(value)) {
                value = "";
            }
            successCallback.invoke(value);
        } catch (Exception e) {
            errorCallback.invoke(e.getMessage());
        }

    }

    @ReactMethod
    public void getValueFromNativePromise(Promise promise){

        try {

            Activity activity = mReactContext.getCurrentActivity();
            String value = activity.getIntent().getStringExtra("value");
            if (TextUtils.isEmpty(value)) {
                value = "";
            }
            promise.resolve(value);


        } catch (Exception e) {
            //promise失败
            promise.reject("100",e.getMessage());

        }

    }

    /**
     * native 端发送消息给js，此方法为异步不能有返回值
     */
    public void sendMessageToJs(String msg) {
        mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(MESSAGE_KEY, msg);
    }


}
