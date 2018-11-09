package com.mr.service;

import com.mr.model.TMallItemVO;
import com.mr.model.TMallSku;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/7.
 */
public interface ItemSeivice {
    List<TMallSku> getSkuListBySpuId(Integer spuId);

    TMallItemVO getSkuAttrBySkuId(Integer skuId);
}
