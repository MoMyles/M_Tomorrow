package com.cetcme.m.helper;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.widget.RelativeLayout;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.indicators.BallSpinFadeLoaderIndicator;

public class LoadingHelper {
    public static AlertDialog defaultLoading(Context context) {
        final RelativeLayout rl = new RelativeLayout(context);
        final AVLoadingIndicatorView indicatorView = new AVLoadingIndicatorView(context);
        indicatorView.setIndicator(new BallSpinFadeLoaderIndicator());
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(128, 128);
        rlp.addRule(RelativeLayout.CENTER_IN_PARENT);
        indicatorView.setLayoutParams(rlp);
        rl.addView(indicatorView);
        final AlertDialog alertDialog = new AlertDialog.Builder(context).setView(rl).setCancelable(false).create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return alertDialog;
    }
}
