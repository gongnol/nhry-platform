package com.nhry.data.milk.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milk.dao.TDispOrderMapper;
import com.nhry.data.milk.domain.TDispOrder;
import com.nhry.data.milk.domain.TDispOrderKey;
import com.nhry.model.milk.RouteOrderSearchModel;
import com.nhry.model.milktrans.CreateEmpReturnboxModel;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TDispOrderMapperImpl implements TDispOrderMapper
{
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	private UserSessionService userSessionService;
	public void setUserSessionService(UserSessionService userSessionService) {
		this.userSessionService = userSessionService;
	}
	@Override
	public BigDecimal creatRecBot(CreateEmpReturnboxModel cModel) {
		return sqlSessionTemplate.selectOne("creatRecBot",cModel);
	}

	@Override
	public TDispOrder getDispOrderByNo(String dispOrderNo) {
		return sqlSessionTemplate.selectOne("getDispOrderByNo",dispOrderNo);
	}


	@Override
	public PageInfo searchRoutePlansByPage(RouteOrderSearchModel smodel)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectListByPages("searchRoutePlansByPage",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
	}
	
	@Override
	public TDispOrder selectByPrimaryKey(TDispOrderKey key)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectDispOrderByOrderNo", key);
	}
	
	@Override
	public List<TDispOrder> selectTodayDispOrderByBranchNo(String branchNo,Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		TDispOrder key = new TDispOrder();
		key.setBranchNo(branchNo);
		key.setBranchName(format.format(date));
		return sqlSessionTemplate.selectList("selectTodayDispOrderByBranchNo",key);
	}

	@Override
	public int insert(TDispOrder record)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("addNewDispOrder", record);
	}

	@Override
	public TDispOrder selectYestodayDispOrderByEmp(TDispOrder record)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectYestodayDispOrderByEmp", record);
	}
	
	@Override
	public TDispOrder selectYestodayDispOrderByEmpType10(TDispOrder record)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectYestodayDispOrderByEmpType10", record);
	}

	@Override
	public int updateDispOrderStatus(String orderCode,String status)
	{
		TDispOrder record = new TDispOrder();
		record.setOrderNo(orderCode);
		record.setStatus(status);
		record.setLastModified(new Date());
		record.setLastModifiedBy(userSessionService.getCurrentUser().getLoginName());
		record.setLastModifiedByTxt(userSessionService.getCurrentUser().getDisplayName());
		return sqlSessionTemplate.update("updateDispOrder", record);
	}
	/* (non-Javadoc) 
	* @title: updateDispOrderEmp
	* @description: 更新路单送奶员
	* @param order
	* @return 
	* @see com.nhry.data.milk.dao.TDispOrderMapper#updateDispOrderEmp(com.nhry.data.milk.domain.TDispOrder) 
	*/
	@Override
	public int updateDispOrderEmp(TDispOrder order)
	{
		return sqlSessionTemplate.update("updateDispOrderEmp", order);
	}

	@Override
	public List<TDispOrder> selectDispOrderByBranchNoAndDay(String branchNo,Date orderDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		TDispOrder key = new TDispOrder();
		key.setBranchNo(branchNo);
		key.setDispDate(orderDate);
		return sqlSessionTemplate.selectList("selectDispOrderByBranchNoAndDay",key);
	}


	@Override
	public List<TDispOrder> selectConfirmDispOrderByBranchNoAndDay(String branchNo,Date orderDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		TDispOrder key = new TDispOrder();
		key.setBranchNo(branchNo);
		key.setBranchName(format.format(orderDate));
		return sqlSessionTemplate.selectList("selectConfirmDispOrderByBranchNoAndDay",key);
	}
	
	@Override
	public List<TDispOrder> selectConfirmedDispOrderByDate(String branchNo,String date)
	{
		TDispOrder key = new TDispOrder();
		key.setBranchNo(branchNo);
		key.setBranchName(date);
		return sqlSessionTemplate.selectList("selectConfirmedDispOrderByDate",key);
	}
	
	@Override
	public int deleteDispOrderByOrderNo(List<String> codeList)
	{
		return sqlSessionTemplate.delete("deleteDispOrderByOrderNo",codeList);
	}

	/**
	 * 查询奶站下本日进货汇总金额
	 * @param branchNo
	 * @param date
     * @return
     */
	@Override
	public List<TDispOrder> getBranchEmpAmt(String branchNo, Date date) {
		TDispOrder key = new TDispOrder();
		key.setBranchNo(branchNo);
		key.setDispDate(date);
		return sqlSessionTemplate.selectList("getBranchEmpAmt",key);
	}

	/**
	 * 查询奶站送奶员下本日进货汇总金额
	 * @param branchNo
	 * @param date
	 * @param empNo
     * @return
     */
	@Override
	public TDispOrder getBranchEmpAmtByEmpNo(String branchNo, Date date, String empNo) {
		TDispOrder key = new TDispOrder();
		key.setBranchNo(branchNo);
		key.setDispDate(date);
		key.setDispEmpNo(empNo);
		return sqlSessionTemplate.selectOne("getBranchEmpAmtByEmpNo",key);
	}
}
