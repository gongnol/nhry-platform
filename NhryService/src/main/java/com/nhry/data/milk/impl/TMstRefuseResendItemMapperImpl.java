package com.nhry.data.milk.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milk.dao.TMstRefuseResendItemMapper;
import com.nhry.data.milktrans.domain.TMstRefuseResendItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gongjk on 2016/10/19.
 */
public class TMstRefuseResendItemMapperImpl implements TMstRefuseResendItemMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    @Override
    public int addResendItem(TMstRefuseResendItem resendItem) {
        return sqlSessionTemplate.insert("addResendItem",resendItem);
    }



    @Override
    public List<TMstRefuseResendItem> selectItemByRequireOrder(String orderNo) {

        return sqlSessionTemplate.selectList("selectItemByRequireOrder", orderNo);
    }

    @Override
    public int delResendItemByRequireOrderNoAndType(String orderNo,String type) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("orderNo",orderNo);
        map.put("type",type);
        return sqlSessionTemplate.delete("delResendItemByMap",map);

    }
    @Override
    public int delResendItemByReOrderNoAndResendOrderNo(String orderNo, String resendOrderNo) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("orderNo",orderNo);
        map.put("resendOrderNo",resendOrderNo);
        return sqlSessionTemplate.delete("delResendItemByMap",map);
    }

    @Override
    public TMstRefuseResendItem selectItemByReqorderAndNo(String reqOrderNo, String resendOrderNo) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("orderNo",reqOrderNo);
        map.put("resendOrderNo",resendOrderNo);
        return sqlSessionTemplate.selectOne("selectItemByReqorderAndNo",map);
    }

    @Override
    public int uptResendItem(TMstRefuseResendItem oldResendItem) {
        return sqlSessionTemplate.update("uptResendItem",oldResendItem);
    }


}
