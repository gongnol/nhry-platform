/**
 * MemberActCreateBatService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.MemberActivitiesBat;


/*
 *  MemberActCreateBatService java interface
 */
public interface MemberActCreateBatService {
    /**
     * Auto generated method signature
     *
     * @param z_CRM_MEMB_ACTIVITIES_CREATE_T0
     */
    public com.nhry.webService.client.MemberActivitiesBat.functions.Z_CRM_MEMB_ACTIVITIES_CREATE_TResponse memberActCreateBat(
            com.nhry.webService.client.MemberActivitiesBat.functions.Z_CRM_MEMB_ACTIVITIES_CREATE_T z_CRM_MEMB_ACTIVITIES_CREATE_T0)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param z_CRM_MEMB_ACTIVITIES_CREATE_T0
     */
    public void startmemberActCreateBat(
            com.nhry.webService.client.MemberActivitiesBat.functions.Z_CRM_MEMB_ACTIVITIES_CREATE_T z_CRM_MEMB_ACTIVITIES_CREATE_T0,
            final com.nhry.webService.client.MemberActivitiesBat.MemberActCreateBatServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    //
}
