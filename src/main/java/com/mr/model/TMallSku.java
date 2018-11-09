package com.mr.model;

import java.util.Date;

public class TMallSku {
    //编号
    private Integer id;
    //商品id
    private Integer shpId;
    //库存
    private Integer kc;
    //价格
    private Double jg;
    //创建时间
    private Date chjshj;
    //sku名称
    private String skuMch;
    //sku销量
    private Integer skuXl;
    //库存地址
    private String kcdz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShpId() {
        return shpId;
    }

    public void setShpId(Integer shpId) {
        this.shpId = shpId;
    }

    public Integer getKc() {
        return kc;
    }

    public void setKc(Integer kc) {
        this.kc = kc;
    }

    public Double getJg() {
        return jg;
    }

    public void setJg(Double jg) {
        this.jg = jg;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public String getSkuMch() {
        return skuMch;
    }

    public void setSkuMch(String skuMch) {
        this.skuMch = skuMch == null ? null : skuMch.trim();
    }

    public Integer getSkuXl() {
        return skuXl;
    }

    public void setSkuXl(Integer skuXl) {
        this.skuXl = skuXl;
    }

    public String getKcdz() {
        return kcdz;
    }

    public void setKcdz(String kcdz) {
        this.kcdz = kcdz == null ? null : kcdz.trim();
    }
}