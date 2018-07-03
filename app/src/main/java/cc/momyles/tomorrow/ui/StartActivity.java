package cc.momyles.tomorrow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

import cc.momyles.tomorrow.R;
import cc.momyles.tomorrow.ui.base.BaseActivity;
import cc.momyles.tomorrow.util.MClickUtil;

public class StartActivity extends BaseActivity {

    private AppCompatImageView image = null;
    private AppCompatTextView timerText = null;
    private AppCompatButton jump = null;

    private Timer timer = null;
    private Handler handler = null;
    private int timeCount = 5;

    @Override
    protected void onBindView(Bundle savedInstanceState) {

        jump = findViewById(R.id.jump);
        timerText = findViewById(R.id.timer);
        image = findViewById(R.id.image);

        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!MClickUtil.isFastClick(R.id.jump)) {
                    if (timer != null) {
                        timer.cancel();
                    }
                    toMain();
                }
            }
        });
        Picasso.get().load("http://f.hiphotos.baidu.com/image/pic/item/8718367adab44aed5b24056fbf1c8701a08bfbd7.jpg")
                .placeholder(R.mipmap.start_default_bg).fit().into(image);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:// 刷新倒计时
                        timerText.setText(msg.obj + "s");
                        break;
                }
            }
        };

        createTimer();
    }

    /**
     * 创建倒计时
     */
    private void createTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeCount--;
                Message message = Message.obtain();
                message.what = 1;
                message.obj = timeCount;
                handler.sendMessage(message);
                if (timeCount == 0) {
                    cancelTimer();// 取消定时任务
                    toMain();
                }
            }
        }, 1000, 1000);
    }

    /**
     * 去首页
     */
    private void toMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected Object getLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler = null;
        timer = null;
    }

    private void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
