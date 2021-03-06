package com.mr.model;

import java.io.Serializable;
import java.util.Date;

public class TMallShoppingCar implements Serializable {
    private Integer id;
    //sku名称
    private String skuMch;
    //sku价格
    private Double skuJg;
    //添加数量
    private Integer tjshl;
    //合计
    private Double hj;
    //用户id
    private Integer yhId;
    //商品id
    private Integer shpId;
    //创建时间
    private Date chjshj;
    //sku id
    private Integer skuId;
    //商品图片
    private String shpTp;
    //是否选中
    private String shfxz;
    //库存地址
    private String kcdz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkuMch() {
        return skuMch;
    }

    public void setSkuMch(String skuMch) {
        this.skuMch = skuMch == null ? null : skuMch.trim();
    }

    public Double getSkuJg() {
        return skuJg;
    }

    public void setSkuJg(Double skuJg) {
        this.skuJg = skuJg;
    }

    public Integer getTjshl() {
        return tjshl;
    }

    public void setTjshl(Integer tjshl) {
        this.tjshl = tjshl;
    }

    public Double getHj() {
        return hj;
    }

    public void setHj(Double hj) {
        this.hj = hj;
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public Integer getShpId() {
        return shpId;
    }

    public void setShpId(Integer shpId) {
        this.shpId = shpId;
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

    public String getShpTp() {
        return shpTp;
    }

    public void setShpTp(String shpTp) {
        this.shpTp = shpTp == null ? null : shpTp.trim();
    }

    public String getShfxz() {
        return shfxz;
    }

    public void setShfxz(String shfxz) {
        this.shfxz = shfxz == null ? null : shfxz.trim();
    }

    public String getKcdz() {
        return kcdz;
    }

    public void setKcdz(String kcdz) {
        this.kcdz = kcdz == null ? null : kcdz.trim();
    }
}