package com.nhry.service.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMaraPriceRel;
import com.nhry.data.basic.domain.TMdDealer;
import com.nhry.data.basic.domain.TMdPrice;
import com.nhry.data.basic.domain.TMdPriceBranch;
import com.nhry.model.basic.PriceQueryModel;

import java.util.List;

public interface PriceService {
	/**
	 * 添加新的价格组
	 * @param record
	 * @return
	 */
	int addNewPriceGroup(TMdPrice record);
    
	/**
	 * 停用价格组
	 * @param id
	 * @return
	 */
	int disablePriceGroup(String id);
	
	/**
	 * 修改价格组
	 * @param record
	 * @return
	 */
	int updatePriceGroup(TMdPrice record);
	
     /**
      * 根据经销商类型、状态 查询
      * @param smodel
      * @return
      */
	PageInfo searchPriceGroups(PriceQueryModel smodel);
    
	/**
	 * 根据code查询价格组
	 * @param id
	 * @return
	 */
	TMdPrice selectPriceGroupByCode(String id);
	
	/**
	 * 根据code查询价格组
	 * @param id
	 * @return
	 */
	TMdPrice selectPGByCode4Edit(String id);
	
	/**
	 * 更新价格组关联的商品信息
	 * @param id records
	 * @return
	 */
	int mergeMaraPriceRel(String id,List<TMaraPriceRel> records);
	
	/**
	 * 添加价格组与奶站关系
	 * @param record
	 * @return
	 */
    int addPriceBranch(TMdPriceBranch record);
    
    /**
     * 根据奶站编号删除奶站价格组关系
     * @param branchNo
     * @return
     */
    int delPriceBranchByNo(String branchNo);
    
    /**
     * 根据价格组id删除奶站与价格组关联关系
     * @param id
     * @return
     */
    int delPriceBranchById(String id);
    
    /**
     * 根据奶站编号和价格组id删除奶站与价格组关系
     * @param branchNo id
     * @return
     */
    int delPriceBranch(String branchNo,String id);
    
   /**
    * 根据奶站编号、产品编号、配送类型 获取产品价格
    * @param branchNo 奶站编号
    * @param matnr       产品编号
    * @param deliveryType 配送类型(10:自取；20：送奶到户)
    * @return
    */
    public float getMaraPrice(String branchNo,String matnr,String deliveryType);
    
    /**
     * 根据奶站编号、产品编号、配送类型 获取产品价格(createOrder)
     * @param branchNo 奶站编号
     * @param matnr       产品编号
     * @param deliveryType 配送类型(10:自取；20：送奶到户)
     * @return
     */
    public float getMaraPriceForCreateOrder(String branchNo, String matnr, String deliveryType,String salesOrg);
    /**
     * 根据当前销售组织获取该公司下面的经销商列表
     * @param
     * @return
     */
    public List<TMdDealer> getDealers();
    
    /**
     * 根据销售组织获取该公司下面的经销商列表
     * @param salesOrg
     * @return
     */
    public List<TMdDealer> getDealers(String salesOrg);
    
    /**
     * 根据奶站编号获取选择
     * @param branchNo
     * @return
     */
    public List<TMdPrice> getPricesGroupByBn(String branchNo);
    
    /**
     * 根据奶站编号获取适用范围内的价格组列表
     * @param branchNo
     * @return
     */
    public List<TMdPrice> getScopePricesGroupByBn(String branchNo);
    
    /**
     * 根据价格编号id查询价格组关联商品信息
     * @param id
     * @return
     */
    public PageInfo findMaraPricesById(String id,int pageNum,int pageSize);

}
