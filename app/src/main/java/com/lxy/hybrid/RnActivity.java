package com.lxy.hybrid;

import android.content.Intent;

import com.facebook.react.ReactActivity;

import java.util.concurrent.ArrayBlockingQueue;

import javax.annotation.Nullable;

public class RnActivity extends ReactActivity {

    @Nullable
    @Override
    protected String getMainComponentName() {
        return "gank";

    }

    //构建一个阻塞的单一数据队列
    public static ArrayBlockingQueue<String> mQueue = new ArrayBlockingQueue<String>(1);

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 200) {

            String result = data.getStringExtra("result");
            if (result != null && !result.equals("")) {
                mQueue.add(result);
            } else {
                mQueue.add("无数据啦");
            }

        } else {
            mQueue.add("没有回调...");
        }
    }

}
