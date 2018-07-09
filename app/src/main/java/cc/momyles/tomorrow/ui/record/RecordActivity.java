package cc.momyles.tomorrow.ui.record;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import cc.momyles.tomorrow.R;
import cc.momyles.tomorrow.ui.base.BaseActivity;

public class RecordActivity extends BaseActivity implements View.OnClickListener {

    private final String TITLE = "记录-列表";

    private QMUITopBar topBar = null;
    private SmartRefreshLayout refresh = null;
    private RecyclerView rv = null;

    private LinearLayoutManager linearLayoutManager = null;
    private RecordAdapter adapter = null;
    private List<Record> data = null;

    private Handler mHandler = null;

    @Override
    protected void onBindView(Bundle savedInstanceState) {
        if (mHandler == null) {
            mHandler = new Handler();
        }
        buildTopBar();
        buildRvList();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.record_right:// 搜索条件选择
                break;
        }
    }

    private void buildTopBar() {
        if (topBar == null) {
            topBar = findViewById(R.id.topBar);
        }
        topBar.setTitle(TITLE);

        ImageButton ib = topBar.addRightImageButton(R.mipmap.search, R.id.record_right);
        ib.setOnClickListener(this);
    }

    private void buildRvList() {
        if (rv == null) {
            rv = findViewById(R.id.rv);
        }
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        if (linearLayoutManager == null) {
            linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        }
        rv.setLayoutManager(linearLayoutManager);
        if (data == null) {
            data = new ArrayList<>();
        }
        if (adapter == null) {
            adapter = new RecordAdapter(R.layout.item_record, data);
        }
        rv.setAdapter(adapter);

        if (refresh == null) {
            refresh = findViewById(R.id.refresh);
        }
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        data.clear();
                        for (int i = 0; i < 100; i++) {
                            Record record = new Record();
                            record.setNo(i + "");
                            record.setName(i + "");
                            record.setFrom("I");
                            data.add(record);
                        }
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                adapter.setNewData(data);
                                refresh.finishRefresh();
                            }
                        }, 500);
                    }
                }, 2000);
            }
        });
        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishLoadMore();
                    }
                }, 2000);
            }
        });

        refresh.setEnableLoadMore(true);//可加载更多
        refresh.autoRefresh();
    }

    @Override
    protected Object getLayout() {
        return R.layout.activity_record;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        topBar = null;
        refresh = null;
        rv = null;
        linearLayoutManager = null;
        adapter = null;
        data = null;
        mHandler = null;
    }
}
