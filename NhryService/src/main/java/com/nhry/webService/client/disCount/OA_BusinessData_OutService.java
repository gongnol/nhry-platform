/**
 * OA_BusinessData_OutService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.disCount;


/*
 *  OA_BusinessData_OutService java interface
 */
public interface OA_BusinessData_OutService {
    /**
     * Auto generated method signature
     *
     * @param zSD_SALESORDER_DATA_RFC_50
     */
    public com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5Response zSD_SALESORDER_DATA_RFC_5(
            com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5 zSD_SALESORDER_DATA_RFC_50)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param zSD_SALESORDER_DATA_RFC_50
     */
    public void startzSD_SALESORDER_DATA_RFC_5(
            com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5 zSD_SALESORDER_DATA_RFC_50,
            final com.nhry.webService.client.disCount.OA_BusinessData_OutServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param zOA_ACC_DOCUMENT_REV_POST2
     */
    public com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POSTResponse zOA_ACC_DOCUMENT_REV_POST(
            com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POST zOA_ACC_DOCUMENT_REV_POST2)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param zOA_ACC_DOCUMENT_REV_POST2
     */
    public void startzOA_ACC_DOCUMENT_REV_POST(
            com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POST zOA_ACC_DOCUMENT_REV_POST2,
            final com.nhry.webService.client.disCount.OA_BusinessData_OutServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    //
}
