package cc.momyles.tomorrow.ui;

import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

import cc.momyles.tomorrow.R;
import cc.momyles.tomorrow.app.MyApp;


public class MenuAdapter extends BaseQuickAdapter<Menu, BaseViewHolder> {

    private final int screenWidth = ScreenUtils.getScreenWidth();

    public MenuAdapter(int layoutResId, @Nullable List<Menu> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final Menu item) {
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(screenWidth / 3, ViewGroup.LayoutParams.WRAP_CONTENT);
        helper.itemView.setLayoutParams(lp);
        helper.itemView.setOnTouchListener(MyApp.getContext().focus());
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getIntent()!=null){
                    MyApp.getContext().startActivity(item.getIntent());
                }
            }
        });
        if (item != null) {
            helper.setText(R.id.tv1, item.getName() == null ? "" : item.getName());
            if (item.getResId() > 0) {
                Picasso.get().load(item.getResId()).placeholder(R.mipmap.img_default).fit().into(helper.<AppCompatImageView>getView(R.id.iv1));
            } else {
                Picasso.get().load(item.getUrl()).placeholder(R.mipmap.img_default).fit().into(helper.<AppCompatImageView>getView(R.id.iv1));
            }
        } else {
            helper.setText(R.id.tv1, "未命名");
            Picasso.get().load(R.mipmap.img_default).fit().into(helper.<AppCompatImageView>getView(R.id.iv1));
        }
    }
}
