package com.mr.mapper;

import com.mr.model.TMallShoppingcar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/7.
 */
public interface CarMapper {

    TMallShoppingcar getCarBySkuIdAndUserId(@Param("skuId") Integer skuId,@Param("userId") Integer userId);

    List<TMallShoppingcar> getCarListBySkuIdAndUserId(@Param("userId") Integer userId);
}
