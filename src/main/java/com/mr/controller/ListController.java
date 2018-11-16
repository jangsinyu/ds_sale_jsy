package com.mr.controller;

import com.mr.model.OBJECGTMallAttr;
import com.mr.model.OBJECTTMallSku;
import com.mr.model.TMallSku;
import com.mr.model.TMallSkuAttrValueVO;
import com.mr.service.ListService;
import com.mr.util.MyHttpClientUtil;
import com.mr.util.MyJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    @RequestMapping("getSkuListByKey")
    public String getSkuListByKey(String skuMch, ModelMap returnMap){
        Map<String, String> keyMap = new HashMap<String, String>();
        keyMap.put("key",skuMch);
        String s = MyHttpClientUtil.doGet("http://localhost:8082/getSkuListByKey.do", keyMap);

        List<TMallSku> skuList = MyJsonUtil.jsonToList(s, TMallSku.class);
        Integer shpId = skuList.get(1).getShpId();

        //根据商品id查询分类编号2
        Integer flbh2 = listService.getFlbh2ByShpId(shpId);
        //查询商品属性集合
        List<OBJECGTMallAttr> attrList = listService.getAttrListByClass2(flbh2);

        returnMap.put("flbh2", flbh2);
        returnMap.put("attrList", attrList);
        returnMap.put("skuList",skuList);
        return "list";
    }


}
