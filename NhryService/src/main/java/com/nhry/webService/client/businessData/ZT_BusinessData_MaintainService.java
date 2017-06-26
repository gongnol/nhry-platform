/**
 * ZT_BusinessData_MaintainService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */
package com.nhry.webService.client.businessData;


/*
 *  ZT_BusinessData_MaintainService java interface
 */
public interface ZT_BusinessData_MaintainService {
    /**
     * Auto generated method signature
     *
     * @param zSD_DELIVERY_DATA0
     */
    public com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATAResponse deliveryQuery(
        com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATA zSD_DELIVERY_DATA0)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param zSD_DELIVERY_DATA0
     */
    public void startdeliveryQuery(
        com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATA zSD_DELIVERY_DATA0,
        final com.nhry.webService.client.businessData.ZT_BusinessData_MaintainServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param zSD_SALESORDER_DATA_RFC_22
     */
    public com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2Response salesOrderCreate(
        com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2 zSD_SALESORDER_DATA_RFC_22)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param zSD_SALESORDER_DATA_RFC_22
     */
    public void startsalesOrderCreate(
        com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2 zSD_SALESORDER_DATA_RFC_22,
        final com.nhry.webService.client.businessData.ZT_BusinessData_MaintainServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param zSD_REQUISITION_CREATE_RFC4
     */
    public com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFCResponse requisitionCreate(
        com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFC zSD_REQUISITION_CREATE_RFC4)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param zSD_REQUISITION_CREATE_RFC4
     */
    public void startrequisitionCreate(
        com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFC zSD_REQUISITION_CREATE_RFC4,
        final com.nhry.webService.client.businessData.ZT_BusinessData_MaintainServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    //
}
