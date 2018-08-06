package com.cetcme.m.net;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

public abstract class MNetHelperAbstract {

    private static Retrofit retrofit;
    private static final int DEFAULT_TIMEOUT = 5;


    protected MNetHelperAbstract() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .client(getOkHttpClient() == null ? okHttpClient : getOkHttpClient())
                .baseUrl(getBaseUrl())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
    }

    protected abstract OkHttpClient getOkHttpClient();

    protected abstract @NonNull String getBaseUrl();

    protected <T> T createService(Class<T> cls) {
        return retrofit.create(cls);
    }
}
