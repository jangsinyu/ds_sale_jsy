package com.mr.mapper;

import com.mr.model.TMallItemVO;
import com.mr.model.TMallSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/7.
 */
public interface ItemMapper {
    List<TMallSku> getSkuListBySpuId(@Param("spuId") Integer spuId);

    TMallItemVO getSkuAttrBySkuId(@Param("skuId")Integer skuId);
}
