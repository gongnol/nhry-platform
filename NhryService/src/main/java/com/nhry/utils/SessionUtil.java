package com.nhry.utils;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class SessionUtil {
	private static final Logger log = Logger.getLogger(SessionUtil.class);

	public static void free(SqlSession session, Statement stmt,ResultSet rs){
         free(rs);
         free(stmt);
         free(session);
	}

	public static void free(SqlSession session, PreparedStatement pStmt,ResultSet rs){
        free(rs);
        free(pStmt);
        free(session);
	}

	public static void free(SqlSession session, Statement stmt){
        free(stmt);
        free(session);
	}
	public static void free(SqlSession session, PreparedStatement pStmt){
        free(pStmt);
        free(session);
	}

	public static void free(Statement stmt,ResultSet rs){
           free(rs);
           free(stmt);
	}	
	
	public static void free(PreparedStatement pStmt,ResultSet rs){
        free(rs);
        free(pStmt);
	}	

	public static void free(SqlSession session){
		if ( session!=null){
			try{ session.close();}catch(Exception e){log.error(e.getMessage(),e);};
		}
	}

	public static void free(ResultSet rs){
		if (rs!=null){
			try{rs.close();}catch(Exception e){log.error(e.getMessage(),e);};
		}
	}
	
	public static void free(Statement stmt){
		if (stmt!=null){
			try{stmt.close();}catch(Exception e){log.error(e.getMessage(),e);};
		}
	}

	public static void free(PreparedStatement pStmt){
		if (pStmt!=null){
			try{pStmt.close();}catch(Exception e){log.error(e.getMessage(),e);};
		}
	}

	public static void free(CallableStatement pStmt){
		if (pStmt!=null){
			try{pStmt.close();}catch(Exception e){log.error(e.getMessage(),e);};
		}
	}

}
