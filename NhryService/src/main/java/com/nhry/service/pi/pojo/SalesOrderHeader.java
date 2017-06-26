package com.nhry.service.pi.pojo;

import java.util.Date;

/**
 * Created by cbz on 8/15/2016.
 */
public class SalesOrderHeader {
    /**
     * 客户编号
     */
    String KUNNR;
    /**
     * 送达方
     */
    String KUNWE;
    /**
     * 销售组织
     */
    String VKORG;
    /**
     * 客户采购订单编号
     */
    String BSTKD;
    /**
     * 交货日期
     */
    Date LFDAT;
    /**
     * 活动编号
     */
    String activityId;
    /**
     * 库存地点
     */
    String lgort;
    /**
     * 工厂
     */
    String werks;
    /**
     * 订单类型
     */
    String auartType;
    /**
     * 订购原因( 业务原因 )
     */
    String augru;
    /**
     * 备注
     */
    String zz001;
    /**
     * 成本中心
     */
    String kostl;
    /**
     * 线上订单客户编码
     */
    String KUNWE2;
    /**
     * 销售渠道
     */
    String VTWEG;

    public String getVTWEG() {
        return VTWEG;
    }

    public void setVTWEG(String VTWEG) {
        this.VTWEG = VTWEG;
    }

    public String getKUNWE2() {
        return KUNWE2;
    }

    public void setKUNWE2(String KUNWE2) {
        this.KUNWE2 = KUNWE2;
    }

    public String getKUNNR() {
        return KUNNR;
    }

    public void setKUNNR(String KUNNR) {
        this.KUNNR = KUNNR;
    }

    public String getKUNWE() {
        return KUNWE;
    }

    public void setKUNWE(String KUNWE) {
        this.KUNWE = KUNWE;
    }

    public String getVKORG() {
        return VKORG;
    }

    public void setVKORG(String VKORG) {
        this.VKORG = VKORG;
    }

    public String getBSTKD() {
        return BSTKD;
    }

    public void setBSTKD(String BSTKD) {
        this.BSTKD = BSTKD;
    }

    public Date getLFDAT() {
        return LFDAT;
    }

    public void setLFDAT(Date LFDAT) {
        this.LFDAT = LFDAT;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getLgort() {
        return lgort;
    }

    public void setLgort(String lgort) {
        this.lgort = lgort;
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
    }

    public String getAuartType() {
        return auartType;
    }

    public void setAuartType(String auartType) {
        this.auartType = auartType;
    }

    public String getAugru() {
        return augru;
    }

    public void setAugru(String augru) {
        this.augru = augru;
    }

    public String getZz001() {
        return zz001;
    }

    public void setZz001(String zz001) {
        this.zz001 = zz001;
    }

    public String getKostl() {
        return kostl;
    }

    public void setKostl(String kostl) {
        this.kostl = kostl;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("kunner="+ getKUNNR());
        sb.append("&kunwe="+ getKUNWE());
        sb.append("&vkorg="+ getVKORG());
        sb.append("&bstkd="+ getBSTKD());
        sb.append("&lfdat="+ getLFDAT()==null?"":getLFDAT().toString());
        sb.append("&lgort="+ getLgort());
        sb.append("&werks="+getWerks());
        sb.append("&auartType="+getAuartType());
        sb.append("&activityId="+getActivityId());
        sb.append("&Augru"+getAugru());
        sb.append("&zz001"+getZz001());
        sb.append("&kostl"+getKostl());
        return sb.toString();
    }
}
