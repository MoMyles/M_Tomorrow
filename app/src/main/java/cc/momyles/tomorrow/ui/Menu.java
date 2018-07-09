package cc.momyles.tomorrow.ui;

import android.content.Intent;

public class Menu {
    private String name;
    private String url;
    private int resId;
    private Intent intent;

    public Menu(String name, String url, Intent intent) {
        this.name = name;
        this.url = url;
        this.intent = intent;
        this.resId = 0;
    }

    public Menu(String name, int resId, Intent intent) {
        this.name = name;
        this.resId = resId;
        this.intent = intent;
        this.url = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
