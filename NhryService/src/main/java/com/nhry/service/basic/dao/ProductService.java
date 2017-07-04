package com.nhry.service.basic.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdMara;
import com.nhry.data.basic.domain.TMdMaraEx;
import com.nhry.data.basic.domain.TMdMaraSort;
import com.nhry.model.basic.ProductQueryModel;
import com.nhry.model.basic.UpdateMaraListModel;
import com.nhry.model.basic.UpdateMaraModel;
public interface ProductService {
	/**
	 * 根据产品编号获取产品信息
	 * @param productCode
	 * @return
	 */
    TMdMara selectProductByCode(String productCode);

    /**
     * 判断某产品是否需要回瓶
     * matnr 产品编号
     * salesOrg 销售组织
     * @return
     */
    TMdMaraEx getMaraExByMatnrAndSalesOrg(String matnr,String salesOrg);
    
    /**
     * 新增产品信息
     * @param record
     * @return
     */
    int addProductByCode(TMdMara record);
    
    /**
     * 修改产品信息
     * @param record
     * @return
     */
    int uptProductByCode(TMdMara record);
    
    /**
     * 更新产品的扩展信息
     * @param matnr
     * @param maraEx
     * @return
     */
    int uptProductExByCode(String matnr,TMdMaraEx maraEx);
    
    /**
     * 根据产品编号发布相应的产品
     * @param code
     * @return
     */
    int pubProductByCode(String code,String status,boolean flag);
    
    /**
     * 根据分类、产品状态、(产品名称、产品简称、产品编号)查询产品列表信息
     * @param smodel
     * @return
     */
    public PageInfo searchProducts(ProductQueryModel smodel);
    
    
    /**
     * 根据分类、产品状态、(产品名称、产品简称、产品编号)查询产品列表信息(分奶设置)
     * @param smodel
     * @return
     */
    public PageInfo searchSting(ProductQueryModel smodel);
     
    /**
     * 根据产品编号查询产品及其扩展信息
     * @param matnr
     * @return
     */
    TMdMara selectProductAndExByCode(String matnr);
    
    /**
     * 根据产品编号模糊查询产品信息列表
     * @param productCode
     * @return
     */
    List<TMdMara> selectProductAndExListByCode(String productCode);
    
    /**
     * 根据价格组编号，查询该价格组中未被选择的公司产品列表
     * @param id
     * @return
     */
    List<TMdMara> findMarasBySalesCodeAndOrg(String id);
    
    /**
     * 获取奶站可销售的产品清单
     * @param branchNo
     * @return
     */
    PageInfo getBranchSaleMaras(ProductQueryModel pm);

    List<TMdMara>  getProductByCodeOrName(String product);
    
    /**
     * 获取当前销售组织下产品与奶瓶规格数据
     * @return
     */
    Map<String,String> getMataBotTypes();

    PageInfo listsBySalesOrg(ProductQueryModel pmodel);
    
    /**
     * 获取奶站可销售的产品列表
     * @return
     */
    public List<TMdMara> getBranchSaleMaras();
    
    
    /**
     * 创建订单
     * @param tMdMaras
     * @return
     */
    public int updateSort(UpdateMaraListModel updateMaraListModel);
    /**
     * 通过奶点获取排序
     * @param branchNo
     * @return
     */
	List<TMdMaraSort> findMaraSortByBranchNo(String branchNo);
	/**
	 * 获取可销售奶瓶并排序
	 * @param pm
	 * @return
	 */
	List<TMdMara> getBranchSaleMaraList(ProductQueryModel pm);

	
	List<TMdMara> getBranchSaleMaraAppList(ProductQueryModel pm);
}
