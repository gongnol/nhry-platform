/**
 * BAPIRETURN1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.disCount.functions;


/**
 *  BAPIRETURN1 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class BAPIRETURN1 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = BAPIRETURN1
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for TYPE
     */
    protected TYPE_type3 localTYPE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTYPETracker = false;

    /**
     * field for ID
     */
    protected ID_type3 localID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIDTracker = false;

    /**
     * field for NUMBER
     */
    protected com.nhry.webService.client.disCount.functions.NUMBER_type3 localNUMBER;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localNUMBERTracker = false;

    /**
     * field for MESSAGE
     */
    protected com.nhry.webService.client.disCount.functions.MESSAGE_type3 localMESSAGE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMESSAGETracker = false;

    /**
     * field for LOG_NO
     */
    protected com.nhry.webService.client.disCount.functions.LOG_NO_type3 localLOG_NO;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLOG_NOTracker = false;

    /**
     * field for LOG_MSG_NO
     */
    protected com.nhry.webService.client.disCount.functions.LOG_MSG_NO_type3 localLOG_MSG_NO;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLOG_MSG_NOTracker = false;

    /**
     * field for MESSAGE_V1
     */
    protected com.nhry.webService.client.disCount.functions.MESSAGE_V1_type3 localMESSAGE_V1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMESSAGE_V1Tracker = false;

    /**
     * field for MESSAGE_V2
     */
    protected com.nhry.webService.client.disCount.functions.MESSAGE_V2_type3 localMESSAGE_V2;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMESSAGE_V2Tracker = false;

    /**
     * field for MESSAGE_V3
     */
    protected com.nhry.webService.client.disCount.functions.MESSAGE_V3_type3 localMESSAGE_V3;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMESSAGE_V3Tracker = false;

    /**
     * field for MESSAGE_V4
     */
    protected com.nhry.webService.client.disCount.functions.MESSAGE_V4_type3 localMESSAGE_V4;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMESSAGE_V4Tracker = false;

    public boolean isTYPESpecified() {
        return localTYPETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.TYPE_type3
     */
    public TYPE_type3 getTYPE() {
        return localTYPE;
    }

    /**
     * Auto generated setter method
     * @param param TYPE
     */
    public void setTYPE(
        TYPE_type3 param) {
        localTYPETracker = param != null;

        this.localTYPE = param;
    }

    public boolean isIDSpecified() {
        return localIDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.ID_type3
     */
    public ID_type3 getID() {
        return localID;
    }

    /**
     * Auto generated setter method
     * @param param ID
     */
    public void setID(
        ID_type3 param) {
        localIDTracker = param != null;

        this.localID = param;
    }

    public boolean isNUMBERSpecified() {
        return localNUMBERTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.NUMBER_type3
     */
    public com.nhry.webService.client.disCount.functions.NUMBER_type3 getNUMBER() {
        return localNUMBER;
    }

    /**
     * Auto generated setter method
     * @param param NUMBER
     */
    public void setNUMBER(
        com.nhry.webService.client.disCount.functions.NUMBER_type3 param) {
        localNUMBERTracker = param != null;

        this.localNUMBER = param;
    }

    public boolean isMESSAGESpecified() {
        return localMESSAGETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.MESSAGE_type3
     */
    public com.nhry.webService.client.disCount.functions.MESSAGE_type3 getMESSAGE() {
        return localMESSAGE;
    }

    /**
     * Auto generated setter method
     * @param param MESSAGE
     */
    public void setMESSAGE(
        com.nhry.webService.client.disCount.functions.MESSAGE_type3 param) {
        localMESSAGETracker = param != null;

        this.localMESSAGE = param;
    }

    public boolean isLOG_NOSpecified() {
        return localLOG_NOTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.LOG_NO_type3
     */
    public com.nhry.webService.client.disCount.functions.LOG_NO_type3 getLOG_NO() {
        return localLOG_NO;
    }

    /**
     * Auto generated setter method
     * @param param LOG_NO
     */
    public void setLOG_NO(
        com.nhry.webService.client.disCount.functions.LOG_NO_type3 param) {
        localLOG_NOTracker = param != null;

        this.localLOG_NO = param;
    }

    public boolean isLOG_MSG_NOSpecified() {
        return localLOG_MSG_NOTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.LOG_MSG_NO_type3
     */
    public com.nhry.webService.client.disCount.functions.LOG_MSG_NO_type3 getLOG_MSG_NO() {
        return localLOG_MSG_NO;
    }

    /**
     * Auto generated setter method
     * @param param LOG_MSG_NO
     */
    public void setLOG_MSG_NO(
        com.nhry.webService.client.disCount.functions.LOG_MSG_NO_type3 param) {
        localLOG_MSG_NOTracker = param != null;

        this.localLOG_MSG_NO = param;
    }

    public boolean isMESSAGE_V1Specified() {
        return localMESSAGE_V1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.MESSAGE_V1_type3
     */
    public com.nhry.webService.client.disCount.functions.MESSAGE_V1_type3 getMESSAGE_V1() {
        return localMESSAGE_V1;
    }

    /**
     * Auto generated setter method
     * @param param MESSAGE_V1
     */
    public void setMESSAGE_V1(
        com.nhry.webService.client.disCount.functions.MESSAGE_V1_type3 param) {
        localMESSAGE_V1Tracker = param != null;

        this.localMESSAGE_V1 = param;
    }

    public boolean isMESSAGE_V2Specified() {
        return localMESSAGE_V2Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.MESSAGE_V2_type3
     */
    public com.nhry.webService.client.disCount.functions.MESSAGE_V2_type3 getMESSAGE_V2() {
        return localMESSAGE_V2;
    }

    /**
     * Auto generated setter method
     * @param param MESSAGE_V2
     */
    public void setMESSAGE_V2(
        com.nhry.webService.client.disCount.functions.MESSAGE_V2_type3 param) {
        localMESSAGE_V2Tracker = param != null;

        this.localMESSAGE_V2 = param;
    }

    public boolean isMESSAGE_V3Specified() {
        return localMESSAGE_V3Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.MESSAGE_V3_type3
     */
    public com.nhry.webService.client.disCount.functions.MESSAGE_V3_type3 getMESSAGE_V3() {
        return localMESSAGE_V3;
    }

    /**
     * Auto generated setter method
     * @param param MESSAGE_V3
     */
    public void setMESSAGE_V3(
        com.nhry.webService.client.disCount.functions.MESSAGE_V3_type3 param) {
        localMESSAGE_V3Tracker = param != null;

        this.localMESSAGE_V3 = param;
    }

    public boolean isMESSAGE_V4Specified() {
        return localMESSAGE_V4Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.MESSAGE_V4_type3
     */
    public com.nhry.webService.client.disCount.functions.MESSAGE_V4_type3 getMESSAGE_V4() {
        return localMESSAGE_V4;
    }

    /**
     * Auto generated setter method
     * @param param MESSAGE_V4
     */
    public void setMESSAGE_V4(
        com.nhry.webService.client.disCount.functions.MESSAGE_V4_type3 param) {
        localMESSAGE_V4Tracker = param != null;

        this.localMESSAGE_V4 = param;
    }

    /**
     *
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {
        return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                this, parentQName));
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException,
            org.apache.axis2.databinding.ADBException {
        serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException,
            org.apache.axis2.databinding.ADBException {
        String prefix = null;
        String namespace = null;

        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();
        writeStartElement(prefix, namespace, parentQName.getLocalPart(),
            xmlWriter);

        if (serializeType) {
            String namespacePrefix = registerPrefix(xmlWriter,
                    "urn:sap-com:document:sap:rfc:functions");

            if ((namespacePrefix != null) &&
                    (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    namespacePrefix + ":BAPIRETURN1", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "BAPIRETURN1", xmlWriter);
            }
        }

        if (localTYPETracker) {
            if (localTYPE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TYPE cannot be null!!");
            }

            localTYPE.serialize(new javax.xml.namespace.QName("", "TYPE"),
                xmlWriter);
        }

        if (localIDTracker) {
            if (localID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ID cannot be null!!");
            }

            localID.serialize(new javax.xml.namespace.QName("", "ID"), xmlWriter);
        }

        if (localNUMBERTracker) {
            if (localNUMBER == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NUMBER cannot be null!!");
            }

            localNUMBER.serialize(new javax.xml.namespace.QName("", "NUMBER"),
                xmlWriter);
        }

        if (localMESSAGETracker) {
            if (localMESSAGE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MESSAGE cannot be null!!");
            }

            localMESSAGE.serialize(new javax.xml.namespace.QName("", "MESSAGE"),
                xmlWriter);
        }

        if (localLOG_NOTracker) {
            if (localLOG_NO == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "LOG_NO cannot be null!!");
            }

            localLOG_NO.serialize(new javax.xml.namespace.QName("", "LOG_NO"),
                xmlWriter);
        }

        if (localLOG_MSG_NOTracker) {
            if (localLOG_MSG_NO == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "LOG_MSG_NO cannot be null!!");
            }

            localLOG_MSG_NO.serialize(new javax.xml.namespace.QName("",
                    "LOG_MSG_NO"), xmlWriter);
        }

        if (localMESSAGE_V1Tracker) {
            if (localMESSAGE_V1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MESSAGE_V1 cannot be null!!");
            }

            localMESSAGE_V1.serialize(new javax.xml.namespace.QName("",
                    "MESSAGE_V1"), xmlWriter);
        }

        if (localMESSAGE_V2Tracker) {
            if (localMESSAGE_V2 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MESSAGE_V2 cannot be null!!");
            }

            localMESSAGE_V2.serialize(new javax.xml.namespace.QName("",
                    "MESSAGE_V2"), xmlWriter);
        }

        if (localMESSAGE_V3Tracker) {
            if (localMESSAGE_V3 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MESSAGE_V3 cannot be null!!");
            }

            localMESSAGE_V3.serialize(new javax.xml.namespace.QName("",
                    "MESSAGE_V3"), xmlWriter);
        }

        if (localMESSAGE_V4Tracker) {
            if (localMESSAGE_V4 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MESSAGE_V4 cannot be null!!");
            }

            localMESSAGE_V4.serialize(new javax.xml.namespace.QName("",
                    "MESSAGE_V4"), xmlWriter);
        }

        xmlWriter.writeEndElement();
    }

    private static String generatePrefix(String namespace) {
        if (namespace.equals("urn:sap-com:document:sap:rfc:functions")) {
            return "ns1";
        }

        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(String prefix,
        String namespace, String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        String writerPrefix = xmlWriter.getPrefix(namespace);

        if (writerPrefix != null) {
            xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
        } else {
            if (namespace.length() == 0) {
                prefix = "";
            } else if (prefix == null) {
                prefix = generatePrefix(namespace);
            }

            xmlWriter.writeStartElement(prefix, localPart, namespace);
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(String prefix,
        String namespace, String attName,
        String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        String writerPrefix = xmlWriter.getPrefix(namespace);

        if (writerPrefix != null) {
            xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
        } else {
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
            xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
        }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(String namespace,
        String attName, String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attValue);
        } else {
            xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                namespace, attName, attValue);
        }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(String namespace,
        String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        String attributeNamespace = qname.getNamespaceURI();
        String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

        if (attributePrefix == null) {
            attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
        }

        String attributeValue;

        if (attributePrefix.trim().length() > 0) {
            attributeValue = attributePrefix + ":" + qname.getLocalPart();
        } else {
            attributeValue = qname.getLocalPart();
        }

        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attributeValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                attributeValue);
        }
    }

    /**
     *  method to handle Qnames
     */
    private void writeQName(javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        String namespaceURI = qname.getNamespaceURI();

        if (namespaceURI != null) {
            String prefix = xmlWriter.getPrefix(namespaceURI);

            if (prefix == null) {
                prefix = generatePrefix(namespaceURI);
                xmlWriter.writeNamespace(prefix, namespaceURI);
                xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
                xmlWriter.writeCharacters(prefix + ":" +
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            } else {
                // i.e this is the default namespace
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    qname));
        }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        if (qnames != null) {
            // we have to store this data until last moment since it is not possible to write any
            // namespace data after writing the charactor data
            StringBuffer stringToWrite = new StringBuffer();
            String namespaceURI = null;
            String prefix = null;

            for (int i = 0; i < qnames.length; i++) {
                if (i > 0) {
                    stringToWrite.append(" ");
                }

                namespaceURI = qnames[i].getNamespaceURI();

                if (namespaceURI != null) {
                    prefix = xmlWriter.getPrefix(namespaceURI);

                    if ((prefix == null) || (prefix.length() == 0)) {
                        prefix = generatePrefix(namespaceURI);
                        xmlWriter.writeNamespace(prefix, namespaceURI);
                        xmlWriter.setPrefix(prefix, namespaceURI);
                    }

                    if (prefix.trim().length() > 0) {
                        stringToWrite.append(prefix).append(":")
                                     .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                } else {
                    stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qnames[i]));
                }
            }

            xmlWriter.writeCharacters(stringToWrite.toString());
        }
    }

    /**
     * Register a namespace prefix
     */
    private String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, String namespace)
        throws javax.xml.stream.XMLStreamException {
        String prefix = xmlWriter.getPrefix(namespace);

        if (prefix == null) {
            prefix = generatePrefix(namespace);

            javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

            while (true) {
                String uri = nsContext.getNamespaceURI(prefix);

                if ((uri == null) || (uri.length() == 0)) {
                    break;
                }

                prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
            }

            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }

        return prefix;
    }

    /**
     *  Factory class that keeps the parse method
     */
    public static class Factory {
        private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

        /**
         * static method to create the object
         * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
         *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
         * Postcondition: If this object is an element, the reader is positioned at its end element
         *                If this object is a complex type, the reader is positioned at the end element of its outer element
         */
        public static BAPIRETURN1 parse(javax.xml.stream.XMLStreamReader reader)
            throws Exception {
            BAPIRETURN1 object = new BAPIRETURN1();

            int event;
            javax.xml.namespace.QName currentQName = null;
            String nillableValue = null;
            String prefix = "";
            String namespaceuri = "";

            try {
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                currentQName = reader.getName();

                if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "type");

                    if (fullTypeName != null) {
                        String nsPrefix = null;

                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0,
                                    fullTypeName.indexOf(":"));
                        }

                        nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                        String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                        if (!"BAPIRETURN1".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (BAPIRETURN1) com.nhry.webService.client.disCount.functions.ExtensionMapper.getTypeObject(nsUri,
                                type, reader);
                        }
                    }
                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TYPE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TYPE").equals(
                            reader.getName())) {
                    object.setTYPE(TYPE_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ID").equals(
                            reader.getName())) {
                    object.setID(ID_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "NUMBER").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "NUMBER").equals(
                            reader.getName())) {
                    object.setNUMBER(com.nhry.webService.client.disCount.functions.NUMBER_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MESSAGE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MESSAGE").equals(
                            reader.getName())) {
                    object.setMESSAGE(com.nhry.webService.client.disCount.functions.MESSAGE_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "LOG_NO").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "LOG_NO").equals(
                            reader.getName())) {
                    object.setLOG_NO(com.nhry.webService.client.disCount.functions.LOG_NO_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "LOG_MSG_NO").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "LOG_MSG_NO").equals(
                            reader.getName())) {
                    object.setLOG_MSG_NO(com.nhry.webService.client.disCount.functions.LOG_MSG_NO_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MESSAGE_V1").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MESSAGE_V1").equals(
                            reader.getName())) {
                    object.setMESSAGE_V1(com.nhry.webService.client.disCount.functions.MESSAGE_V1_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MESSAGE_V2").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MESSAGE_V2").equals(
                            reader.getName())) {
                    object.setMESSAGE_V2(com.nhry.webService.client.disCount.functions.MESSAGE_V2_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MESSAGE_V3").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MESSAGE_V3").equals(
                            reader.getName())) {
                    object.setMESSAGE_V3(com.nhry.webService.client.disCount.functions.MESSAGE_V3_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MESSAGE_V4").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MESSAGE_V4").equals(
                            reader.getName())) {
                    object.setMESSAGE_V4(com.nhry.webService.client.disCount.functions.MESSAGE_V4_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()) {
                    // 2 - A start element we are not expecting indicates a trailing invalid property
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }
            } catch (javax.xml.stream.XMLStreamException e) {
                throw new Exception(e);
            }

            return object;
        }
    } //end of factory class
}
