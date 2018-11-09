package com.mr.controller;

import com.mr.model.TMallUserAccount;
import com.mr.service.LoginService;
import com.mr.util.MyCookieUtils;
import com.sun.net.httpserver.HttpsConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by JangSinyu on 2018/11/5.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("toLoginPage")
    public String toLoginPage(){
        return "login";
    }

    /**
     *      验证用户名密码登录方法
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("checkUserAndPswd")
    public String checkUserAndPswd(String userName, String password,
                                   HttpSession session,
                                   HttpServletRequest request,
                                   HttpServletResponse response){
        TMallUserAccount user = loginService.checkUserAndPswd(userName, password);
        if (null == user){//查询用户为空，登录失败
            return "redirect:toLoginPage.do";
        }else{//登录成功，放入cookie，并跳转到首页
            session.setAttribute("user", user);
            String yhMch = user.getYhMch();
            MyCookieUtils.setCookie(request, response, "yhMch", yhMch, 24*60*60, true);
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
