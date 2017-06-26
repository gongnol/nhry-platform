package com.nhry.service.basic.dao;


import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdResidentialArea;
import com.nhry.model.basic.BranchAreaSearch;
import com.nhry.service.basic.pojo.AreaSearchModel;
import com.nhry.service.basic.pojo.BranchScopeModel;
import com.nhry.service.basic.pojo.ResidentialAreaModel;

import java.util.List;

/**
 * Created by gongjk on 2016/6/3.
 */
public interface ResidentialAreaService {
    public List<TMdResidentialArea> getAreaByBranchNo(String branchNo);

    public TMdResidentialArea selectById(String id);

    public PageInfo findAreaListByPage(ResidentialAreaModel residentialAreaModel);

    int  addResidentialArea(TMdResidentialArea area);

    int addResidentialAreas(List<TMdResidentialArea> area);

    int  uptResidentialArea(TMdResidentialArea area);

    int deleteAreaById(String id);

    public PageInfo searchAreaByBranchNo(BranchAreaSearch bsearch);

    public int areaRelBranch(BranchScopeModel rmodel);

    List<TMdResidentialArea> getUnDistAreas();

    List<TMdResidentialArea>  searchAreaBySalesOrg( AreaSearchModel aModel);

    List<TMdResidentialArea>  searchSalesOrgArea(AreaSearchModel aModel);

    List<TMdResidentialArea> searchAreaSaleOrgBranchNo (AreaSearchModel aModel);
}
