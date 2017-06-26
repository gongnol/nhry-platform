package com.nhry.data.auth.dao;

import com.nhry.data.auth.domain.TSysOrgs;

public interface TSysOrgsMapper {
    int delSysOrgByOrgId(String orgId);

    int addSysOrgs(TSysOrgs record);

    TSysOrgs findSysOrgById(String orgId);

    int uptSysOrg(TSysOrgs record);

}