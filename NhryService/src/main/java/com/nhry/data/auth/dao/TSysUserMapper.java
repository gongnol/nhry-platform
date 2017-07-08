package com.nhry.data.auth.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.model.auth.UserQueryModel;
import com.nhry.model.auth.UserQueryModel2;
import com.nhry.model.auth.UserQueryModel3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface TSysUserMapper {
	public PageInfo findUser(UserQueryModel um);

	public TSysUser login(TSysUser user);

	public int addUser(TSysUser user);

	TSysUser findUserByLoginName(String loginName);
	
	TSysUser findUserByLoginName2(String loginName);

	int updateUser(TSysUser record);
	
	public int updateUserPw(TSysUser record);
	
	public int deleteUserByLoginName(TSysUser user);

	List<TSysUser> findUserByRoleId(UserQueryModel2 um);

	PageInfo findUserPageByRoleId(UserQueryModel um);
	
	/**
	 * 根据组织和角色id，查找用户列表
	 * @param attrs
	 * @return
	 */
	List<TSysUser> getUsersByRidandOrgs(Map<String,String> attrs);
	
	/**
	 * 根据组织和角色查询登录名列表(不在给定经销商范围内的)
	 * @param attrs
	 * @return
	 */
	List<TSysUser> getloginNamesByOrgsandRid(Map<String,String> attrs);
	
	/**
	 * 根据组织和角色查询登录名列表
	 * @param attrs
	 * @return
	 */
	List<TSysUser> getloginNamesByOrgsandRid2(Map<String,String> attrs);

	/**
	 * 查询未分配角色的用户
	 * @param model
	 * @return
     */
	PageInfo findNotRoleUser(UserQueryModel3 model);

	/**
	 * 查询未分配角色的用户分页
	 * @param model
	 * @return
     */
	PageInfo<TSysUser> findNotRoleUserPage(UserQueryModel3 model);
	
	/**
	 * 通过多个获取
	 * @param loginName
	 * @return
	 */
	public List<TSysUser> findUserByLoginNameList(ArrayList<String> loginName);

	TSysUser doLogin(TSysUser user);

	public TSysUser findUserPass(String loginName);

	TSysUser findUserByLogin(String loginName);
}