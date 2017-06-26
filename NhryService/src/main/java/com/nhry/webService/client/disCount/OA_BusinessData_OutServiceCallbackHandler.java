/**
 * OA_BusinessData_OutServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.disCount;


/**
 *  OA_BusinessData_OutServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class OA_BusinessData_OutServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public OA_BusinessData_OutServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public OA_BusinessData_OutServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for zSD_SALESORDER_DATA_RFC_5 method
     * override this method for handling normal response from zSD_SALESORDER_DATA_RFC_5 operation
     */
    public void receiveResultzSD_SALESORDER_DATA_RFC_5(
        com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from zSD_SALESORDER_DATA_RFC_5 operation
     */
    public void receiveErrorzSD_SALESORDER_DATA_RFC_5(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for zOA_ACC_DOCUMENT_REV_POST method
     * override this method for handling normal response from zOA_ACC_DOCUMENT_REV_POST operation
     */
    public void receiveResultzOA_ACC_DOCUMENT_REV_POST(
        com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POSTResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from zOA_ACC_DOCUMENT_REV_POST operation
     */
    public void receiveErrorzOA_ACC_DOCUMENT_REV_POST(Exception e) {
    }
}
