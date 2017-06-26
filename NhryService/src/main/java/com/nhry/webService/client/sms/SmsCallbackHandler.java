/**
 * SmsCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.sms;


/**
 *  SmsCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class SmsCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public SmsCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public SmsCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for reply method
     * override this method for handling normal response from reply operation
     */
    public void receiveResultreply(
        com.nhry.webService.client.sms.functions.ReplyResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from reply operation
     */
    public void receiveErrorreply(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sms method
     * override this method for handling normal response from sms operation
     */
    public void receiveResultsms(
        com.nhry.webService.client.sms.functions.SmsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sms operation
     */
    public void receiveErrorsms(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for replyConfirm method
     * override this method for handling normal response from replyConfirm operation
     */
    public void receiveResultreplyConfirm(
        com.nhry.webService.client.sms.functions.ReplyConfirmResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from replyConfirm operation
     */
    public void receiveErrorreplyConfirm(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for auditing method
     * override this method for handling normal response from auditing operation
     */
    public void receiveResultauditing(
        com.nhry.webService.client.sms.functions.AuditingResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from auditing operation
     */
    public void receiveErrorauditing(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for searchSmsNum method
     * override this method for handling normal response from searchSmsNum operation
     */
    public void receiveResultsearchSmsNum(
        com.nhry.webService.client.sms.functions.SearchSmsNumResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from searchSmsNum operation
     */
    public void receiveErrorsearchSmsNum(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for report method
     * override this method for handling normal response from report operation
     */
    public void receiveResultreport(
        com.nhry.webService.client.sms.functions.ReportResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from report operation
     */
    public void receiveErrorreport(Exception e) {
    }
}
