package com.nhry.data.sqlexecutor;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;


/**
 * 
 * @author luofuchun
 *
 */
public class UserSQLExecutor {

	public static int getTotalCount(String countSql, SqlSession session)throws SQLException{
		Statement stmt=null;
		ResultSet rs =null;
		try{
			stmt=session.getConnection().createStatement();
			rs =stmt.executeQuery(countSql);
			rs.next();
			return rs.getInt(1);
		}finally{
			if (stmt!=null){
				stmt.close();
			}
		}
	}
	
	public static int getTotalCount(String countSql,List<SQLParam> sqlParams, SqlSession session)throws SQLException{
		
		ResultSet rs =null;
		PreparedStatement pstmt=null;
		try{
			pstmt=session.getConnection().prepareStatement(countSql);
			SQLParam.setParams(pstmt, sqlParams);
			rs =pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}finally{
			if (pstmt!=null){
				pstmt.close();
			}
		}
	}
	
	/**
	 * 
	 * @param sql
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	public static int doUpdate(String sql, SqlSession session)throws SQLException{
		Statement stmt=null;
		try{
			stmt=session.getConnection().createStatement();
			return stmt.executeUpdate(sql);
		}finally{
			if (stmt!=null){
				stmt.close();
			}
		}
	}

	/**
	 * 按preparedStatement 方式更新
	 * @param sql
	 * @param sqlParams
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	public static int doUpdate(String sql, List<SQLParam> sqlParams, SqlSession session)throws SQLException{
		PreparedStatement pstmt=null;
		try{
			pstmt=session.getConnection().prepareStatement(sql);
			SQLParam.setParams(pstmt, sqlParams);
			return pstmt.executeUpdate();
		}finally{
			if (pstmt!=null){
				pstmt.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <E> List<E> queryListByPageForMySql(String sql,int pageNo,int pageSize, Class<E> cls,SqlSession session) throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
		List<E> answer=new ArrayList<E>();
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try{
			String sqlPage=sql +" LIMIT ? OFFSET ? " ;
			pstmt=session.getConnection().prepareStatement(sqlPage);
			pstmt.setInt(1, pageSize);
			pstmt.setInt(2, pageSize*(pageNo -1));
			rs=pstmt.executeQuery();
			while(rs.next()){
				Object obj=BeanConverter.convert(rs, cls);
				answer.add((E)obj);
			}
			return answer;
		}finally{
			if (pstmt!=null)
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if (rs!=null)
					try{
						rs.close();
					}catch(Exception e){
						e.printStackTrace();
					}
		}
	}


	/**
	 * 按preparedStatement 方式查询
	 * @param <E>
	 * @param sql
	 * @param sqlParams
	 * @param pageNo
	 * @param pageSize
	 * @param cls
	 * @param session
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static <E> List<E> queryListByPageForMysql(String sql,List<SQLParam> sqlParams, int pageNo,int pageSize, Class<E> cls,SqlSession session) throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
		if (!session.getConnection().getAutoCommit()){
			throw new SQLException("必须设置自动提交才能使用分页功能");
		}

		List<E> answer=new ArrayList<E>();
		PreparedStatement pstmt=null;
		ResultSet rs =null;

		try{
			String sqlPage=sql +" LIMIT ? OFFSET ? " ;
			pstmt=session.getConnection().prepareStatement(sqlPage);
			pstmt.setInt(sqlParams==null || sqlParams.size() <1?1:sqlParams.size()+1, pageSize);
			pstmt.setInt(sqlParams==null || sqlParams.size() <1?2:sqlParams.size()+2, pageSize*(pageNo -1));
			SQLParam.setParams(pstmt, sqlParams);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Object obj=BeanConverter.convert(rs, cls);
				answer.add((E)obj);
			}
			return answer;
		}finally{
			if (pstmt!=null)
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if (rs!=null)
					try{
						rs.close();
					}catch(Exception e){
						e.printStackTrace();
					}
		}
	}
	//	
	//	public static <E> List<E> queryListByPageForSybase(String sql,int pageNo,int pageSize, Class<E> cls,SqlSession session) throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
	//		if (!session.getConnection().getAutoCommit()){
	//			throw new SQLException("必须设置自动提交才能使用分页功能");
	//		}
	//		List<E> answer=new ArrayList<E>();
	//		PreparedStatement pstmt=null;
	//		ResultSet rs =null;
	//		try{
	//			String sqlPage="exec get_page_data(?,?,?)";
	//			pstmt=session.getConnection().prepareStatement(sqlPage);
	//			pstmt.setString(1, sql);
	//			pstmt.setInt(2, (pageNo-1)*pageSize);
	//			pstmt.setInt(3, pageSize);
	//			rs=pstmt.executeQuery();
	//			while(rs.next()){
	//				Object obj=BeanConverter.convert(rs, cls);
	//				answer.add((E)obj);
	//			}
	//			return answer;
	//		}finally{
	//			if (pstmt!=null)
	//				try{
	//					pstmt.close();
	//				}catch(Exception e){
	//				  e.printStackTrace();
	//				}
	//			if (rs!=null)
	//				try{
	//					rs.close();
	//				}catch(Exception e){
	//				  e.printStackTrace();
	//				}
	//		}
	//	}


	public static void execLockQuery(String lockSql, SqlSession session)throws SQLException{
		Statement stmt=null;
		try{
			stmt=session.getConnection().createStatement();
			stmt.executeQuery(lockSql);
		}finally{
			if (stmt!=null){
				stmt.close();
			}
		}
	}
	/**
	 * 
	 * @param <E>
	 * @param sql
	 * @param cls
	 * @param session
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static <E> List<E> queryList(String sql,Class<E> cls,SqlSession session) throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
		List<E> answer=new ArrayList<E>();
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try{
			pstmt=session.getConnection().prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Object obj=BeanConverter.convert(rs, cls);
				answer.add((E)obj);
			}
			return answer;

		}finally{
			if (pstmt!=null)
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if (rs!=null)
					try{
						rs.close();
					}catch(Exception e){
						e.printStackTrace();
					}
		}
	}


	/**
	 * 按preparedStatement 方式查询
	 * @param <E>
	 * @param sql
	 * @param sqlParams
	 * @param cls
	 * @param session
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static <E> List<E> queryList(String sql,List<SQLParam> sqlParams,Class<E> cls,SqlSession session) throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
		List<E> answer=new ArrayList<E>();
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try{
			pstmt=session.getConnection().prepareStatement(sql);
			SQLParam.setParams(pstmt, sqlParams);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Object obj=BeanConverter.convert(rs, cls);
				answer.add((E)obj);
			}
			return answer;

		}finally{
			if (pstmt!=null)
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if (rs!=null)
					try{
						rs.close();
					}catch(Exception e){
						e.printStackTrace();
					}
		}
	}
	/**
	 * 
	 * @param <E>
	 * @param sql
	 * @param rows
	 * @param cls
	 * @param session
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static <E> List<E> queryList(String sql,int rows , Class<E> cls,SqlSession session) throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
		List<E> answer=new ArrayList<E>();
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try{
			int selectIdx=sql.toUpperCase().indexOf("SELECT");
			//			int orderIdx=sql.toUpperCase().lastIndexOf("ORDER BY");
			String sqlNew="select top "+rows+" "+sql.substring(selectIdx+6);
		//	System.out.println(sqlNew);
			pstmt=session.getConnection().prepareStatement(sqlNew);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Object obj=BeanConverter.convert(rs, cls);
				answer.add((E)obj);
			}
			return answer;

		}finally{
			if (pstmt!=null)
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if (rs!=null)
					try{
						rs.close();
					}catch(Exception e){
						e.printStackTrace();
					}
		}
	}
	@SuppressWarnings("unchecked")
	public static <E> List<E> queryList(String sql,int rows ,List<SQLParam> sqlParams, Class<E> cls,SqlSession session) throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
		List<E> answer=new ArrayList<E>();
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try{
			int selectIdx=sql.toUpperCase().indexOf("SELECT");
			//			int orderIdx=sql.toUpperCase().lastIndexOf("ORDER BY");
			String sqlNew="select top "+rows+" "+sql.substring(selectIdx+6);
		//	System.out.println(sqlNew);
			pstmt=session.getConnection().prepareStatement(sqlNew);
			SQLParam.setParams(pstmt, sqlParams);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Object obj=BeanConverter.convert(rs, cls);
				answer.add((E)obj);
			}
			return answer;

		}finally{
			if (pstmt!=null)
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if (rs!=null)
					try{
						rs.close();
					}catch(Exception e){
						e.printStackTrace();
					}
		}
	}

	/**
	 * @param <E>
	 * @param sql
	 * @param cls
	 * @param session
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static <E> E queryFirst(String sql,Class<E> cls, SqlSession session)  throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try{
			int selectIdx=sql.toUpperCase().indexOf("SELECT");
			//			int orderIdx=sql.toUpperCase().lastIndexOf("ORDER BY");
			String sqlNew="select " +sql.substring(selectIdx+6) + " limit 1 ";
			//System.out.println(sqlNew);
			pstmt=session.getConnection().prepareStatement(sqlNew);
			rs=pstmt.executeQuery();
			if (rs.next()){
				Object obj=BeanConverter.convert(rs, cls);
				return (E)obj;
			}else{
				return null;
			}
		}finally{
			if (pstmt!=null)
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if (rs!=null)
					try{
						rs.close();
					}catch(Exception e){
						e.printStackTrace();
					}
		}
	}
	/**
	 * 按preparedStatement 方式查询
	 * @param <E>
	 * @param sql
	 * @param cls
	 * @param sqlParams
	 * @param session
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static <E> E queryFirst(String sql, List<SQLParam> sqlParams,Class<E> cls,SqlSession session)  throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try{
			int selectIdx=sql.toUpperCase().indexOf("SELECT");
			String sqlNew="select top 1 "+sql.substring(selectIdx+6);
//			System.out.println(sqlNew);
			SQLParam.setParams(pstmt, sqlParams);
			pstmt=session.getConnection().prepareStatement(sqlNew);
			rs=pstmt.executeQuery();
			if (rs.next()){
				Object obj=BeanConverter.convert(rs, cls);
				return (E)obj;
			}else{
				return null;
			}
		}finally{
			if (pstmt!=null)
				try{
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if (rs!=null)
					try{
						rs.close();
					}catch(Exception e){
						e.printStackTrace();
					}
		}
	}


}

