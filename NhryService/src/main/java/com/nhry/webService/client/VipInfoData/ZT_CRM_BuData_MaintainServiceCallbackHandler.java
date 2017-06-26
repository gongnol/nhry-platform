/**
 * ZT_CRM_BuData_MaintainServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.VipInfoData;


/**
 *  ZT_CRM_BuData_MaintainServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class ZT_CRM_BuData_MaintainServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public ZT_CRM_BuData_MaintainServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public ZT_CRM_BuData_MaintainServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for memberCreate method
     * override this method for handling normal response from memberCreate operation
     */
    public void receiveResultmemberCreate(
        com.nhry.webService.client.VipInfoData.functions.Z_CRM_MEMB_MSTDATA_UPD_DHResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from memberCreate operation
     */
    public void receiveErrormemberCreate(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for customerComplain method
     * override this method for handling normal response from customerComplain operation
     */
    public void receiveResultcustomerComplain(
        com.nhry.webService.client.VipInfoData.functions.Z_CRM_SNG_TSResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from customerComplain operation
     */
    public void receiveErrorcustomerComplain(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for createRebateByTrade method
     * override this method for handling normal response from createRebateByTrade operation
     */
    public void receiveResultcreateRebateByTrade(
        com.nhry.webService.client.VipInfoData.functions.Z_CRM_CREATE_REBATE_BY_TRADEResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from createRebateByTrade operation
     */
    public void receiveErrorcreateRebateByTrade(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for subscriberMaintain method
     * override this method for handling normal response from subscriberMaintain operation
     */
    public void receiveResultsubscriberMaintain(
        com.nhry.webService.client.VipInfoData.functions.Z_CRM_MEMB_ZTAB0000LQ_UPDATEResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from subscriberMaintain operation
     */
    public void receiveErrorsubscriberMaintain(Exception e) {
    }
}
