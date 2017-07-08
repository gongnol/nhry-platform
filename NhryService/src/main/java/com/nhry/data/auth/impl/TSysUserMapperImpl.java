package com.nhry.data.auth.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.auth.dao.TSysUserMapper;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.model.auth.UserQueryModel;
import com.nhry.model.auth.UserQueryModel2;
import com.nhry.model.auth.UserQueryModel3;

public class TSysUserMapperImpl implements TSysUserMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	@Override
	public PageInfo findUser(UserQueryModel um) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectListByPages("findUser", um, Integer.parseInt(um.getPageNum()),Integer.parseInt(um.getPageSize()));
	}
	
	@Override
	public List<TSysUser> findUserByLoginNameList(ArrayList<String> list) {
		return sqlSessionTemplate.selectList("findUserByLoginNameList",list );
	}

	@Override
	public TSysUser login(TSysUser user) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("login", user);
	}
	
	@Override
	public TSysUser doLogin(TSysUser user) {
		return sqlSessionTemplate.selectOne("doLogin", user);
	}

	@Override
	public int addUser(TSysUser user) {
		return this.sqlSessionTemplate.insert("addUser", user);
	}

	@Override
	public TSysUser findUserByLoginName(String loginName) {
		return this.sqlSessionTemplate.selectOne("findUserByLoginName", loginName);
	}
	

	@Override
	public TSysUser findUserByLogin(String loginName) {
		return this.sqlSessionTemplate.selectOne("findUserByLogin", loginName);
	}


	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int updateUser(TSysUser record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updateUser", record);
	}

	@Override
	public int updateUserPw(TSysUser record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updateUserPw", record);
	}

	@Override
	public int deleteUserByLoginName(TSysUser user) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("deleteUserByLoginName", user);
	}

	@Override
	public List<TSysUser> findUserByRoleId(UserQueryModel2 um) {
		return sqlSessionTemplate.selectList("findUserByRoleId",um);
	}

	@Override
	public PageInfo findUserPageByRoleId(UserQueryModel um) {
		return sqlSessionTemplate.selectListByPages("findPageByRoleId",um,Integer.parseInt(um.getPageNum()),Integer.parseInt(um.getPageSize()));
	}

	@Override
	public List<TSysUser> getUsersByRidandOrgs(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getUsersByRidandOrgs", attrs);
	}

	@Override
	public List<TSysUser> getloginNamesByOrgsandRid(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getloginNamesByOrgsandRid", attrs);
	}

	@Override
	public List<TSysUser> getloginNamesByOrgsandRid2(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getloginNamesByOrgsandRid2", attrs);
	}

	@Override
	public PageInfo findNotRoleUser(UserQueryModel3 model) {
		return this.sqlSessionTemplate.selectListByPages("findNotRoleUser",model, Integer.parseInt(model.getPageNum()), Integer.parseInt(model.getPageSize()));
	}

	@Override
	public PageInfo<TSysUser> findNotRoleUserPage(UserQueryModel3 model) {
		return this.sqlSessionTemplate.selectListByPages("findNotRoleUser",model,Integer.valueOf(model.getPageNum()),Integer.valueOf(model.getPageSize()));
	}

	@Override
	public TSysUser findUserByLoginName2(String loginName) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findUserByLoginName2", loginName);
	}

	@Override
	public TSysUser findUserPass(String loginName) {
		return this.sqlSessionTemplate.selectOne("findUserPass", loginName);
	}
}
