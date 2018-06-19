package cc.momyles.tomorrow.ui.order;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ajguan.library.EasyRefreshLayout;
import com.ajguan.library.LoadModel;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

import cc.momyles.tomorrow.R;
import cc.momyles.tomorrow.ui.base.BaseActivity;
import cc.momyles.tomorrow.ui.order.adapter.OrderAdapter;
import cc.momyles.tomorrow.ui.order.entity.Order;

public class OrderActivity extends BaseActivity {

    private final String TITLE = "订单-列表";

    private QMUITopBar topBar = null;
    private EasyRefreshLayout easy = null;
    private RecyclerView rvList = null;

    private LinearLayoutManager linearLayoutManager = null;
    private OrderAdapter adapter = null;
    private List<Order> data = null;

    private Handler mHandler = null;

    @Override
    protected void onBindView(Bundle savedInstanceState) {
        if (mHandler == null) {
            mHandler = new Handler();
        }
        buildTopBar();
        buildRvList();
    }

    private void buildTopBar() {
        if (topBar == null) {
            topBar = findViewById(R.id.topBar);
        }
        topBar.setTitle(TITLE);
    }

    private void buildRvList() {
        if (easy == null) {
            easy = findViewById(R.id.easy);
        }
        easy.setLoadMoreModel(LoadModel.NONE);
        easy.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {

            }

            @Override
            public void onRefreshing() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        data.clear();
                        for (int i=0;i<100;i++){
                            Order order = new Order();
                            order.setNo(i+"");
                            order.setName(i+"");
                            order.setFrom("I");
                            data.add(order);
                        }
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                adapter.setNewData(data);
                                easy.refreshComplete();
                            }
                        }, 500);
                    }
                }, 2000);
            }
        });
        if (rvList == null) {
            rvList = findViewById(R.id.rvList);
        }
        rvList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        if (linearLayoutManager == null) {
            linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        }
        rvList.setLayoutManager(linearLayoutManager);
        if (data == null) {
            data = new ArrayList<>();
        }
        if (adapter == null) {
            adapter = new OrderAdapter(R.layout.item_order, data);
        }
        rvList.setAdapter(adapter);
    }

    @Override
    protected Object getLayout() {
        return R.layout.activity_order;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        topBar = null;
        easy = null;
        rvList = null;
        linearLayoutManager = null;
        adapter = null;
        data = null;
        mHandler = null;
    }
}
