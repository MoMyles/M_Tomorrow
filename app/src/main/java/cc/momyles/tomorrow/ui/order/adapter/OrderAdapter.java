package cc.momyles.tomorrow.ui.order.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.momyles.tomorrow.R;
import cc.momyles.tomorrow.ui.order.entity.Order;

public class OrderAdapter extends BaseQuickAdapter<Order, BaseViewHolder> {

    public OrderAdapter(int layoutResId, @Nullable List<Order> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Order item) {
        if (item != null && helper != null) {
            helper.setText(R.id.tv1, item.getName() == null ? "" : item.getName());
        }
    }
}
