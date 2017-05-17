package q.lunbo;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;


import com.example.duan.lianxi.R;

import java.util.ArrayList;


/**
 * Created by WangLu on 16/9/1.
 */
    public class FragmentAdapterDemo extends BannerPagerAdapter {

        private Context mContext;
        private ArrayList<String> data;

        public FragmentAdapterDemo(Context context, ArrayList<String> data) {
            super(context, data);
            mContext = context;
            this.data = data;
        }

        /**
         * 只需要重写构造和这个方法即可
         * 在这里可以设置自己的View,使用自己的图片加载库
         */
        @Override
        public View setView(int position) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.fragment_auto, null);
         /*   SimpleDraweeView iv1 = (SimpleDraweeView) v.findViewById(R.id.sdv1);
            setIma(iv1,data.get(position).get(0).getImg());
            TextView tv1=(TextView)v.findViewById(R.id.money1);
            tv1.setText(data.get(position).get(0).getPrice());
            SimpleDraweeView iv2 = (SimpleDraweeView) v.findViewById(R.id.sdv2);
            setIma(iv2,data.get(position).get(1).getImg());
            TextView tv2=(TextView)v.findViewById(R.id.money2);
            tv2.setText(data.get(position).get(1).getPrice());
            SimpleDraweeView iv3 = (SimpleDraweeView) v.findViewById(R.id.sdv3);
            setIma(iv3,data.get(position).get(2).getImg());
            TextView tv3=(TextView)v.findViewById(R.id.money3);
            tv3.setText(data.get(position).get(2).getPrice());*/
            return v;
        }

   /* private void setIma(SimpleDraweeView sdv,String string){
        String str = ".gif";
        if(string.endsWith(str)){
            DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                    .setUri(Uri.parse(string))
                    .setAutoPlayAnimations(true) // 设置加载图片完成后是否直接进行播放
                    .build();
            sdv.setController(draweeController);
        }else {
            sdv.setImageURI(Uri.parse(string));
        }
    }*/
    }
