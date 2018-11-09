package com.mr.service;

import com.mr.model.TMallShoppingcar;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/7.
 */
public interface CarService {
    TMallShoppingcar getCarBySkuIdAndUserId(Integer skuId, Integer userId);

    List<TMallShoppingcar> getCarListBySkuIdAndUserId(Integer id);
}
