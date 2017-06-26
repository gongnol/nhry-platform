package com.nhry.service.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.dao.TSysUserMapper;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TBranchNotsellListMapper;
import com.nhry.data.basic.dao.TSysMessageMapper;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.data.basic.domain.TMdMara;
import com.nhry.data.basic.domain.TSysMessage;
import com.nhry.data.order.dao.TPreOrderMapper;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.data.stud.domain.TMdMaraStud;
import com.nhry.model.basic.MessageModel;
import com.nhry.model.basic.OrderModel;
import com.nhry.service.BaseService;
import com.nhry.service.basic.dao.TSysMessageService;
import com.nhry.utils.PrimaryKeyUtils;
import com.nhry.utils.SysContant;
import com.nhry.utils.date.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TSysMessageServiceImpl extends BaseService implements TSysMessageService {
	private static final Logger LOGGER = Logger.getLogger(TSysMessageServiceImpl.class);
	private TSysMessageMapper messageMapper;
    private TSysUserMapper userMapper;
    private TBranchNotsellListMapper notsellListMapper;
    private TPreOrderMapper tPreOrderMapper;
    
	@Override
	public int delTSysMessageByNo(String messageNo) {
		// TODO Auto-generated method stub
		return this.messageMapper.delTSysMessageByNo(messageNo);
	}

	@Override
	public int addTSysMessage(TSysMessage record) {
		// TODO Auto-generated method stub
		return this.messageMapper.addTSysMessage(record);
	}

	@Override
	public TSysMessage findTSysmessageByNo(String messageNo) {
		// TODO Auto-generated method stub
		return this.messageMapper.findTSysmessageByNo(messageNo);
	}

	@Override
	public int uptTSysMessage(TSysMessage record) {
		// TODO Auto-generated method stub
		return this.messageMapper.uptTSysMessage(record);
	}

	public void setMessageMapper(TSysMessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}

	public void setUserMapper(TSysUserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean sendProductsMessages(String title,TMdMara mara,TSysUser user) {
		// TODO Auto-generated method stub
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("salesOrg", mara.getSalesOrg());
		attrs.put("matnr", mara.getMatnr());
		List<String> list = this.notsellListMapper.getNotSellDealerNosByMatnr(attrs);
		List<TSysUser> users = null;
		if(list != null && list.size() > 0){
			attrs.put("rid", SysContant.getSystemConst("branch_back_office"));
			if(list.contains("-1")){
				//自营奶站不可售卖
				attrs.put("branchGroup", SysContant.getSystemConst("dealer_Branch"));
			}
			StringBuffer sb = new StringBuffer();
			for(String dn : list){
				if("-1".equals(dn)){
					continue;
				}
				sb.append("'").append(dn).append("'").append(",");
			}
			if(sb.length() > 1){
				sb.deleteCharAt(sb.length()-1);
				attrs.put("dealerNo", sb.toString());
			}
			users = this.userMapper.getloginNamesByOrgsandRid(attrs);
		}else{
			//所有奶站都可以售卖
			users = this.userMapper.getloginNamesByOrgsandRid(attrs);
		}
		if(users != null && users.size() > 0){
			sendMessage(users, title+"！产品编号："+mara.getMatnr(), "产品编号："+mara.getMatnr()+"  产品名称："+mara.getMatnrTxt()+" 产品简称："+mara.getMaraEx().getShortTxt()+" 报货提前天数："
					+mara.getMaraEx().getPreDays(), "10","10",user);
		}
		return true;
	}
	
	/**
	 * 发送消息
	 * @param users  发送用户列表
	 * @param title    消息主题
	 * @param content  消息内容
	 * @param type       消息类型(10：产品消息；20：订单消息；30：奶站消息)
	 * @param source    消息来源(10:系统本身；20：电商系统)
	 */
	private void sendMessage(List<TSysUser> users,String title,String content,String type,String source,TSysUser sysuser){
		if(users != null && users.size() > 0){
			for(TSysUser user : users){
				TSysMessage mess = new TSysMessage();
				mess.setSalesOrg(user.getSalesOrg());
				mess.setDealerNo(user.getDealerId());
				mess.setBranchNo(user.getBranchNo());
				mess.setLoginName(user.getLoginName());
				mess.setType(type);    //产品消息
				mess.setSource(source);
				mess.setDisplayName(user.getDisplayName());
				mess.setFinishFlag("N");
				mess.setMessageNo(PrimaryKeyUtils.generateUuidKey());
				mess.setCreateAt(new Date());
				mess.setCreateBy(sysuser.getLoginName());
				mess.setCreateByTxt(sysuser.getDisplayName());
				mess.setSource("10");
				mess.setTitle(title);
				mess.setContent(content);
				this.messageMapper.addTSysMessage(mess);
			}
		}
	}

	public void setNotsellListMapper(TBranchNotsellListMapper notsellListMapper) {
		this.notsellListMapper = notsellListMapper;
	}

	@Override
	public boolean sendOrderMemo(OrderModel om) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(om.getOrderNo()) || StringUtils.isEmpty(om.getMemoType()) || StringUtils.isEmpty(om.getMemoTitle()) || StringUtils.isEmpty(om.getMemoContent())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号(orderNo)、备注类别(memoType)、备注标题(memoTitle)、备注内容(memoContent)都必须输入!");
		}
		TPreOrder order = tPreOrderMapper.selectByPrimaryKey(om.getOrderNo());
		if(order == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"该订单编号(orderNo)对应的订单不存在，请检查你的订单编号!");
		}
		String memoContent = om.getMemoContent()+"  订单编号为："+order.getOrderNo();

		List<TSysUser> users = null;
		TSysUser sysuser = this.userSessionService.getCurrentUser();
		//10-送部门内勤 20-送该订单奶站内勤 30-送部门内勤和奶站内勤
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("salesOrg", order.getSalesOrg());
		if("10".equals(om.getMemoType())){
			//部门内勤
			attrs.put("rid", "'"+SysContant.getSystemConst("department_back_office")+"'");
			users = userMapper.getloginNamesByOrgsandRid2(attrs);
			if(users == null || users.size() == 0){
				throw new ServiceException(MessageCode.LOGIC_ERROR, "该组织下没有找到相应的部门内勤人员!");
			}
			this.sendMessage(users, om.getMemoTitle(),memoContent, "20","20",sysuser);
			if(!StringUtils.isEmpty(order.getDealerNo())){
				//经销商奶站订单
				attrs.put("dealerNo", order.getDealerNo());
				attrs.put("rid", "'"+SysContant.getSystemConst("dealer_back_office")+"'");
				users = userMapper.getloginNamesByOrgsandRid2(attrs);
				if(users == null || users.size() == 0){
					throw new ServiceException(MessageCode.LOGIC_ERROR, "该组织下没有找到相应的经销商内勤人员!");
				}
				this.sendMessage(users, om.getMemoTitle(),memoContent , "20","20",sysuser);
			}
		}else if("20".equals(om.getMemoType())){
			//奶站内勤
			attrs.put("branchNo", order.getBranchNo());
			attrs.put("dealerNo", order.getDealerNo());
			attrs.put("rid", "'"+SysContant.getSystemConst("branch_back_office")+"'");
			users = userMapper.getloginNamesByOrgsandRid2(attrs);
			if(users == null || users.size() == 0){
				throw new ServiceException(MessageCode.LOGIC_ERROR, "该组织下没有找到相应的奶站内勤人员!");
			}
			this.sendMessage(users, om.getMemoTitle(), memoContent, "20","20",sysuser);
		}else if("30".equals(om.getMemoType())){
			//部门内勤和奶站内勤
			om.setMemoType("10");
			this.sendOrderMemo(om);
			
			om.setMemoType("20");
			this.sendOrderMemo(om);
		}
		return true;
	}

	public void settPreOrderMapper(TPreOrderMapper tPreOrderMapper) {
		this.tPreOrderMapper = tPreOrderMapper;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean sendMessagesForCreateProducts(TMdMara mara) {
		// TODO Auto-generated method stub
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("salesOrg", mara.getSalesOrg());
		//部门内勤
		attrs.put("rid", "'"+SysContant.getSystemConst("department_back_office")+"'");
		List<TSysUser> users = userMapper.getloginNamesByOrgsandRid2(attrs);
		if(users == null || users.size() == 0){
			LOGGER.warn("该销售组织下："+mara.getSalesOrg()+"目前没有部门内勤！");
			return false;
		}else{
			this.sendMessage(users, "新品添加消息！商品编号："+mara.getMatnr(), "新品添加消息！商品编号："+mara.getMatnr()+" 商品名称："+mara.getMatnrTxt(), "30","10",SysContant.getSysUser());
		}
		return true;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean sendMessagesForCreateProducts(TMdMaraStud mara) {
		// TODO Auto-generated method stub
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("salesOrg", mara.getSalesOrg());
		//部门内勤
		attrs.put("rid", "'"+SysContant.getSystemConst("department_back_office")+"'");
		List<TSysUser> users = userMapper.getloginNamesByOrgsandRid2(attrs);
		if(users == null || users.size() == 0){
			LOGGER.warn("该销售组织下："+mara.getSalesOrg()+"目前没有部门内勤！");
			return false;
		}else{
			this.sendMessage(users, "学生奶新品添加消息！商品编号："+mara.getMatnr(), "新品添加消息！商品编号："+mara.getMatnr()+" 商品名称："+mara.getMatnrTxt(), "30","10",SysContant.getSysUser());
		}
		return true;
	}
	
	
	

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean sendMessagesForCreateBranch(TMdBranch branch) {
		// TODO Auto-generated method stub
		
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("salesOrg", branch.getSalesOrg());
		//部门内勤
		attrs.put("rid", "'"+SysContant.getSystemConst("department_back_office")+"'");
		List<TSysUser> users = userMapper.getloginNamesByOrgsandRid2(attrs);
		if(users == null || users.size() == 0){
			LOGGER.warn("该销售组织下："+branch.getSalesOrg()+"目前没有部门内勤！");
			return false;
		}else{
			this.sendMessage(users, "奶站新建消息！奶站编号："+branch.getBranchNo(), "奶站新建消息！奶站编号："+branch.getBranchNo()+" 奶站名称："+branch.getBranchName(), "30","10",SysContant.getSysUser());
		}
		return true;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean sendMessagesForUptBranch(TMdBranch branch,int flag,TSysUser user) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(branch.getSalesOrg()) || StringUtils.isEmpty(branch.getBranchNo())){
			return false;
		}
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("salesOrg", branch.getSalesOrg());
		attrs.put("branchNo", branch.getBranchNo());
		attrs.put("dealerNo", branch.getDealerNo());
		attrs.put("rid", "'"+SysContant.getSystemConst("branch_back_office")+"'");
		List<TSysUser> users = userMapper.getloginNamesByOrgsandRid2(attrs);
		if(users == null || users.size() == 0){
			LOGGER.warn("该销售组织下："+branch.getSalesOrg()+"目前没有奶站内勤！");
			return false;
		}else{
			if(1 == flag){
				//价格组发生变化
				this.sendMessage(users, "奶站更新价格组消息！奶站编号："+branch.getBranchNo(), "奶站配置更新消息！奶站编号："+branch.getBranchNo()+" 奶站名称："+branch.getBranchName()+" 价格组配置发生变化，敬请关注！", "30","10",user);
			}else if(2 == flag){
				//配送区域发生变化
				this.sendMessage(users, "奶站更新配送消息！奶站编号："+branch.getBranchNo(), "奶站配置更新消息！奶站编号："+branch.getBranchNo()+" 奶站名称："+branch.getBranchName()+" 配送区域发生变化，敬请关注！", "30","10",user);
			}
		}
		return true;
	}

	@Override
	public PageInfo searchMessages(MessageModel mess) {
		// TODO Auto-generated method stub
		mess.setLoginName(this.userSessionService.getCurrentUser().getLoginName());
		return this.messageMapper.searchMessages(mess);
	}

	@Override
	public int closeMessage(String messageNo) {
		// TODO Auto-generated method stub
		Map attrs = new HashMap();
		attrs.put("finishTime", new Date());
		attrs.put("finishFlag", "Y");
		attrs.put("loginName", this.userSessionService.getCurrentUser().getLoginName());
		attrs.put("messageNo", messageNo);
		return this.messageMapper.closeSysMessage(attrs);
	}

	@Override
	public int sendMessageForEmpUpt(TMdBranchEmp emp, String tag,TSysUser user) {
		// TODO Auto-generated method stub
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("salesOrg", emp.getSalesOrg());
		attrs.put("branchNo", emp.getBranchNo());
		attrs.put("rid", "'"+SysContant.getSystemConst("branch_back_office")+"'");
		List<TSysUser> users = userMapper.getloginNamesByOrgsandRid2(attrs);
		if(users == null || users.size() == 0){
			LOGGER.warn("该销售组织下："+emp.getSalesOrg()+"目前没有奶站内勤！");
			return -1;
		}else{
			if("add".equals(tag)){
				//新增员工
				this.sendMessage(users, "奶站新增员啦！员工编号："+emp.getHrEmpNo(), "奶站新增员消息！员工编号："+emp.getHrEmpNo()+" 员工姓名："+emp.getEmpName()+"，敬请关注！", "30","10",user);
			}else if("upt".equals(tag)){
				//员工变更奶站
				this.sendMessage(users, "奶站有员工离职啦！员工编号："+emp.getHrEmpNo(), "奶站员工离职消息！员工编号："+emp.getHrEmpNo()+" 员工姓名："+emp.getEmpName()+"，敬请关注！", "30","10",user);
			}
		}
		return 1;
	}
}
