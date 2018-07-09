package cc.momyles.tomorrow.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import cc.momyles.tomorrow.R;
import cc.momyles.tomorrow.loader.ImgLoader;
import cc.momyles.tomorrow.ui.base.BaseActivity;
import cc.momyles.tomorrow.ui.record.RecordActivity;


public class MainActivity extends BaseActivity {
    private final String TITLE = "首页";

    private QMUITopBar topBar = null;
    private Banner banner = null;
    private RecyclerView rv = null;

    private List<String> imageList = null;
    private List<Menu> menuList = null;
    private GridLayoutManager gridLayoutManager = null;
    private MenuAdapter adapter = null;

    @Override
    protected void onBindView(Bundle savedInstanceState) {
        topBar = findViewById(R.id.topBar);
        topBar.setTitle(TITLE);
        Button btnRight = topBar.addRightTextButton("我的", R.id.main_btn_right);
        btnRight.setTextColor(Color.WHITE);

        banner = findViewById(R.id.banner);
        banner.setImageLoader(new ImgLoader());
        imageList = new ArrayList<>();
        imageList.add("http://d.hiphotos.baidu.com/zhidao/pic/item/279759ee3d6d55fb2166d92165224f4a20a4dd11.jpg");
        imageList.add("http://t1.niutuku.com/960/39/39-438850.jpg");
        imageList.add("http://pic1.win4000.com/wallpaper/2017-12-02/5a224092e284b.png");
        imageList.add("http://attach.bbs.miui.com/forum/201605/11/163014tkjbn8bj8z7b2wk0.jpg");
        banner.setImages(imageList);
        banner.start();

        rv = findViewById(R.id.rv);
        gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gridLayoutManager);
        menuList = new ArrayList<>();
        menuList.add(new Menu("检查", "http://imgsrc.baidu.com/imgad/pic/item/35a85edf8db1cb1304324e2ed654564e92584bb7.jpg", null));
        menuList.add(new Menu("查询", "http://imgsrc.baidu.com/imgad/pic/item/a2cc7cd98d1001e91ac36c32b30e7bec54e7970b.jpg", new Intent(this, RecordActivity.class)));
        menuList.add(new Menu("待办", "http://imgsrc.baidu.com/imgad/pic/item/a2cc7cd98d1001e91ac36c32b30e7bec54e7970b.jpg", null));
        adapter = new MenuAdapter(R.layout.item_main_menu, menuList);
        rv.setAdapter(adapter);
    }

    @Override
    protected Object getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        topBar = null;
        banner = null;
        rv = null;
        gridLayoutManager = null;
        imageList = null;
        menuList = null;
        adapter = null;
    }
}
