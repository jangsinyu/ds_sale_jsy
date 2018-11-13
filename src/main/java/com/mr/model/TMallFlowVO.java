package com.mr.model;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/12.
 */
public class TMallFlowVO extends TMallFlow {

    private List<TMallOrderInfo> orderInfoList;

    public List<TMallOrderInfo> getOrderInfoList() {
        return orderInfoList;
    }

    public void setOrderInfoList(List<TMallOrderInfo> orderInfoList) {
        this.orderInfoList = orderInfoList;
    }
}
