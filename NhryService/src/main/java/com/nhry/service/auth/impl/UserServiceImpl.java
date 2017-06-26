package com.nhry.service.auth.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.dao.TSysRoleMapper;
import com.nhry.data.auth.dao.TSysUserMapper;
import com.nhry.data.auth.domain.TSysAccesskey;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdBranchEmpMapper;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.data.config.dao.NHSysCodeItemMapper;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.model.auth.UserQueryModel;
import com.nhry.model.auth.UserQueryModel2;
import com.nhry.model.auth.UserQueryModel3;
import com.nhry.service.BaseService;
import com.nhry.service.auth.dao.ResourceService;
import com.nhry.service.auth.dao.TSysAccesskeyService;
import com.nhry.service.auth.dao.UserService;
import com.nhry.service.basic.dao.BranchEmpService;
import com.nhry.service.basic.dao.TSysMessageService;
import com.nhry.utils.Base64Util;
import com.nhry.utils.SysContant;
import com.nhry.utils.date.Date;

public class UserServiceImpl extends BaseService implements UserService {
	private TSysUserMapper userMapper;
	private TSysRoleMapper roleMapper;
	private ResourceService resService;
	private NHSysCodeItemMapper codeItemMapper;
	private RedisTemplate objectRedisTemplate;
	private BranchEmpService branchEmpService;
	private TSysAccesskeyService accessKeyService;
	private TMdBranchEmpMapper branchEmpMapper;
	private TSysMessageService messageService;
    
	
	@Override
	public List<TSysUser> findUserByLoginNameList(ArrayList<String> loginName) {
		return userMapper.findUserByLoginNameList(loginName);
	}
	
	@Override
	public PageInfo findUser(UserQueryModel um){
		// TODO Auto-generated method stub
		TSysUser sysuser = this.userSessionService.getCurrentUser();
		if(!StringUtils.isEmpty(sysuser.getSalesOrg())){
			um.setSalesOrg(sysuser.getSalesOrg());
		}
		if(!StringUtils.isEmpty(sysuser.getCustomizedHrregion())){
			um.setCmpCode(sysuser.getCustomizedHrregion());
		}
		return userMapper.findUser(um);
	}

	public int addUser(TSysUser user) {
		if(StringUtils.isEmpty(user.getLoginName()) || StringUtils.isEmpty(user.getDisplayName())){
			 throw new ServiceException(MessageCode.LOGIC_ERROR, "loginName、displayName属性值不能为空!");
		}
		if(!StringUtils.isEmpty(user.getCustomizedHrregion())){
			NHSysCodeItem item = new NHSysCodeItem();
			item.setParent(user.getCustomizedHrregion());
			item.setTypeCode(SysContant.getSystemConst("sales_org"));
			List<NHSysCodeItem> items = codeItemMapper.findItemsByParentCode(item);
			if(items != null && items.size() > 0 && !StringUtils.isEmpty(items.get(0).getItemCode())){
				user.setSalesOrg(items.get(0).getItemCode());
			}
		}
		TSysUser u = this.userMapper.findUserByLoginName2(user.getLoginName());
		if(u == null){
			user.setCreateOn(new Date());
			user.setLastModified(new Date());
			return userMapper.addUser(user);
		}else{
			//用户修改时，不同步组织属性
			user.setSalesOrg(u.getSalesOrg());
			user.setDealerId(u.getDealerId());
			user.setBranchNo(u.getBranchNo());
			user.setLastModified(new Date());
			this.userMapper.updateUser(user);
			
			if("true".equals(user.getDsPwpAccountDisabled()) && !StringUtils.isEmpty(u.getBranchNo())){
				//账号被禁用
				TMdBranchEmp emp = branchEmpMapper.selectActiveBranchEmpByNo(user.getLoginName());
				if(emp != null){
					emp.setLeaveDate(new Date());
					emp.setStatus("0");
					emp.setLastModified(new Date());
					emp.setLastModifiedBy(SysContant.getSysUser().getLoginName());
					emp.setLastModifiedByTxt(SysContant.getSysUser().getDisplayName());
					branchEmpMapper.uptBranchEmpByBraNo(emp);
					messageService.sendMessageForEmpUpt(emp, "upt", SysContant.getSysUser());
				}
			}else if(!StringUtils.isEmpty(u.getBranchNo())){
				TMdBranchEmp emp = new TMdBranchEmp();
				emp.setEmpNo(u.getLoginName());
				emp.setHrEmpNo(u.getLoginName());
				emp.setBranchNo(u.getBranchNo());
				emp.setEmpName(u.getDisplayName());
				emp.setMp(u.getMobile());
				emp.setIdNo(u.getSmartIdcardnumber());
				emp.setJoinDate(u.getCustomizedJoininworkdate());
				emp.setLastModified(new Date());
				emp.setLastModifiedBy(SysContant.getSysUser().getLoginName());
				emp.setLastModifiedByTxt(SysContant.getSysUser().getDisplayName());
				branchEmpMapper.uptBranchEmpByBraNo(emp);
			}
			return 1;
		}
	}

	@Override
	public TSysUser login(TSysUser user) {
		if(StringUtils.isEmpty(user.getLoginName())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"用户名不能为空!");
		}
		TSysUser _user = userMapper.login(user);
		if(_user == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"用户名或密码错误!!");
		}
		return _user;
	}
	
	@Override
	public TSysUser doLogin(TSysUser user){
		if(StringUtils.isEmpty(user.getLoginName())||StringUtils.isEmpty(user.getPassword())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"用户名和密码不能为空!");
		}
		TSysUser _user = userMapper.doLogin(user);
		if(_user == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"用户名或密码错误!!");
		}
		return _user;
	}


	public void setUserMapper(TSysUserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public TSysUser findUserByLoginName(String loginName) {
		return userMapper.findUserByLoginName(loginName);
	}

	@Override
	public int updateUser(TSysUser record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getLoginName())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "用户名登录名不能为空！");
		}
		TSysUser user = new TSysUser();
		user.setLoginName(record.getLoginName());
		TSysUser oldSysuser = userMapper.login(user);
		if(oldSysuser == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该用户名对应的用户不存在！");
		}
		
		record.setLastModified(new Date());
		if("-1".equals(record.getDealerId())){
			record.setDealerId(null);
		}
		userMapper.updateUser(record);
		
		if(!StringUtils.isEmpty(oldSysuser.getBranchNo()) && StringUtils.isEmpty(record.getBranchNo())){
			//奶站员工
			TMdBranchEmp emp = new TMdBranchEmp();
			emp.setEmpNo(oldSysuser.getLoginName());
			branchEmpService.addBranchEmp(emp,true);
		}else{
			TSysUser sysuser = userMapper.login(user);
			if(!StringUtils.isEmpty(record.getBranchNo())){
				//奶站员工
				TMdBranchEmp emp = new TMdBranchEmp();
				emp.setEmpNo(sysuser.getLoginName());
				emp.setHrEmpNo(sysuser.getLoginName());
				emp.setBranchNo(sysuser.getBranchNo());
				emp.setSalesOrg(sysuser.getSalesOrg());
				emp.setEmpName(sysuser.getDisplayName());
				emp.setMp(sysuser.getMobile());
				emp.setIdNo(sysuser.getSmartIdcardnumber());
				emp.setJoinDate(sysuser.getCustomizedJoininworkdate());
				branchEmpService.addBranchEmp(emp,false);
			}
		}
		return 1;
	}

	@Override
	public int deleteUserByLoginName(String uname) {
		// TODO Auto-generated method stub
		TSysUser user = this.findUserByLoginName(uname);
		if(user == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该用户名对应的用户信息不存在！");
		}
		user.setLastModified(new Date());
		return this.userMapper.deleteUserByLoginName(user);
	}

	@Override
	public List<TSysUser> findUserByRoleId(UserQueryModel2 um) {
//		if(StringUtils.isEmpty(um.getRoleId())){
//			throw new ServiceException(MessageCode.LOGIC_ERROR,"roleId不能为空！");
//		}
		return userMapper.findUserByRoleId(um);
	}

	@Override
	public PageInfo findUserPageByRoleId(UserQueryModel um) {
		if(StringUtils.isEmpty(um.getPageNum()) || StringUtils.isEmpty(um.getPageSize()) || StringUtils.isEmpty(um.getRoleId())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"roleId,pageNum和pageSize不能为空！");
		}
		TSysUser sysuser = this.userSessionService.getCurrentUser();
		if(!StringUtils.isEmpty(sysuser.getSalesOrg())){
			um.setSalesOrg(sysuser.getSalesOrg());
		}
		if(!StringUtils.isEmpty(sysuser.getCustomizedHrregion())){
			um.setCmpCode(sysuser.getCustomizedHrregion());
		}
		return userMapper.findUserPageByRoleId(um);
	}

	@Override
	public PageInfo findNotRoleUser(UserQueryModel3 model) {
		return userMapper.findNotRoleUser(model);
	}

	@Override
	public PageInfo<TSysUser> findNotRoleUserPage(UserQueryModel3 model) {
		if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
		}
		return userMapper.findNotRoleUserPage(model);
	}

	public void setRoleMapper(TSysRoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	public void setResService(ResourceService resService) {
		this.resService = resService;
	}

	public void setCodeItemMapper(NHSysCodeItemMapper codeItemMapper) {
		this.codeItemMapper = codeItemMapper;
	}

	@Override
	public TSysUser getCurrentLoginUser() {
		// TODO Auto-generated method stub
		TSysUser user = this.userSessionService.getCurrentUser();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		objectRedisTemplate.opsForHash().put("SALORDER",user.getBranchNo()+ format.format(new Date()),"OFF");
		return user;
	}

	public void setObjectRedisTemplate(RedisTemplate objectRedisTemplate) {
		this.objectRedisTemplate = objectRedisTemplate;
	}

	public void setBranchEmpService(BranchEmpService branchEmpService) {
		this.branchEmpService = branchEmpService;
	}

	@Override
	public boolean logout(String token) {
		// TODO Auto-generated method stub
		TSysAccesskey key = new TSysAccesskey();
		key.setAccesskey(Base64Util.decodeStr(token));
		key.setType("10");
		TSysAccesskey ak = accessKeyService.findAccesskeyByKey(key);
		if(ak == null){
			return false;
		}else{
			accessKeyService.deleteAccesskeyByAk(key);
		}
		return true;
	}

	public void setAccessKeyService(TSysAccesskeyService accessKeyService) {
		this.accessKeyService = accessKeyService;
	}

	public void setBranchEmpMapper(TMdBranchEmpMapper branchEmpMapper) {
		this.branchEmpMapper = branchEmpMapper;
	}

	public void setMessageService(TSysMessageService messageService) {
		this.messageService = messageService;
	}

	@Override
	public int updateUserPass(TSysUser user) {
		if(StringUtils.isEmpty(user.getNewPassword())||StringUtils.isEmpty(user.getConfirmPassword())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"新密码,确认密码都不能为空");
		}
		if(!user.getNewPassword().equals(user.getConfirmPassword())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"新密码和确认密码不同!!");
		}
		TSysUser sysUser = this.findUserPass(user.getLoginName());
		if(StringUtils.isEmpty(sysUser.getPassword())){
			if(!StringUtils.isEmpty(user.getPassword())){
				throw new ServiceException(MessageCode.LOGIC_ERROR,"原密码输入错误!!");
			}
		}else{
			if(StringUtils.isEmpty(user.getPassword())){
				throw new ServiceException(MessageCode.LOGIC_ERROR,"原密码输入错误!!");
			}else{
				if(!sysUser.getPassword().equals(user.getPassword())){
					throw new ServiceException(MessageCode.LOGIC_ERROR,"原密码输入错误!!");
				}
			}
		}
	
		return userMapper.updateUserPw(user);
	}

	private TSysUser findUserPass(String loginName) {
		return userMapper.findUserPass(loginName);
	}
}
