/**
 * PointQuery_OutService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.VipPoint;


/*
 *  PointQuery_OutService java interface
 */
public interface PointQuery_OutService {
    /**
     * Auto generated method signature
     *
     * @param z_CRM_PT_QUERY_RFC0
     */
    public com.nhry.webService.client.VipPoint.functions.Z_CRM_PT_QUERY_RFCResponse pointQuery_Out(
            com.nhry.webService.client.VipPoint.functions.Z_CRM_PT_QUERY_RFC z_CRM_PT_QUERY_RFC0)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param z_CRM_PT_QUERY_RFC0
     */
    public void startpointQuery_Out(
            com.nhry.webService.client.VipPoint.functions.Z_CRM_PT_QUERY_RFC z_CRM_PT_QUERY_RFC0,
            final PointQuery_OutServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    //
}
