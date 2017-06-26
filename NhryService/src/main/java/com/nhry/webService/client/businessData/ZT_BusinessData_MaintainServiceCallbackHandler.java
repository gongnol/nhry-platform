/**
 * ZT_BusinessData_MaintainServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */
package com.nhry.webService.client.businessData;


/**
 *  ZT_BusinessData_MaintainServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class ZT_BusinessData_MaintainServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public ZT_BusinessData_MaintainServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public ZT_BusinessData_MaintainServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for deliveryQuery method
     * override this method for handling normal response from deliveryQuery operation
     */
    public void receiveResultdeliveryQuery(
        com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATAResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from deliveryQuery operation
     */
    public void receiveErrordeliveryQuery(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for salesOrderCreate method
     * override this method for handling normal response from salesOrderCreate operation
     */
    public void receiveResultsalesOrderCreate(
        com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from salesOrderCreate operation
     */
    public void receiveErrorsalesOrderCreate(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for requisitionCreate method
     * override this method for handling normal response from requisitionCreate operation
     */
    public void receiveResultrequisitionCreate(
        com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFCResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from requisitionCreate operation
     */
    public void receiveErrorrequisitionCreate(java.lang.Exception e) {
    }
}
