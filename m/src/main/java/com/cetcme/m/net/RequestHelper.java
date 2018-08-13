package com.cetcme.m.net;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.cetcme.m.helper.LoadingHelper;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RequestHelper {
    private static AlertDialog alert = null;

    public RequestHelper(Context context) {
        alert = LoadingHelper.defaultLoading(context);
    }

    public <T> Disposable doRequestWithLoading(Observable<T> observable, final OnRequestListener<T> requestListener) {
        if (observable == null) return null;
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        showAlert();
                    }
                })
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        if (requestListener != null) {
                            requestListener.success(t);
                        }
                        hideAlert();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (requestListener != null) {
                            requestListener.failure(throwable);
                        }
                        hideAlert();
                    }
                });
    }

    public <T> Disposable doRequest(Observable<T> observable, final OnRequestListener<T> requestListener) {
        if (observable == null) return null;
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        if (requestListener != null) {
                            requestListener.success(t);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (requestListener != null) {
                            requestListener.failure(throwable);
                        }
                    }
                });
    }

    private void showAlert() {
        if (alert != null && !alert.isShowing()) {
            alert.show();
        }
    }

    private void hideAlert() {
        if (alert != null && alert.isShowing()) {
            alert.dismiss();
        }
    }

    public interface OnRequestListener<T> {
        void success(T t);

        void failure(Throwable throwable);
    }
}
