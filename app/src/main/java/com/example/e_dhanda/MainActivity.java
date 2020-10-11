package com.example.e_dhanda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent mInHome = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(mInHome);
                MainActivity.this.finish();
            }
        }, 3000);
    }
}