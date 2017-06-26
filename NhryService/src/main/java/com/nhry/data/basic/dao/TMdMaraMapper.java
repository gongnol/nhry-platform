package com.nhry.data.basic.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdMara;
import com.nhry.model.basic.ProductQueryModel;
import com.nhry.model.basic.UpdateMaraModel;

public interface TMdMaraMapper {
	
	/**
	 * 根据产品编号查询产品
	 * @param matnr
	 * @return
	 */
    TMdMara selectProductByCode(Map<String,String> attrs);
    
    /**
     * 根据产品编号查询产品与产品扩展信息
     * @param matnr
     * @return
     */
    TMdMara selectProductAndExByCode(Map<String,String> attrs);
    
    /**
     * 修改产品信息
     * @param record
     * @return
     */
    int uptProductByCode(TMdMara record);
    
    /**
     * 发布产品
     * @param code
     * @return
     */
    int pubProductByCode(Map<String,String> attrs);
    
    /**
     * 根据产品分类、状态
     * @param smodel
     * @return
     */
    PageInfo searchProducts(ProductQueryModel smodel);
    
    /**
     * 根据产品编号查询产品与产品扩展信息
     * @param productCode
     * @return
     */
    List<TMdMara> selectProductAndExListByCode(Map<String,String> attrs);
    
    
    List<TMdMara> findMarasBySalesCodeAndOrg(Map<String,String> attrs);
    
    /**
     * 添加产品信息
     * @param tMdMara
     * @return
     */
    int addProduct(TMdMara tMdMara);
    
    /**
     * 修改产品信息
     * @param tMdMara
     * @return
     */
    int updateProduct(TMdMara tMdMara);

    int isProduct(String id);
    
    /**
     * 获取经销商可销售的产品列表
     * @param attrs
     * @return
     */
    PageInfo getDealerMaras(ProductQueryModel pm);
    
    /**
     * 获取自营奶站的可销售的产品列表
     * @param attrs
     * @return
     */
    PageInfo getCompMaras(ProductQueryModel pm);

    List<TMdMara>  getProductByCodeOrNameAndSalesOrg(Map<String,String> attrs);

    PageInfo listsBySalesOrg(ProductQueryModel pm);
    
    /**
     * 获取经销商可销售的产品列表
     * @param pm
     * @return
     */
    public List<TMdMara> getDealerMarasList(ProductQueryModel pm);
    
    /**
     * 获取自营奶站可销售的产品列表
     * @param pm
     * @return
     */
    public List<TMdMara> getCompMarasList(ProductQueryModel pm);
    
    
    /**
    * 排序修改
    * @param attrs
    * @return
    */
    int  updateSort(UpdateMaraModel updateMaraModel);
}