package cc.momyles.tomorrow.ui.record;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.momyles.tomorrow.R;

public class RecordAdapter extends BaseQuickAdapter<Record, BaseViewHolder> {

    public RecordAdapter(int layoutResId, @Nullable List<Record> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Record item) {
        if (item != null && helper != null) {
            helper.setText(R.id.tv1, item.getName() == null ? "" : item.getName());
        }
    }
}
