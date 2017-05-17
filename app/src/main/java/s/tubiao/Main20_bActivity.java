package s.tubiao;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.duan.lianxi.R;

/**
 * 需要导入依赖包MPChartLib
 *
 * XAxis 为 X轴的类

 Entry 为每个点的类

 DataSet 一组Y轴上面的数据

 Linedata 整个Y轴的数据
 * */
public class Main20_bActivity extends Activity {
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main20_b);
        setViews();
        setListener();
    }

    private void setViews() {
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
    }

    private void setListener() {
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main20_bActivity.this,Main20_b_aActivity.class);
                startActivity(intent);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main20_bActivity.this,Main20_b_bActivity.class);
                startActivity(intent);
            }
        });
    }
}
