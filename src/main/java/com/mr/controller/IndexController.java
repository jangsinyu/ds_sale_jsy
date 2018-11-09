package com.mr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JangSinyu on 2018/11/5.
 */
@Controller
public class IndexController {

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("toMainPage")
    public String toMainPage(){
        return "index";
    }


}
