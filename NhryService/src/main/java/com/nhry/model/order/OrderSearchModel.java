package com.nhry.model.order;

import com.nhry.model.basic.BaseQueryModel;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(value = "OrderSearchModel", description = "订单信息列表查询对象")
public class OrderSearchModel extends BaseQueryModel implements Serializable {
	@ApiModelProperty(value="orderNo",notes="订单编号")
	private String orderNo;
	private String branchNo;
	private String empNo;
	private String product;
	private String content;//订户电话或者姓名
	private String goAmt;//订单续订的续费
	private String paymentmethod;//付款方式
	private String address;
	private String milkmemberNo;
	private String orderDate;
	private String paymentStat;
	private String milkboxStat;
	private String preorderStat;
	private String preorderSource;
	private String orderDateStart;
	private String orderDateEnd;
	private String endDateStart;
	private String endDateEnd;
	private Date startDate;
	private Date endDate;
	private String companyName;
	private String reason;
	private String status;
	private String orderReturnDateStart;
	private String orderReturnDateEnd;
	private String salesOrg;
	private String dealerNo;
	private String memoTxt;
	private Integer goDays;
	private String onlineSourceType;
	private String promSubType;
	private String preorderStat20F70Z017;//是否查询出年卡，机构待确认的订单 10:年卡+机构 20:年卡 30:机构
	private String orderDispDateStart;//配送开始日期
	private String orderDispDateEnd;//配送截止日期
	
	
	public String getOrderDispDateStart() {
		return orderDispDateStart;
	}

	public void setOrderDispDateStart(String orderDispDateStart) {
		this.orderDispDateStart = orderDispDateStart;
	}

	public String getOrderDispDateEnd() {
		return orderDispDateEnd;
	}

	public void setOrderDispDateEnd(String orderDispDateEnd) {
		this.orderDispDateEnd = orderDispDateEnd;
	}

	public String getPreorderStat20F70Z017() {
		return preorderStat20F70Z017;
	}

	public void setPreorderStat20F70Z017(String preorderStat20F70Z017) {
		this.preorderStat20F70Z017 = preorderStat20F70Z017;
	}

	private ArrayList<String> orders = new ArrayList<String>();
	private List<String> mps;

	public String getPromSubType() {
		return promSubType;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}



	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}



	public void setPromSubType(String promSubType) {
		this.promSubType = promSubType;
	}

	public List<String> getMps() {
		return mps;
	}

	public String getOnlineSourceType() {
		return onlineSourceType;
	}

	public void setOnlineSourceType(String onlineSourceType) {
		this.onlineSourceType = onlineSourceType;
	}

	public void setMps(List<String> mps) {
		this.mps = mps;
	}

	//电商额外字段
	private String shopId;
	private String ecOrderNo;
	private String orderPlatNo;
	private String dhOrderNo;
	private String empMobile;
	private String empName;
	private String dhFlag;
	private String buyerName;
	private Date backDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPreorderSource() {
		return preorderSource;
	}

	public void setPreorderSource(String preorderSource) {
		this.preorderSource = preorderSource;
	}

	public String getMemoTxt()
	{
		return memoTxt;
	}
	public void setMemoTxt(String memoTxt)
	{
		this.memoTxt = memoTxt;
	}
	public ArrayList<String> getOrders()
	{
		return orders;
	}
	public void setOrders(ArrayList<String> orders)
	{
		this.orders = orders;
	}
	public String getBuyerName()
	{
		return buyerName;
	}
	public void setBuyerName(String buyerName)
	{
		this.buyerName = buyerName;
	}
	public String getShopId()
	{
		return shopId;
	}
	public void setShopId(String shopId)
	{
		this.shopId = shopId;
	}
	public String getEcOrderNo()
	{
		return ecOrderNo;
	}
	public void setEcOrderNo(String ecOrderNo)
	{
		this.ecOrderNo = ecOrderNo;
	}
	public String getOrderPlatNo()
	{
		return orderPlatNo;
	}
	public void setOrderPlatNo(String orderPlatNo)
	{
		this.orderPlatNo = orderPlatNo;
	}
	public String getDhOrderNo()
	{
		return dhOrderNo;
	}
	public void setDhOrderNo(String dhOrderNo)
	{
		this.dhOrderNo = dhOrderNo;
	}
	public String getEmpMobile()
	{
		return empMobile;
	}
	public void setEmpMobile(String empMobile)
	{
		this.empMobile = empMobile;
	}
	public String getEmpName()
	{
		return empName;
	}
	public void setEmpName(String empName)
	{
		this.empName = empName;
	}
	public String getDhFlag()
	{
		return dhFlag;
	}
	public void setDhFlag(String dhFlag)
	{
		this.dhFlag = dhFlag;
	}
	public Integer getGoDays()
	{
		return goDays;
	}
	public void setGoDays(Integer goDays)
	{
		this.goDays = goDays;
	}
	public String getDealerNo()
	{
		return dealerNo;
	}
	public void setDealerNo(String dealerNo)
	{
		this.dealerNo = dealerNo;
	}
	public String getSalesOrg()
	{
		return salesOrg;
	}
	public void setSalesOrg(String salesOrg)
	{
		this.salesOrg = salesOrg;
	}
	public String getGoAmt()
	{
		return goAmt;
	}
	public void setGoAmt(String goAmt)
	{
		this.goAmt = goAmt;
	}
	public String getProduct()
	{
		return product;
	}
	public void setProduct(String product)
	{
		this.product = product;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getOrderReturnDateStart()
	{
		return orderReturnDateStart;
	}
	public void setOrderReturnDateStart(String orderReturnDateStart)
	{
		this.orderReturnDateStart = orderReturnDateStart;
	}
	public String getOrderReturnDateEnd()
	{
		return orderReturnDateEnd;
	}
	public void setOrderReturnDateEnd(String orderReturnDateEnd)
	{
		this.orderReturnDateEnd = orderReturnDateEnd;
	}
	public String getReason()
	{
		return reason;
	}
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	public String getCompanyName()
	{
		return companyName;
	}
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getOrderDateStart()
	{
		return orderDateStart;
	}
	public void setOrderDateStart(String orderDateStart)
	{
		this.orderDateStart = orderDateStart;
	}
	public String getOrderDateEnd()
	{
		return orderDateEnd;
	}
	public void setOrderDateEnd(String orderDateEnd)
	{
		this.orderDateEnd = orderDateEnd;
	}
	public String getOrderNo()
	{
		return orderNo;
	}
	public void setOrderNo(String orderNo)
	{
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
	public String getEmpNo()
	{
		return empNo;
	}
	public void setEmpNo(String empNo)
	{
		this.empNo = empNo;
	}
	public String getMilkmemberNo()
	{
		return milkmemberNo;
	}
	public void setMilkmemberNo(String milkmemberNo)
	{
		this.milkmemberNo = milkmemberNo;
	}
	public String getOrderDate()
	{
		return orderDate;
	}
	public void setOrderDate(String orderDate)
	{
		this.orderDate = orderDate;
	}
	public String getPaymentStat()
	{
		return paymentStat;
	}
	public void setPaymentStat(String paymentStat)
	{
		this.paymentStat = paymentStat;
	}
	public String getMilkboxStat()
	{
		return milkboxStat;
	}
	public void setMilkboxStat(String milkboxStat)
	{
		this.milkboxStat = milkboxStat;
	}
	public String getPreorderStat()
	{
		return preorderStat;
	}
	public void setPreorderStat(String preorderStat)
	{
		this.preorderStat = preorderStat;
	}

	public Date getBackDate() {
		return backDate;
	}

	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}

	public String getEndDateStart() {
		return endDateStart;
	}

	public void setEndDateStart(String endDateStart) {
		this.endDateStart = endDateStart;
	}

	public String getEndDateEnd() {
		return endDateEnd;
	}

	public void setEndDateEnd(String endDateEnd) {
		this.endDateEnd = endDateEnd;
	}
}
