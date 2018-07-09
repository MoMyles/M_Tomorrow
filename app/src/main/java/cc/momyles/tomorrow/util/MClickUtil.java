package cc.momyles.tomorrow.util;

/**
 * 防止快速重复点击
 */
public class MClickUtil {
    private static final int MIN_DELAY_TIME = 1000;  // 两次点击间隔不能少于1000ms
    private static long lastClickTime = 0l;
    private static int resId = 0;

    public static boolean isFastClick(int resId) {
        if (resId == MClickUtil.resId) {
            boolean flag = true;
            long currentClickTime = System.currentTimeMillis();
            if ((currentClickTime - lastClickTime) >= MIN_DELAY_TIME) {
                flag = false;
            }
            lastClickTime = currentClickTime;
            return flag;
        } else {
            MClickUtil.resId = resId;
            MClickUtil.lastClickTime = System.currentTimeMillis();
        }
        return false;
    }
}
