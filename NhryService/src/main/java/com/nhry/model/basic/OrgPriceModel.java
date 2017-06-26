package com.nhry.model.basic;

import com.wordnik.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huaguan on 2017/4/26.
 */
@ApiModel(value = "OrgPriceModel", description = "机构价格信息查询对象")
public class OrgPriceModel extends BaseQueryModel implements Serializable {
    private String orgId;
    private String status;//状态
    private String isShow;//是否显示
    private String salesOrg;
    private String matnr;
    private String search;
    private Date orderDate;
    private Date startDate;
    private Date endDate;

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

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
}
