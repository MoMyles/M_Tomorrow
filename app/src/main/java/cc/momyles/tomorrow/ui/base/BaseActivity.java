package cc.momyles.tomorrow.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        QMUIStatusBarHelper.translucent(this);

        Object obj = getLayout();
        if (obj != null) {
            if (obj instanceof View) {
                setContentView((View) obj);
            } else {
                setContentView((Integer) obj);
            }
            onBindView(savedInstanceState);
        }
    }

    protected abstract void onBindView(Bundle savedInstanceState);

    protected abstract Object getLayout();
}
