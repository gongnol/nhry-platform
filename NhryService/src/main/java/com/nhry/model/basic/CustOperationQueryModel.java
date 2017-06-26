package com.nhry.model.basic;

/**
 * Created by gongjk on 2016/10/24.
 */
public class CustOperationQueryModel extends BaseQueryModel {
    private String search;
    private String branchNo;
    private String dateStart;
    private String dateEnd;
    private String dispDate;

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDispDate() {
        return dispDate;
    }

    public void setDispDate(String dispDate) {
        this.dispDate = dispDate;
    }
}
