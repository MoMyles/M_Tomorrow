package cc.momyles.tomorrow.ui;

import android.os.Bundle;

import com.qmuiteam.qmui.widget.QMUIViewPager;

import java.util.ArrayList;
import java.util.List;

import cc.momyles.tomorrow.R;
import cc.momyles.tomorrow.ui.adapter.StartPagerAdapter;
import cc.momyles.tomorrow.ui.base.BaseActivity;

public class StartActivity extends BaseActivity {

    private QMUIViewPager pager = null;
    private StartPagerAdapter startPagerAdapter = null;
    private List<String> imgs;

    @Override
    protected void onBindView(Bundle savedInstanceState) {
        if (pager == null) {
            pager = findViewById(R.id.pager);
        }
        pager.setEnableLoop(true);

        if (imgs == null) {
            imgs = new ArrayList<>();
            imgs.add("http://f.hiphotos.baidu.com/image/pic/item/8718367adab44aed5b24056fbf1c8701a08bfbd7.jpg");
            imgs.add("http://a.hiphotos.baidu.com/image/pic/item/fc1f4134970a304eb5088f73ddc8a786c9175c14.jpg");
        }
        if (startPagerAdapter == null) {
            startPagerAdapter = new StartPagerAdapter(this, imgs);
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
