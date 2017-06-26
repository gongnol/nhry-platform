package com.nhry.model.order;

import com.nhry.model.basic.BaseQueryModel;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by gongjk on 2016/6/21.
 */
@ApiModel(value = "ManHandOrderSearchModel", description = "订单信息列表查询对象")
public class ManHandOrderSearchModel extends BaseQueryModel implements Serializable {
    @ApiModelProperty(value = "orderNo", notes = "订单编号")
    private String preorderStat;
    private String orderDateStart;
    private String orderDateEnd;
    private String retReason;
    private String branchNo;
    private String orderNo;
    private String salesOrg;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBranchNo()
	{
		return branchNo;
	}

	public void setBranchNo(String branchNo)
	{
		this.branchNo = branchNo;
	}

	public String getSalesOrg()
	{
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg)
	{
		this.salesOrg = salesOrg;
	}

	public String getPreorderStat() {
        return preorderStat;
    }

    public void setPreorderStat(String preorderStat) {
        this.preorderStat = preorderStat;
    }

    public String getOrderDateStart() {
        return orderDateStart;
    }

    public void setOrderDateStart(String orderDateStart) {
        this.orderDateStart = orderDateStart;
    }

    public String getOrderDateEnd() {
        return orderDateEnd;
    }

    public void setOrderDateEnd(String orderDateEnd) {
        this.orderDateEnd = orderDateEnd;
    }

    public String getRetReason() {
        return retReason;
    }

    public void setRetReason(String retReason) {
        this.retReason = retReason;
    }
}