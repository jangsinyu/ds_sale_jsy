package com.mr.model;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/12.
 */
public class TMallOrderVO extends TMallOrder {

    private List<TMallFlowVO> flowVOList;


    public List<TMallFlowVO> getFlowVOList() {
        return flowVOList;
    }

    public void setFlowVOList(List<TMallFlowVO> flowVOList) {
        this.flowVOList = flowVOList;
    }
}
