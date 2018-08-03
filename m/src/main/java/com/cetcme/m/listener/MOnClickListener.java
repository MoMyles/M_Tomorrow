package com.cetcme.m.listener;

import android.view.View;

import com.cetcme.m.helper.MClickHelper;

public abstract class MOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        if (MClickHelper.isFastClick(view.getId())){
            return;
        }
        click(view);
    }

    protected abstract void click(View view);
}
