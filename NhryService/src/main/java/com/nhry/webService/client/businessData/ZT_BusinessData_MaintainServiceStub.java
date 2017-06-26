/**
 * ZT_BusinessData_MaintainServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */
package com.nhry.webService.client.businessData;


/*
 *  ZT_BusinessData_MaintainServiceStub java implementation
 */
public class ZT_BusinessData_MaintainServiceStub extends org.apache.axis2.client.Stub
    implements ZT_BusinessData_MaintainService {
    private static int counter = 0;
    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();
    private javax.xml.namespace.QName[] opNameArray = null;

    /**
     *Constructor that takes in a configContext
     */
    public ZT_BusinessData_MaintainServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public ZT_BusinessData_MaintainServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,
                _service);

        _serviceClient.getOptions()
                      .setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
    }

    /**
     * Default Constructor
     */
    public ZT_BusinessData_MaintainServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext)
        throws org.apache.axis2.AxisFault {
        this(configurationContext,
            "http://pidev.newhope.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=ZT_Q&receiverParty=&receiverService=&interface=ZT_BusinessData_Maintain&interfaceNamespace=urn%3Anewhopedairy.cn%3AZT%3ABusinessData");
    }

    /**
     * Default Constructor
     */
    public ZT_BusinessData_MaintainServiceStub()
        throws org.apache.axis2.AxisFault {
        this(
            "http://pidev.newhope.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=ZT_Q&receiverParty=&receiverService=&interface=ZT_BusinessData_Maintain&interfaceNamespace=urn%3Anewhopedairy.cn%3AZT%3ABusinessData");
    }

    /**
     * Constructor taking the target endpoint
     */
    public ZT_BusinessData_MaintainServiceStub(java.lang.String targetEndpoint)
        throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    private static synchronized java.lang.String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }

        counter = counter + 1;

        return java.lang.Long.toString(java.lang.System.currentTimeMillis()) +
        "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault {
        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService(
                "ZT_BusinessData_MaintainService" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[3];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "urn:newhopedairy.cn:ZT:BusinessData", "deliveryQuery"));
        _service.addOperation(__operation);

        _operations[0] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "urn:newhopedairy.cn:ZT:BusinessData", "salesOrderCreate"));
        _service.addOperation(__operation);

        _operations[1] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "urn:newhopedairy.cn:ZT:BusinessData", "requisitionCreate"));
        _service.addOperation(__operation);

        _operations[2] = __operation;
    }

    //populates the faults
    private void populateFaults() {
    }

    /**
     * Auto generated method signature
     *
     * @see com.nhry.webService.client.businessData.ZT_BusinessData_MaintainService#deliveryQuery
     * @param zSD_DELIVERY_DATA6
     */
    public com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATAResponse deliveryQuery(
        com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATA zSD_DELIVERY_DATA6)
        throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions()
                            .setAction("http://sap.com/xi/WebService/soap1.1");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                                                        .getSoapVersionURI()),
                    zSD_DELIVERY_DATA6,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "urn:newhopedairy.cn:ZT:BusinessData",
                            "deliveryQuery")),
                    new javax.xml.namespace.QName(
                        "urn:sap-com:document:sap:rfc:functions",
                        "ZSD_DELIVERY_DATA"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody()
                                                       .getFirstElement(),
                    com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATAResponse.class);

            return (com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATAResponse) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "DeliveryQuery"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "DeliveryQuery"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "DeliveryQuery"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,
                                messageClass);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[] { messageClass });
                        m.invoke(ex, new java.lang.Object[] { messageObject });

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                               .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.nhry.webService.client.businessData.ZT_BusinessData_MaintainService#startdeliveryQuery
     * @param zSD_DELIVERY_DATA6
     */
    public void startdeliveryQuery(
        com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATA zSD_DELIVERY_DATA6,
        final com.nhry.webService.client.businessData.ZT_BusinessData_MaintainServiceCallbackHandler callback)
        throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
        _operationClient.getOptions()
                        .setAction("http://sap.com/xi/WebService/soap1.1");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
            org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
            "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                                                    .getSoapVersionURI()),
                zSD_DELIVERY_DATA6,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "urn:newhopedairy.cn:ZT:BusinessData", "deliveryQuery")),
                new javax.xml.namespace.QName(
                    "urn:sap-com:document:sap:rfc:functions",
                    "ZSD_DELIVERY_DATA"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                    try {
                        org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                        java.lang.Object object = fromOM(resultEnv.getBody()
                                                                  .getFirstElement(),
                                com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATAResponse.class);
                        callback.receiveResultdeliveryQuery((com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATAResponse) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrordeliveryQuery(e);
                    }
                }

                public void onError(java.lang.Exception error) {
                    if (error instanceof org.apache.axis2.AxisFault) {
                        org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                        org.apache.axiom.om.OMElement faultElt = f.getDetail();

                        if (faultElt != null) {
                            if (faultExceptionNameMap.containsKey(
                                        new org.apache.axis2.client.FaultMapKey(
                                            faultElt.getQName(), "DeliveryQuery"))) {
                                //make the fault by reflection
                                try {
                                    java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "DeliveryQuery"));
                                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "DeliveryQuery"));
                                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                    java.lang.Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new java.lang.Class[] { messageClass });
                                    m.invoke(ex,
                                        new java.lang.Object[] { messageObject });

                                    callback.receiveErrordeliveryQuery(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (java.lang.ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrordeliveryQuery(f);
                                } catch (java.lang.ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrordeliveryQuery(f);
                                } catch (java.lang.NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrordeliveryQuery(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrordeliveryQuery(f);
                                } catch (java.lang.IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrordeliveryQuery(f);
                                } catch (java.lang.InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrordeliveryQuery(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrordeliveryQuery(f);
                                }
                            } else {
                                callback.receiveErrordeliveryQuery(f);
                            }
                        } else {
                            callback.receiveErrordeliveryQuery(f);
                        }
                    } else {
                        callback.receiveErrordeliveryQuery(error);
                    }
                }

                public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                    org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                    onError(fault);
                }

                public void onComplete() {
                    try {
                        _messageContext.getTransportOut().getSender()
                                       .cleanup(_messageContext);
                    } catch (org.apache.axis2.AxisFault axisFault) {
                        callback.receiveErrordeliveryQuery(axisFault);
                    }
                }
            });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[0].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[0].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see com.nhry.webService.client.businessData.ZT_BusinessData_MaintainService#salesOrderCreate
     * @param zSD_SALESORDER_DATA_RFC_28
     */
    public com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2Response salesOrderCreate(
        com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2 zSD_SALESORDER_DATA_RFC_28)
        throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
            _operationClient.getOptions()
                            .setAction("http://sap.com/xi/WebService/soap1.1");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                                                        .getSoapVersionURI()),
                    zSD_SALESORDER_DATA_RFC_28,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "urn:newhopedairy.cn:ZT:BusinessData",
                            "salesOrderCreate")),
                    new javax.xml.namespace.QName(
                        "urn:sap-com:document:sap:rfc:functions",
                        "ZSD_SALESORDER_DATA_RFC_2"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody()
                                                       .getFirstElement(),
                    com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2Response.class);

            return (com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2Response) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "SalesOrderCreate"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "SalesOrderCreate"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "SalesOrderCreate"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,
                                messageClass);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[] { messageClass });
                        m.invoke(ex, new java.lang.Object[] { messageObject });

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                               .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.nhry.webService.client.businessData.ZT_BusinessData_MaintainService#startsalesOrderCreate
     * @param zSD_SALESORDER_DATA_RFC_28
     */
    public void startsalesOrderCreate(
        com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2 zSD_SALESORDER_DATA_RFC_28,
        final com.nhry.webService.client.businessData.ZT_BusinessData_MaintainServiceCallbackHandler callback)
        throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
        _operationClient.getOptions()
                        .setAction("http://sap.com/xi/WebService/soap1.1");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
            org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
            "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                                                    .getSoapVersionURI()),
                zSD_SALESORDER_DATA_RFC_28,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "urn:newhopedairy.cn:ZT:BusinessData",
                        "salesOrderCreate")),
                new javax.xml.namespace.QName(
                    "urn:sap-com:document:sap:rfc:functions",
                    "ZSD_SALESORDER_DATA_RFC_2"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                    try {
                        org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                        java.lang.Object object = fromOM(resultEnv.getBody()
                                                                  .getFirstElement(),
                                com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2Response.class);
                        callback.receiveResultsalesOrderCreate((com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2Response) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrorsalesOrderCreate(e);
                    }
                }

                public void onError(java.lang.Exception error) {
                    if (error instanceof org.apache.axis2.AxisFault) {
                        org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                        org.apache.axiom.om.OMElement faultElt = f.getDetail();

                        if (faultElt != null) {
                            if (faultExceptionNameMap.containsKey(
                                        new org.apache.axis2.client.FaultMapKey(
                                            faultElt.getQName(),
                                            "SalesOrderCreate"))) {
                                //make the fault by reflection
                                try {
                                    java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "SalesOrderCreate"));
                                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "SalesOrderCreate"));
                                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                    java.lang.Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new java.lang.Class[] { messageClass });
                                    m.invoke(ex,
                                        new java.lang.Object[] { messageObject });

                                    callback.receiveErrorsalesOrderCreate(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (java.lang.ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorsalesOrderCreate(f);
                                } catch (java.lang.ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorsalesOrderCreate(f);
                                } catch (java.lang.NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorsalesOrderCreate(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorsalesOrderCreate(f);
                                } catch (java.lang.IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorsalesOrderCreate(f);
                                } catch (java.lang.InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorsalesOrderCreate(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorsalesOrderCreate(f);
                                }
                            } else {
                                callback.receiveErrorsalesOrderCreate(f);
                            }
                        } else {
                            callback.receiveErrorsalesOrderCreate(f);
                        }
                    } else {
                        callback.receiveErrorsalesOrderCreate(error);
                    }
                }

                public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                    org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                    onError(fault);
                }

                public void onComplete() {
                    try {
                        _messageContext.getTransportOut().getSender()
                                       .cleanup(_messageContext);
                    } catch (org.apache.axis2.AxisFault axisFault) {
                        callback.receiveErrorsalesOrderCreate(axisFault);
                    }
                }
            });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[1].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[1].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see com.nhry.webService.client.businessData.ZT_BusinessData_MaintainService#requisitionCreate
     * @param zSD_REQUISITION_CREATE_RFC10
     */
    public com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFCResponse requisitionCreate(
        com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFC zSD_REQUISITION_CREATE_RFC10)
        throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
            _operationClient.getOptions()
                            .setAction("http://sap.com/xi/WebService/soap1.1");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                                                        .getSoapVersionURI()),
                    zSD_REQUISITION_CREATE_RFC10,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "urn:newhopedairy.cn:ZT:BusinessData",
                            "requisitionCreate")),
                    new javax.xml.namespace.QName(
                        "urn:sap-com:document:sap:rfc:functions",
                        "ZSD_REQUISITION_CREATE_RFC"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody()
                                                       .getFirstElement(),
                    com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFCResponse.class);

            return (com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFCResponse) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "RequisitionCreate"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "RequisitionCreate"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "RequisitionCreate"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,
                                messageClass);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[] { messageClass });
                        m.invoke(ex, new java.lang.Object[] { messageObject });

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                               .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.nhry.webService.client.businessData.ZT_BusinessData_MaintainService#startrequisitionCreate
     * @param zSD_REQUISITION_CREATE_RFC10
     */
    public void startrequisitionCreate(
        com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFC zSD_REQUISITION_CREATE_RFC10,
        final com.nhry.webService.client.businessData.ZT_BusinessData_MaintainServiceCallbackHandler callback)
        throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
        _operationClient.getOptions()
                        .setAction("http://sap.com/xi/WebService/soap1.1");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
            org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
            "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                                                    .getSoapVersionURI()),
                zSD_REQUISITION_CREATE_RFC10,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "urn:newhopedairy.cn:ZT:BusinessData",
                        "requisitionCreate")),
                new javax.xml.namespace.QName(
                    "urn:sap-com:document:sap:rfc:functions",
                    "ZSD_REQUISITION_CREATE_RFC"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                    try {
                        org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                        java.lang.Object object = fromOM(resultEnv.getBody()
                                                                  .getFirstElement(),
                                com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFCResponse.class);
                        callback.receiveResultrequisitionCreate((com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFCResponse) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrorrequisitionCreate(e);
                    }
                }

                public void onError(java.lang.Exception error) {
                    if (error instanceof org.apache.axis2.AxisFault) {
                        org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                        org.apache.axiom.om.OMElement faultElt = f.getDetail();

                        if (faultElt != null) {
                            if (faultExceptionNameMap.containsKey(
                                        new org.apache.axis2.client.FaultMapKey(
                                            faultElt.getQName(),
                                            "RequisitionCreate"))) {
                                //make the fault by reflection
                                try {
                                    java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "RequisitionCreate"));
                                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "RequisitionCreate"));
                                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                    java.lang.Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new java.lang.Class[] { messageClass });
                                    m.invoke(ex,
                                        new java.lang.Object[] { messageObject });

                                    callback.receiveErrorrequisitionCreate(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (java.lang.ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorrequisitionCreate(f);
                                } catch (java.lang.ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorrequisitionCreate(f);
                                } catch (java.lang.NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorrequisitionCreate(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorrequisitionCreate(f);
                                } catch (java.lang.IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorrequisitionCreate(f);
                                } catch (java.lang.InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorrequisitionCreate(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorrequisitionCreate(f);
                                }
                            } else {
                                callback.receiveErrorrequisitionCreate(f);
                            }
                        } else {
                            callback.receiveErrorrequisitionCreate(f);
                        }
                    } else {
                        callback.receiveErrorrequisitionCreate(error);
                    }
                }

                public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                    org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                    onError(fault);
                }

                public void onComplete() {
                    try {
                        _messageContext.getTransportOut().getSender()
                                       .cleanup(_messageContext);
                    } catch (org.apache.axis2.AxisFault axisFault) {
                        callback.receiveErrorrequisitionCreate(axisFault);
                    }
                }
            });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[2].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[2].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        if (opNameArray == null) {
            return false;
        }

        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }

        return false;
    }

    //http://pidev.newhope.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=ZT_Q&receiverParty=&receiverService=&interface=ZT_BusinessData_Maintain&interfaceNamespace=urn%3Anewhopedairy.cn%3AZT%3ABusinessData
    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATA param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATA.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATAResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATAResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2 param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2Response param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2Response.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFC param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFC.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFCResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFCResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATA param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATA.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2 param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFC param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFC.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type) throws org.apache.axis2.AxisFault {
        try {
            if (com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATA.class.equals(
                        type)) {
                return com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATA.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATAResponse.class.equals(
                        type)) {
                return com.nhry.webService.client.businessData.functions.ZSD_DELIVERY_DATAResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFC.class.equals(
                        type)) {
                return com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFC.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFCResponse.class.equals(
                        type)) {
                return com.nhry.webService.client.businessData.functions.ZSD_REQUISITION_CREATE_RFCResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2.class.equals(
                        type)) {
                return com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2Response.class.equals(
                        type)) {
                return com.nhry.webService.client.businessData.functions.ZSD_SALESORDER_DATA_RFC_2Response.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }
}
