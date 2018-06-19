package cc.momyles.tomorrow.ui.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.qmuiteam.qmui.widget.QMUIPagerAdapter;


public class StartPagerAdapter extends QMUIPagerAdapter {
    @Override
    protected Object hydrate(ViewGroup container, int position) {
        return null;
    }

    @Override
    protected void populate(ViewGroup container, Object item, int position) {

    }

    @Override
    protected void destroy(ViewGroup container, int position, Object object) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
