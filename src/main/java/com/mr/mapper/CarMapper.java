package com.mr.mapper;

import com.mr.model.TMallShoppingCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by JangSinyu on 2018/11/7.
 */
public interface CarMapper {

    List<TMallShoppingCar> getCarListByUserId(@Param("userId") Integer userId);

    void updateCarListBySkuIdAndUserId(Map<String, Object> map);

    void saveCarToDateBase(Map<String, Object> map);

    void updateCarSfxzBySkuIdAndUserId(Map<String, Object> map);

    TMallShoppingCar getCarByUserIdAndSkuId(@Param("skuId") Integer skuId, @Param("userId") Integer userId);

    void updateCarByUser(TMallShoppingCar car);
}
