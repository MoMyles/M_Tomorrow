package cc.momyles.tomorrow.ui;

import android.os.Bundle;

import com.qmuiteam.qmui.widget.QMUIViewPager;

import cc.momyles.tomorrow.R;
import cc.momyles.tomorrow.ui.adapter.StartPagerAdapter;
import cc.momyles.tomorrow.ui.base.BaseActivity;

public class StartActivity extends BaseActivity {

    private QMUIViewPager pager = null;
    private StartPagerAdapter startPagerAdapter = null;

    @Override
    protected void onBindView(Bundle savedInstanceState) {
        if (pager == null) {
            pager = findViewById(R.id.pager);
        }
        pager.setEnableLoop(true);

        if (startPagerAdapter == null) {
            startPagerAdapter = new StartPagerAdapter();
        }
        pager.setAdapter(startPagerAdapter);
    }

    @Override
    protected Object getLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pager = null;
        startPagerAdapter = null;
    }
}
