package com.nhry.service.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.orderorg.dao.TMdOrderOrgMapper;
import com.nhry.data.orderorg.dao.TMdOrgCustMapper;
import com.nhry.data.orderorg.domain.TMdOrderOrg;
import com.nhry.data.orderorg.domain.TMdOrgCust;
import com.nhry.data.orderorg.domain.TMdOrgCustKey;
import com.nhry.model.basic.OrderOrgModel;
import com.nhry.service.basic.dao.OrderOrgService;
import com.nhry.utils.CodeGeneratorUtil;
import com.nhry.utils.date.Date;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by huaguan on 2016/12/1.
 */
public class OrderOrgServiceImpl implements OrderOrgService {
    private TMdOrderOrgMapper orderOrgMapper;
    private TMdOrgCustMapper  orgCustMapper;

    public void setOrgCustMapper(TMdOrgCustMapper orgCustMapper) {
        this.orgCustMapper = orgCustMapper;
    }

    private UserSessionService userSessionService;

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    public void setOrderOrgMapper(TMdOrderOrgMapper orderOrgMapper) {
        this.orderOrgMapper = orderOrgMapper;
    }

    @Override
    public int deleteOrderOrgByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insertOrderOrg(TMdOrderOrg orderOrg) {
        TSysUser user = userSessionService.getCurrentUser();
        if(orderOrg!=null){
            orderOrg.setId(CodeGeneratorUtil.getCode());
            orderOrg.setSalesOrg(user.getSalesOrg());
            orderOrg.setCreateAt(new Date());
            orderOrg.setCreateBy(user.getLoginName());
            orderOrg.setCreateByTxt(user.getDisplayName());
        }else{
            throw new ServiceException(MessageCode.LOGIC_ERROR,"新增机构信息错误，为空不能插入");
        }
        return orderOrgMapper.insertOrderOrg(orderOrg);
    }

    @Override
    public int insertOrderOrgSelective(OrderOrgModel record) {
        return 0;
    }

    @Override
    public TMdOrderOrg selectOrderOrgByPrimaryKey(String id) {
        return orderOrgMapper.selectOrderOrgByPrimaryKey(id);
    }

    @Override
    public int updateOrderOrgByPrimaryKeySelective(OrderOrgModel record) {
        TSysUser user = userSessionService.getCurrentUser();
        TMdOrderOrg orderOrg = new TMdOrderOrg();
        if(record!=null){
            orderOrg.setId(record.getId());
            if(record.getTel()!=null){orderOrg.setTel(record.getTel());}
            if(record.getOrgName()!=null){orderOrg.setOrgName(record.getOrgName());}
            if(record.getMp()!=null){orderOrg.setMp(record.getMp());}
            if(record.getContact()!=null){orderOrg.setContact(record.getContact());}
            if(record.getAddress()!=null){orderOrg.setAddress(record.getAddress());}
            if(record.getOrgCode()!=null){orderOrg.setOrgCode(record.getOrgCode());}
            orderOrg.setLastModified(new Date());
            orderOrg.setLastModifiedBy(user.getLoginName());
            orderOrg.setLastModifiedByTxt(user.getDisplayName());
        }
        return orderOrgMapper.updateOrderOrgByPrimaryKeySelective(orderOrg);
    }

    @Override
    public int updateOrderOrgByPrimaryKey(OrderOrgModel record) {
        return 0;
    }

    @Override
    public PageInfo findTMdOrderOrgList(OrderOrgModel record) {
        TSysUser user = userSessionService.getCurrentUser();
        record.setSalesOrg(user.getSalesOrg());
        return orderOrgMapper.findTMdOrderOrgList(record);
    }

    /**
     * 根据销售组织查询机构名称
     * @return
     */
    @Override
    public List<TMdOrderOrg> findOrderOrgListForSelect() {
        TSysUser user = userSessionService.getCurrentUser();
        return orderOrgMapper.findOrderOrgListForSelect(user.getSalesOrg());
    }
//机构订户关系表开始-----

    /**
     * 清除机构订户关联关系
     * @param key
     * @return
     */
    @Override
    public int deleteByPrimaryKey(TMdOrgCustKey key) {
        return orgCustMapper.deleteByPrimaryKey(key);
    }

    /**
     * 新增机构订户关系
     * @param orgCust
     * @return
     */
    @Override
    public int insertOrgCust(TMdOrgCustKey orgCust) {
        TSysUser user = userSessionService.getCurrentUser();
        //判断如果该订户下存在某机构下，则不允许条件到其他机构上
        if(orgCust!=null){
            TMdOrderOrg orderOrg = orderOrgMapper.selectOrgByCustId(orgCust.getOrgId());
            if(orderOrg!=null){
                throw new ServiceException(MessageCode.LOGIC_ERROR,"该订户已经在机构："+orderOrg.getOrgName()+"下，不能进行关联");
            }
        }
        TMdOrgCust record = new TMdOrgCust();
        if(orgCust!=null){
            record.setOrgId(orgCust.getOrgId());
            record.setCustId(orgCust.getCustId());
            record.setCreateAt(new Date());
            record.setCreateBy(user.getLoginName());
            record.setCreateByTxt(user.getDisplayName());
        }else{
            throw new ServiceException(MessageCode.LOGIC_ERROR,"建立机构订户关联关系出错，机构订户关联关系为空不能创建");
        }
        return orgCustMapper.insert(record);
    }

    /**
     * 根据机构ID查询改机构下关联的订户ID
     * @param orgId
     * @return
     */
    @Override
    public List<TMdOrgCust> findTMdOrgCustList(String orgId) {
        return orgCustMapper.findTMdOrgCustList(orgId);
    }

    @Override
    public TMdOrderOrg findTMdOrderOrgByOrgCode(String orgCode) {
        OrderOrgModel record = new OrderOrgModel();
        TSysUser user = userSessionService.getCurrentUser();
        record.setOrgCode(orgCode);
        record.setSalesOrg(user.getSalesOrg());
        return orderOrgMapper.findTMdOrderOrgByOrgCode(record);
    }
}
