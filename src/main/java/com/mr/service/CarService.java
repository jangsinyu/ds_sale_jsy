package com.mr.service;

import com.mr.model.TMallShoppingCar;

import java.util.List;
import java.util.Map;

/**
 * Created by JangSinyu on 2018/11/7.
 */
public interface CarService {

    List<TMallShoppingCar> getCarListByUserId(Integer id);

    void updateCarListBySkuIdAndUserId(Map<String, Object> map);

    void saveCarToDateBase(Map<String, Object> car);

    void updateCarSfxzBySkuIdAndUserId(String shfxz,int skuId, Integer userId);

    TMallShoppingCar getCarByUserIdAndSkuId(Integer skuId, Integer userId);

    void updateCarByUser(TMallShoppingCar car);
}
