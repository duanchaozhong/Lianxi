package s.tubiao;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan.lianxi.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Main20_b_dActivity extends DemoBase{
    private BarChart mChart;
    private List<Score>result=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main20_b_d);
        mChart = (BarChart) findViewById(R.id.chart1);
        //设置图表右下角的描述文字是否显示
        mChart.getDescription().setEnabled(false);
        // 设置最大可见值的数量
        mChart.setMaxVisibleValueCount(60);
        // 缩放现在只能分别在x和y轴上进行
        mChart.setPinchZoom(false);
        mChart.setDrawBarShadow(false);
        mChart.setDrawGridBackground(false);
        //得到X坐标轴
        XAxis xAxis = mChart.getXAxis();
        //设置坐标文字显示在下方
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //是否显示Y坐标轴上的刻度竖线，默认是true
        mChart.getAxisLeft().setDrawGridLines(true);
        mChart.getAxisLeft().setGridColor(Color.RED);
        mChart.getAxisRight().setEnabled(false);
        mChart.getAxisLeft().setLabelCount(7);
        //设置Y轴是否从0开始
        mChart.getAxisLeft().setStartAtZero(true);

        //设置X坐标轴上的刻度线
        xAxis.setGridColor(Color.BLUE);
        xAxis.setAxisLineColor(Color.RED);
        xAxis.setLabelCount(5);
        setData();
        // 添加一个平滑的动画
        mChart.animateY(2500);
        mChart.getLegend().setEnabled(false);
    }
    private void setData(){
 //       result.add("张三");result.add("李四");result.add("王五");result.add("狗六");result.add("刘七");
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        yVals1.add(new BarEntry(1, 7));
        yVals1.add(new BarEntry(2, 3));
        yVals1.add(new BarEntry(3, 5));
        yVals1.add(new BarEntry(4, 6));
        yVals1.add(new BarEntry(5, 4));

        Score score1 = new Score(100f, 0f, "Peter");
        Score score2 = new Score(100f, 0f, "张三");
        result.add(score1);result.add(score2);result.add(score1);result.add(score1);result.add(score1);
        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return result.get((int) value-1).getPlayerName();
            }
        };
        mChart.getXAxis().setValueFormatter(formatter);
        BarDataSet set1;
        if (mChart.getData() != null && mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet)mChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Data Set");
            set1.setColors(ColorTemplate.VORDIPLOM_COLORS);
            set1.setDrawValues(false);
            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            BarData data = new BarData(dataSets);
            mChart.setData(data);
            mChart.setFitBars(true);
        }
        //是图表刷新
        mChart.invalidate();
    }
}
