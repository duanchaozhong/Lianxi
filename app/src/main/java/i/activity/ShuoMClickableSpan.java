package i.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/**
 * Created by duan on 2016/9/28.
 */
public class ShuoMClickableSpan extends ClickableSpan {

    String string;
    Context context;
    String type;
    public ShuoMClickableSpan(String str, Context context,String type){
        super();
        this.string = str;
        this.context = context;
        this.type=type;
    }


    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(Color.BLUE);
    }


    @Override
    public void onClick(View widget) {
        if(type.equals("1")){
            Intent intent = new Intent();
            intent.setClass(context, TwoActivity.class);
            context.startActivity(intent);
        }

    }
}
