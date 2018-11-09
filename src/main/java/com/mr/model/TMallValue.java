package com.mr.model;

import java.util.Date;

public class TMallValue {
    //编号
    private Integer id;
    //属性值
    private String shxzh;
    //是否启用
    private String shfqy;
    //属性id
    private Integer shxmId;
    //属性值名
    private String shxzhMch;
    //创建时间
    private Date chjshj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShxzh() {
        return shxzh;
    }

    public void setShxzh(String shxzh) {
        this.shxzh = shxzh == null ? null : shxzh.trim();
    }

    public String getShfqy() {
        return shfqy;
    }

    public void setShfqy(String shfqy) {
        this.shfqy = shfqy == null ? null : shfqy.trim();
    }

    public Integer getShxmId() {
        return shxmId;
    }

    public void setShxmId(Integer shxmId) {
        this.shxmId = shxmId;
    }

    public String getShxzhMch() {
        return shxzhMch;
    }

    public void setShxzhMch(String shxzhMch) {
        this.shxzhMch = shxzhMch == null ? null : shxzhMch.trim();
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }
}