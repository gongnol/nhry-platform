package com.nhry.service.basic.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.nhry.data.basic.domain.TMdAddress;

public class Addresses implements Serializable {
  private List<TMdAddress> addresses = new ArrayList<TMdAddress>();

public List<TMdAddress> getAddresses() {
	return addresses;
}

public void setAddresses(List<TMdAddress> addresses) {
	this.addresses = addresses;
}
}
