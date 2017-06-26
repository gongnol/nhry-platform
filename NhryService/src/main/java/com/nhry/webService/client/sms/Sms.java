/**
 * Sms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.sms;


/*
 *  Sms java interface
 */
public interface Sms {
    /**
     * Auto generated method signature
     *
     * @param replyRequest0
     */
    public com.nhry.webService.client.sms.functions.ReplyResponse reply(
            com.nhry.webService.client.sms.functions.ReplyRequest replyRequest0)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param replyRequest0
     */
    public void startreply(
            com.nhry.webService.client.sms.functions.ReplyRequest replyRequest0,
            final com.nhry.webService.client.sms.SmsCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param sms2
     */
    public com.nhry.webService.client.sms.functions.SmsResponse sms(
            com.nhry.webService.client.sms.functions.Sms sms2)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param sms2
     */
    public void startsms(com.nhry.webService.client.sms.functions.Sms sms2,
                         final com.nhry.webService.client.sms.SmsCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param replyConfirmRequest4
     */
    public com.nhry.webService.client.sms.functions.ReplyConfirmResponse replyConfirm(
            com.nhry.webService.client.sms.functions.ReplyConfirmRequest replyConfirmRequest4)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param replyConfirmRequest4
     */
    public void startreplyConfirm(
            com.nhry.webService.client.sms.functions.ReplyConfirmRequest replyConfirmRequest4,
            final com.nhry.webService.client.sms.SmsCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param auditingRequest6
     */
    public com.nhry.webService.client.sms.functions.AuditingResponse auditing(
            com.nhry.webService.client.sms.functions.AuditingRequest auditingRequest6)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param auditingRequest6
     */
    public void startauditing(
            com.nhry.webService.client.sms.functions.AuditingRequest auditingRequest6,
            final com.nhry.webService.client.sms.SmsCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param searchSmsNumRequest8
     */
    public com.nhry.webService.client.sms.functions.SearchSmsNumResponse searchSmsNum(
            com.nhry.webService.client.sms.functions.SearchSmsNumRequest searchSmsNumRequest8)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param searchSmsNumRequest8
     */
    public void startsearchSmsNum(
            com.nhry.webService.client.sms.functions.SearchSmsNumRequest searchSmsNumRequest8,
            final com.nhry.webService.client.sms.SmsCallbackHandler callback)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param report10
     */
    public com.nhry.webService.client.sms.functions.ReportResponse report(
            com.nhry.webService.client.sms.functions.Report report10)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param report10
     */
    public void startreport(
            com.nhry.webService.client.sms.functions.Report report10,
            final com.nhry.webService.client.sms.SmsCallbackHandler callback)
        throws java.rmi.RemoteException;

    //
}
