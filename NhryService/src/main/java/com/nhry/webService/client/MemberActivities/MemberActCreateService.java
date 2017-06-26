/**
 * MemberActCreateService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.MemberActivities;


/*
 *  MemberActCreateService java interface
 */
public interface MemberActCreateService {
    /**
     * Auto generated method signature
     *
     * @param z_CRM_MEMB_ACTIVITIES_CREATE0
     */
    public com.nhry.webService.client.MemberActivities.functions.Z_CRM_MEMB_ACTIVITIES_CREATEResponse memberActCreate(
            com.nhry.webService.client.MemberActivities.functions.Z_CRM_MEMB_ACTIVITIES_CREATE z_CRM_MEMB_ACTIVITIES_CREATE0)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param z_CRM_MEMB_ACTIVITIES_CREATE0
     */
    public void startmemberActCreate(
            com.nhry.webService.client.MemberActivities.functions.Z_CRM_MEMB_ACTIVITIES_CREATE z_CRM_MEMB_ACTIVITIES_CREATE0,
            final MemberActCreateServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    //
}
