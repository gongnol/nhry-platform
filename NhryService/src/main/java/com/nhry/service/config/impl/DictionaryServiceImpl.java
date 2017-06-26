package com.nhry.service.config.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.config.dao.NHSysCodeItemMapper;
import com.nhry.data.config.dao.NHSysCodeTypeMapper;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.config.domain.NHSysCodeType;
import com.nhry.model.basic.DictionarySearchModel;
import com.nhry.service.BaseService;
import com.nhry.service.config.dao.DictionaryService;
import com.nhry.utils.PrimaryKeyUtils;
import com.nhry.utils.date.Date;

public class DictionaryServiceImpl extends BaseService implements DictionaryService {
	private NHSysCodeItemMapper codeItemMapper;
	private NHSysCodeTypeMapper codeTypeMapper;

	@Override
	public List<NHSysCodeItem> getCodeItemsByTypeCode(String typecode) {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(typecode)) {
			throw new ServiceException(MessageCode.LOGIC_ERROR, "类型编码不能为空!");
		}
		return codeItemMapper.getCodeItemsByTypeCode(typecode);
	}

	public void setCodeItemMapper(NHSysCodeItemMapper codeItemMapper) {
		this.codeItemMapper = codeItemMapper;
	}

	@Override
	public int delSysCodeTypeByCode(String typeCode) {
		// TODO Auto-generated method stub
		NHSysCodeType codetype = this.findCodeTypeByCode(typeCode);
		if(codetype == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"该类型编码对应的字典代码类型数据不存在！");
		}
		int count = findTypeItemCountByTypeCode(typeCode);
		if(count  > 0){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"该类型编码对应的还有"+count+"个字典代码,暂不能删除！");
		}
		return this.codeTypeMapper.delSysCodeTypeByCode(typeCode);
	}

	@Override
	public int addSysCodeType(NHSysCodeType record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getTypeName())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "类型名称(typeName)不能为空!");
		}
		if(StringUtils.isEmpty(record.getTypeCode())){
			record.setTypeCode(PrimaryKeyUtils.generateUuidKey());
		}
		record.setCreateAt(new Date());
		record.setCreateBy(this.userSessionService.getCurrentUser().getLoginName());
		record.setCreateByTxt(this.userSessionService.getCurrentUser().getDisplayName());
		return this.codeTypeMapper.addSysCodeType(record);
	}

	@Override
	public NHSysCodeType findCodeTypeByCode(String typeCode) {
		// TODO Auto-generated method stub
		return this.codeTypeMapper.findCodeTypeByCode(typeCode);
	}

	@Override
	public int updateSysCodeType(NHSysCodeType record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getTypeName()) || StringUtils.isEmpty(record.getTypeCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "类型编码(typeCode)和类型名称(typeName)不能为空!");
		}
		NHSysCodeType codetype = this.findCodeTypeByCode(record.getTypeCode());
		if(codetype == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"该类型编码对应的字典代码类型数据不存在！");
		}
		record.setLastModified(new Date());
		record.setLastModifiedBy(this.userSessionService.getCurrentUser().getLoginName());
		record.setLastModifiedByTxt(this.userSessionService.getCurrentUser().getDisplayName());
		return this.codeTypeMapper.updateSysCodeType(record);
	}

	public void setCodeTypeMapper(NHSysCodeTypeMapper codeTypeMapper) {
		this.codeTypeMapper = codeTypeMapper;
	}

	@Override
	public int findTypeItemCountByTypeCode(String typecode) {
		// TODO Auto-generated method stub
		return this.codeItemMapper.findItemCountByTypeCode(typecode);
	}

	@Override
	public int deleteCodeItemByCode(NHSysCodeItem codeitem) {
		// TODO Auto-generated method stub
		NHSysCodeItem item = this.findCodeItenByCode(codeitem);
		if(item == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该字典代码不存在!");
		}
		return this.codeItemMapper.deleteCodeItemByCode(codeitem);
	}

	@Override
	public int addCodeItem(NHSysCodeItem record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getTypeCode()) || StringUtils.isEmpty(record.getItemName())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "typeCode、itemName对应的属性值不能为空!");
		}
		NHSysCodeType codetype = this.findCodeTypeByCode(record.getTypeCode());
		if(codetype == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "typeCode对应的字典代码类型不存在!");
		}
		if(StringUtils.isEmpty(record.getItemCode())){
			record.setItemCode(PrimaryKeyUtils.generateUuidKey());
		}
		if(StringUtils.isEmpty(record.getParent())){
			record.setParent("-1");
		}else{
			NHSysCodeItem codeitem = new NHSysCodeItem();
			codeitem.setTypeCode(record.getTypeCode());
			codeitem.setItemCode(record.getParent());
			NHSysCodeItem _codeitem= this.findCodeItenByCode(codeitem);
			if(_codeitem == null){
				throw new ServiceException(MessageCode.LOGIC_ERROR, "parent属性对应的字典代码行项目父节点不存在!");
			}
		}
		record.setCreateAt(new Date());
		record.setCreateBy(userSessionService.getCurrentUser().getLoginName());
		record.setCreateByTxt(userSessionService.getCurrentUser().getDisplayName());
		return this.codeItemMapper.addCodeItem(record);
	}

	@Override
	public NHSysCodeItem findCodeItenByCode(NHSysCodeItem codeitem) {
		// TODO Auto-generated method stub
		return this.codeItemMapper.findCodeItenByCode(codeitem);
	}

	@Override
	public int updateCodeItemByCode(NHSysCodeItem record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getItemCode()) || StringUtils.isEmpty(record.getTypeCode()) || StringUtils.isEmpty(record.getItemName())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "itemCode、typeCode、itemName对应的属性值不能为空!");
		}
		NHSysCodeItem item = this.findCodeItenByCode(record);
		if(item == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该字典代码不存在!");
		}
		record.setLastModified(new Date());
		record.setLastModifiedBy(userSessionService.getCurrentUser().getLoginName());
		record.setLastModifiedByTxt(userSessionService.getCurrentUser().getDisplayName());
		return this.codeItemMapper.updateCodeItemByCode(record);
	}

	@Override
	public List<NHSysCodeItem> getTreeCodeItemsByTypeCode(String typecode) {
		// TODO Auto-generated method stub
		List<NHSysCodeItem> items = new ArrayList<NHSysCodeItem>();
		List<NHSysCodeItem> list = this.getCodeItemsByTypeCode(typecode);
		if (list == null || list.size() == 0) {
			return items;
		}

		Map<String, NHSysCodeItem> temp = new LinkedHashMap<String, NHSysCodeItem>();
		for (NHSysCodeItem item : list) {
			temp.put(item.getItemCode(), item);
		}
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, NHSysCodeItem> entry : temp.entrySet()) {
			NHSysCodeItem children = entry.getValue();
			NHSysCodeItem parent = temp.get(children.getParent());
			if (parent != null) {
				parent.getChildrens().add(children);
			}
			if ("-1".equals(children.getParent())) {
				sb.append(children.getItemCode()).append(",");
			}
		}
		if(sb.length() > 1){
			sb.deleteCharAt(sb.length()-1);
			for(String code : sb.toString().split(",")){
				items.add(temp.get(code));
			}
		}
		return items;
	}

	@Override
	public List<NHSysCodeItem> findItemsByParentCode(NHSysCodeItem record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getTypeCode()) || StringUtils.isEmpty(record.getParent())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "typeCode、parent属性值不能为空！");
		}
		return this.codeItemMapper.findItemsByParentCode(record);
	}

	@Override
	public List<NHSysCodeType> findAllTypeCodes()
	{
		return this.codeTypeMapper.getAllTypeCodes();
	}

}
