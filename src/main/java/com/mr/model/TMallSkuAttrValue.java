package com.mr.model;

import java.util.Date;

public class TMallSkuAttrValue {
    //编号
    private Integer id;
    //属性名id
    private Integer shxmId;
    //属性值id
    private Integer shxzhId;
    //商品id
    private Integer shpId;
    //是否是sku
    private String isSku;
    //创建时间
    private Date chjshj;
    //skuid
    private Integer skuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShxmId() {
        return shxmId;
    }

    public void setShxmId(Integer shxmId) {
        this.shxmId = shxmId;
    }

    public Integer getShxzhId() {
        return shxzhId;
    }

    public void setShxzhId(Integer shxzhId) {
        this.shxzhId = shxzhId;
    }

    public Integer getShpId() {
        return shpId;
    }

    public void setShpId(Integer shpId) {
        this.shpId = shpId;
    }

    public String getIsSku() {
        return isSku;
    }

    public void setIsSku(String isSku) {
        this.isSku = isSku == null ? null : isSku.trim();
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }
}