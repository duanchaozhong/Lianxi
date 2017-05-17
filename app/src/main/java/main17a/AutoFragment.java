package main17a;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan.lianxi.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class AutoFragment extends Fragment {
    private View view;
    private SimpleDraweeView sdv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            Fresco.initialize(getActivity());
            view=inflater.inflate(R.layout.fragment_auto, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setViews();
        setListener();
    }

    private void setViews() {
        sdv= (SimpleDraweeView) view.findViewById(R.id.sdv1);
        String str = ".gif";
        if("https://www.yueyetv.com/UploadFiles/CAR/110809890.gif".endsWith(str)){
            DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                    .setUri(Uri.parse("https://www.yueyetv.com/UploadFiles/CAR/110809890.gif"))
                    .setAutoPlayAnimations(true) // 设置加载图片完成后是否直接进行播放
                    .build();
            sdv.setController(draweeController);
        }else {
            sdv.setImageURI(Uri.parse("https://www.yueyetv.com/UploadFiles/CAR/110809890.gif"));
        }
    }

    private void setListener() {
    }
}
