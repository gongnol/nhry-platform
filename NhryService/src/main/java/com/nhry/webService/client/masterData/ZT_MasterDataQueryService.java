/**
 * ZT_MasterDataQueryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.masterData;


/*
 *  ZT_MasterDataQueryService java interface
 */
public interface ZT_MasterDataQueryService {
    /**
     * Auto generated method signature
     *
     * @param zSD_CUSTOMER_DATA_SYN_RFC0
     */
    public com.nhry.webService.client.masterData.functions.ZSD_CUSTOMER_DATA_SYN_RFCResponse customerQuery(
        com.nhry.webService.client.masterData.functions.ZSD_CUSTOMER_DATA_SYN_RFC zSD_CUSTOMER_DATA_SYN_RFC0)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param zSD_CUSTOMER_DATA_SYN_RFC0
     */
    public void startcustomerQuery(
        com.nhry.webService.client.masterData.functions.ZSD_CUSTOMER_DATA_SYN_RFC zSD_CUSTOMER_DATA_SYN_RFC0,
        final com.nhry.webService.client.masterData.ZT_MasterDataQueryServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param zMM_POS_24DATA2
     */
    public com.nhry.webService.client.masterData.functions.ZMM_POS_24DATAResponse matWHWQuery(
        com.nhry.webService.client.masterData.functions.ZMM_POS_24DATA zMM_POS_24DATA2)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param zMM_POS_24DATA2
     */
    public void startmatWHWQuery(
        com.nhry.webService.client.masterData.functions.ZMM_POS_24DATA zMM_POS_24DATA2,
        final com.nhry.webService.client.masterData.ZT_MasterDataQueryServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param zSD_T005_DATA4
     */
    public com.nhry.webService.client.masterData.functions.ZSD_T005_DATAResponse codeQuery(
        com.nhry.webService.client.masterData.functions.ZSD_T005_DATA zSD_T005_DATA4)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param zSD_T005_DATA4
     */
    public void startcodeQuery(
        com.nhry.webService.client.masterData.functions.ZSD_T005_DATA zSD_T005_DATA4,
        final com.nhry.webService.client.masterData.ZT_MasterDataQueryServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param zSD_MATERAIL_DATA_RFC6
     */
    public com.nhry.webService.client.masterData.functions.ZSD_MATERAIL_DATA_RFCResponse mATQUERY(
        com.nhry.webService.client.masterData.functions.ZSD_MATERAIL_DATA_RFC zSD_MATERAIL_DATA_RFC6)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param zSD_MATERAIL_DATA_RFC6
     */
    public void startmATQUERY(
        com.nhry.webService.client.masterData.functions.ZSD_MATERAIL_DATA_RFC zSD_MATERAIL_DATA_RFC6,
        final com.nhry.webService.client.masterData.ZT_MasterDataQueryServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param zSD_SALES_ORGANIZATION_RFC8
     */
    public com.nhry.webService.client.masterData.functions.ZSD_SALES_ORGANIZATION_RFCResponse salesQuery(
        com.nhry.webService.client.masterData.functions.ZSD_SALES_ORGANIZATION_RFC zSD_SALES_ORGANIZATION_RFC8)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param zSD_SALES_ORGANIZATION_RFC8
     */
    public void startsalesQuery(
        com.nhry.webService.client.masterData.functions.ZSD_SALES_ORGANIZATION_RFC zSD_SALES_ORGANIZATION_RFC8,
        final com.nhry.webService.client.masterData.ZT_MasterDataQueryServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    //
}
