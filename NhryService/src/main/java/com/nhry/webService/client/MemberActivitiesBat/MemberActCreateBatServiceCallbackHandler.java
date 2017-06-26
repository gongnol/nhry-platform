/**
 * MemberActCreateBatServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.MemberActivitiesBat;


/**
 *  MemberActCreateBatServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class MemberActCreateBatServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public MemberActCreateBatServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public MemberActCreateBatServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for memberActCreateBat method
     * override this method for handling normal response from memberActCreateBat operation
     */
    public void receiveResultmemberActCreateBat(
        com.nhry.webService.client.MemberActivitiesBat.functions.Z_CRM_MEMB_ACTIVITIES_CREATE_TResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from memberActCreateBat operation
     */
    public void receiveErrormemberActCreateBat(Exception e) {
    }
}
