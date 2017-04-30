package s.tubiao;

import android.app.Activity;
import android.os.Bundle;

import com.example.duan.lianxi.R;

/**
 * jgraph框架
 * 需要导入jgraph依赖包
 * */
public class Main20_aActivity extends Activity {
  //  private JcoolGraph biao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main20_a);
        setViews();
        setListener();
    }

    private void setViews() {
      //  biao= (JcoolGraph) findViewById(R.id.sug_recode_line);
    }

    private void setListener() {

    }
}
