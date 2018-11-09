package com.mr.service.impl;

import com.mr.mapper.CarMapper;
import com.mr.model.TMallShoppingcar;
import com.mr.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/7.
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    public TMallShoppingcar getCarBySkuIdAndUserId(Integer skuId, Integer userId) {
        return carMapper.getCarBySkuIdAndUserId(skuId,userId);
    }

    public List<TMallShoppingcar> getCarListBySkuIdAndUserId(Integer userId) {
        return carMapper.getCarListBySkuIdAndUserId(userId);
    }
}
