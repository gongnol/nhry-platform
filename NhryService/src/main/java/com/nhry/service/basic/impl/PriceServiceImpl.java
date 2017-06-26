package com.nhry.service.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.*;
import com.nhry.data.basic.domain.*;
import com.nhry.model.basic.PriceQueryModel;
import com.nhry.service.BaseService;
import com.nhry.service.basic.dao.PriceService;
import com.nhry.service.basic.dao.TSysMessageService;
import com.nhry.service.basic.pojo.PriceGroup;
import com.nhry.utils.PrimaryKeyUtils;
import com.nhry.utils.SysContant;
import com.nhry.utils.date.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.task.TaskExecutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceServiceImpl extends BaseService implements PriceService {
	private TMdPriceMapper tMdPriceMapper;
	private TMaraPriceRelMapper maraPriceMapper;
	private TMdPriceBranchMapper priceBranchMapper;
	private TMdBranchMapper branchMapper;
	private TMdDealerMapper dealerMapper;
	private TSysMessageService messService;
	private TaskExecutor taskExecutor;

	public void settMdPriceMapper(TMdPriceMapper tMdPriceMapper) {
		this.tMdPriceMapper = tMdPriceMapper;
	}

	@Override
	public int addNewPriceGroup(TMdPrice record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getPriceGroup()) || StringUtils.isEmpty(record.getPriceType())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"价格组名称、价格组类型不能为空!");
		}
		if(SysContant.getSystemConst("price_type_area").equals(record.getPriceType()) && StringUtils.isEmpty(record.getScope())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"选择区域价时必须选择适用范围!");
		}
		if(record.getMprices() == null || record.getMprices().size() == 0){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"价格组至少关联一个商品!");
		}
		TSysUser user = this.userSessionService.getCurrentUser();
		if(SysContant.getSystemConst("price_type_comp").equals(record.getPriceType()) || (SysContant.getSystemConst("price_type_area").equals(record.getPriceType())
				&& !"-1".equals(record.getScope()))){
			Map<String,String> attrs=new HashMap<String,String>(2);
			attrs.put("salesOrg", user.getSalesOrg());
			attrs.put("dealerNo", user.getDealerId());
			attrs.put("priceType", record.getPriceType());
			attrs.put("scope", record.getScope());
			int count = this.tMdPriceMapper.getCompPriceGroupCount(attrs);
			if(count > 0){
				throw new ServiceException(MessageCode.LOGIC_ERROR,"当前销售组织下该类型价格组已经存在!");
			}
		}
		record.setId(PrimaryKeyUtils.generateUuidKey());
		record.setCreateBy(user.getLoginName());
		record.setCreateByTxt(user.getDisplayName());
		record.setCreateAt(new Date());
		record.setStatus("Y");
		record.setSalesOrg(user.getSalesOrg());
		record.setDealerNo(user.getDealerId());
		tMdPriceMapper.addNewPriceGroup(record);
		//维护产品与价格组关系
		mergeMaraPriceRel(record.getId(),record.getMprices());
		
		//选择区域价、公司价 自动将该组织下所有的奶站关联上该价格组
		if(SysContant.getSystemConst("price_type_comp").equals(record.getPriceType()) || SysContant.getSystemConst("price_type_area").equals(record.getPriceType())){
			if(SysContant.getSystemConst("price_type_area").equals(record.getPriceType()) && StringUtils.isEmpty(record.getScope())){
				throw new ServiceException(MessageCode.LOGIC_ERROR, "选择区域价时，适用范围必须选择!");
			}else{
				if("-1".equals(record.getScope())){
					//选择区域价、公司价时，自营奶站不自动关联上该价格组
					return 1;
				}
				Map<String,String> attrs = new HashMap<String,String>();
				attrs.put("salesOrg", user.getSalesOrg());
				attrs.put("dealerNo", record.getScope());
				List<TMdBranch> branchs = branchMapper.findBranchByDno(attrs);
				for(TMdBranch tb : branchs){
					TMdPriceBranch pb = new TMdPriceBranch();
					pb.setBranchNo(tb.getBranchNo());
					pb.setId(record.getId());
					pb.setCreateAt(new Date());
					pb.setCreateBy(user.getLoginName());
					pb.setCreateByTxt(user.getDisplayName());
					this.priceBranchMapper.addPriceBranch(pb);
				}
			}
		}
		return 1;
	}

	@Override
	public int disablePriceGroup(String id) {
		TMdPrice priceGroup = this.selectPriceGroupByCode(id);
		if (priceGroup == null) {
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该价格组不存在!");
		}
		priceGroup.setLastModified(new Date());
		priceGroup.setLastModifiedBy(this.userSessionService.getCurrentUser().getLoginName());
		priceGroup.setLastModifiedByTxt(this.userSessionService.getCurrentUser().getDisplayName());
		//禁用奶站
		tMdPriceMapper.disablePriceGroup(priceGroup);
		//删除该价格组与所有奶站的关系
		return priceBranchMapper.delPriceBranchById(id);
	}

	@Override
	public int updatePriceGroup(TMdPrice record) {
		if(StringUtils.isEmpty(record.getId()) || StringUtils.isEmpty(record.getPriceGroup()) || StringUtils.isEmpty(record.getPriceType())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "价格组编号(id)、价格组名称(priceGroup)、价格组类型(priceType)不能为空!");
		}
		TMdPrice priceGroup = this.selectPriceGroupByCode(record.getId());
		if (priceGroup == null) {
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该价格组不存在!");
		}
		record.setLastModified(new Date());
		record.setLastModifiedBy(this.userSessionService.getCurrentUser().getLoginName());
		record.setLastModifiedByTxt(this.userSessionService.getCurrentUser().getDisplayName());
		tMdPriceMapper.updatePriceGroup(record);
		//维护产品与价格组关系
		mergeMaraPriceRel(record.getId(),record.getMprices());
		return 1;
	}

	@Override
	public PageInfo searchPriceGroups(PriceQueryModel smodel) {
		if (StringUtils.isEmpty(smodel.getPageNum()) || StringUtils.isEmpty(smodel.getPageSize())) {
			throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
		}
		smodel.setDealerNo(this.userSessionService.getCurrentUser().getDealerId());
		smodel.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
		return tMdPriceMapper.searchPriceGroups(smodel);
	}

	@Override
	public TMdPrice selectPriceGroupByCode(String id) {
		// TODO Auto-generated method stub
		TMdPrice price = tMdPriceMapper.selectPriceGroupById(id);
//		if(price != null){
//			price.setMprices(this.maraPriceMapper.findMaraPricesById(id));
//		}
		return price;
	}

	public void setMaraPriceMapper(TMaraPriceRelMapper maraPriceMapper) {
		this.maraPriceMapper = maraPriceMapper;
	}

	@Override
	public int mergeMaraPriceRel(String id,List<TMaraPriceRel> records) {
		// TODO Auto-generated method stub
		//移除原先关联的商品信息
		this.maraPriceMapper.delMaraPricesById(id);
		//添加新的商品关联信息
		if(records != null && records.size() > 0){
			for(TMaraPriceRel mp : records){
				mp.setRelNo(PrimaryKeyUtils.generateUuidKey());
				mp.setId(id);
				mp.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
				mp.setCreateAt(new Date());
				mp.setCreateBy(this.userSessionService.getCurrentUser().getLoginName());
				mp.setCreateByTxt(this.userSessionService.getCurrentUser().getDisplayName());
				this.maraPriceMapper.addMaraPrice(mp);
			}
		}
		return 1;
	}

	@Override
	public int addPriceBranch(TMdPriceBranch record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getBranchNo()) || StringUtils.isEmpty(record.getId()) || StringUtils.isEmpty(record.getPriceType())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "奶站编号(branchNo)、价格编号(id)和价格组类型(priceType)不能为空!");
		}
		TMdBranch branch = this.branchMapper.selectBranchByNo(record.getBranchNo());
		if(branch == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站编号(branchNo)对应的奶站不存在!");
		}
		TMdPrice price = tMdPriceMapper.selectPriceGroupById(record.getId());
		if(price == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该价格组编号(branchNo)对应的价格组不存在!");
		}
		int count = priceBranchMapper.findPriceBrachCountByPt(record);
		if(count > 0){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站下面存在相同类型的价格组，不允许重复添加同一类型价格组!");
		}
		TSysUser user = this.userSessionService.getCurrentUser();
		record.setCreateAt(new Date());
		record.setCreateBy(user.getLoginName());
		record.setCreateByTxt(user.getDisplayName());
		this.priceBranchMapper.addPriceBranch(record);
		//奶站价格组更新，发送系统消息(以线程方式)
		taskExecutor.execute(new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				this.setName("sendMessagesForAddPriceBranch");
				messService.sendMessagesForUptBranch(branch,1,user);
			}
		});
		return 1;
	}

	@Override
	public int delPriceBranchByNo(String branchNo) {
		// TODO Auto-generated method stub
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("branchNo", branchNo);
		int count = this.priceBranchMapper.findPriceBranchCount(attrs);
		if(count == 0){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站编号(branchNo)对应的奶站价格组关系记录不存在!");
		}
		return this.priceBranchMapper.delPriceBranchByNo(branchNo);
	}

	@Override
	public int delPriceBranchById(String id) {
		// TODO Auto-generated method stub
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("id", id);
		int count = this.priceBranchMapper.findPriceBranchCount(attrs);
		if(count == 0){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该价格编号(id)对应的奶站价格组关系记录不存在!");
		}
		return this.priceBranchMapper.delPriceBranchById(id);
	}

	@Override
	public int delPriceBranch(String branchNo,String id) {
		// TODO Auto-generated method stub
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("branchNo", branchNo);
		attrs.put("id", id);
		int count = this.priceBranchMapper.findPriceBranchCount(attrs);
		if(count == 0){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站编号(branchNo)和价格编号(id)对应的奶站价格组关系记录不存在!");
		}
		TMdPrice price =  tMdPriceMapper.selectPriceGroupById(id);
		if(price != null){
			 if("10".equals(price.getPriceType())){
				 //公司价
				 throw new ServiceException(MessageCode.LOGIC_ERROR, "公司价不允许删除!");
			 }else if("20".equals(price.getPriceType()) && !StringUtils.isEmpty(price.getScope()) && !"-1".equals(price.getPriceType())){
				 //区域价
				 throw new ServiceException(MessageCode.LOGIC_ERROR, "经销商奶站的区域价不允许删除!");
			 }
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该价格组编号id对应的价格组不存在!");
		}
		priceBranchMapper.delPriceBranch(attrs);
		//奶站价格组更新，发送系统消息
		TSysUser user = this.userSessionService.getCurrentUser();
		taskExecutor.execute(new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				this.setName("sendMessagesForDelPriceBranch");
				TMdBranch branch = branchMapper.selectBranchByNo(branchNo);
				if(branch != null){
					messService.sendMessagesForUptBranch(branch,1,user);
				}
			}
		});
		return 1;
	}

	public void setPriceBranchMapper(TMdPriceBranchMapper priceBranchMapper) {
		this.priceBranchMapper = priceBranchMapper;
	}

	public void setBranchMapper(TMdBranchMapper branchMapper) {
		this.branchMapper = branchMapper;
	}

	@Override
	public float getMaraPrice(String branchNo, String matnr, String deliveryType) {
		// TODO Auto-generated method stub
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("salesOrg",this.userSessionService.getCurrentUser().getSalesOrg());
		attrs.put("branchNo", branchNo);
		attrs.put("matnr", matnr);
		//先查询该奶站上该商品关联的价格组列表
		List<PriceGroup> prices = this.tMdPriceMapper.findMaraPriceBymatnrAndNo(attrs);
		PriceGroup price = null;
		if(prices != null && prices.size() > 0){
			price = prices.get(0);
		}else{
			//奶站上没有关联如何价格组、查询公司上的价格组(渠道价格组)
			price = this.tMdPriceMapper.findMaraPriceBymatnrAndOrg(attrs);
		}
		if(price == null){
			//如果公司和奶站对于该商品都适用的价格组
			return -1.0f;
		}
		if("10".equals(deliveryType)){
			//自取价
			return price.getPrice1();
		}else if("20".equals(deliveryType)){
			//订户价
			return price.getPrice2();
		}
		return -1.0f;
	}
	
	@Override
	public float getMaraPriceForCreateOrder(String branchNo, String matnr, String deliveryType,String salesOrg) {
		// TODO Auto-generated method stub
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("salesOrg",salesOrg);
		attrs.put("branchNo", branchNo);
		attrs.put("matnr", matnr);
		//先查询该奶站上该商品关联的价格组列表
		List<PriceGroup> prices = this.tMdPriceMapper.findMaraPriceBymatnrAndNo(attrs);
		PriceGroup price = null;
		if(prices != null && prices.size() > 0){
			price = prices.get(0);
		}else{
			//奶站上没有关联如何价格组、查询公司上的价格组(渠道价格组)
			price = this.tMdPriceMapper.findMaraPriceBymatnrAndOrg(attrs);
		}
		if(price == null){
			//如果公司和奶站对于该商品都适用的价格组
			return -1.0f;
		}
		if("10".equals(deliveryType)){
			//自取价
			return price.getPrice1();
		}else if("20".equals(deliveryType)){
			//订户价
			return price.getPrice2();
		}
		return -1.0f;
	}

	public void setDealerMapper(TMdDealerMapper dealerMapper) {
		this.dealerMapper = dealerMapper;
	}

	@Override
	public List<TMdDealer> getDealers() {
		// TODO Auto-generated method stub
		List<TMdDealer> list = this.dealerMapper.findDealersBySalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
		if(list == null){
			list = new ArrayList<TMdDealer>();
		}
		boolean flag = false;
		for(TMdDealer dealer : list){
			if("-1".equals(dealer.getDealerNo())){
				flag = true;
				break;
			}
		}
		if(!flag){
			TMdDealer dealer = new TMdDealer();
			dealer.setDealerNo("-1");
			dealer.setDealerName("自营奶站");
			list.add(0,dealer);
		}
		return list;
	}

	@Override
	public TMdPrice selectPGByCode4Edit(String id) {
		// TODO Auto-generated method stub
		TMdPrice price = this.tMdPriceMapper.selectPGByCode4Edit(id);
		if(price != null){
			Map<String,String> attrs = new HashMap<String,String>();
			attrs.put("salesOrg", this.userSessionService.getCurrentUser().getSalesOrg());
			attrs.put("id", id);
			price.setMprices(this.maraPriceMapper.findMaraPricesById(attrs));
		}
		return price;
	}

	@Override
	public List<TMdPrice> getPricesGroupByBn(String branchNo) {
		// TODO Auto-generated method stub
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("salesOrg",this.userSessionService.getCurrentUser().getSalesOrg());
		attrs.put("branchNo", branchNo);
		return this.tMdPriceMapper.getPricesGroupByBn(attrs);
	}

	@Override
	public List<TMdPrice> getScopePricesGroupByBn(String branchNo) {
		// TODO Auto-generated method stub
		TMdBranch branch = this.branchMapper.selectBranchByNo(branchNo);
		if(branch == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"该奶站编号(branchNo)对应的奶站不存在!");
		}
		if(SysContant.getSystemConst("own_Branch").equals(branch.getBranchGroup())){
			//自有奶站
			return this.tMdPriceMapper.getOwnBranchPricesGroupByBn(this.userSessionService.getCurrentUser().getSalesOrg());
		}else if(SysContant.getSystemConst("dealer_Branch").equals(branch.getBranchGroup())){
			//经销商奶站
			Map<String,String> attrs = new HashMap<String,String>();
			attrs.put("salesOrg",this.userSessionService.getCurrentUser().getSalesOrg());
			attrs.put("dealerNo", this.userSessionService.getCurrentUser().getDealerId());
			return this.tMdPriceMapper.getDealerBranchPricesGroupByBn(attrs);
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"该奶站信息不全,请联系管理完善该奶站信息!");
		}
	}

	@Override
	public PageInfo findMaraPricesById(String id,int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		Map<String,String> attrs = new HashMap<String,String>();
		attrs.put("salesOrg", this.userSessionService.getCurrentUser().getSalesOrg());
		attrs.put("id", id);
		return this.maraPriceMapper.findMaraPricesById(attrs, pageNum, pageSize);
	}

	public void setMessService(TSysMessageService messService) {
		this.messService = messService;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	@Override
	public List<TMdDealer> getDealers(String salesOrg) {
		// TODO Auto-generated method stub
		List<TMdDealer> list = this.dealerMapper.findDealersBySalesOrg(salesOrg);
		if(list == null){
			list = new ArrayList<TMdDealer>();
		}
		boolean flag = false;
		for(TMdDealer dealer : list){
			if("-1".equals(dealer.getDealerNo())){
				flag = true;
				break;
			}
		}
		if(!flag){
			TMdDealer dealer = new TMdDealer();
			dealer.setDealerNo("-1");
			dealer.setDealerName("自营奶站");
			list.add(dealer);
		}
		return list;
	}
}
