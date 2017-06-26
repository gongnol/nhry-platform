package com.nhry.common.jedis.entity;

public class StringComplexEntity extends ComplexEntity<String> {

	private static final long serialVersionUID = 1L;
	
	public void addEntity(String key, String obj){
			listData.add(key+"|"+obj);
			hashData.put(key,obj);
	}

	public void addEntity(String key, String value,String objectXML){
		//[10,已支付]|<code></code><idx></idx><value></value>
		listData.add("["+key+","+value+"]|"+objectXML);
		hashData.put(key,value+"|"+objectXML);
    }
}
