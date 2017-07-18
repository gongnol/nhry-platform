package com.nhry.data.config.dao;

import java.util.List;

import com.nhry.data.auth.domain.CompanyQueryModel;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.github.pagehelper.PageInfo;
import com.nhry.model.order.OrderSearchModel;

public interface NHSysCodeItemMapper {
	/**
	 * 根据code删除codeItem
	 * @param key
	 * @return
	 */
    int deleteCodeItemByCode(NHSysCodeItem codeitem);
    
    /**
     * 添加CodeItem
     * @param record
     * @return
     */
    int addCodeItem(NHSysCodeItem record);
    
    /**
     * 根据code查询CodeItem
     * @param key
     * @return
     */
    NHSysCodeItem findCodeItenByCode(NHSysCodeItem codeitem);
    
    /**
     * 修改codeItem
     * @param record
     * @return
     */
    int updateCodeItemByCode(NHSysCodeItem record);
    
    /**
     * 根据typecode查询codeitem列表
     * @param typecode
     * @return
     */
    public List<NHSysCodeItem> getCodeItemsByTypeCode(String typecode) ;
    
    /**
     * 根据typecode查询TypeItem数量
     * @param typecode
     * @return
     */
    public int findItemCountByTypeCode(String typecode);
    
    /**
     * 根据parent和typecode，查询items
     * @param record
     * @return
     */
    public List<NHSysCodeItem> findItemsByParentCode(NHSysCodeItem record);

    public PageInfo searchCodeItemsByPages(OrderSearchModel smodel);

    public PageInfo searchCompanyCodeItemsByPages(OrderSearchModel smodel);
    
	NHSysCodeItem getCompnayCodeItem(CompanyQueryModel model);
    
}