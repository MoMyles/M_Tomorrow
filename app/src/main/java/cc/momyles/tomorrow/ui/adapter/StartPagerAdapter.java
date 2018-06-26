package cc.momyles.tomorrow.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qmuiteam.qmui.widget.QMUIPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;


public class StartPagerAdapter extends QMUIPagerAdapter {

    private Context context;
    private List<String> datas;

    public StartPagerAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }


    @Override
    protected Object hydrate(ViewGroup container, int position) {
        AppCompatImageView iv = new AppCompatImageView(context);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        iv.setLayoutParams(lp);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        iv.setAdjustViewBounds(true);

        return iv;
    }

    @Override
    protected void populate(ViewGroup container, Object item, int position) {
        AppCompatImageView iv = (AppCompatImageView) item;
        String path = datas.get(position);
        Picasso.get().load(path).fit().into(iv);
        container.addView(iv);
    }

    @Override
    protected void destroy(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
