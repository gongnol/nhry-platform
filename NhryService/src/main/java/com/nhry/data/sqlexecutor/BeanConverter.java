package com.nhry.data.sqlexecutor;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

 
public class BeanConverter {
	private static HashMap hmSetMethodsBeans = new HashMap();  
    private static HashMap hmGetMethodsBeans = new HashMap();  
    
    public static Object convert(ResultSet rs, Class cls) throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
  	  Object obj = null;    
      obj=cls.newInstance();
      HashMap hmSetMethods = getSetMethods(cls);  
		for (int i=0;i<rs.getMetaData().getColumnCount();i++){
			String jdbcFieldName=rs.getMetaData().getColumnLabel(i+1);
			String _propertyName=getFieldNameByJdbcFieldName(jdbcFieldName);
          Method setMethod = (Method) hmSetMethods.get(_propertyName.toLowerCase());  
          if (setMethod !=null){ 
	            Object[] params =null;
	            if (rs.getMetaData().getColumnTypeName(i+1).equalsIgnoreCase("NUMERIC")||rs.getMetaData().getColumnTypeName(i+1).equalsIgnoreCase("DECIMAL") || rs.getMetaData().getColumnTypeName(i+1).equalsIgnoreCase("DOUBLE"))
	            {
	            	if (rs.getMetaData().getScale(i+1) > 0)
   		              params = new Object[]{rs.getDouble(i+1)};  
	            	else 
	            		if(rs.getMetaData().getPrecision(i+1)>9)
				            params = new Object[]{rs.getLong(i+1)}; 
	            		else
	            			params = new Object[]{rs.getInt(i+1)};  
	            }else if (rs.getMetaData().getColumnTypeName(i+1).equalsIgnoreCase("SMALLINT")) {
		            //params = new Object[]{rs.getBoolean(i+1)};  
		            params = new Object[]{rs.getShort(i+1)}; 
	            }
	            else if (
	            		rs.getMetaData().getColumnTypeName(i+1).equalsIgnoreCase("INT")|| rs.getMetaData().getColumnTypeName(i+1).equalsIgnoreCase("INTEGER")) {
		            params = new Object[]{rs.getInt(i+1)};  
	            }else if (rs.getMetaData().getColumnTypeName(i+1).equalsIgnoreCase("BIGINT")){
		            params = new Object[]{rs.getLong(i+1)};  
	            }else if (rs.getMetaData().getColumnTypeName(i+1).equalsIgnoreCase("CHAR")||rs.getMetaData().getColumnTypeName(i+1).equalsIgnoreCase("VARCHAR")||rs.getMetaData().getColumnTypeName(i+1).equalsIgnoreCase("TEXT")||rs.getMetaData().getColumnTypeName(i+1).equalsIgnoreCase("XML")){
		            params = new Object[]{rs.getString(i+1)};  
	            }else{
	            	params= new Object[]{rs.getObject(i+1)};  
	            }
	            setMethod.invoke(obj, params);  
          }
		}
		return obj;
		}
    
  
//    /** 
//     * @param com 
//     * @param cls 
//     * @return 
//     * @throws BeanConvertException 
//     */  
    public static Object convert(Object instance, Class cls) 
        //throws BeanConvertException 
        {  
        Object obj = null;  
        HashMap hmGetMethods = getGetMethods(instance.getClass()); 
        HashMap hmSetMethods = getSetMethods(cls);  
        Set keySet = null;  
        keySet = hmSetMethods.keySet();  
        Iterator it = keySet.iterator();  
        while (it.hasNext()) {  
            String _propertyName = (String)it.next();  
            Method getMethod = (Method) hmGetMethods.get(_propertyName);  
            Method setMethod = (Method) hmSetMethods.get(_propertyName);  
            if (setMethod != null && getMethod != null)  {  
                try {  
                    if (obj == null) 
                        obj = cls.newInstance();  
                        getMethod.invoke(instance,null);  
                    Object[] params = {getMethod.invoke(instance, null) };  
                    setMethod.invoke(obj, params);  
                } catch (Exception e)  {  
                    e.printStackTrace();  
                    //throw new BeanConvertException();  
                }  
            }  
        }  
        return obj;  
    }  
        
        
     public static HashMap getSetMethods(Class cls)
        //throws BeanConvertException
     {  
        return getSetMethods(cls,Object.class);  
    }  
 
    public static HashMap getSetMethods(Class cls, Class stopClass)  
        //throws BeanConvertException 
        {  
        String clsName = cls.getName();  
        HashMap hmBean = (HashMap)hmSetMethodsBeans.get(clsName);  
        if (hmBean != null)   
            return hmBean;  
      
        BeanInfo beanInfo = null;  
      
        try {  
            beanInfo = Introspector.getBeanInfo(cls, stopClass);  
        } catch (IntrospectionException e) {  
            e.printStackTrace();  
            //throw new BeanConvertException();  
        }  
        PropertyDescriptor[] props;  
        HashMap hm = new HashMap();  
        props = beanInfo.getPropertyDescriptors();  
      
        for (int i = 0; i < props.length; i++){  
            Method setMethod = props[i].getWriteMethod();  
      
            if (setMethod != null); {  
                String field = props[i].getName().toLowerCase();  
                //System.out.println("field:"+field);
                hm.put(field, setMethod);  
            }  
        }  
        hmSetMethodsBeans.put(clsName, hm);  
        return hm;  
    }  

    public static HashMap getGetMethods(Class cls) 
        //throws BeanConvertException
    {  
        return getGetMethods(cls,Object.class);  
    }  

    public static HashMap getGetMethods(Class cls, Class stopClass)
        //throws BeanConvertException 
        {  
        String clsName = cls.getName();  
        HashMap hmBean = (HashMap) hmGetMethodsBeans.get(clsName) ;
        if (hmBean != null) {  
            return hmBean;  
        }  
      
        BeanInfo drbeanInfo = null;  
      
        try {  
            drbeanInfo = Introspector.getBeanInfo(cls);  
        } catch (IntrospectionException e) {  
            e.printStackTrace();  
           // throw new BeanConvertException();  
        }  
      
        PropertyDescriptor[] props;  
        HashMap hm = new HashMap();  
        props = drbeanInfo.getPropertyDescriptors();  
      
        for (int i = 0; i < props.length; i++){  
            Method getMethod = props[i].getReadMethod();  
            if (getMethod != null); {  
                String field = props[i].getName().toLowerCase();  
                hm.put(field, getMethod);  
            }  
        }  
        hmGetMethodsBeans.put(clsName, hm);  
        return hm;  
    }          
    
    public static String getFieldNameByJdbcFieldName(String jdbcFieldName){
    	String result="";
    	jdbcFieldName=jdbcFieldName.trim().toLowerCase();
    	
    	String[] strArray= jdbcFieldName .split("_");
    	for (int i=0;i<strArray.length;i++){
    		if (i==0){
    		    if (strArray[i].length()>1)
    			    result +=strArray[i].substring(0,1)+strArray[i].substring(1);
    		    else
    		    	result +=strArray[i].toUpperCase();	
    		}
    		else{
    		    if (strArray[i].length()>1)
        		   result +=strArray[i].substring(0,1).toUpperCase()+strArray[i].substring(1);
    		    else
    		    	result +=strArray[i].toUpperCase();	
    		}
    	}
    	return result;
    }
    
    public static  Object getPropertyValue(String propertyName, Object dto){
        HashMap hmGetMethods = getGetMethods(dto.getClass()); 
        Method getMethod = (Method) hmGetMethods.get(propertyName.toLowerCase());  
        if (getMethod != null)  
        	try{
                return  getMethod.invoke(dto,null);
        	}catch(Exception e){
                throw new  RuntimeException("getPropertyValue error "+propertyName);
        	}
           else
          throw new  RuntimeException("bean:"+dto.getClass().getName()+"getPropertyValue error:"+propertyName);
    }
 
     public static void main(String[] args){
 
    }
        
}
