package com.nhry.data.sqlexecutor;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;


/**
 * 
 * @author luofuchun
 *
 */
public class SQLParam{
	//支持数据类型 String , int ,short, long , double , date, timestamp 
	public static final int  STRING_TYPE=1;
	public static final int  SHORT_TYPE=2;
	public static final int  INT_TYPE=3;
	public static final int  LONG_TYPE=4;
	public static final int  DOUBLE_TYPE=5;
	public static final int  DATE_TYPE=6;
	public static final int  TIMESTAMP_TYPE=7;
	
	private int type;
	private Object value;

	public static void setParams(PreparedStatement ps,List<SQLParam> sqlParams )throws SQLException{
		if (sqlParams==null || sqlParams.size() <1){
			return ;
		}
		for(int i=0;i<sqlParams.size();i++){
			sqlParams.get(i).setParam(i+1, ps);
		}
	}
	public void setParam(int parameterIndex, PreparedStatement ps )throws SQLException{
		if (STRING_TYPE==this.type){
			if (null ==value){
				ps.setNull(parameterIndex, java.sql.Types.VARCHAR);
			}else{
				ps.setString(parameterIndex, this.getStringValue());
			}
		}else if (SHORT_TYPE==this.type){
			if (null ==value){
				ps.setNull(parameterIndex, java.sql.Types.SMALLINT);
			}else{
				ps.setShort(parameterIndex, this.getShortValue());
			}
		}else if (INT_TYPE==this.type){
			if (null ==value){
				ps.setNull(parameterIndex, java.sql.Types.INTEGER);
			}else{
				ps.setInt(parameterIndex, this.getIntValue());
			}
			
		}else if (LONG_TYPE==this.type){
			if (null ==value){
				ps.setNull(parameterIndex, java.sql.Types.BIGINT);
			}else{
				ps.setLong(parameterIndex, this.getLongValue());
			}

		}else if (DOUBLE_TYPE==this.type){
			if (null ==value){
				ps.setNull(parameterIndex, java.sql.Types.DOUBLE);
			}else{
				ps.setDouble(parameterIndex, this.getDoubleValue());
			}
		
		}else if (DATE_TYPE==this.type){
			if (null ==value){
				ps.setNull(parameterIndex, java.sql.Types.DATE);
			}else{
				ps.setDate(parameterIndex, this.getDateValue());
			}
		
		}else if (TIMESTAMP_TYPE==this.type){
			if (null ==value){
				ps.setNull(parameterIndex, java.sql.Types.TIMESTAMP);
			}else{
				ps.setTimestamp(parameterIndex, this.getTimestampValue());
			}
 		
		}else {
			throw new ServiceException(MessageCode.SERVER_ERROR,"不支持的参数数据类型:"+type);
		}
	}
	
	public SQLParam(int type, Object value){
		this.type=type;
		this.value=value;
	}

	public int getType() {
		return type;
	}

	public Object getValue() {
		return value;
	}

	public String getStringValue() {
		if (value ==null) return null;
		return (String )value;
	}
	
	public int getIntValue() {
		if (value ==null) return 0;
		return ((Integer)value).intValue();
	}

	public short getShortValue() {
		if (value ==null) return 0;
		return ((Short)value).shortValue();
	}

	public long getLongValue() {
		if (value ==null) return 0l;
		return ((Long)value).longValue();
	}

	public double getDoubleValue() {
		if (value ==null) return 0.0;
		return ((Double)value).doubleValue();
	}

	public Date getDateValue() {
		if (value ==null) return null;
		return (Date)value;
	}
	
	public Timestamp getTimestampValue() {
		if (value ==null) return null;
		return (Timestamp )value;
	}
	
}
