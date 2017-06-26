package com.nhry.data.basic.domain;

import java.util.Date;

public class TMdBranchEx {
    private String branchNo;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;

    private String compCode;

    private String docType;

    private String purchOrg;

    private String purchGroup;

    private String supplPlnt;

    private String reslo;

    private String kostl;

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo == null ? null : branchNo.trim();
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

    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode == null ? null : compCode.trim();
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType == null ? null : docType.trim();
    }

    public String getPurchOrg() {
        return purchOrg;
    }

    public void setPurchOrg(String purchOrg) {
        this.purchOrg = purchOrg == null ? null : purchOrg.trim();
    }

    public String getPurchGroup() {
        return purchGroup;
    }

    public void setPurchGroup(String purchGroup) {
        this.purchGroup = purchGroup == null ? null : purchGroup.trim();
    }

    public String getSupplPlnt() {
        return supplPlnt;
    }

    public void setSupplPlnt(String supplPlnt) {
        this.supplPlnt = supplPlnt == null ? null : supplPlnt.trim();
    }

    public String getReslo() {
        return reslo;
    }

    public void setReslo(String reslo) {
        this.reslo = reslo;
    }

    public String getKostl() {
        return kostl;
    }

    public void setKostl(String kostl) {
        this.kostl = kostl;
    }
}