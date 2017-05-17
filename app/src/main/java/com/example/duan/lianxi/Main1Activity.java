package com.example.duan.lianxi;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *  动画
 * */
public class Main1Activity extends Activity implements ValueAnimator.AnimatorUpdateListener{
    public static Main1Activity instance;
    private TextView tv;
    private TextView tv2;
    private ImageView iv;
    private TextView number;
    private AnimationDrawable animationDrawable;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        //设置全屏
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //显示自定义的SurfaceView视图
        //setContentView(new MySurfaceView(this));

        setContentView(R.layout.activity_main1);
        iv=(ImageView)findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnimation(R.anim.rotate,iv);
            }
        });
        ImageView img = (ImageView) findViewById(R.id.image);
        img.setImageResource(R.drawable.anim);
        animationDrawable = (AnimationDrawable) img.getDrawable();
        animationDrawable.start();

        tv=(TextView)findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv, "TranslationY", 0, 300,-300,0);
                //objectAnimator.addUpdateListener(this);
                objectAnimator.setDuration(800);
                objectAnimator.start();
            }
        });
        tv2=(TextView)findViewById(R.id.tv2);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //下面是补位动画   tv2必须在tv的上方才行，原因不知道
                TranslateAnimation animation = new TranslateAnimation(0, 0, 0, 300);
                animation.setDuration(1000);
                animation.setFillAfter(true);
                tv.startAnimation(animation);
            }
        });

        number=(TextView)findViewById(R.id.number);
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofInt(number, "age", 1, 100);
                //objectAnimator.addUpdateListener(this);
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        //监听动画的每次变动
                        int values = (int) animation.getAnimatedValue();
                        number.setText(String.valueOf(values));
                    }
                });
                objectAnimator.setDuration(5000);
                objectAnimator.start();
            }
        });
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {

    }

    private void setAnimation(int id,ImageView iv){
        Animation operatingAnim = AnimationUtils.loadAnimation(Main1Activity.this, id);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        if (operatingAnim != null) {
            iv.startAnimation(operatingAnim);
        }
    }
}
