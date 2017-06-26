/**
 * ZT_CRM_BuData_MaintainService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.VipInfoData;


/*
 *  ZT_CRM_BuData_MaintainService java interface
 */
public interface ZT_CRM_BuData_MaintainService {
    /**
     * Auto generated method signature
     *
     * @param z_CRM_MEMB_MSTDATA_UPD_DH0
     */
    public com.nhry.webService.client.VipInfoData.functions.Z_CRM_MEMB_MSTDATA_UPD_DHResponse memberCreate(
            com.nhry.webService.client.VipInfoData.functions.Z_CRM_MEMB_MSTDATA_UPD_DH z_CRM_MEMB_MSTDATA_UPD_DH0)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param z_CRM_MEMB_MSTDATA_UPD_DH0
     */
    public void startmemberCreate(
            com.nhry.webService.client.VipInfoData.functions.Z_CRM_MEMB_MSTDATA_UPD_DH z_CRM_MEMB_MSTDATA_UPD_DH0,
            final ZT_CRM_BuData_MaintainServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param z_CRM_SNG_TS2
     */
    public com.nhry.webService.client.VipInfoData.functions.Z_CRM_SNG_TSResponse customerComplain(
            com.nhry.webService.client.VipInfoData.functions.Z_CRM_SNG_TS z_CRM_SNG_TS2)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param z_CRM_SNG_TS2
     */
    public void startcustomerComplain(
            com.nhry.webService.client.VipInfoData.functions.Z_CRM_SNG_TS z_CRM_SNG_TS2,
            final ZT_CRM_BuData_MaintainServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param z_CRM_CREATE_REBATE_BY_TRADE4
     */
    public com.nhry.webService.client.VipInfoData.functions.Z_CRM_CREATE_REBATE_BY_TRADEResponse createRebateByTrade(
            com.nhry.webService.client.VipInfoData.functions.Z_CRM_CREATE_REBATE_BY_TRADE z_CRM_CREATE_REBATE_BY_TRADE4)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param z_CRM_CREATE_REBATE_BY_TRADE4
     */
    public void startcreateRebateByTrade(
            com.nhry.webService.client.VipInfoData.functions.Z_CRM_CREATE_REBATE_BY_TRADE z_CRM_CREATE_REBATE_BY_TRADE4,
            final ZT_CRM_BuData_MaintainServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param z_CRM_MEMB_ZTAB0000LQ_UPDATE6
     */
    public com.nhry.webService.client.VipInfoData.functions.Z_CRM_MEMB_ZTAB0000LQ_UPDATEResponse subscriberMaintain(
            com.nhry.webService.client.VipInfoData.functions.Z_CRM_MEMB_ZTAB0000LQ_UPDATE z_CRM_MEMB_ZTAB0000LQ_UPDATE6)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param z_CRM_MEMB_ZTAB0000LQ_UPDATE6
     */
    public void startsubscriberMaintain(
            com.nhry.webService.client.VipInfoData.functions.Z_CRM_MEMB_ZTAB0000LQ_UPDATE z_CRM_MEMB_ZTAB0000LQ_UPDATE6,
            final ZT_CRM_BuData_MaintainServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    //
}
