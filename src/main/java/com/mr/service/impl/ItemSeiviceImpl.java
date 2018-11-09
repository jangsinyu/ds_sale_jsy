package com.mr.service.impl;

import com.mr.mapper.ItemMapper;
import com.mr.model.TMallItemVO;
import com.mr.model.TMallSku;
import com.mr.service.ItemSeivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/7.
 */
@Service
public class ItemSeiviceImpl implements ItemSeivice {

    @Autowired
    private ItemMapper itemMapper;

    public List<TMallSku> getSkuListBySpuId(Integer spuId) {
        return itemMapper.getSkuListBySpuId(spuId);
    }

    public TMallItemVO getSkuAttrBySkuId(Integer skuId) {
        return itemMapper.getSkuAttrBySkuId(skuId);
    }
}
