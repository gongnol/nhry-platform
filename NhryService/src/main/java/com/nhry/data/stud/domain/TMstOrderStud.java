package com.nhry.data.stud.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author zhaoxijun
 * @date 2017年4月11日
 */
public class TMstOrderStud implements Serializable, Cloneable{
	private static final long serialVersionUID = 1L;

	private String erpCode;//学校ERP代码
	
	private String orderId;

    private Date orderDate;

    private String schoolCode;
    
    private String schoolName;//

    private String orderStatus;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;

    private String remark;
    
    private String salesOrg;//销售组织
    
    private String orderDateStr;//订单日期（目标日期）
    
    private String takeOrderDateStr;//取数的订单日期
    
    private List<TMstOrderStudItem> list10;//学生奶
    
    private List<TMstOrderStudItem> list20;//老师奶
    
    private List<TMstOrderStudLoss> list30;//损耗
    
    private String list10Sum;
    
    private String list20Sum;
    
    private String list30Sum;
    
    private String list5020Sum;//不分包奶总数
    
    private String list5030Sum;//不分包奶损耗总数
    
    private String matnr;//
    
    private String matnrTxt;//
    
    private String totalSum;//总数(老师奶+学生奶+补损)
    
    private String zbotCode;
    
    private String zbotCodeName;
    
    private String orderType;//10学生，20老师
    
    private String classCode;
    
    private String className;
    
    private String qty;
    
    private String erpOrderId;
    
    private String erpOrderFreeId;
    
    private String erpOrderFillId;
    
    private String erpOrderStatus;
    
    private String erpOrderMsg;
    
    private String isBatch;//10批量，20单独生成的
    
    
    private String erpOrderFreeStatus;
    
    private String erpOrderFreeMsg;
    
    private String erpOrderFillStatus;
    
    private String erpOrderFillMsg;
    
    
   private String erpOrderFreeFillId;
   
   private String erpOrderFreeFillStatus;
   
   private String erpOrderFreeFillMsg;
    
    
    
    
    

    public TMstOrderStud(String schoolCode, String salesOrg, String orderDateStr) {
		super();
		this.schoolCode = schoolCode;
		this.salesOrg = salesOrg;
		this.orderDateStr = orderDateStr;
	}
    
    

	public String getErpOrderFreeFillId() {
		return erpOrderFreeFillId;
	}



	public void setErpOrderFreeFillId(String erpOrderFreeFillId) {
		this.erpOrderFreeFillId = erpOrderFreeFillId;
	}



	public String getErpOrderFreeFillStatus() {
		return erpOrderFreeFillStatus;
	}



	public void setErpOrderFreeFillStatus(String erpOrderFreeFillStatus) {
		this.erpOrderFreeFillStatus = erpOrderFreeFillStatus;
	}



	public String getErpOrderFreeFillMsg() {
		return erpOrderFreeFillMsg;
	}



	public void setErpOrderFreeFillMsg(String erpOrderFreeFillMsg) {
		this.erpOrderFreeFillMsg = erpOrderFreeFillMsg;
	}



	public TMstOrderStud() {
		super();
	}

	public String getErpOrderFillId() {
		return erpOrderFillId;
	}

	public void setErpOrderFillId(String erpOrderFillId) {
		this.erpOrderFillId = erpOrderFillId;
	}

	public String getErpOrderFillStatus() {
		return erpOrderFillStatus;
	}

	public void setErpOrderFillStatus(String erpOrderFillStatus) {
		this.erpOrderFillStatus = erpOrderFillStatus;
	}

	public String getErpOrderFillMsg() {
		return erpOrderFillMsg;
	}

	public void setErpOrderFillMsg(String erpOrderFillMsg) {
		this.erpOrderFillMsg = erpOrderFillMsg;
	}

	public String getErpOrderFreeStatus() {
		return erpOrderFreeStatus;
	}

	public void setErpOrderFreeStatus(String erpOrderFreeStatus) {
		this.erpOrderFreeStatus = erpOrderFreeStatus;
	}

	public String getErpOrderFreeMsg() {
		return erpOrderFreeMsg;
	}

	public void setErpOrderFreeMsg(String erpOrderFreeMsg) {
		this.erpOrderFreeMsg = erpOrderFreeMsg;
	}

	public String getIsBatch() {
		return isBatch;
	}

	public void setIsBatch(String isBatch) {
		this.isBatch = isBatch;
	}


	public String getErpOrderFreeId() {
		return erpOrderFreeId;
	}

	public void setErpOrderFreeId(String erpOrderFreeId) {
		this.erpOrderFreeId = erpOrderFreeId;
	}

	public String getErpOrderId() {
		return erpOrderId;
	}

	public void setErpOrderId(String erpOrderId) {
		this.erpOrderId = erpOrderId;
	}

	public String getErpOrderStatus() {
		return erpOrderStatus;
	}

	public void setErpOrderStatus(String erpOrderStatus) {
		this.erpOrderStatus = erpOrderStatus;
	}

	public String getErpOrderMsg() {
		return erpOrderMsg;
	}

	public void setErpOrderMsg(String erpOrderMsg) {
		this.erpOrderMsg = erpOrderMsg;
	}

	public String getList5020Sum() {
		return list5020Sum;
	}

	public void setList5020Sum(String list5020Sum) {
		this.list5020Sum = list5020Sum;
	}

	public String getList5030Sum() {
		return list5030Sum;
	}

	public void setList5030Sum(String list5030Sum) {
		this.list5030Sum = list5030Sum;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getOrderType() {
		return orderType;
	}

	public String getErpCode() {
		return erpCode;
	}

	public void setErpCode(String erpCode) {
		this.erpCode = erpCode;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getMatnrTxt() {
		return matnrTxt;
	}

	public void setMatnrTxt(String matnrTxt) {
		this.matnrTxt = matnrTxt;
	}

	public String getTotalSum() {
		return null==totalSum?"0":totalSum;
	}

	public void setTotalSum(String totalSum) {
		this.totalSum = totalSum;
	}

	public String getZbotCode() {
		return zbotCode;
	}

	public void setZbotCode(String zbotCode) {
		this.zbotCode = zbotCode;
	}

	public String getZbotCodeName() {
		return zbotCodeName;
	}

	public void setZbotCodeName(String zbotCodeName) {
		this.zbotCodeName = zbotCodeName;
	}

	public String getTakeOrderDateStr() {
		return takeOrderDateStr;
	}

	public void setTakeOrderDateStr(String takeOrderDateStr) {
		this.takeOrderDateStr = takeOrderDateStr;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getList10Sum() {
		return null==list10Sum?"0":list10Sum;
	}

	public void setList10Sum(String list10Sum) {
		this.list10Sum = null==list10Sum?"0":list10Sum;
	}

	public String getList20Sum() {
		return null==list20Sum?"0":list20Sum;
	}

	public void setList20Sum(String list20Sum) {
		this.list20Sum = null==list20Sum?"0":list20Sum;
	}

	public String getList30Sum() {
		return null==list30Sum?"0":list30Sum;
	}

	public void setList30Sum(String list30Sum) {
		this.list30Sum = null==list30Sum?"0":list30Sum;
	}

	public String getMatnr() {
		return matnr;
	}

	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}

	public List<TMstOrderStudItem> getList10() {
		return list10;
	}

	public void setList10(List<TMstOrderStudItem> list10) {
		this.list10 = list10;
	}

	public List<TMstOrderStudItem> getList20() {
		return list20;
	}

	public void setList20(List<TMstOrderStudItem> list20) {
		this.list20 = list20;
	}

	public List<TMstOrderStudLoss> getList30() {
		return list30;
	}

	public void setList30(List<TMstOrderStudLoss> list30) {
		this.list30 = list30;
	}

	public String getOrderDateStr() {
		return orderDateStr;
	}

	public void setOrderDateStr(String orderDateStr) {
		this.orderDateStr = orderDateStr;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getSalesOrg() {
		return salesOrg;
	}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        if(null != orderDate){
        	try {
            	this.orderDateStr = new SimpleDateFormat("yyyy-MM-dd").format(orderDate);
    		} catch (Exception e) {
    			//ignore
    		}
        }
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode == null ? null : schoolCode.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getCreateByTxt() {
        return createByTxt;
    }

    public void setCreateByTxt(String createByTxt) {
        this.createByTxt = createByTxt == null ? null : createByTxt.trim();
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }

    public String getLastModifiedByTxt() {
        return lastModifiedByTxt;
    }

    public void setLastModifiedByTxt(String lastModifiedByTxt) {
        this.lastModifiedByTxt = lastModifiedByTxt == null ? null : lastModifiedByTxt.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
    
}