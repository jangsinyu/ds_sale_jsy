package com.mr.mapper;


import com.mr.model.OBJECGTMallAttr;
import com.mr.model.OBJECTTMallSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by JangSinyu on 2018/11/6.
 */
public interface ListMapper {

    List<OBJECGTMallAttr> getAttrListByClass2(Integer flbh2);

    List<OBJECTTMallSku> getSkuListByClSass2(Integer flbh2);

    List<OBJECTTMallSku> getSkuByClass2AndType(Map<String, Object> map);

    Integer getFlbh2ByShpId(@Param("shpId")Integer shpId);
}
