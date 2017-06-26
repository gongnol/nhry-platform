package com.nhry.service.external.impl;

import com.nhry.data.basic.dao.TMdBranchEmpMapper;
import com.nhry.data.basic.domain.*;
import com.nhry.data.config.dao.NHSysCodeItemMapper;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.model.order.OrderSearchModel;
import com.nhry.service.basic.dao.TVipCustInfoService;
import com.nhry.service.basic.pojo.BranchEmpModel;
import com.nhry.service.external.EcBaseService;
import com.nhry.service.external.dao.EcService;
import com.nhry.utils.EnvContant;
import com.nhry.utils.SysContant;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EcServiceImpl extends EcBaseService implements EcService{
    private NHSysCodeItemMapper itemMapper;
    private TVipCustInfoService tVipCustInfoService;
    private TMdBranchEmpMapper branchEmpMapper;

	public void setBranchEmpMapper(TMdBranchEmpMapper branchEmpMapper)
	{
		this.branchEmpMapper = branchEmpMapper;
	}

	public void settVipCustInfoService(TVipCustInfoService tVipCustInfoService)
	{
		this.tVipCustInfoService = tVipCustInfoService;
	}

	@Override
	public void pushBranch2EcForUpt(TMdBranch branch) {
		// TODO Auto-generated method stub
		try {
			NHSysCodeItem item = new NHSysCodeItem();
			item.setTypeCode(SysContant.getSystemConst("branch_province"));
			item.setItemCode(branch.getProvince());
			NHSysCodeItem ct = itemMapper.findCodeItenByCode(item);
			JSONArray arr = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("businessno", "BUSSSENDBRANCHINFO");
			JSONObject body = new JSONObject();
			JSONObject ssbi = new JSONObject();
			ssbi.put("serviceName", "SVCSENDBRANCHINFO");
			JSONArray data = new JSONArray();
			JSONObject branchJson = new JSONObject();
			branchJson.put("customerId", "DH");
			branchJson.put("branch_no", branch.getBranchNo());
			branchJson.put("sales_org", branch.getSalesOrg());
			branchJson.put("company_code", branch.getCompanyCode());
			branchJson.put("branch_name", branch.getBranchName());
			branchJson.put("branch_group",branch.getBranchGroup());
			branchJson.put("sales_cha",branch.getSalesCha());
			branchJson.put("branch_level",branch.getBranchLevel());
			branchJson.put("province",ct != null ? ct.getAttr1() : null);
			branchJson.put("city", branch.getCity());
			branchJson.put("county", branch.getCounty());
			branchJson.put("address",branch.getAddress());
			branchJson.put("tel", branch.getTel());
			branchJson.put("werks",branch.getWerks());
			branchJson.put("lgort", branch.getLgort());
			branchJson.put("emp_no",branch.getEmpNo());
			branchJson.put("mp",branch.getMp());
			branchJson.put("dealer_no",branch.getDealerNo());
			data.put(branchJson);
			ssbi.put("data", data);
			body.put("SVCSENDBRANCHINFO", ssbi);
			json.put("body", body);
			arr.put(json);
			pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setItemMapper(NHSysCodeItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	@Override
	public void getOrderList(OrderSearchModel model)
	{
			try {
				JSONArray arr = new JSONArray();
				JSONObject json = new JSONObject();
				json.put("businessno", "BUSSGETORDERLIST");
				JSONObject body = new JSONObject();
				JSONObject ssbi = new JSONObject();
				ssbi.put("serviceName", "SVCGETORDERLIST");
				JSONArray data = new JSONArray();
				JSONObject orderSearchJson = new JSONObject();
				
				orderSearchJson.put("customerId", "DH");
				orderSearchJson.put("shopId", model.getShopId());
				orderSearchJson.put("ecOrderNo", model.getEcOrderNo());
				orderSearchJson.put("orderPlatNo", model.getOrderPlatNo());
				orderSearchJson.put("dhOrderNo", model.getDhOrderNo());
				orderSearchJson.put("vipNo", model.getMilkmemberNo());
				orderSearchJson.put("mobile", model.getContent());
				orderSearchJson.put("buyerName", model.getBuyerName());
				orderSearchJson.put("empMobile", model.getEmpMobile());
				orderSearchJson.put("empName", model.getEmpName());
				orderSearchJson.put("branchName", model.getBranchNo());
				orderSearchJson.put("createDateStart", model.getOrderDateStart());
				orderSearchJson.put("createDateEnd", model.getOrderDateEnd());
				orderSearchJson.put("dhFlag", model.getDhFlag());
				orderSearchJson.put("salesOrg", model.getSalesOrg());
				
				data.put(orderSearchJson);
				ssbi.put("data", data);
				body.put("SVCGETORDERLIST", ssbi);
				json.put("body", body);
				arr.put(json);
				pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
			} catch (JSONException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void getOrderdtlinfo(OrderSearchModel model)
	{
		try {
			JSONArray arr = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("businessno", "BUSSGETORDERDETAIL");
			JSONObject body = new JSONObject();
			JSONObject ssbi = new JSONObject();
			ssbi.put("serviceName", "SVCGETORDERDETAIL");
			JSONArray data = new JSONArray();
			JSONObject orderSearchJson = new JSONObject();
			
			orderSearchJson.put("customerId", "DH");
			orderSearchJson.put("dhOrderNo", model.getOrderNo());
			
			data.put(orderSearchJson);
			ssbi.put("data", data);
			body.put("SVCGETORDERDETAIL", ssbi);
			json.put("body", body);
			arr.put(json);
			pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendOrderStopRe(OrderSearchModel model)
	{
		try {
			JSONArray arr = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("businessno", "BUSSSENDORDERSTOPRE");
			JSONObject body = new JSONObject();
			JSONObject ssbi = new JSONObject();
			ssbi.put("serviceName", "SVCSENDORDERSTOPRE");
			JSONArray data = new JSONArray();
			JSONObject orderStopReJson = new JSONObject();
			
			orderStopReJson.put("customerId", "DH");
			orderStopReJson.put("dhOrderNo", model.getOrderNo());
			orderStopReJson.put("pauseFlag", model.getContent());//停奶标志Y/N
			orderStopReJson.put("pauseStartDate", model.getOrderDateStart());//停奶开始日期yyyy-mm-dd
			orderStopReJson.put("pauseEndDate", model.getOrderDateEnd());//停奶截止日期
			orderStopReJson.put("reason", model.getReason());//原因
			
			data.put(orderStopReJson);
			ssbi.put("data", data);
			body.put("SVCSENDORDERSTOPRE", ssbi);
			json.put("body", body);
			arr.put(json);
			pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendOrderStatus(TPreOrder order)
	{
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			JSONArray arr = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("businessno", "BUSSSENDORDERSTATUS");
			JSONObject body = new JSONObject();
			JSONObject ssbi = new JSONObject();
			ssbi.put("serviceName", "SVCSENDORDERSTATUS");
			JSONArray data = new JSONArray();
			JSONObject orderStatusReJson = new JSONObject();
			
			orderStatusReJson.put("customerId", "DH");
			orderStatusReJson.put("dhOrderNo", order.getOrderNo());
			orderStatusReJson.put("status", order.getPreorderStat());//已支付：101发货：200交易完成：220退订：300
			orderStatusReJson.put("paymentType", order.getPaymentmethod());//02微信04现金09卡支付
			orderStatusReJson.put("reFee", order.getCurAmt());//退款金额
			orderStatusReJson.put("editDate", f.format(new Date()));
			orderStatusReJson.put("empMobile", order.getBranchMp());//送奶员手机
			orderStatusReJson.put("empName", order.getBranchEmpName());//送奶员姓名
			if("200".equals(order.getPreorderStat())){
				BranchEmpModel emp = branchEmpMapper.empDetailInfo(order.getEmpNo());
				if(emp.getEmp()!=null){
					orderStatusReJson.put("empMobile", emp.getEmp().getMp());//送奶员手机
					orderStatusReJson.put("empName", emp.getEmp().getEmpName());//送奶员姓名
				}
			}
			
			data.put(orderStatusReJson);
			ssbi.put("data", data);
			body.put("SVCSENDORDERSTATUS", ssbi);
			json.put("body", body);
			arr.put(json);
			pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getOrderComments(TPreOrder order)
	{
		try {
			JSONArray arr = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("businessno", "BUSSGETORDERCOMMENTS");
			JSONObject body = new JSONObject();
			JSONObject ssbi = new JSONObject();
			ssbi.put("serviceName", "SVCGETORDERCOMMENTS");
			JSONArray data = new JSONArray();
			JSONObject orderCommentsReJson = new JSONObject();
			
			orderCommentsReJson.put("customerId", "DH");
			orderCommentsReJson.put("dhOrderNo", order.getOrderNo());
			
			data.put(orderCommentsReJson);
			ssbi.put("data", data);
			body.put("SVCGETORDERCOMMENTS", ssbi);
			json.put("body", body);
			arr.put(json);
			pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendOrderComments(TPreOrder order)
	{
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			JSONArray arr = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("businessno", "BUSSSENDORDERCOMMENTS");
			JSONObject body = new JSONObject();
			JSONObject ssbi = new JSONObject();
			ssbi.put("serviceName", "SVCSENDORDERCOMMENTS");
			JSONArray data = new JSONArray();
			JSONObject orderCommentsReJson = new JSONObject();
			
			orderCommentsReJson.put("customerId", "DH");
			orderCommentsReJson.put("dhOrderNo", order.getOrderNo());
			orderCommentsReJson.put("type", order.getOrderType());//备注类别10-地址20-奶站30-其他
			orderCommentsReJson.put("editPerson", order.getCreaterBy());
			orderCommentsReJson.put("editDate", f.format(new Date()));
			orderCommentsReJson.put("commentsTitle", order.getSign());
			orderCommentsReJson.put("commentsTxt", order.getMemoTxt());
			
			data.put(orderCommentsReJson);
			ssbi.put("data", data);
			body.put("SVCSENDORDERCOMMENTS", ssbi);
			json.put("body", body);
			arr.put(json);
			pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void sendOrderInfo(TPreOrder order, List<TPlanOrderItem> entries)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			JSONArray arr = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("businessno", "BUSSSENDORDERINFO");
			JSONObject body = new JSONObject();
			JSONObject orderJson = new JSONObject();
			JSONObject entryJson = new JSONObject();
			JSONObject promotionJson = new JSONObject();
			
			TMdAddress address = tVipCustInfoService.findAddressById(order.getAdressNo());
			TMdBranchEmp emp = branchEmpMapper.selectBranchEmpByNo(order.getEmpNo());
			
			//订单主信息
			orderJson.put("serviceName", "SVCSENDORDERMAIN");
			JSONArray data = new JSONArray();
			JSONObject oorderJson = new JSONObject();
			oorderJson.put("customerId", "DH");
			oorderJson.put("orderPlatNo", order.getOrderNo());
			oorderJson.put("dhOrderNo", order.getOrderNo());
			oorderJson.put("netShopId", "00006");
			oorderJson.put("empId", "");
			oorderJson.put("createDate", format.format(order.getOrderDate()));
			oorderJson.put("vipNo", order.getMemberNo());
			oorderJson.put("buyerName", address.getRecvName());
			oorderJson.put("postFee", "0");
			oorderJson.put("paidFlag", "N");
			oorderJson.put("paidDate", "");
			oorderJson.put("paymentType", "");
			oorderJson.put("phone", address.getTel());
			oorderJson.put("mobile", address.getMp());
			oorderJson.put("addrGuid", order.getAdressNo());
			oorderJson.put("province", address.getProvince());
			oorderJson.put("city", address.getCity());
			oorderJson.put("district", address.getCounty());
			oorderJson.put("street", "");
			oorderJson.put("townName", address.getResidentialAreaName()==null?"":address.getResidentialAreaName());
			oorderJson.put("address", address.getAddressTxt());
			oorderJson.put("empMobile", emp==null?"":emp.getMp() );
			oorderJson.put("empName", emp==null?"":emp.getEmpName() );
			oorderJson.put("branchNo", order.getBranchNo());
			if("20".equals(order.getMilkboxStat())){
				oorderJson.put("milkBoxFlag", "Y");
			}else{
				oorderJson.put("milkBoxFlag", "N");
			}
			if("20".equals(order.getSign())){
				oorderJson.put("pauseFlag", "Y");
				oorderJson.put("pauseDateStart", f.format(order.getStopDateStart()));
				oorderJson.put("pauseDateEnd", f.format(order.getStopDateEnd()));
			}
			oorderJson.put("orderSource", "DH");
			oorderJson.put("remark", order.getMemoTxt());
			data.put(oorderJson);
			orderJson.put("data", data);
			
			//订单行信息
			entryJson.put("serviceName", "SVCSENDORDERITEMLIST");
			JSONArray data2 = new JSONArray();
			for(TPlanOrderItem e:entries){
   			JSONObject oentryJson = new JSONObject();
   			oentryJson.put("as_order_no", "SVCSENDORDERMAIN##@@AS_ECORDERNO");
   			oentryJson.put("oid", e.getItemNo());
   			oentryJson.put("salePrice", e.getSalesPrice().floatValue());
   			oentryJson.put("fee", e.getSalesPrice().multiply(new BigDecimal(e.getDispTotal())).floatValue() );
   			oentryJson.put("itemNo", e.getMatnr());
   			oentryJson.put("quantity", e.getDispTotal());
   			oentryJson.put("dhType", "30");
   			oentryJson.put("dayQty", e.getQty());
   			oentryJson.put("ruleType", e.getRuleType().equals("10")?"02":"05");
   			oentryJson.put("reachTimeType", e.getReachTimeType());
   			oentryJson.put("plantimeStart", format.format(e.getStartDispDate()));
   			oentryJson.put("plantimeEnd", format.format(e.getEndDispDate()));
   			oentryJson.put("remark", "");
   			data2.put(oentryJson);
			}
			entryJson.put("data", data2);
			
			//订单的促销信息
			entryJson.put("serviceName", "SVCSENDORDERTICKETLIST");
			JSONArray data3 = new JSONArray();
//			for(TPlanOrderItem e:entries){
//				if(StringUtil.isBlank(e.getPromotion()))continue;
//				JSONObject opromotionJson = new JSONObject();
//				opromotionJson.put("as_order_no", "SVCSENDORDERMAIN##@@AS_ECORDERNO");
//				opromotionJson.put("ticketNo", e.getPromotion());
//				data3.put(opromotionJson);
//			}
			promotionJson.put("data", data3);
			
			//推送
			body.put("SVCSENDORDERMAIN", orderJson);
			body.put("SVCSENDORDERITEMLIST", entryJson);
			body.put("SVCSENDORDERTICKETLIST", promotionJson);
			json.put("body", body);
			arr.put(json);
			
			pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void sendResidentialArea2Ec(TMdResidentialArea area) {
		// TODO Auto-generated method stub
		try {
			JSONArray arr = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("businessno", "BUSSSENDTOWNINFO");
			JSONObject body = new JSONObject();
			JSONObject ssbi = new JSONObject();
			ssbi.put("serviceName", "SVCSENDTOWNINFO");
			JSONArray data = new JSONArray();
			JSONObject areaJson = new JSONObject();
			areaJson.put("customerId", "DH");
			areaJson.put("residential_area_id", area.getId());
			areaJson.put("sales_org",area.getSalesOrg());
			areaJson.put("province", area.getProvince());
			areaJson.put("city",area.getCity());
			areaJson.put("county",area.getCounty());
			areaJson.put("street",area.getStreet());
			areaJson.put("guideboard",area.getGuideboard());
			areaJson.put("residential_area_txt",area.getResidentialAreaTxt());
			areaJson.put("residential_num", area.getResidentialNum());
			areaJson.put("property_txt",area.getPropertyTxt());
			areaJson.put("property_tel", area.getPropertyTel());
			areaJson.put("status",area.getStatus());
			data.put(areaJson);
			ssbi.put("data", data);
			body.put("SVCSENDTOWNINFO", ssbi);
			json.put("body", body);
			arr.put(json);
			pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void senduptBranchScope2Ec(TMdBranchScopeKey branchScope,String actionFlag) {
		// TODO Auto-generated method stub
		try {
			JSONArray arr = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("businessno", "BUSSSENDBRANCHAREA");
			JSONObject body = new JSONObject();
			JSONObject ssbi = new JSONObject();
			ssbi.put("serviceName", "SVCSENDBRANCHAREA");
			JSONArray data = new JSONArray();
			JSONObject bkJson = new JSONObject();
			bkJson.put("customerId", "DH");
			bkJson.put("residential_area_id",branchScope.getResidentialAreaId());
			bkJson.put("branch_no",branchScope.getBranchNo());
			bkJson.put("type", actionFlag);
			data.put(bkJson);
			ssbi.put("data", data);
			body.put("SVCSENDBRANCHAREA", ssbi);
			json.put("body", body);
			arr.put(json);
			pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void sendOrderBranch(TPreOrder order)
	{
		try {
			JSONArray arr = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("businessno", "BUSSSENDORDERBRANCH");
			JSONObject body = new JSONObject();
			JSONObject ssbi = new JSONObject();
			ssbi.put("serviceName", "SVCSENDORDERBRANCH");
			JSONArray data = new JSONArray();

			JSONObject orderStatusReJson = new JSONObject();
			
			orderStatusReJson.put("customerId", "DH");
			orderStatusReJson.put("dhOrderNo", order.getOrderNo());
			orderStatusReJson.put("branchNo", order.getBranchNo());
			orderStatusReJson.put("cusNo",order.getDealerNo());
			data.put(orderStatusReJson);
			ssbi.put("data", data);
			body.put("SVCSENDORDERBRANCH", ssbi);
			json.put("body", body);
			arr.put(json);

			pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void sendReplaceBranch(String orderNo, String branchNo, String type, int qty, BigDecimal amt, String remark) {
		try{
			JSONArray arr = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("businessno", "BUSSSENDORDERREBRANCH");
			JSONObject body = new JSONObject();
			JSONObject ssbi = new JSONObject();
			ssbi.put("serviceName", "SVCSENDORDERREBRANCH");
			JSONArray data = new JSONArray();

			JSONObject resultJson = new JSONObject();
			resultJson.put("customerId", "DH");
			resultJson.put("dhOrderNo", orderNo);
			resultJson.put("branchNo", branchNo);
			resultJson.put("type",type);
			resultJson.put("qty",qty);
			resultJson.put("fee",amt);
			resultJson.put("remark",remark);
			data.put(resultJson);
			ssbi.put("data", data);
			body.put("SVCSENDORDERREBRANCH", ssbi);
			json.put("body", body);
			arr.put(json);
			pushMessage2Ec(EnvContant.getSystemConst("ec_base_url")+EnvContant.getSystemConst("ec_upt_branch"), arr.toString(), true);
		} catch (JSONException e){
			e.printStackTrace();
		}

	}
}
