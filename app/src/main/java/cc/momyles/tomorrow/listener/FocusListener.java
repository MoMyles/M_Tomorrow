package cc.momyles.tomorrow.listener;

import android.view.MotionEvent;
import android.view.View;

import cc.momyles.tomorrow.R;

public class FocusListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                view.setBackgroundResource(R.drawable.focus);
                break;
            case MotionEvent.ACTION_UP:
                view.setBackgroundResource(R.drawable.unfocus);
                break;
        }
        return false;
    }
}
