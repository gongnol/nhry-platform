package com.nhry.model.basic;

import java.io.Serializable;

public class CustStat implements Serializable {
  private String status;
  private String amount;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}

}
