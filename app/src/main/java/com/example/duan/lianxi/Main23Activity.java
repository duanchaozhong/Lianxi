package com.example.duan.lianxi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import litepal.BaseActivity;
import litepal.News;

/***
 * 需要加入compile 'org.litepal.android:core:1.5.1'
 * 在application初始化，创建litepal.xml文件
 * */
public class Main23Activity extends Activity{
    private Toolbar toolbar;
    private Button button1;//创建表
    private Button button2;//添加数据
    private Button button3;//更新数据
    private Button button4;//删除数据
    private Button button5;//查询数据
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);
        setViews();
        setListener();
    }

    private void setViews() {
        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button4);
        button5= (Button) findViewById(R.id.button5);
    }

    private void setListener() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                News person=new News();
                person.setName("我叫帅哥");
                person.setAuthor("shui");
                person.setPages(454);
                person.setPrice(16.96);
                person.save();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                News person=new News();
                person.setPrice(19.9);
                person.setPages(588);
                person.updateAll("name=?","我叫帅哥");  //意思是把名字为“我叫帅哥”的这本书的价格和页数改为19.9和588
               // person.delete();//直接删除这张表
            /*    News person2=new News();
                person2.setToDefault("pages");          //意思是把页数更新为默认值“0”
                person2.updateAll();                    //意思是把所有书的页数都更新为0*/
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSupport.deleteAll(News.class,"price<?","15");       //删除News表中价格低于15的书
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<News>list=DataSupport.findAll(News.class);
                for(News news:list){
                    Log.i("查询name",news.getName());
                }
            }
        });
    }
}
