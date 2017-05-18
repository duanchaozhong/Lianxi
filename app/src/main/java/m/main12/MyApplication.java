package m.main12;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Weiping on 2016/3/23.
 */
public class MyApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }

}
