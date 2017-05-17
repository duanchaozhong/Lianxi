package com.example.duan.lianxi;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import okhttp3.Call;
import okhttp3.Request;

/**
 * 使用jc视频播放器需要添加 <uses-permission android:name="android.permission.INTERNET" />
 * 需要在application进行初始化
 *
 * 用到下载的话需要添加classpath 'com.novoda:bintray-release:0.3.4'
 *<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
 * */
public class Main22Activity extends AppCompatActivity {
    private JCVideoPlayer jcVideoPlayer;
    private Button button;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        setViews();
    }

    private void setViews() {
        jcVideoPlayer = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        button=(Button)findViewById(R.id.button);
        mProgressBar=(ProgressBar)findViewById(R.id.id_progress);
        jcVideoPlayer.setUp(this.getFilesDir().getPath()+"/adow.mp4",
                "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640",
                "嫂子别摸我");
        SimpleDraweeView sdv =(SimpleDraweeView)findViewById(R.id.sdv);
        jcVideoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFile();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    public void downloadFile() {
        Log.i("dcz",this.getFilesDir().getPath());
        String url = "http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4";
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//.execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "adow.mp4")//
                .execute(new FileCallBack(this.getFilesDir().getPath(), "adow.mp4")//
                {
                    @Override
                    public void onBefore(Request request, int id)
                    {
                    }

                    @Override
                    public void inProgress(float progress, long total, int id)
                    {
                        mProgressBar.setProgress((int) (100 * progress));
                        Log.e("dcz", "inProgress :" + (int) (100 * progress));
                    }

                    @Override
                    public void onError(Call call, Exception e, int id)
                    {
                        Log.e("dcz", "onError :" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File file, int id)
                    {
                        Log.e("dcz", "onResponse :" + file.getAbsolutePath());
                    }
                });
    }
}
