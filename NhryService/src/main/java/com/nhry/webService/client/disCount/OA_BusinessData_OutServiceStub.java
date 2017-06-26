/**
 * OA_BusinessData_OutServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.disCount;


/*
 *  OA_BusinessData_OutServiceStub java implementation
 */
public class OA_BusinessData_OutServiceStub extends org.apache.axis2.client.Stub
    implements OA_BusinessData_OutService {
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
    public OA_BusinessData_OutServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext,
        String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public OA_BusinessData_OutServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext,
        String targetEndpoint, boolean useSeparateListener)
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
    public OA_BusinessData_OutServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext)
        throws org.apache.axis2.AxisFault {
        this(configurationContext,
            "http://pidev.newhope.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=OA_Q&receiverParty=&receiverService=&interface=OA_BusinessData_Out&interfaceNamespace=urn%3Anewhopedairy.cn%3AOA%3ABusinessData");
    }

    /**
     * Default Constructor
     */
    public OA_BusinessData_OutServiceStub() throws org.apache.axis2.AxisFault {
        this(
            "http://pidev.newhope.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=OA_Q&receiverParty=&receiverService=&interface=OA_BusinessData_Out&interfaceNamespace=urn%3Anewhopedairy.cn%3AOA%3ABusinessData");
    }

    /**
     * Constructor taking the target endpoint
     */
    public OA_BusinessData_OutServiceStub(String targetEndpoint)
        throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    private static synchronized String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }

        counter = counter + 1;

        return Long.toString(System.currentTimeMillis()) +
        "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault {
        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService(
                "OA_BusinessData_OutService" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[2];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "urn:newhopedairy.cn:OA:BusinessData",
                "zSD_SALESORDER_DATA_RFC_5"));
        _service.addOperation(__operation);

        _operations[0] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "urn:newhopedairy.cn:OA:BusinessData",
                "zOA_ACC_DOCUMENT_REV_POST"));
        _service.addOperation(__operation);

        _operations[1] = __operation;
    }

    //populates the faults
    private void populateFaults() {
    }

    /**
     * Auto generated method signature
     *
     * @see com.nhry.webService.client.disCount.OA_BusinessData_OutService#zSD_SALESORDER_DATA_RFC_5
     * @param zSD_SALESORDER_DATA_RFC_54
     */
    public com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5Response zSD_SALESORDER_DATA_RFC_5(
        com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5 zSD_SALESORDER_DATA_RFC_54)
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
                    zSD_SALESORDER_DATA_RFC_54,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "urn:newhopedairy.cn:OA:BusinessData",
                            "zSD_SALESORDER_DATA_RFC_5")),
                    new javax.xml.namespace.QName(
                        "urn:sap-com:document:sap:rfc:functions",
                        "ZSD_SALESORDER_DATA_RFC_5"));

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

            Object object = fromOM(_returnEnv.getBody()
                                                       .getFirstElement(),
                    com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5Response.class);

            return (com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5Response) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "ZSD_SALESORDER_DATA_RFC_5"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(),
                                    "ZSD_SALESORDER_DATA_RFC_5"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(),
                                    "ZSD_SALESORDER_DATA_RFC_5"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
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
     * @see com.nhry.webService.client.disCount.OA_BusinessData_OutService#startzSD_SALESORDER_DATA_RFC_5
     * @param zSD_SALESORDER_DATA_RFC_54
     */
    public void startzSD_SALESORDER_DATA_RFC_5(
        com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5 zSD_SALESORDER_DATA_RFC_54,
        final com.nhry.webService.client.disCount.OA_BusinessData_OutServiceCallbackHandler callback)
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
                zSD_SALESORDER_DATA_RFC_54,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "urn:newhopedairy.cn:OA:BusinessData",
                        "zSD_SALESORDER_DATA_RFC_5")),
                new javax.xml.namespace.QName(
                    "urn:sap-com:document:sap:rfc:functions",
                    "ZSD_SALESORDER_DATA_RFC_5"));

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

                        Object object = fromOM(resultEnv.getBody()
                                                                  .getFirstElement(),
                                com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5Response.class);
                        callback.receiveResultzSD_SALESORDER_DATA_RFC_5((com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5Response) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(e);
                    }
                }

                public void onError(Exception error) {
                    if (error instanceof org.apache.axis2.AxisFault) {
                        org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                        org.apache.axiom.om.OMElement faultElt = f.getDetail();

                        if (faultElt != null) {
                            if (faultExceptionNameMap.containsKey(
                                        new org.apache.axis2.client.FaultMapKey(
                                            faultElt.getQName(),
                                            "ZSD_SALESORDER_DATA_RFC_5"))) {
                                //make the fault by reflection
                                try {
                                    String exceptionClassName = (String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZSD_SALESORDER_DATA_RFC_5"));
                                    Class exceptionClass = Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                    Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    String messageClassName = (String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZSD_SALESORDER_DATA_RFC_5"));
                                    Class messageClass = Class.forName(messageClassName);
                                    Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new Class[] { messageClass });
                                    m.invoke(ex,
                                        new Object[] { messageObject });

                                    callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(f);
                                } catch (ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(f);
                                } catch (NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(f);
                                } catch (IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(f);
                                } catch (InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(f);
                                }
                            } else {
                                callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(f);
                            }
                        } else {
                            callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(f);
                        }
                    } else {
                        callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(error);
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
                        callback.receiveErrorzSD_SALESORDER_DATA_RFC_5(axisFault);
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
     * @see com.nhry.webService.client.disCount.OA_BusinessData_OutService#zOA_ACC_DOCUMENT_REV_POST
     * @param zOA_ACC_DOCUMENT_REV_POST6
     */
    public com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POSTResponse zOA_ACC_DOCUMENT_REV_POST(
        com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POST zOA_ACC_DOCUMENT_REV_POST6)
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
                    zOA_ACC_DOCUMENT_REV_POST6,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "urn:newhopedairy.cn:OA:BusinessData",
                            "zOA_ACC_DOCUMENT_REV_POST")),
                    new javax.xml.namespace.QName(
                        "urn:sap-com:document:sap:rfc:functions",
                        "ZOA_ACC_DOCUMENT_REV_POST"));

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

            Object object = fromOM(_returnEnv.getBody()
                                                       .getFirstElement(),
                    com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POSTResponse.class);

            return (com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POSTResponse) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "ZOA_ACC_DOCUMENT_REV_POST"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(),
                                    "ZOA_ACC_DOCUMENT_REV_POST"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(),
                                    "ZOA_ACC_DOCUMENT_REV_POST"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
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
     * @see com.nhry.webService.client.disCount.OA_BusinessData_OutService#startzOA_ACC_DOCUMENT_REV_POST
     * @param zOA_ACC_DOCUMENT_REV_POST6
     */
    public void startzOA_ACC_DOCUMENT_REV_POST(
        com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POST zOA_ACC_DOCUMENT_REV_POST6,
        final com.nhry.webService.client.disCount.OA_BusinessData_OutServiceCallbackHandler callback)
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
                zOA_ACC_DOCUMENT_REV_POST6,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "urn:newhopedairy.cn:OA:BusinessData",
                        "zOA_ACC_DOCUMENT_REV_POST")),
                new javax.xml.namespace.QName(
                    "urn:sap-com:document:sap:rfc:functions",
                    "ZOA_ACC_DOCUMENT_REV_POST"));

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

                        Object object = fromOM(resultEnv.getBody()
                                                                  .getFirstElement(),
                                com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POSTResponse.class);
                        callback.receiveResultzOA_ACC_DOCUMENT_REV_POST((com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POSTResponse) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(e);
                    }
                }

                public void onError(Exception error) {
                    if (error instanceof org.apache.axis2.AxisFault) {
                        org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                        org.apache.axiom.om.OMElement faultElt = f.getDetail();

                        if (faultElt != null) {
                            if (faultExceptionNameMap.containsKey(
                                        new org.apache.axis2.client.FaultMapKey(
                                            faultElt.getQName(),
                                            "ZOA_ACC_DOCUMENT_REV_POST"))) {
                                //make the fault by reflection
                                try {
                                    String exceptionClassName = (String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZOA_ACC_DOCUMENT_REV_POST"));
                                    Class exceptionClass = Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                    Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    String messageClassName = (String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZOA_ACC_DOCUMENT_REV_POST"));
                                    Class messageClass = Class.forName(messageClassName);
                                    Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new Class[] { messageClass });
                                    m.invoke(ex,
                                        new Object[] { messageObject });

                                    callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(f);
                                } catch (ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(f);
                                } catch (NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(f);
                                } catch (IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(f);
                                } catch (InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(f);
                                }
                            } else {
                                callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(f);
                            }
                        } else {
                            callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(f);
                        }
                    } else {
                        callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(error);
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
                        callback.receiveErrorzOA_ACC_DOCUMENT_REV_POST(axisFault);
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

    //http://pidev.newhope.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=OA_Q&receiverParty=&receiverService=&interface=OA_BusinessData_Out&interfaceNamespace=urn%3Anewhopedairy.cn%3AOA%3ABusinessData
    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5 param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5Response param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5Response.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POST param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POST.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POSTResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POSTResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5 param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POST param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POST.MY_QNAME,
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

    private Object fromOM(org.apache.axiom.om.OMElement param,
        Class type) throws org.apache.axis2.AxisFault {
        try {
            if (com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POST.class.equals(
                        type)) {
                return com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POST.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POSTResponse.class.equals(
                        type)) {
                return com.nhry.webService.client.disCount.functions.ZOA_ACC_DOCUMENT_REV_POSTResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5.class.equals(
                        type)) {
                return com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5Response.class.equals(
                        type)) {
                return com.nhry.webService.client.disCount.functions.ZSD_SALESORDER_DATA_RFC_5Response.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }
}
