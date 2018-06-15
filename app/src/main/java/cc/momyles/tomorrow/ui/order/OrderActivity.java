package cc.momyles.tomorrow.ui.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

import cc.momyles.tomorrow.R;

public class OrderActivity extends AppCompatActivity {

    private QMUITopBar topBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);

        setContentView(R.layout.activity_order);

        topBar = findViewById(R.id.topBar);
        topBar.setTitle("订单-列表");
    }
}
