package com.cetcme.m;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

public class M extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
