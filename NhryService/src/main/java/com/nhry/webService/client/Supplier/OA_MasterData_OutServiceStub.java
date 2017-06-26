/**
 * OA_MasterData_OutServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.nhry.webService.client.Supplier;


/*
 *  OA_MasterData_OutServiceStub java implementation
 */
public class OA_MasterData_OutServiceStub extends org.apache.axis2.client.Stub
    implements OA_MasterData_OutService {
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
    public OA_MasterData_OutServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public OA_MasterData_OutServiceStub(
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
    public OA_MasterData_OutServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext)
        throws org.apache.axis2.AxisFault {
        this(configurationContext,
            "http://pidev.newhope.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=OA_Q&receiverParty=&receiverService=&interface=OA_MasterData_Out&interfaceNamespace=urn%3Anewhopedairy.cn%3AOA%3ABusinessData");
    }

    /**
     * Default Constructor
     */
    public OA_MasterData_OutServiceStub() throws org.apache.axis2.AxisFault {
        this(
            "http://pidev.newhope.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=OA_Q&receiverParty=&receiverService=&interface=OA_MasterData_Out&interfaceNamespace=urn%3Anewhopedairy.cn%3AOA%3ABusinessData");
    }

    /**
     * Constructor taking the target endpoint
     */
    public OA_MasterData_OutServiceStub(java.lang.String targetEndpoint)
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
                "OA_MasterData_OutService" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[4];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "urn:newhopedairy.cn:OA:BusinessData", "zMM_MC_ET_LIFNR"));
        _service.addOperation(__operation);

        _operations[0] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "urn:newhopedairy.cn:OA:BusinessData", "zOA_LIFNR_KNBA"));
        _service.addOperation(__operation);

        _operations[1] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "urn:newhopedairy.cn:OA:BusinessData", "zOA_FUN_BUKRS"));
        _service.addOperation(__operation);

        _operations[2] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "urn:newhopedairy.cn:OA:BusinessData", "zOA_AUFK_DATA"));
        _service.addOperation(__operation);

        _operations[3] = __operation;
    }

    //populates the faults
    private void populateFaults() {
    }

    /**
     * Auto generated method signature
     *
     * @see com.nhry.webService.client.Supplier.OA_MasterData_OutService#zMM_MC_ET_LIFNR
     * @param zMM_MC_ET_LIFNR8
     */
    public com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNRResponse zMM_MC_ET_LIFNR(
        com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNR zMM_MC_ET_LIFNR8)
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
                    zMM_MC_ET_LIFNR8,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "urn:newhopedairy.cn:OA:BusinessData",
                            "zMM_MC_ET_LIFNR")),
                    new javax.xml.namespace.QName(
                        "urn:sap-com:document:sap:rfc:functions",
                        "ZMM_MC_ET_LIFNR"));

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
                    com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNRResponse.class);

            return (com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNRResponse) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "ZMM_MC_ET_LIFNR"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "ZMM_MC_ET_LIFNR"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "ZMM_MC_ET_LIFNR"));
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
     * @see com.nhry.webService.client.Supplier.OA_MasterData_OutService#startzMM_MC_ET_LIFNR
     * @param zMM_MC_ET_LIFNR8
     */
    public void startzMM_MC_ET_LIFNR(
        com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNR zMM_MC_ET_LIFNR8,
        final com.nhry.webService.client.Supplier.OA_MasterData_OutServiceCallbackHandler callback)
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
                zMM_MC_ET_LIFNR8,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "urn:newhopedairy.cn:OA:BusinessData", "zMM_MC_ET_LIFNR")),
                new javax.xml.namespace.QName(
                    "urn:sap-com:document:sap:rfc:functions", "ZMM_MC_ET_LIFNR"));

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
                                com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNRResponse.class);
                        callback.receiveResultzMM_MC_ET_LIFNR((com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNRResponse) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrorzMM_MC_ET_LIFNR(e);
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
                                            "ZMM_MC_ET_LIFNR"))) {
                                //make the fault by reflection
                                try {
                                    java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZMM_MC_ET_LIFNR"));
                                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZMM_MC_ET_LIFNR"));
                                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                    java.lang.Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new java.lang.Class[] { messageClass });
                                    m.invoke(ex,
                                        new java.lang.Object[] { messageObject });

                                    callback.receiveErrorzMM_MC_ET_LIFNR(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (java.lang.ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzMM_MC_ET_LIFNR(f);
                                } catch (java.lang.ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzMM_MC_ET_LIFNR(f);
                                } catch (java.lang.NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzMM_MC_ET_LIFNR(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzMM_MC_ET_LIFNR(f);
                                } catch (java.lang.IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzMM_MC_ET_LIFNR(f);
                                } catch (java.lang.InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzMM_MC_ET_LIFNR(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzMM_MC_ET_LIFNR(f);
                                }
                            } else {
                                callback.receiveErrorzMM_MC_ET_LIFNR(f);
                            }
                        } else {
                            callback.receiveErrorzMM_MC_ET_LIFNR(f);
                        }
                    } else {
                        callback.receiveErrorzMM_MC_ET_LIFNR(error);
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
                        callback.receiveErrorzMM_MC_ET_LIFNR(axisFault);
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
     * @see com.nhry.webService.client.Supplier.OA_MasterData_OutService#zOA_LIFNR_KNBA
     * @param zOA_LIFNR_KNBA10
     */
    public com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBAResponse zOA_LIFNR_KNBA(
        com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBA zOA_LIFNR_KNBA10)
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
                    zOA_LIFNR_KNBA10,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "urn:newhopedairy.cn:OA:BusinessData",
                            "zOA_LIFNR_KNBA")),
                    new javax.xml.namespace.QName(
                        "urn:sap-com:document:sap:rfc:functions",
                        "ZOA_LIFNR_KNBA"));

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
                    com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBAResponse.class);

            return (com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBAResponse) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "ZOA_LIFNR_KNBA"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "ZOA_LIFNR_KNBA"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "ZOA_LIFNR_KNBA"));
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
     * @see com.nhry.webService.client.Supplier.OA_MasterData_OutService#startzOA_LIFNR_KNBA
     * @param zOA_LIFNR_KNBA10
     */
    public void startzOA_LIFNR_KNBA(
        com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBA zOA_LIFNR_KNBA10,
        final com.nhry.webService.client.Supplier.OA_MasterData_OutServiceCallbackHandler callback)
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
                zOA_LIFNR_KNBA10,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "urn:newhopedairy.cn:OA:BusinessData", "zOA_LIFNR_KNBA")),
                new javax.xml.namespace.QName(
                    "urn:sap-com:document:sap:rfc:functions", "ZOA_LIFNR_KNBA"));

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
                                com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBAResponse.class);
                        callback.receiveResultzOA_LIFNR_KNBA((com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBAResponse) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrorzOA_LIFNR_KNBA(e);
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
                                            "ZOA_LIFNR_KNBA"))) {
                                //make the fault by reflection
                                try {
                                    java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZOA_LIFNR_KNBA"));
                                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZOA_LIFNR_KNBA"));
                                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                    java.lang.Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new java.lang.Class[] { messageClass });
                                    m.invoke(ex,
                                        new java.lang.Object[] { messageObject });

                                    callback.receiveErrorzOA_LIFNR_KNBA(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (java.lang.ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_LIFNR_KNBA(f);
                                } catch (java.lang.ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_LIFNR_KNBA(f);
                                } catch (java.lang.NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_LIFNR_KNBA(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_LIFNR_KNBA(f);
                                } catch (java.lang.IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_LIFNR_KNBA(f);
                                } catch (java.lang.InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_LIFNR_KNBA(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_LIFNR_KNBA(f);
                                }
                            } else {
                                callback.receiveErrorzOA_LIFNR_KNBA(f);
                            }
                        } else {
                            callback.receiveErrorzOA_LIFNR_KNBA(f);
                        }
                    } else {
                        callback.receiveErrorzOA_LIFNR_KNBA(error);
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
                        callback.receiveErrorzOA_LIFNR_KNBA(axisFault);
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
     * @see com.nhry.webService.client.Supplier.OA_MasterData_OutService#zOA_FUN_BUKRS
     * @param zOA_FUN_BUKRS12
     */
    public com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRSResponse zOA_FUN_BUKRS(
        com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRS zOA_FUN_BUKRS12)
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
                    zOA_FUN_BUKRS12,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "urn:newhopedairy.cn:OA:BusinessData",
                            "zOA_FUN_BUKRS")),
                    new javax.xml.namespace.QName(
                        "urn:sap-com:document:sap:rfc:functions",
                        "ZOA_FUN_BUKRS"));

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
                    com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRSResponse.class);

            return (com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRSResponse) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "ZOA_FUN_BUKRS"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "ZOA_FUN_BUKRS"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "ZOA_FUN_BUKRS"));
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
     * @see com.nhry.webService.client.Supplier.OA_MasterData_OutService#startzOA_FUN_BUKRS
     * @param zOA_FUN_BUKRS12
     */
    public void startzOA_FUN_BUKRS(
        com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRS zOA_FUN_BUKRS12,
        final com.nhry.webService.client.Supplier.OA_MasterData_OutServiceCallbackHandler callback)
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
                zOA_FUN_BUKRS12,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "urn:newhopedairy.cn:OA:BusinessData", "zOA_FUN_BUKRS")),
                new javax.xml.namespace.QName(
                    "urn:sap-com:document:sap:rfc:functions", "ZOA_FUN_BUKRS"));

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
                                com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRSResponse.class);
                        callback.receiveResultzOA_FUN_BUKRS((com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRSResponse) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrorzOA_FUN_BUKRS(e);
                    }
                }

                public void onError(java.lang.Exception error) {
                    if (error instanceof org.apache.axis2.AxisFault) {
                        org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                        org.apache.axiom.om.OMElement faultElt = f.getDetail();

                        if (faultElt != null) {
                            if (faultExceptionNameMap.containsKey(
                                        new org.apache.axis2.client.FaultMapKey(
                                            faultElt.getQName(), "ZOA_FUN_BUKRS"))) {
                                //make the fault by reflection
                                try {
                                    java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZOA_FUN_BUKRS"));
                                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZOA_FUN_BUKRS"));
                                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                    java.lang.Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new java.lang.Class[] { messageClass });
                                    m.invoke(ex,
                                        new java.lang.Object[] { messageObject });

                                    callback.receiveErrorzOA_FUN_BUKRS(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (java.lang.ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_FUN_BUKRS(f);
                                } catch (java.lang.ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_FUN_BUKRS(f);
                                } catch (java.lang.NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_FUN_BUKRS(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_FUN_BUKRS(f);
                                } catch (java.lang.IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_FUN_BUKRS(f);
                                } catch (java.lang.InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_FUN_BUKRS(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_FUN_BUKRS(f);
                                }
                            } else {
                                callback.receiveErrorzOA_FUN_BUKRS(f);
                            }
                        } else {
                            callback.receiveErrorzOA_FUN_BUKRS(f);
                        }
                    } else {
                        callback.receiveErrorzOA_FUN_BUKRS(error);
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
                        callback.receiveErrorzOA_FUN_BUKRS(axisFault);
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

    /**
     * Auto generated method signature
     *
     * @see com.nhry.webService.client.Supplier.OA_MasterData_OutService#zOA_AUFK_DATA
     * @param zOA_AUFK_DATA14
     */
    public com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATAResponse zOA_AUFK_DATA(
        com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATA zOA_AUFK_DATA14)
        throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
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
                    zOA_AUFK_DATA14,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "urn:newhopedairy.cn:OA:BusinessData",
                            "zOA_AUFK_DATA")),
                    new javax.xml.namespace.QName(
                        "urn:sap-com:document:sap:rfc:functions",
                        "ZOA_AUFK_DATA"));

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
                    com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATAResponse.class);

            return (com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATAResponse) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "ZOA_AUFK_DATA"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "ZOA_AUFK_DATA"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "ZOA_AUFK_DATA"));
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
     * @see com.nhry.webService.client.Supplier.OA_MasterData_OutService#startzOA_AUFK_DATA
     * @param zOA_AUFK_DATA14
     */
    public void startzOA_AUFK_DATA(
        com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATA zOA_AUFK_DATA14,
        final com.nhry.webService.client.Supplier.OA_MasterData_OutServiceCallbackHandler callback)
        throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
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
                zOA_AUFK_DATA14,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "urn:newhopedairy.cn:OA:BusinessData", "zOA_AUFK_DATA")),
                new javax.xml.namespace.QName(
                    "urn:sap-com:document:sap:rfc:functions", "ZOA_AUFK_DATA"));

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
                                com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATAResponse.class);
                        callback.receiveResultzOA_AUFK_DATA((com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATAResponse) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrorzOA_AUFK_DATA(e);
                    }
                }

                public void onError(java.lang.Exception error) {
                    if (error instanceof org.apache.axis2.AxisFault) {
                        org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                        org.apache.axiom.om.OMElement faultElt = f.getDetail();

                        if (faultElt != null) {
                            if (faultExceptionNameMap.containsKey(
                                        new org.apache.axis2.client.FaultMapKey(
                                            faultElt.getQName(), "ZOA_AUFK_DATA"))) {
                                //make the fault by reflection
                                try {
                                    java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZOA_AUFK_DATA"));
                                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "ZOA_AUFK_DATA"));
                                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                    java.lang.Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new java.lang.Class[] { messageClass });
                                    m.invoke(ex,
                                        new java.lang.Object[] { messageObject });

                                    callback.receiveErrorzOA_AUFK_DATA(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (java.lang.ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_AUFK_DATA(f);
                                } catch (java.lang.ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_AUFK_DATA(f);
                                } catch (java.lang.NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_AUFK_DATA(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_AUFK_DATA(f);
                                } catch (java.lang.IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_AUFK_DATA(f);
                                } catch (java.lang.InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_AUFK_DATA(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorzOA_AUFK_DATA(f);
                                }
                            } else {
                                callback.receiveErrorzOA_AUFK_DATA(f);
                            }
                        } else {
                            callback.receiveErrorzOA_AUFK_DATA(f);
                        }
                    } else {
                        callback.receiveErrorzOA_AUFK_DATA(error);
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
                        callback.receiveErrorzOA_AUFK_DATA(axisFault);
                    }
                }
            });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[3].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[3].setMessageReceiver(_callbackReceiver);
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

    //http://pidev.newhope.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=OA_Q&receiverParty=&receiverService=&interface=OA_MasterData_Out&interfaceNamespace=urn%3Anewhopedairy.cn%3AOA%3ABusinessData
    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNR param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNR.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNRResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNRResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBA param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBA.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBAResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBAResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRS param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRS.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRSResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRSResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATA param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATA.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATAResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATAResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNR param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNR.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBA param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBA.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRS param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRS.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATA param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATA.MY_QNAME,
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
            if (com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNR.class.equals(
                        type)) {
                return com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNR.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNRResponse.class.equals(
                        type)) {
                return com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNRResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATA.class.equals(
                        type)) {
                return com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATA.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATAResponse.class.equals(
                        type)) {
                return com.nhry.webService.client.Supplier.functions.ZOA_AUFK_DATAResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRS.class.equals(
                        type)) {
                return com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRS.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRSResponse.class.equals(
                        type)) {
                return com.nhry.webService.client.Supplier.functions.ZOA_FUN_BUKRSResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBA.class.equals(
                        type)) {
                return com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBA.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBAResponse.class.equals(
                        type)) {
                return com.nhry.webService.client.Supplier.functions.ZOA_LIFNR_KNBAResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }
}
