package com.mr.controller;

import com.mr.model.TMallItemVO;
import com.mr.model.TMallSku;
import com.mr.service.ItemSeivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/7.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemSeivice itemSeivice;


    /**
     *  跳转至商品详情页面
     */
    @RequestMapping("toItemPage")
    public String toItemPage(Integer skuId, Integer spuId, ModelMap map){

        //根据skuid查询出数据
        TMallItemVO itemVO = itemSeivice.getSkuAttrBySkuId(skuId);

        //spu查询到的sku集合
        List<TMallSku> skuList = itemSeivice.getSkuListBySpuId(spuId);

        map.put("itemVO",itemVO);
        map.put("skuList",skuList);

        return "item";
    }


}
