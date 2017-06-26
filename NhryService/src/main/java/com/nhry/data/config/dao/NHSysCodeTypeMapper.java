package com.nhry.data.config.dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.config.domain.NHSysCodeType;
import com.nhry.model.basic.DictionarySearchModel;

public interface NHSysCodeTypeMapper {
	/**
	 * 删除字典代码类型
	 * @param typeCode 类型编码
	 * @return
	 */
    int delSysCodeTypeByCode(String typeCode);
    
    /**
     * 添加字典代码类型
     * @param record
     * @return
     */
    int addSysCodeType(NHSysCodeType record);
    
    /**
     * 根据code查找字典代码类型
     * @param typeCode
     * @return
     */
    NHSysCodeType findCodeTypeByCode(String typeCode);
    
    /**
     * 修改字典代码类型
     * @param record
     * @return
     */
    int updateSysCodeType(NHSysCodeType record);
    
    /**
     * 获取所有的typeCode
     * @param typecode
     * @return
     */
    List<NHSysCodeType> getAllTypeCodes() ;


}