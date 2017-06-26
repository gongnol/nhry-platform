package com.nhry.data.auth.domain;

public class TSysOrgs {
    private String orgId;

    private String smartParentid;

    private String smartShortname;

    private Integer customizedOrglevel;

    private String smartType;

    private String departmentName;

    private String customizedVparentid;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getSmartParentid() {
        return smartParentid;
    }

    public void setSmartParentid(String smartParentid) {
        this.smartParentid = smartParentid == null ? null : smartParentid.trim();
    }

    public String getSmartShortname() {
        return smartShortname;
    }

    public void setSmartShortname(String smartShortname) {
        this.smartShortname = smartShortname == null ? null : smartShortname.trim();
    }

    public Integer getCustomizedOrglevel() {
        return customizedOrglevel;
    }

    public void setCustomizedOrglevel(Integer customizedOrglevel) {
        this.customizedOrglevel = customizedOrglevel;
    }

    public String getSmartType() {
        return smartType;
    }

    public void setSmartType(String smartType) {
        this.smartType = smartType == null ? null : smartType.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getCustomizedVparentid() {
        return customizedVparentid;
    }

    public void setCustomizedVparentid(String customizedVparentid) {
        this.customizedVparentid = customizedVparentid == null ? null : customizedVparentid.trim();
    }
}