package cc.momyles.tomorrow.app;

import android.app.Application;

public class MyApp extends Application {
    public static final String SP_NAME = "MyApp";

    private static MyApp instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
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
