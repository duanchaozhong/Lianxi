package com.example.duan.lianxi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import i.activity.ShuoMClickableSpan;
/**
 * textview部分颜色
 * */
public class Main8Activity extends Activity {
    private TextView tv;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        tv=(TextView)findViewById(R.id.tv);
        String ttt = "嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻";
        String sss = "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈";
        SpannableString spanttt = new SpannableString(ttt);
        SpannableString spansss = new SpannableString(sss);
        ClickableSpan clickttt = new ShuoMClickableSpan(ttt, this,"1");
        ClickableSpan clicksss = new ShuoMClickableSpan(ttt, this,"0");
        spanttt.setSpan(clickttt, 0, ttt.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spansss.setSpan(clicksss, 0, sss.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv.setText("哈哈");
        tv.append(spanttt);
        tv.append("你是谁你谁你是谁你谁你是谁你谁");
        tv.append(spansss);
        tv.append("你是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁");
        tv.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
