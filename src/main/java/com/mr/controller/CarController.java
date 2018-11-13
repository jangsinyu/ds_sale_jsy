package com.mr.controller;

import com.mr.model.TMallShoppingCar;
import com.mr.model.TMallUserAccount;
import com.mr.service.CarService;
import com.mr.util.MyCookieUtils;
import com.mr.util.MyJsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JangSinyu on 2018/11/7.
 */
@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *  添加商品到购物车
     *
     *  cookieName: cookieCarList
     *
     * @CookieValue("key")   从cookie对象中获取名为key的cookie值
     * @param car
     * @param session
     * @return
     */
    @RequestMapping("saveToShoppingCar")
    public String saveToShoppingCar(TMallShoppingCar car, HttpSession session,
                                    @CookieValue(value = "cookieCarList" ,required = false) String cookieCarList,
                                    HttpServletRequest request, HttpServletResponse response, ModelMap returnMap) {
        //计算合计价格
        car.setHj(getHj(car));
        //定义List集合
        List<TMallShoppingCar> carList = new ArrayList<TMallShoppingCar>();
        //判断用户是否登录
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");
        if(user == null){//如果用户为空，未登录
            if(StringUtils.isEmpty(cookieCarList)){//判断cookie中为空
                //给购物车集合赋值
                carList.add(car);
            }else{//cookie中不为空
                //判断存不存在
                carList = MyJsonUtil.jsonToList(cookieCarList, TMallShoppingCar.class);
                //判断购物车中是否存在此商品
                boolean isHaving = skuIsHaving(carList, car);
                if(isHaving){//如果cookie中存在
                    //更新：拿到购物车中的数据,更新
                    for (int i = 0; i < carList.size(); i++) {
                        //判断购物车中是否存在此商品
                        if(carList.get(i).getSkuId() == car.getSkuId()){//相等就修改商品数量
                            //增加数量
                            carList.get(i).setTjshl(carList.get(i).getTjshl() + car.getTjshl());
                            carList.get(i).setHj(getHj(carList.get(i)));
                        }
                    }
                }else{//如果cookie 中不存在
                    //给购物车集合赋值
                    carList.add(car);
                    //讲数据放入cookie中
                }
            }
            //将数据放入cookie中
            MyCookieUtils.setCookie(request,response,"cookieCarList",
                    MyJsonUtil.objectToJson(carList), 3*24*60*60,true);
        }else{//用户已登录
            //定义数据集合
            Map<String, Object> map = new HashMap<String, Object>();
            //通过userId从数据库中查询是否为空。
            carList = carService.getCarListByUserId(user.getId());
            if(carList != null && carList.size() > 0){//不为空
                //判断商品是否存在
                boolean isHaving = skuIsHaving(carList, car);
                if(isHaving){//db中存在
                    //更新数据
                    for (int i = 0; i < carList.size(); i++) {
                        if(carList.get(i).getSkuId() == car.getSkuId()){//相等则添加商品
                            //定义map集合添加数据
                            map.put("userId", user.getId());//用户Id
                            map.put("skuId", car.getSkuId());//skuId
                            map.put("tjshl", carList.get(i).getTjshl() + car.getTjshl());
                            //修改数量计算合计
                            carList.get(i).setTjshl(carList.get(i).getTjshl() + car.getTjshl());
                            map.put("hj",getHj(carList.get(i)));
                            //修改数据
                            carService.updateCarListBySkuIdAndUserId(map);
                        }
                    }
                }else{//数据库中不存在此数据
                    map.put("userId",user.getId());
                    map.put("car",car);
                    carService.saveCarToDateBase(map);
                }
            }else{//为空
                //直接添加数据到数据库
                map.put("userId",user.getId());
                map.put("car",car);
                carService.saveCarToDateBase(map);
            }
            //更新redis （清空当前用户的redis数据）
            redisTemplate.delete("redisCartListUser"+user.getId());
        }
        returnMap.put("skuName",car.getSkuMch());
        returnMap.put("tjshul",car.getTjshl());
        returnMap.put("skuId",car.getSkuId());
        returnMap.put("spuId",car.getShpId());
        return "finishCar";
    }


    /**
     * 查询展示小购物车
     * @param session
     * @param map
     * @param cookieCarList
     * @return
     */
    @RequestMapping("findMiniCar")
    public String findMiniCar(HttpSession session, ModelMap map,
                              @CookieValue(value = "cookieCarList" ,required = false) String cookieCarList){
        //定义List集合
        List<TMallShoppingCar> carList = new ArrayList<TMallShoppingCar>();
        //判断用户是否登录
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");
        if(user == null){//用户未登录
             carList = MyJsonUtil.jsonToList(cookieCarList, TMallShoppingCar.class);
        }else{//登录
            //查询redis中数据，判断是否为空
            carList = (List<TMallShoppingCar>) redisTemplate.opsForValue().get("redisCartListUser"+user.getId());
            if(carList == null || carList.size() == 0){//为空
                carList = carService.getCarListByUserId(user.getId());
                redisTemplate.opsForValue().set("redisCartListUser"+user.getId(),carList);
            }
        }
        // TODO: 2018/11/9    此处有Bug 当carList为空时，会报空指针异常  上面创建carList新建不出来
        Integer countSum = 0;
        for (int i = 0; i < carList.size(); i++) {
            countSum += carList.get(i).getTjshl();
        }
        //返回的数据
        map.put("carList",carList);
        map.put("hjSum", getSum(carList));
        map.put("countSum", countSum);
        return "MiniCarInner";
    }



    /**
     * 跳转至购物车页面
     * @return
     */
    @RequestMapping("toShoppingCarPage")
    public String toShoppingCarPage(HttpSession session, ModelMap map,
                                    @CookieValue(value = "cookieCarList" ,required = false) String cookieCarList){
        //判断用户是否登录
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");
        //定义List集合
        List<TMallShoppingCar> carList = new ArrayList<TMallShoppingCar>();
        if(user == null){//用户未登录
            carList = MyJsonUtil.jsonToList(cookieCarList, TMallShoppingCar.class);
        }else{//登录
            //查询redis中数据，判断是否为空
            carList = (List<TMallShoppingCar>) redisTemplate.opsForValue().get("redisCartListUser"+user.getId());
            if(carList == null || carList.size() == 0){//为空
                carList = carService.getCarListByUserId(user.getId());
                redisTemplate.opsForValue().set("redisCartListUser"+user.getId(),carList);
            }
        }
        // TODO: 2018/11/9   此处有Bug 当carList为空时，会报空指针异常
        Integer countSum = 0;
        for (int i = 0; i < carList.size(); i++) {
            countSum += carList.get(i).getTjshl();
        }
        //返回的数据
        map.put("carList",carList);
        map.put("hjSum", getSum(carList));
        map.put("countSum", countSum);
        return "shoppingCarPage";
    }



    /**
     *  改变是否选中状态
     * @param shfxz
     * @return
     */
    @RequestMapping("changeState")
    public String changeState(String shfxz,int skuId,HttpSession session,ModelMap map,
                              @CookieValue(value = "cookieCarList" ,required = false) String cookieCarList,
                              HttpServletResponse response,HttpServletRequest request){
        //判断用户是否登录
        TMallUserAccount user = (TMallUserAccount)session.getAttribute("user");
        //定义List集合
        List<TMallShoppingCar> carList = new ArrayList<TMallShoppingCar>();
        if(user == null){//用户未登录
            carList = MyJsonUtil.jsonToList(cookieCarList, TMallShoppingCar.class);
            for (int i = 0; i < carList.size(); i++) {
                if (carList.get(i).getSkuId() == skuId){
                    carList.get(i).setShfxz(shfxz);
                }
            }
            MyCookieUtils.setCookie(request,response,"cookieCarList",MyJsonUtil.objectToJson(carList),3*24*60*60,true);
        }else{
            //查询redis中数据，判断是否为空
            carList = (List<TMallShoppingCar>) redisTemplate.opsForValue().get("redisCartListUser"+user.getId());
            carService.updateCarSfxzBySkuIdAndUserId(shfxz,skuId,user.getId());
            for (int i = 0; i < carList.size(); i++) {
                if (carList.get(i).getSkuId() == skuId){
                    carList.get(i).setShfxz(shfxz);
                }
            }
            redisTemplate.opsForValue().set("redisCartListUser"+user.getId(),carList);
        }
        map.put("carList",carList);
        map.put("hjSum",getSum(carList));
        return "shoppingCarInner";
    }


    //计算总价格
    public static BigDecimal getSum(List<TMallShoppingCar> carList){
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < carList.size(); i++) {
            if(carList.get(i).getShfxz().equals("1")){
                sum = sum.add(new BigDecimal(carList.get(i).getHj()));
            }
        }
        return sum;
    }
    //计算合计
    public static double getHj(TMallShoppingCar car){
        BigDecimal tjshul = new BigDecimal(car.getTjshl()+"");
        BigDecimal jg = new BigDecimal(car.getSkuJg()+"");
        double hj = tjshul.multiply(jg).doubleValue();
        return hj;
    }
    //当非空时，判断商品是否存在
    public boolean skuIsHaving(List<TMallShoppingCar> carList, TMallShoppingCar car){
        boolean isHaving = false;
        //判断商品是否存在
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getSkuId() == car.getSkuId()){//如果相等，说明存在此商品
                isHaving = true;
            }
        }
        return isHaving;
    }
}
