/**
 * OA_MasterData_OutServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.Supplier;


/**
 *  OA_MasterData_OutServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class OA_MasterData_OutServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public OA_MasterData_OutServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public OA_MasterData_OutServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for zMM_MC_ET_LIFNR method
     * override this method for handling normal response from zMM_MC_ET_LIFNR operation
     */
    public void receiveResultzMM_MC_ET_LIFNR(
        com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNRResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from zMM_MC_ET_LIFNR operation
     */
    public void receiveErrorzMM_MC_ET_LIFNR(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for zOA_LIFNR_KNBA method
     * override this method for handling normal response from zOA_LIFNR_KNBA operation
     */
    public void receiveResultzOA_LIFNR_KNBA(
        com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBAResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from zOA_LIFNR_KNBA operation
     */
    public void receiveErrorzOA_LIFNR_KNBA(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for zOA_FUN_BUKRS method
     * override this method for handling normal response from zOA_FUN_BUKRS operation
     */
    public void receiveResultzOA_FUN_BUKRS(
        com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRSResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from zOA_FUN_BUKRS operation
     */
    public void receiveErrorzOA_FUN_BUKRS(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for zOA_AUFK_DATA method
     * override this method for handling normal response from zOA_AUFK_DATA operation
     */
    public void receiveResultzOA_AUFK_DATA(
        com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATAResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from zOA_AUFK_DATA operation
     */
    public void receiveErrorzOA_AUFK_DATA(java.lang.Exception e) {
    }
}
