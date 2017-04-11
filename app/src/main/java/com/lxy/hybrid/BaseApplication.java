package com.lxy.hybrid;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.lxy.hybrid.rnjava.ToastReactPackage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lxy on 2017/4/10.
 */

public class BaseApplication extends Application implements ReactApplication {


    private ReactNativeHost mHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {

            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new ToastReactPackage()
            );
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mHost;
    }

}
