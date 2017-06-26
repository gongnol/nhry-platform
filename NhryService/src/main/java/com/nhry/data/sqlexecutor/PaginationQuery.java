package com.nhry.data.sqlexecutor;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class PaginationQuery {
	
	public static <E> PageData<E> getMysqlPageData(String sql,List<SQLParam> sqlParams,int pageNo,int pageSize,Class<E> cls,SqlSession session)throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
		PageData<E> pageData=new PageData<E>();
		pageData.setCurPageNo(pageNo);
		pageData.setPageSize(pageSize);
		
		String sqlCount=sql;
		
		if (sqlCount.toUpperCase().indexOf("ORDER BY")>0){
			sqlCount=sqlCount.substring(0, sqlCount.toUpperCase().indexOf("ORDER BY"));
		}
			
		if (sqlCount.toUpperCase().indexOf("ORDER  BY")>0){
			sqlCount=sqlCount.substring(0, sqlCount.toUpperCase().indexOf("ORDER BY"));
		}
		sqlCount="select count(*) from ("+sqlCount+") nxn";
	
		pageData.setTotalCount(UserSQLExecutor.getTotalCount(sqlCount, sqlParams, session));
		pageData.setListData(UserSQLExecutor.queryListByPageForMysql(sql, sqlParams, pageNo, pageSize, cls, session));
		return pageData;
	}

}
