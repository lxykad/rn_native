package com.lxy.hybrid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);
    }

    public void btOnClick(View view){
        Intent intent = new Intent();
        intent.putExtra("result","NativeActivity返回的数据");
        this.setResult(Activity.RESULT_OK,intent);
        this.finish();
    }
}
