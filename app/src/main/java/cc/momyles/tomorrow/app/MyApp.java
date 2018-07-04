package cc.momyles.tomorrow.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

import cc.momyles.tomorrow.listener.FocusListener;

public class MyApp extends Application {
    public static final String SP_NAME = "MyApp";

    private static MyApp instance = null;

    private static FocusListener focusListener = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        focusListener = new FocusListener();
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

    public FocusListener focus() {
        return focusListener;
    }
}
