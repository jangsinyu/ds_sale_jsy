package com.mr.service.impl;

import com.mr.mapper.ListMapper;
import com.mr.model.OBJECGTMallAttr;
import com.mr.model.OBJECTTMallSku;
import com.mr.model.TMallSkuAttrValueVO;
import com.mr.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JangSinyu on 2018/11/6.
 */
@Service
public class ListServiceImpl implements ListService {

    @Autowired
    private ListMapper listMapper;

    public List<OBJECGTMallAttr> getAttrListByClass2(Integer flbh2) {
        return listMapper.getAttrListByClass2(flbh2);
    }

    public List<OBJECTTMallSku> getSkuListByClSass2(Integer flbh2) {
        return listMapper.getSkuListByClSass2(flbh2);
    }

    public List<OBJECTTMallSku> getSkuByClass2AndType(TMallSkuAttrValueVO attrValueListVo, Integer flbh2) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("attrValueList",attrValueListVo.getAttrValueList());
        map.put("flbh2",flbh2);
        return listMapper.getSkuByClass2AndType(map);
    }

    public Integer getFlbh2ByShpId(Integer shpId) {
        return listMapper.getFlbh2ByShpId(shpId);
    }
}
