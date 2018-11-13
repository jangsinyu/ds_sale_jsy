package com.mr.model;

import java.util.Date;

/**
 * 物流表对应实体类
 */
public class TMallFlow {
    private Integer id;
    //配送方法
    private String psfsh;
    //配送时间
    private Date psshj;
    //配送描述
    private String psmsh;
    //用户id
    private Integer yhId;
    //创建时间
    private Date chjshj;
    //订单id
    private Integer ddId;
    //目前地点
    private String mqdd;
    //目的地
    private String mdd;
    //业务员
    private String ywy;
    //联系方式
    private String lxfsh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPsfsh() {
        return psfsh;
    }

    public void setPsfsh(String psfsh) {
        this.psfsh = psfsh == null ? null : psfsh.trim();
    }

    public Date getPsshj() {
        return psshj;
    }

    public void setPsshj(Date psshj) {
        this.psshj = psshj;
    }

    public String getPsmsh() {
        return psmsh;
    }

    public void setPsmsh(String psmsh) {
        this.psmsh = psmsh == null ? null : psmsh.trim();
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public Integer getDdId() {
        return ddId;
    }

    public void setDdId(Integer ddId) {
        this.ddId = ddId;
    }

    public String getMqdd() {
        return mqdd;
    }

    public void setMqdd(String mqdd) {
        this.mqdd = mqdd == null ? null : mqdd.trim();
    }

    public String getMdd() {
        return mdd;
    }

    public void setMdd(String mdd) {
        this.mdd = mdd == null ? null : mdd.trim();
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy == null ? null : ywy.trim();
    }

    public String getLxfsh() {
        return lxfsh;
    }

    public void setLxfsh(String lxfsh) {
        this.lxfsh = lxfsh == null ? null : lxfsh.trim();
    }
}