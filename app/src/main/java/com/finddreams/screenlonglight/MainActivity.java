package com.finddreams.screenlonglight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LongLightUtils.keepScreenLongLight(this);
//        LongLightUtils.openWakeLock(this);
    }

    public void openLandScape(View view) {
        startActivity(new Intent(this, LandScapeActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        LongLightUtils.closeWakeLock(this);
    }
}
