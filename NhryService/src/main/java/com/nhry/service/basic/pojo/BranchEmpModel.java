package com.nhry.service.basic.pojo;

import com.nhry.data.basic.domain.TMdBranchEmp;

import java.util.List;

/**
 * Created by gongjk on 2016/6/20.
 */
public class BranchEmpModel {
   private TMdBranchEmp emp;
    private List routes;

    public TMdBranchEmp getEmp() {
        return emp;
    }

    public void setEmp(TMdBranchEmp emp) {
        this.emp = emp;
    }

    public List getRoutes() {
        return routes;
    }

    public void setRoutes(List routes) {
        this.routes = routes;
    }
}
