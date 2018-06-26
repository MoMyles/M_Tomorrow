package cc.momyles.tomorrow.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

public class MyApp extends Application {
    public static final String SP_NAME = "MyApp";

    private static MyApp instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }

    public static MyApp getContext() {
        return instance;
    }
}
