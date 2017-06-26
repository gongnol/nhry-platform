/**
 * MemberAddrUpdateService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.Address;


/*
 *  MemberAddrUpdateService java interface
 */
public interface MemberAddrUpdateService {
    /**
     * Auto generated method signature
     *
     * @param z_CRM_ADDR_UPDATE0
     */
    public com.nhry.webService.client.Address.functions.Z_CRM_ADDR_UPDATEResponse memberAddrUpdate(
            com.nhry.webService.client.Address.functions.Z_CRM_ADDR_UPDATE z_CRM_ADDR_UPDATE0)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param z_CRM_ADDR_UPDATE0
     */
    public void startmemberAddrUpdate(
            com.nhry.webService.client.Address.functions.Z_CRM_ADDR_UPDATE z_CRM_ADDR_UPDATE0,
            final MemberAddrUpdateServiceCallbackHandler callback)
        throws java.rmi.RemoteException;

    //
}
