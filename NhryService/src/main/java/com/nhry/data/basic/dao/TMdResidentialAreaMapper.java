package com.nhry.data.basic.dao;


import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdResidentialArea;
import com.nhry.model.basic.BranchAreaSearch;
import com.nhry.service.basic.pojo.AreaSearchModel;
import com.nhry.service.basic.pojo.ResidentialAreaModel;

import java.util.List;

public interface TMdResidentialAreaMapper {
    public  TMdResidentialArea selectById(String id);

    int updateByPrimaryKeySelective(TMdResidentialArea record);

    int updateByPrimaryKey(TMdResidentialArea record);

    public List<TMdResidentialArea> getAreaByBranchNo(String branchNo) ;

    public PageInfo findAreaListByPage(ResidentialAreaModel residentialAreaModel);

    public  int addResidentialArea(TMdResidentialArea tMdResidentialArea);

    int uptResidentialArea(TMdResidentialArea tMdResidentialArea);

    int deleteAreaById(String id);

    PageInfo searchAreaByBranchNo(BranchAreaSearch bSearch);

    int updateStatusToUnDistById(String residentialAreaId);

    TMdResidentialArea getAreaById(String id);

    int updateStatusToDistedById(String id);

    /**
     * 获取销售组织下的未分配的配送区域
     * @param salesOrg
     * @return
     */
    List<TMdResidentialArea> getUnDistAreas(String salesOrg);

    List<TMdResidentialArea> searchAreaBySalesOrg(AreaSearchModel aModel);

    List<TMdResidentialArea> getAreaByAreaName(String residentialAreaTxt,String salesOrg);

    List<TMdResidentialArea> searchAreaSaleOrgBranchNo(AreaSearchModel aModel);
}