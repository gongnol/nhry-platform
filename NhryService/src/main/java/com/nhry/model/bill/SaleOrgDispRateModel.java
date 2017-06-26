package com.nhry.model.bill;

import java.util.List;

/**
 * Created by gongjk on 2016/7/4.
 */
public class SaleOrgDispRateModel {
    private String salesOrg;
    private String salesOrgName;
    private String salaryMet;
    List<DispNumEntry> dispNumEntries;
    List<DispProductEntry> dispProductEntries;

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getSalesOrgName() {
        return salesOrgName;
    }

    public void setSalesOrgName(String salesOrgName) {
        this.salesOrgName = salesOrgName;
    }

    public String getSalaryMet() {
        return salaryMet;
    }

    public void setSalaryMet(String salaryMet) {
        this.salaryMet = salaryMet;
    }

    public List<DispNumEntry> getDispNumEntries() {
        return dispNumEntries;
    }

    public void setDispNumEntries(List<DispNumEntry> dispNumEntries) {
        this.dispNumEntries = dispNumEntries;
    }

    public List<DispProductEntry> getDispProductEntries() {
        return dispProductEntries;
    }

    public void setDispProductEntries(List<DispProductEntry> dispProductEntries) {
        this.dispProductEntries = dispProductEntries;
    }
}
