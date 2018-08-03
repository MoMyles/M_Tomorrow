package com.cetcme.m.helper;

public class MClickHelper {
    private static final int MIN_DELAY_TIME = 1000;  // 两次点击间隔不能少于1000ms
    private static long lastClickTime = 0l;
    private static int resId = 0;

    public static boolean isFastClick(int resId) {
        if (resId == MClickHelper.resId) {
            boolean flag = true;
            long currentClickTime = System.currentTimeMillis();
            if ((currentClickTime - lastClickTime) >= MIN_DELAY_TIME) {
                flag = false;
            }
            lastClickTime = currentClickTime;
            return flag;
        } else {
            MClickHelper.resId = resId;
            MClickHelper.lastClickTime = System.currentTimeMillis();
        }
        return false;
    }
}
