package com.nhry.data.basic.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdPrice;
import com.nhry.model.basic.PriceQueryModel;
import com.nhry.service.basic.pojo.PriceGroup;

public interface TMdPriceMapper {
	 /**
	  * 添加一个新的价格组
	  * @param record
	  * @return
	  */
	 int addNewPriceGroup(TMdPrice record);
	 
	 /**
	  * 禁用价格组
	  * @param record
	  * @return
	  */
	 int disablePriceGroup(TMdPrice record);
	 
	 /**
	  * 修改价格组
	  * @param record
	  * @return
	  */
	 int updatePriceGroup(TMdPrice record);
	 
	 /**
	  * 
	  * @param smodel
	  * @return
	  */
	 PageInfo searchPriceGroups(PriceQueryModel smodel);
	 
	 /**
	  * 根据价格组编号查询价格组明细
	  * @param id
	  * @return
	  */
	 TMdPrice selectPriceGroupById(String id);
	 
	 /**
	  * 根据价格组编号查询价格组明细
	  * @param id
	  * @return
	  */
	 TMdPrice selectPGByCode4Edit(String id);
	 
	 /**
	  * 根据销售奶站编号和产品编号，查询价格组列表
	  * @param attrs
	  * @return
	  */
	 List<PriceGroup> findMaraPriceBymatnrAndNo(Map<String,String> attrs);
	 
	 /**
	  * 根据销售组织编号和产品编号，查询渠道价格组
	  * @param attrs
	  * @return
	  */
	 PriceGroup findMaraPriceBymatnrAndOrg(Map<String,String> attrs);
	 
	 /**
	  * 根据奶站编号获取价格组
	  * @param branchNo
	  * @return
	  */
	 public List<TMdPrice> getPricesGroupByBn(Map<String,String> attrs);
	 
	 /**
	  * 获取自由奶站价格组列表
	  * @param salesOrg
	  * @return
	  */
	 public List<TMdPrice> getOwnBranchPricesGroupByBn(String salesOrg);
	 
	 /**
	  * 获取经销商奶站价格组列表
	  * @param salesOrg
	  * @return
	  */
	 public List<TMdPrice> getDealerBranchPricesGroupByBn(Map<String,String> attrs);
	 
	 /**
	  * 获取公司价在当前组织(salesOrg)下的个数
	  * @param salesOrg
	  * @return
	  */
	 public int getCompPriceGroupCount(Map<String,String> attrs);
}