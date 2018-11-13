package com.mr.model;

/**
 * Created by JangSinyu on 2018/11/7.
 *
 * 用户地址表
 */
public class TMallAddress {
    //id
    private Integer id;
    //用户地址名称
    private String dzMch;
    //关联编号
    private Integer dzzt;
    //收件人
    private String shjr;
    //联系方式
    private String lxfsh;
    //用户id
    private Integer yhId;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDzMch() {
        return dzMch;
    }
    public void setDzMch(String dzMch) {
        this.dzMch = dzMch == null ? null : dzMch.trim();
    }
    public Integer getDzzt() {
        return dzzt;
    }
    public void setDzzt(Integer dzzt) {
        this.dzzt = dzzt;
    }
    public String getShjr() {
        return shjr;
    }
    public void setShjr(String shjr) {
        this.shjr = shjr == null ? null : shjr.trim();
    }
    public String getLxfsh() {
        return lxfsh;
    }
    public void setLxfsh(String lxfsh) {
        this.lxfsh = lxfsh == null ? null : lxfsh.trim();
    }
    public Integer getYhId() {
        return yhId;
    }
    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }
}