package com.mr.model;

import java.util.Date;

public class TMallProduct {
    //id自增
    private Integer id;
    //商品名称
    private String shpMch;
    //商品图片
    private String shpTp;
    //分类编号1
    private Integer flbh1;
    //分类编号2
    private Integer flbh2;
    //品牌id
    private Integer ppId;
    //创建时间
    private Date chjshj;
    //商品描述
    private String shpMsh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShpMch() {
        return shpMch;
    }

    public void setShpMch(String shpMch) {
        this.shpMch = shpMch == null ? null : shpMch.trim();
    }

    public String getShpTp() {
        return shpTp;
    }

    public void setShpTp(String shpTp) {
        this.shpTp = shpTp == null ? null : shpTp.trim();
    }

    public Integer getFlbh1() {
        return flbh1;
    }

    public void setFlbh1(Integer flbh1) {
        this.flbh1 = flbh1;
    }

    public Integer getFlbh2() {
        return flbh2;
    }

    public void setFlbh2(Integer flbh2) {
        this.flbh2 = flbh2;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public String getShpMsh() {
        return shpMsh;
    }

    public void setShpMsh(String shpMsh) {
        this.shpMsh = shpMsh == null ? null : shpMsh.trim();
    }
}