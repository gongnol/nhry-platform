package com.nhry.service.stud.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.stud.dao.TMdClassMapper;
import com.nhry.data.stud.domain.TMdClass;
import com.nhry.model.stud.ClassListModel;
import com.nhry.model.stud.ClassQueryModel;
import com.nhry.service.stud.dao.ClassService;

/**
 * @author zhaoxijun
 * @data 2017年4月10日
 */
public class ClassServiceImpl implements ClassService {

	@Autowired
	private UserSessionService userSessionService;
	
	@Autowired
	private TMdClassMapper classMapper;
	
	@Override
	public TMdClass findClassByClassCode(String classCode) {
		return classMapper.selectByClassCode(classCode);
	}

	@Override
	public List<TMdClass> findClassListBySalesOrg(String salesOrg) {
		if(StringUtils.isBlank(salesOrg)){
			salesOrg = this.userSessionService.getCurrentUser().getSalesOrg();
		}
		if(StringUtils.isBlank(salesOrg)){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "销售组织编码必填");
		}
		return classMapper.findClassListBySalesOrg10(salesOrg);
	}

	@Override
	public PageInfo<TMdClass> findClassPage(ClassQueryModel queryModel) {
		if(null == queryModel || StringUtils.isBlank(queryModel.getPageNum())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前页数必填");
		}
		if(StringUtils.isBlank(queryModel.getPageSize())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "每页显示条数必填");
		}
		queryModel.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
		return classMapper.findClassPage(queryModel);
	}

	@Override
	public int addClass(TMdClass mdClass) {
		if(null == mdClass || StringUtils.isBlank(mdClass.getClassCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "班级代码必填");
		}
		if(StringUtils.isBlank(mdClass.getClassName())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "班级名称必填");
		}
		if(StringUtils.isBlank(this.userSessionService.getCurrentUser().getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		Date date = new Date();
		mdClass.setCreateAt(date);
		mdClass.setCreateBy(this.userSessionService.getCurrentUser().getLoginName());
		mdClass.setCreateByTxt(this.userSessionService.getCurrentUser().getDisplayName());
		mdClass.setLastModified(date);
		mdClass.setLastModifiedBy(this.userSessionService.getCurrentUser().getLoginName());
		mdClass.setLastModifiedByTxt(this.userSessionService.getCurrentUser().getDisplayName());
		mdClass.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
		mdClass.setSort(0);
		mdClass.setVisiable("10");
		try {
			return classMapper.insertClass(mdClass);
		} catch (DuplicateKeyException e) {
			throw new ServiceException(MessageCode.LOGIC_ERROR, "班级代码系统已存在，请重新输入");
		}
	}
	
	
	
	@Override
	public int addClassList(ClassListModel smodel) {
		TSysUser currentUser = userSessionService.getCurrentUser();
		if(StringUtils.isBlank(currentUser.getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		//获取当前销售组织的基础班级信息
		List<TMdClass> sysClassList = classMapper.findClassListBySalesOrg(currentUser.getSalesOrg());
		//获取传过来的数据
		List<TMdClass> classList = smodel.getClassList();
		//需要删除的班级信息
		ArrayList<TMdClass> delteCalss = new ArrayList<TMdClass>();
		//需要添加的班级信息
		ArrayList<TMdClass> updateClass = new ArrayList<TMdClass>();
		//进行筛选
		for (int i = 0; i < sysClassList.size(); i++) {
			TMdClass tMdClass = sysClassList.get(i);
			Boolean falg=false;
			for (TMdClass clas : classList) {
				if(clas.getClassCode().equals(tMdClass.getClassCode())){
					updateClass.add(clas);
					falg=true;
				}
			}
			if(!falg){
				delteCalss.add(tMdClass);
			}
		}
		
		//移除修改班级信息剩下需要添加的班级信息
		classList.removeAll(updateClass);
		//删除班级信息
		for (TMdClass mdClass : delteCalss) {
			classMapper.deleteByClass(mdClass);
		}
		//更新班级信息
		for (TMdClass mdClass : updateClass) {
			Date date = new Date();
			mdClass.setLastModified(date);
			mdClass.setLastModifiedBy(this.userSessionService.getCurrentUser().getLoginName());
			mdClass.setLastModifiedByTxt(this.userSessionService.getCurrentUser().getDisplayName());
			classMapper.updateTMdClass(mdClass);
		}
		
		//添加班级信息
		for (TMdClass mdClass : classList) {
			if(null == mdClass || StringUtils.isBlank(mdClass.getClassCode())){
				throw new ServiceException(MessageCode.LOGIC_ERROR, "班级代码必填");
			}
			if(StringUtils.isBlank(mdClass.getClassName())){
				throw new ServiceException(MessageCode.LOGIC_ERROR, "班级名称必填");
			}
			if(StringUtils.isBlank(this.userSessionService.getCurrentUser().getSalesOrg())){
				throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
			}
			Date date = new Date();
			mdClass.setCreateAt(date);
			mdClass.setCreateBy(this.userSessionService.getCurrentUser().getLoginName());
			mdClass.setCreateByTxt(this.userSessionService.getCurrentUser().getDisplayName());
			mdClass.setLastModified(date);
			mdClass.setLastModifiedBy(this.userSessionService.getCurrentUser().getLoginName());
			mdClass.setLastModifiedByTxt(this.userSessionService.getCurrentUser().getDisplayName());
			mdClass.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
			mdClass.setSort(0);
			mdClass.setVisiable("10");
			try {
				classMapper.insertClass(mdClass);
			} catch (Exception e) {
				throw new ServiceException(MessageCode.LOGIC_ERROR, "班级代码系统已存在，请重新输入");
			}
		}
		return 1;
	}


	@Override
	public int updClass(TMdClass mdClass) {
		
		if(null == mdClass || StringUtils.isBlank(mdClass.getClassCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "班级代码必传");
		}
		if(StringUtils.isBlank(mdClass.getClassName())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "班级名称必填");
		}
		if(StringUtils.isBlank(this.userSessionService.getCurrentUser().getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		
		TMdClass findMdClass = this.findClassByClassCode(mdClass.getClassCode());
		if(null == findMdClass){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "系统不存在班级代码"+mdClass.getClassCode());
		}
		
		Date date = new Date();
		mdClass.setLastModified(date);
		mdClass.setLastModifiedBy(this.userSessionService.getCurrentUser().getLoginName());
		mdClass.setLastModifiedByTxt(this.userSessionService.getCurrentUser().getDisplayName());
		mdClass.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
		mdClass.setVisiable("10");
		return classMapper.updateTMdClass(mdClass);
	}

	@Override
	public int delClass(String classCode) {
		if(StringUtils.isBlank(classCode)){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "班级代码必传");
		}
		TMdClass findMdClass = this.findClassByClassCode(classCode);
		if(null == findMdClass){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "系统不存在班级代码:"+classCode);
		}
		
		return classMapper.deleteByClassCode(classCode);
	}

}
