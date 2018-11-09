package com.mr.controller;

import com.mr.model.OBJECGTMallAttr;
import com.mr.model.OBJECTTMallSku;
import com.mr.model.TMallSkuAttrValueVO;
import com.mr.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/6.
 */
@Controller
public class ListController {
    @Autowired
    private ListService listService;

    /**
     *  跳转至商品集合页面
     * @param flbh2
     * @param map
     * @return
     */
    @RequestMapping("toListPage")
    public String toListPage(Integer flbh2,ModelMap map){
        //查询商品属性集合
        List<OBJECGTMallAttr> attrList = listService.getAttrListByClass2(flbh2);

        //查询sku集合
        List<OBJECTTMallSku> skuList = listService.getSkuListByClSass2(flbh2);

        map.put("skuList", skuList);
        map.put("attrList", attrList);
        map.put("flbh2", flbh2);
        return "list";
    }

    /**
     *  根据商品属性进行查询
     * @return
     */
    @RequestMapping("getSkuByClass2AndType")
    public String getSkuByClass2AndType(TMallSkuAttrValueVO attrValueListVo, Integer flbh2, ModelMap map){
        List<OBJECTTMallSku> skuList = listService.getSkuByClass2AndType(attrValueListVo, flbh2);
        map.put("skuList",skuList);
        return "list-sbox";
    }



}
