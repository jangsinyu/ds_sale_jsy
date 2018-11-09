package com.mr.service.impl;

import com.mr.mapper.CarMapper;
import com.mr.model.TMallShoppingCar;
import com.mr.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JangSinyu on 2018/11/7.
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    public List<TMallShoppingCar> getCarListByUserId(Integer userId) {
        return carMapper.getCarListByUserId(userId);
    }

    public void updateCarListBySkuIdAndUserId(Map<String, Object> map) {
        carMapper.updateCarListBySkuIdAndUserId(map);
    }

    public void saveCarToDateBase(Map<String, Object> map) {
        carMapper.saveCarToDateBase(map);
    }

    public void updateCarSfxzBySkuIdAndUserId(String shfxz,int skuId, Integer userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("skuId",skuId);
        map.put("shfxz",shfxz);
        map.put("userId",userId);
        carMapper.updateCarSfxzBySkuIdAndUserId(map);
    }

    public TMallShoppingCar getCarByUserIdAndSkuId(Integer skuId, Integer userId) {
        return carMapper.getCarByUserIdAndSkuId(skuId,userId);
    }

    public void updateCarByUser(TMallShoppingCar car) {
        carMapper.updateCarByUser(car);
    }
}
