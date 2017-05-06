package com.lxy.hybrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goRnPage(View view) {
        Intent intent = new Intent(MainActivity.this, RnActivity.class);
        intent.putExtra("value", "page1");
        startActivity(intent);
    }

    public void goRnPage2(View view) {
        Intent intent = new Intent(MainActivity.this, RnActivity.class);
        intent.putExtra("value", "page2");
        startActivity(intent);

    }
}
