package com.nhry.common.jedis.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexEntity <T> implements java.io.Serializable {
	public  static final long serialVersionUID = 1L;

	public List<T> listData=new ArrayList<T>();
	public  Map<String,T> hashData=new HashMap<String,T>();
	
	public List<T> getListData() {
		return listData;
	}
	
//	public void setListData(List<T> listData) {
//		this.listData = listData;
//	}
	
	public Map<String, T> getHashData() {
		return hashData;
	}
	
	public void addEntity(String key, T obj){
			listData.add(obj);
			hashData.put(key,obj);
	}
	
	public void clear(){
		listData.clear();
		hashData.clear();
	}
	
}
