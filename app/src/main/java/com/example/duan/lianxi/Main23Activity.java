package com.example.duan.lianxi;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

import litepal.DataArrayAdapter;
import litepal.News;

/***
 * 需要加入compile 'org.litepal.android:core:1.5.1'
 * 在application初始化，创建litepal.xml文件(文件中声明表的名字)
 * */
public class Main23Activity extends Activity{
    private Toolbar toolbar;
    private Button button1;//创建表
    private Button button2;//添加数据
    private Button button3;//更新数据
    private Button button4;//删除数据
    private Button button5;//查询数据
    private ListView lv;
    private DataArrayAdapter mAdapter;
    private ProgressBar mProgressBar;
    private List<List<String>> mList = new ArrayList<List<String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);
        setViews();
        setListener();
    }

    private void setViews() {
        mProgressBar = (ProgressBar) findViewById(R.id.pro);
        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button4);
        button5= (Button) findViewById(R.id.button5);
        lv= (ListView) findViewById(R.id.lv);
        mAdapter = new DataArrayAdapter(this, 0, mList);
        lv.setAdapter(mAdapter);
        populateDataFromDB();
    }

    private void setListener() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Connector.getDatabase();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                News person=new News();
                person.setName("帅哥");
                person.setAge(20);
             //   person.setId(1);
                person.setMale(0);
                person.save();
                refreshListView(person.getId(),"帅哥",20,0);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                News person=new News();
                person.setName("美女");
                person.setAge(19);
                //person.updateAll("name=? and age=?","帅哥","20");
                person.update(Long.parseLong("33"));    //把id为33的数据更新
                populateDataFromDB();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // person.delete();//直接删除这张表
                    //DataSupport.delete(News.class,1);//删除News表中id为1的数据
                    DataSupport.deleteAll(News.class, "name=? and age=?" ,"帅哥","20");
                    populateDataFromDB();
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
    private void refreshListView(long id, String name, int age, int isMale) {
        List<String> stringList = new ArrayList<String>();
        stringList.add(String.valueOf(id));
        stringList.add(name);
        stringList.add(String.valueOf(age));
        stringList.add(String.valueOf(isMale));
        mList.add(stringList);
        mAdapter.notifyDataSetChanged();
        lv.setSelection(mList.size());
    }
    private void populateDataFromDB() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mList.clear();      //列表中显示的数据的集合
                List<String> columnList = new ArrayList<String>();
                columnList.add("id");
                columnList.add("名字");
                columnList.add("年龄");
                columnList.add("受法律");
                mList.add(columnList);
                Cursor cursor = null;
                try {
                    //将表中的数据全部赋值到列表中
                    cursor = Connector.getDatabase().rawQuery("select * from news order by id",null);
                    if (cursor.moveToFirst()) {
                        do {
                            long id = cursor.getLong(cursor.getColumnIndex("id"));
                            String name = cursor.getString(cursor.getColumnIndex("name"));
                            int age = cursor.getInt(cursor.getColumnIndex("age"));
                            int isMale = cursor.getInt(cursor.getColumnIndex("ismale"));
                            List<String> stringList = new ArrayList<String>();
                            stringList.add(String.valueOf(id));
                            stringList.add(name);
                            stringList.add(String.valueOf(age));
                            stringList.add(String.valueOf(isMale));
                            mList.add(stringList);
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setVisibility(View.GONE);
                            mAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        }).start();
    }
}
