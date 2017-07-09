package com.nhry.service.auth.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.task.TaskExecutor;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.dao.TSysResourceMapper;
import com.nhry.data.auth.dao.TSysRoleMapper;
import com.nhry.data.auth.dao.TSysUserMapper;
import com.nhry.data.auth.dao.TSysUserRoleMapper;
import com.nhry.data.auth.domain.TSysRole;
import com.nhry.data.auth.domain.TSysRoleResource;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.auth.domain.TSysUserRole;
import com.nhry.data.basic.dao.TMdBranchEmpMapper;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.model.auth.UserRoleModel;
import com.nhry.service.BaseService;
import com.nhry.service.auth.dao.RoleService;
import com.nhry.service.basic.dao.BranchEmpService;
import com.nhry.service.basic.dao.TSysMessageService;
import com.nhry.utils.PrimaryKeyUtils;
import com.nhry.utils.date.Date;

public class RoleServiceImpl extends BaseService implements RoleService {
	private TSysRoleMapper roleMapper;
	private TSysUserRoleMapper urMapper;
	private TSysResourceMapper resMapper;
	private TSysUserMapper 		userMapper;
	private TMdBranchEmpMapper empMapper;
	private TSysMessageService messService;

	@Override
	public int deleteRoleByRid(String id) {
		// TODO Auto-generated method stub
		TSysRole role = findRoleByRid(id);
		if(role == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该角色id对应的角色不存在！");
		}
		List<TSysUserRole> list = this.urMapper.findUserRoleByRid(id);
		if(list != null && list.size() > 0){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"该角色目前存在"+list.size()+"个人员角色关系,暂不能删除!");
		}
		List<TSysRoleResource> rlist = this.resMapper.findRoleResByRid(id);
		if(rlist != null && rlist.size() > 0){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"该角色目前存在"+list.size()+"个角色资源关系,暂不能删除!");
		}
		return this.roleMapper.deleteRoleByRid(id);
	}

	@Override
	public int addRole(TSysRole record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getRoleName())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"角色名称不能为空!");
		}
		record.setId(PrimaryKeyUtils.generateUuidKey());
		record.setCreateAt(new Date());
		record.setCreateBy(userSessionService.getCurrentUser().getLoginName());
		record.setCreateByTxt(userSessionService.getCurrentUser().getDisplayName());
		return this.roleMapper.addRole(record);
	}

	@Override
	public TSysRole findRoleByRid(String id) {
		// TODO Auto-generated method stub
		return this.roleMapper.findRoleByRid(id);
	}

	@Override
	public int updateRoleByRid(TSysRole record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getId())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"角色id不能为空!");
		}
		TSysRole role = findRoleByRid(record.getId());
		if(role == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该角色id对应的角色不存在！");
		}
		record.setCreateAt(new Date());
		record.setCreateBy(userSessionService.getCurrentUser().getLoginName());
		record.setCreateByTxt(userSessionService.getCurrentUser().getDisplayName());
		return this.roleMapper.updateRoleByRid(record);
	}

	public void setRoleMapper(TSysRoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Override
	public int assignRoleToUsers(UserRoleModel urmodel) {
		// TODO Auto-generated method stub
		//为一个角色添加一批用户
		if(urmodel.getLoginNames() != null && urmodel.getLoginNames().size() > 0){
			if(StringUtils.isEmpty(urmodel.getRoleId())){
				throw new ServiceException(MessageCode.LOGIC_ERROR, "当loginNames不为空时，角色(roleId)也不能为空!");
			}
			for(String uname : urmodel.getLoginNames()){
				uptUserRoleRelations(urmodel.getRoleId(), uname, urmodel.getIsDefault());
			}
		}
		//为一个用户添加一批角色
		if(urmodel.getRoleIds() != null && urmodel.getRoleIds().size() > 0){
			if(StringUtils.isEmpty(urmodel.getLoginName())){
				throw new ServiceException(MessageCode.LOGIC_ERROR, "当roleIds不为空时，用户登录名(loginName)也不能为空!");
			}
			//判断在员工表中是否有该user
			TMdBranchEmp branchEmp = empMapper.selectBranchEmpByNo(urmodel.getLoginName());
			if(branchEmp==null){
				TSysUser sysuser = userMapper.findUserByLogin(urmodel.getLoginName());
				TMdBranchEmp emp = new TMdBranchEmp();
				emp.setEmpNo(sysuser.getLoginName());
				emp.setHrEmpNo(sysuser.getLoginName());
				emp.setBranchNo(sysuser.getBranchNo());
				emp.setSalesOrg(sysuser.getSalesOrg());
				emp.setEmpName(sysuser.getDisplayName());
				emp.setMp(sysuser.getMobile());
				emp.setIdNo(sysuser.getSmartIdcardnumber());
				emp.setJoinDate(sysuser.getCustomizedJoininworkdate());
				emp.setStatus("1");
				empMapper.addBranchEmp(emp);
				messService.sendMessageForEmpUpt(emp, "add", sysuser);
				
				
				
			}
			
			for(String rid : urmodel.getRoleIds()){
				uptUserRoleRelations(rid, urmodel.getLoginName(), urmodel.getIsDefault());
			}
		}
		return 1;
	}
	
	/**
	 * 更新人员角色关系
	 * @param rid
	 * @param lname
	 * @param isdefault
	 */
	public void uptUserRoleRelations(String rid,String lname,String isdefault){
		TSysUserRole ur = new TSysUserRole();
		ur.setId(rid);
		ur.setLoginName(lname);
		if("Y".equals(isdefault) || "N".equals(isdefault)){
			ur.setIsDefault(isdefault);
		}else{
			ur.setIsDefault(null);
		}
		TSysUserRole userRole = urMapper.findUserRoleRelations(ur);
		if(userRole != null){
			//如果存在该用户关系，则更新用户角色关系
			if(!StringUtils.isEmpty(ur.getIsDefault()) && !ur.getIsDefault().equals(userRole.getIsDefault())){
				userRole.setIsDefault(isdefault);
				this.urMapper.updateUserRoleByLoginName(userRole);
			}
		}else{
			this.urMapper.addUserRole(ur);
		}
	}
	
	

	public void setMessService(TSysMessageService messService) {
		this.messService = messService;
	}

	public void setEmpMapper(TMdBranchEmpMapper empMapper) {
		this.empMapper = empMapper;
	}

	public void setUserMapper(TSysUserMapper userMapper) {
		this.userMapper = userMapper;
	}

	
	public void setUrMapper(TSysUserRoleMapper urMapper) {
		this.urMapper = urMapper;
	}

	@Override
	public int deleteUserRoles(UserRoleModel urmodel) {
		// TODO Auto-generated method stub
		return this.urMapper.deleteUserRoles(urmodel);
	}

	public void setResMapper(TSysResourceMapper resMapper) {
		this.resMapper = resMapper;
	}
	
	
	@Override
	public List<TSysRole> getAllRoles() {
		// TODO Auto-generated method stub
		return this.roleMapper.getAllRoles();
	}
}
