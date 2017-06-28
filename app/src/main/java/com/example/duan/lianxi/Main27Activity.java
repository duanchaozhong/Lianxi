package com.example.duan.lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import activity27.CretinAutoUpdateUtils;

/**
 * APP更新
 *      在application添加
 *      CretinAutoUpdateUtils.Builder builder = new CretinAutoUpdateUtils.Builder()
         .setBaseUrl("http://101.201.31.212:8016/version/checkVersion")
         .setIgnoreThisVersion(true)
         .setShowType(CretinAutoUpdateUtils.Builder.TYPE_DIALOG)
         .setIconRes(R.mipmap.ic_launcher)
         .showLog(true)
         .setRequestMethod(CretinAutoUpdateUtils.Builder.METHOD_GET)
         .setTransition(new UpdateModel())
         .build();
         CretinAutoUpdateUtils.init(builder);

 *   <uses-permission android:name="android.permission.INTERNET"/>
     <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
     <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
     <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
     <service android:name="activity27.DownloadService"/>
     <provider
         android:name="android.support.v4.content.FileProvider"
         android:authorities="${applicationId}.fileprovider"
         android:grantUriPermissions="true"
         android:exported="false">
         <meta-data
         android:name="android.support.FILE_PROVIDER_PATHS"
         android:resource="@xml/install_file" />
     </provider>

 *   添加xml包
 *
 *      添加layout_notification.xml
        添加filemgr.xml
 *
 * */
public class Main27Activity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main27);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CretinAutoUpdateUtils.getInstance(Main27Activity.this).check();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CretinAutoUpdateUtils.getInstance(this).destroy();
    }
}
