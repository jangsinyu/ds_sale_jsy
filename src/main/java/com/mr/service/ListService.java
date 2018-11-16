package com.mr.service;

import com.mr.model.OBJECGTMallAttr;
import com.mr.model.OBJECTTMallSku;
import com.mr.model.TMallSkuAttrValueVO;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/6.
 */
public interface ListService {
    List<OBJECGTMallAttr> getAttrListByClass2(Integer flbh2);

    List<OBJECTTMallSku> getSkuListByClSass2(Integer flbh2);

    List<OBJECTTMallSku> getSkuByClass2AndType(TMallSkuAttrValueVO attrValueListVo, Integer flbh2);

    Integer getFlbh2ByShpId(Integer shpId);
}
