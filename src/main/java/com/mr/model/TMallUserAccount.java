package com.mr.model;

public class TMallUserAccount {
    private Integer id;
    //用户名称
    private String yhMch;
    //用户昵称
    private String yhNch;
    //用户密码
    private String yhMm;
    //用户姓名
    private String yhXm;
    //手机号
    private String yhShjh;
    //邮箱
    private String yhYx;
    //头像
    private String yhTx;
    //排序号
    private String yhJb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYhMch() {
        return yhMch;
    }

    public void setYhMch(String yhMch) {
        this.yhMch = yhMch == null ? null : yhMch.trim();
    }

    public String getYhNch() {
        return yhNch;
    }

    public void setYhNch(String yhNch) {
        this.yhNch = yhNch == null ? null : yhNch.trim();
    }

    public String getYhMm() {
        return yhMm;
    }

    public void setYhMm(String yhMm) {
        this.yhMm = yhMm == null ? null : yhMm.trim();
    }

    public String getYhXm() {
        return yhXm;
    }

    public void setYhXm(String yhXm) {
        this.yhXm = yhXm == null ? null : yhXm.trim();
    }

    public String getYhShjh() {
        return yhShjh;
    }

    public void setYhShjh(String yhShjh) {
        this.yhShjh = yhShjh == null ? null : yhShjh.trim();
    }

    public String getYhYx() {
        return yhYx;
    }

    public void setYhYx(String yhYx) {
        this.yhYx = yhYx == null ? null : yhYx.trim();
    }

    public String getYhTx() {
        return yhTx;
    }

    public void setYhTx(String yhTx) {
        this.yhTx = yhTx == null ? null : yhTx.trim();
    }

    public String getYhJb() {
        return yhJb;
    }

    public void setYhJb(String yhJb) {
        this.yhJb = yhJb == null ? null : yhJb.trim();
    }
}