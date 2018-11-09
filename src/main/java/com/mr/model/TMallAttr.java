package com.mr.model;

import java.util.Date;

public class TMallAttr {
    //编号
    private Integer id;
    //属性名称
    private String shxmMch;
    //是否启用
    private String shfqy;
    //分类编号2
    private Integer flbh2;
    //创建时间
    private Date chjshj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShxmMch() {
        return shxmMch;
    }

    public void setShxmMch(String shxmMch) {
        this.shxmMch = shxmMch == null ? null : shxmMch.trim();
    }

    public String getShfqy() {
        return shfqy;
    }

    public void setShfqy(String shfqy) {
        this.shfqy = shfqy == null ? null : shfqy.trim();
    }

    public Integer getFlbh2() {
        return flbh2;
    }

    public void setFlbh2(Integer flbh2) {
        this.flbh2 = flbh2;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }
}