package com.mr.service.impl;

import com.mr.mapper.OrderMapper;
import com.mr.model.*;
import com.mr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JangSinyu on 2018/11/12.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<TMallAddress> getAddrList(Integer userId) {
        return orderMapper.getAddrList(userId);
    }

    public void saveOrder(TMallOrderVO orderVO) {

        //保存总订单
        orderMapper.saveOrder(orderVO);
        List<TMallFlowVO> flowVOList = orderVO.getFlowVOList();
        for (int i = 0; i < flowVOList.size(); i++) {
            Map<String, Object> map = new HashMap();
            TMallFlowVO flowVO = flowVOList.get(i);
            map.put("orderId", orderVO.getId());
            map.put("flowVO", flowVO);

            //添加物流订单
            orderMapper.saveFlow(map);

            map.put("orderInfoList", flowVO.getOrderInfoList());
            map.put("flowId", flowVO.getId());

            //添加订单详情
            orderMapper.saveOrderInfo(map);
        }


    }

    public void deleteCarByCarIds(List<Integer> idsList) {
        orderMapper.deleteCarByCarIds(idsList);
    }

    public void updateSku(List<TMallShoppingCar> carList) {
        for (int i = 0; i < carList.size(); i++) {
            TMallShoppingCar car = carList.get(i);
            //根据 skuid 查询出sku
            TMallSku sku = orderMapper.getSkuById(car.getSkuId());
            //修改sku销量， 库存
            sku.setKc(sku.getKc() - car.getTjshl());
            Integer tjshl = car.getTjshl();
            Integer skuXl = sku.getSkuXl();
            sku.setSkuXl(skuXl + tjshl);
            orderMapper.updateSku(sku);
        }
    }
}
