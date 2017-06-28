package com.example.duan.lianxi;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

import activity29.TouchFingerImageView;

public class Main29Activity extends Activity {
    private SimpleDraweeView sdv;
    private TouchFingerImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main29);
        sdv=(SimpleDraweeView)findViewById(R.id.sdv);
        iv=(TouchFingerImageView) findViewById(R.id.iv);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.sdv:break;
            case R.id.iv:break;
        }
    }
}
