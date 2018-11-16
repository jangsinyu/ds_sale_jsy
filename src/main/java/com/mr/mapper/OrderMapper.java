package com.mr.mapper;

import com.mr.model.TMallAddress;
import com.mr.model.TMallOrderVO;
import com.mr.model.TMallSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by JangSinyu on 2018/11/12.
 */
public interface OrderMapper {
    List<TMallAddress> getAddrList(@Param("userId") Integer userId);

    void saveOrder(TMallOrderVO orderVO);

    void saveFlow(Map<String, Object> map);

    void saveOrderInfo(Map<String, Object> map);

    void deleteCarByCarIds(@Param("idsList") List<Integer> idsList);

    void updateSku(TMallSku sku);

    TMallSku getSkuById(@Param("skuId") Integer skuId);
}
