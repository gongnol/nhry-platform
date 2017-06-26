package com.nhry.data.basic.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMaraPriceRel;

public interface TMaraPriceRelMapper {
	/**
	 * 删除价格组关联商品信息
	 * @param relNo
	 * @return
	 */
    int delMaraPriceByNo(String relNo);
    
    /**
     * 添加价格组关联商品信息
     * @param record
     * @return
     */
    int addMaraPrice(TMaraPriceRel record);
    
    /**
     * 根据编号查询价格组关联商品信息
     * @param relNo
     * @return
     */
    TMaraPriceRel findMaraPriceByNo(String relNo);
    
    /**
     * 修改价格组关联商品信息
     * @param record
     * @return
     */
    int uptMaraPricerel(TMaraPriceRel record);
    
    /**
     * 根据价格编号id查询价格组关联商品信息
     * @param id
     * @return
     */
    List<TMaraPriceRel> findMaraPricesById(Map<String,String> attrs);
    
    /**
     * 根据价格编号id查询价格组关联商品信息(分页)
     * @param id
     * @return
     */
    PageInfo findMaraPricesById(Map<String,String> attrs,int pageNum,int pageSize);
    
    /**
     * 根据价格编号id，删除关联的商品价格信息
     * @param id
     * @return
     */
    int delMaraPricesById(String id);
}