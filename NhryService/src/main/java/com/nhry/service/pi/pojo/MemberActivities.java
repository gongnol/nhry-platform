
package com.nhry.service.pi.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class MemberActivities {
    /**
     * 会员活动类别
     *
     * 消费引起的积分获得 ACCRUAL
     *
     * 促销类的订单 CATEGORY
     *
     * 退货 YRETURN
     */
    protected String category;
    /**
     * PROCESS_TYPE
     *
     ** 消费引起的积分获得 YSUB_ACCRUAL
     *
     * 促销类的订单 YSUB_PROMOTION
     *
     * 退货 YSUB_RETURN
     */

    protected String processtype;
    /**
     *会员GUID
     */
    protected String membershipguid;
    /**
     * 销售组织
     */
    protected String salesorg;
    /**
     * 会员卡号可为空
     */
    protected String cardid;
    /**
     * 时间戳(日期+时间)
     */
    protected Date activitydate;
    /**
     * 消费金额
     */
    protected BigDecimal amount;
    /**
     * 积分类型 可为空
     *
     *YFRESH
     *YGROWTH
     *
     */
    protected String pointtype;
    /**
     * 积分数 可为空
     */
    protected BigDecimal points;
    /**
     * 货币可为空
     */
    protected String currency;
    /**
     * ORDER_ID
     */
    protected String orderid;
    /**
     * 行项目编号
     */
    protected String itemnum;
    /**
     * 产品ID
     */
    protected String productid;
    /**
     * 产品数量
     */
    protected BigDecimal productquantity;
    /**
     * 零售店编号 奶站
     */
    protected String retailstoreid;
    /**
     * 交易顺序号 可为空
     */
    protected String transeqnum;
    /**
     *可为空
     */
    protected String tiergroup;
    /**
     * 可为空
     */
    protected String tier;
    /**
     * 立即提交   传  X
     */
    protected String commit;
    /**
     * 立即提交   传  X
     */
    protected String process;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProcesstype() {
        return processtype;
    }

    public void setProcesstype(String processtype) {
        this.processtype = processtype;
    }

    public String getMembershipguid() {
        return membershipguid;
    }

    public void setMembershipguid(String membershipguid) {
        this.membershipguid = membershipguid;
    }

    public String getSalesorg() {
        return salesorg;
    }

    public void setSalesorg(String salesorg) {
        this.salesorg = salesorg;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public Date getActivitydate() {
        return activitydate;
    }

    public void setActivitydate(Date activitydate) {
        this.activitydate = activitydate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPointtype() {
        return pointtype;
    }

    public void setPointtype(String pointtype) {
        this.pointtype = pointtype;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public BigDecimal getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(BigDecimal productquantity) {
        this.productquantity = productquantity;
    }

    public String getRetailstoreid() {
        return retailstoreid;
    }

    public void setRetailstoreid(String retailstoreid) {
        this.retailstoreid = retailstoreid;
    }

    public String getTranseqnum() {
        return transeqnum;
    }

    public void setTranseqnum(String transeqnum) {
        this.transeqnum = transeqnum;
    }

    public String getTiergroup() {
        return tiergroup;
    }

    public void setTiergroup(String tiergroup) {
        this.tiergroup = tiergroup;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
