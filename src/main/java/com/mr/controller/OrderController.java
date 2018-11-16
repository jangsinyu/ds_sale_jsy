package com.mr.controller;

import com.mr.model.*;
import com.mr.service.CarService;
import com.mr.service.OrderService;
import com.mr.util.MyDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by JangSinyu on 2018/11/12.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CarService carService;


    @RequestMapping("toCheckOrderPage")
    public String toCheckOrderPage(HttpSession session, ModelMap map){
        //判断用户是否登录
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");
        if(user == null){
            return "redirect:toLoginPage.do?loginUrl=toCheckOrderPage";
        }else {
            //查询用户地址信息集合、、
            List<TMallAddress> addrList = orderService.getAddrList(user.getId());

            //查询选中的sku集合
            List<TMallShoppingCar> carList = (List<TMallShoppingCar>) redisTemplate.opsForValue().get("redisCartListUser"+user.getId());
            if(carList == null || carList.size() == 0){
                carList = carService.getCarListByUserId(user.getId());
            }

            map.put("sum", CarController.getSum(carList));
            map.put("carList",carList);
            map.put("addrList",addrList);
            return "checkOrder";
        }
    }


    @RequestMapping("saveOrder")
    public String saveOrder(TMallAddress address, HttpSession session, ModelMap map){

        //获取当前用户
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");

        //从redis中查询购物车商品信息
        List<TMallShoppingCar> carList = (List<TMallShoppingCar>) redisTemplate.opsForValue().get("redisCartListUser" + user.getId());

        //创建 TMallOrderVO 实例
        TMallOrderVO orderVO = new TMallOrderVO();

        orderVO.setZje(CarController.getSum(carList).doubleValue());
        orderVO.setJdh(1);
        orderVO.setYhId(user.getId());
        orderVO.setYjsdshj(MyDateUtil.getMyDateType(new Date() ,1));
        orderVO.setDzhId(address.getId());
        orderVO.setShhr(address.getShjr());
        orderVO.setDzhMch(address.getDzMch());

        //创建物流集合
        List<TMallFlowVO> flowVOList = new ArrayList<TMallFlowVO>();

        //创建地址集合
        Set<String> addrSet = new HashSet<String>();

        for (int i = 0; i < carList.size(); i++) {
            TMallShoppingCar car = carList.get(i);
            if(car.getShfxz().equals("1")){
                addrSet.add(car.getKcdz());
            }
        }

        //定义购物车ids集合
        List<Integer> idsList = new ArrayList<Integer>();

        //地址迭代器
        Iterator<String> iterator = addrSet.iterator();
        while (iterator.hasNext()){
            //创建 flowVO 实例
            TMallFlowVO flowVO = new TMallFlowVO();
            String kcdzh = iterator.next();
            flowVO.setPsfsh("顺丰快递");
            flowVO.setPsshj(null);
            flowVO.setPsmsh("顺丰快递：风力雨里，东门等你");
            flowVO.setYhId(user.getId());
            flowVO.setMqdd(kcdzh);
            flowVOList.add(flowVO);


            //创建 TMallOrderInfo 订单详情集合
            List<TMallOrderInfo> orderInfoList = new ArrayList<TMallOrderInfo>();
            for (int j = 0; j < carList.size(); j++) {
                TMallShoppingCar car1 = carList.get(j);
                if(kcdzh.equals(car1.getKcdz()) && car1.getShfxz().equals("1")){
                    TMallOrderInfo orderInfo = new TMallOrderInfo();
                    orderInfo.setSkuJg(car1.getSkuJg());
                    orderInfo.setSkuShl(car1.getTjshl());
                    orderInfo.setSkuKcdz(kcdzh);
                    orderInfo.setGwchId(car1.getId());
                    orderInfo.setSkuId(car1.getSkuId());
                    orderInfo.setSkuMch(car1.getSkuMch());
                    orderInfo.setShpTp(car1.getShpTp());
                    orderInfoList.add(orderInfo);

                    //放入购物车ids集合中
                    idsList.add(car1.getId());
                }
            }
            flowVO.setOrderInfoList(orderInfoList);
            orderVO.setFlowVOList(flowVOList);
        }

        orderService.saveOrder(orderVO);

        //清空redis
        redisTemplate.delete("redisCartListUser" + user.getId());

        //删除购物车数据
        orderService.deleteCarByCarIds(idsList);

        map.put("sum", CarController.getSum(carList));
        map.put("carList",carList);
        return "pay";
    }


    /**
     *      支付成功
     *      //修改  sku 销量，库存
     */
    @RequestMapping("paySuccess")
    public String paySuccess(TMallCarVO carVO){

        /**
         * 需要数据 skuid 订单添加sku数量
         */
        orderService.updateSku(carVO.getCarList());




        return "";

    }


}
