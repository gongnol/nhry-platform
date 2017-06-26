package com.nhry.model.basic;

import java.util.ArrayList;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "UpdateMaraListModel", description = "产品更新对象List")
public class UpdateMaraListModel {
	private List<UpdateMaraModel> list = new ArrayList<UpdateMaraModel>();

	public List<UpdateMaraModel> getList() {
		return list;
	}

	public void setList(List<UpdateMaraModel> list) {
		this.list = list;
	};
	
}
