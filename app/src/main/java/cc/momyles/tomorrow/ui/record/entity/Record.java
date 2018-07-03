package cc.momyles.tomorrow.ui.record.entity;

import java.io.Serializable;

public class Record implements Serializable {
    private String no;
    private String name;
    private String from;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
