package com.mr.controller;

import com.mr.model.TMallShoppingCar;
import com.mr.model.TMallUserAccount;
import com.mr.service.CarService;
import com.mr.service.LoginService;
import com.mr.util.MyCookieUtils;
import com.mr.util.MyJsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JangSinyu on 2018/11/5.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private CarService carService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("toLoginPage")
    public String toLoginPage(String loginUrl, ModelMap map){
        if(!StringUtils.isBlank(loginUrl)){
            map.put("loginUrl",loginUrl);
        }
        return "login";
    }

    /**
     *      验证用户名密码登录方法
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("checkUserAndPswd")
    public String checkUserAndPswd(String userName, String password,String loginUrl,
                       HttpSession session, HttpServletRequest request, HttpServletResponse response,
                       @CookieValue(value = "cookieCarList" ,required = false) String cookieCarList){
        TMallUserAccount user = loginService.checkUserAndPswd(userName, password);
        if (null == user){//查询用户为空，登录失败
            return "redirect:toLoginPage.do";
        }else{//登录成功，放入cookie，并跳转到首页
            session.setAttribute("user", user);
            String yhMch = user.getYhMch();
            MyCookieUtils.setCookie(request, response, "yhMch", yhMch, 24*60*60, true);

            if(!StringUtils.isEmpty(cookieCarList)){
                //获取cookie中的值
                List<TMallShoppingCar> carListCookie = MyJsonUtil.jsonToList(cookieCarList, TMallShoppingCar.class);
                //获得数据库中的数据
                //List<TMallShoppingCar> carListDB = carService.getCarListByUserId(user.getId());

                //循环判断商品是否存在
                for (int i = 0; i < carListCookie.size(); i++) {

                    //取数据库查询
                    TMallShoppingCar car =
                            carService.getCarByUserIdAndSkuId(carListCookie.get(i).getSkuId(),user.getId());
                    if(car != null){//存在
                        //修改添加数量
                        car.setTjshl(car.getTjshl()+carListCookie.get(i).getTjshl());
                        //修改合计
                        car.setHj(CarController.getHj(car));
                        //修改数据库数据
                        carService.updateCarByUser(car);
                    }else{//不存在，直接添加
                        Map<String, Object> paramMap = new HashMap<String, Object>();
                        paramMap.put("userId",user.getId());
                        paramMap.put("car",carListCookie.get(i));
                        carService.saveCarToDateBase(paramMap);
                    }
                }
                redisTemplate.delete("redisCartListUser"+user.getId());
            }
            MyCookieUtils.deleteCookie(request,response,"cookieCarList");
            if(!StringUtils.isBlank(loginUrl)){
                return "redirect:"+loginUrl+".do";
            }
            return "redirect:toMainPage.do";
        }
    }

    /**
     *  注销登录方法
     * @param session
     * @return
     */
    @RequestMapping("toLogout")
    public String toLogout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:toMainPage.do";
    }

    /**
     * 跳转至注册页面
     * @return
     */
    @RequestMapping("toRegistPage")
    public String toRegistPage(){
        return "regist";
    }

    /**
     * 验证账号是否存在
     * @param userName 用户名
     * @return
     */
    @ResponseBody
    @RequestMapping("checkYhMch")
    public String checkYhMch(String userName){
        TMallUserAccount user = loginService.checkYhMch(userName);
        if(null == user){
            return "yes";
        }else{
            return "no";
        }
    }

    @RequestMapping("saveUser")
    public String saveUser(TMallUserAccount user){
        loginService.saveUser(user);
        return "redirect:toLoginPage.do";
    }
}
