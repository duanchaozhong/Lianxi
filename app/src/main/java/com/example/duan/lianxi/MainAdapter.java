package com.example.duan.lianxi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by duan on 2016/9/28.
 */
public class MainAdapter extends BaseAdapter{
    private Context context;
    private List<String>list;
    public MainAdapter(Context context, List<String>list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler hodler;
        if (convertView == null) {
            hodler = new ViewHodler();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_main, null);
            hodler.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(hodler);
        } else {
            hodler = (ViewHodler) convertView.getTag();
        }
        hodler.tv.setText(list.get(position));
        return convertView;
    }
    class ViewHodler {
        TextView tv;
    }
}
