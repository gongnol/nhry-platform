/**
 * BAPIRET2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:48:01 BST)
 */
package com.nhry.webService.client.businessData.functions;


/**
 *  BAPIRET2 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class BAPIRET2 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = BAPIRET2
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for TYPE
     */
    protected com.nhry.webService.client.businessData.functions.TYPE_type1 localTYPE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTYPETracker = false;

    /**
     * field for ID
     */
    protected com.nhry.webService.client.businessData.functions.ID_type1 localID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIDTracker = false;

    /**
     * field for NUMBER
     */
    protected com.nhry.webService.client.businessData.functions.NUMBER_type1 localNUMBER;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localNUMBERTracker = false;

    /**
     * field for MESSAGE
     */
    protected com.nhry.webService.client.businessData.functions.MESSAGE_type1 localMESSAGE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMESSAGETracker = false;

    /**
     * field for LOG_NO
     */
    protected com.nhry.webService.client.businessData.functions.LOG_NO_type1 localLOG_NO;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLOG_NOTracker = false;

    /**
     * field for LOG_MSG_NO
     */
    protected com.nhry.webService.client.businessData.functions.LOG_MSG_NO_type1 localLOG_MSG_NO;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLOG_MSG_NOTracker = false;

    /**
     * field for MESSAGE_V1
     */
    protected com.nhry.webService.client.businessData.functions.MESSAGE_V1_type1 localMESSAGE_V1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMESSAGE_V1Tracker = false;

    /**
     * field for MESSAGE_V2
     */
    protected com.nhry.webService.client.businessData.functions.MESSAGE_V2_type1 localMESSAGE_V2;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMESSAGE_V2Tracker = false;

    /**
     * field for MESSAGE_V3
     */
    protected com.nhry.webService.client.businessData.functions.MESSAGE_V3_type1 localMESSAGE_V3;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMESSAGE_V3Tracker = false;

    /**
     * field for MESSAGE_V4
     */
    protected com.nhry.webService.client.businessData.functions.MESSAGE_V4_type1 localMESSAGE_V4;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMESSAGE_V4Tracker = false;

    /**
     * field for PARAMETER
     */
    protected com.nhry.webService.client.businessData.functions.PARAMETER_type1 localPARAMETER;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPARAMETERTracker = false;

    /**
     * field for ROW
     */
    protected java.math.BigInteger localROW;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localROWTracker = false;

    /**
     * field for FIELD
     */
    protected com.nhry.webService.client.businessData.functions.FIELD_type1 localFIELD;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localFIELDTracker = false;

    /**
     * field for SYSTEM
     */
    protected com.nhry.webService.client.businessData.functions.SYSTEM_type1 localSYSTEM;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSYSTEMTracker = false;

    public boolean isTYPESpecified() {
        return localTYPETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.TYPE_type1
     */
    public com.nhry.webService.client.businessData.functions.TYPE_type1 getTYPE() {
        return localTYPE;
    }

    /**
     * Auto generated setter method
     * @param param TYPE
     */
    public void setTYPE(
        com.nhry.webService.client.businessData.functions.TYPE_type1 param) {
        localTYPETracker = param != null;

        this.localTYPE = param;
    }

    public boolean isIDSpecified() {
        return localIDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.ID_type1
     */
    public com.nhry.webService.client.businessData.functions.ID_type1 getID() {
        return localID;
    }

    /**
     * Auto generated setter method
     * @param param ID
     */
    public void setID(
        com.nhry.webService.client.businessData.functions.ID_type1 param) {
        localIDTracker = param != null;

        this.localID = param;
    }

    public boolean isNUMBERSpecified() {
        return localNUMBERTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.NUMBER_type1
     */
    public com.nhry.webService.client.businessData.functions.NUMBER_type1 getNUMBER() {
        return localNUMBER;
    }

    /**
     * Auto generated setter method
     * @param param NUMBER
     */
    public void setNUMBER(
        com.nhry.webService.client.businessData.functions.NUMBER_type1 param) {
        localNUMBERTracker = param != null;

        this.localNUMBER = param;
    }

    public boolean isMESSAGESpecified() {
        return localMESSAGETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.MESSAGE_type1
     */
    public com.nhry.webService.client.businessData.functions.MESSAGE_type1 getMESSAGE() {
        return localMESSAGE;
    }

    /**
     * Auto generated setter method
     * @param param MESSAGE
     */
    public void setMESSAGE(
        com.nhry.webService.client.businessData.functions.MESSAGE_type1 param) {
        localMESSAGETracker = param != null;

        this.localMESSAGE = param;
    }

    public boolean isLOG_NOSpecified() {
        return localLOG_NOTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.LOG_NO_type1
     */
    public com.nhry.webService.client.businessData.functions.LOG_NO_type1 getLOG_NO() {
        return localLOG_NO;
    }

    /**
     * Auto generated setter method
     * @param param LOG_NO
     */
    public void setLOG_NO(
        com.nhry.webService.client.businessData.functions.LOG_NO_type1 param) {
        localLOG_NOTracker = param != null;

        this.localLOG_NO = param;
    }

    public boolean isLOG_MSG_NOSpecified() {
        return localLOG_MSG_NOTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.LOG_MSG_NO_type1
     */
    public com.nhry.webService.client.businessData.functions.LOG_MSG_NO_type1 getLOG_MSG_NO() {
        return localLOG_MSG_NO;
    }

    /**
     * Auto generated setter method
     * @param param LOG_MSG_NO
     */
    public void setLOG_MSG_NO(
        com.nhry.webService.client.businessData.functions.LOG_MSG_NO_type1 param) {
        localLOG_MSG_NOTracker = param != null;

        this.localLOG_MSG_NO = param;
    }

    public boolean isMESSAGE_V1Specified() {
        return localMESSAGE_V1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.MESSAGE_V1_type1
     */
    public com.nhry.webService.client.businessData.functions.MESSAGE_V1_type1 getMESSAGE_V1() {
        return localMESSAGE_V1;
    }

    /**
     * Auto generated setter method
     * @param param MESSAGE_V1
     */
    public void setMESSAGE_V1(
        com.nhry.webService.client.businessData.functions.MESSAGE_V1_type1 param) {
        localMESSAGE_V1Tracker = param != null;

        this.localMESSAGE_V1 = param;
    }

    public boolean isMESSAGE_V2Specified() {
        return localMESSAGE_V2Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.MESSAGE_V2_type1
     */
    public com.nhry.webService.client.businessData.functions.MESSAGE_V2_type1 getMESSAGE_V2() {
        return localMESSAGE_V2;
    }

    /**
     * Auto generated setter method
     * @param param MESSAGE_V2
     */
    public void setMESSAGE_V2(
        com.nhry.webService.client.businessData.functions.MESSAGE_V2_type1 param) {
        localMESSAGE_V2Tracker = param != null;

        this.localMESSAGE_V2 = param;
    }

    public boolean isMESSAGE_V3Specified() {
        return localMESSAGE_V3Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.MESSAGE_V3_type1
     */
    public com.nhry.webService.client.businessData.functions.MESSAGE_V3_type1 getMESSAGE_V3() {
        return localMESSAGE_V3;
    }

    /**
     * Auto generated setter method
     * @param param MESSAGE_V3
     */
    public void setMESSAGE_V3(
        com.nhry.webService.client.businessData.functions.MESSAGE_V3_type1 param) {
        localMESSAGE_V3Tracker = param != null;

        this.localMESSAGE_V3 = param;
    }

    public boolean isMESSAGE_V4Specified() {
        return localMESSAGE_V4Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.MESSAGE_V4_type1
     */
    public com.nhry.webService.client.businessData.functions.MESSAGE_V4_type1 getMESSAGE_V4() {
        return localMESSAGE_V4;
    }

    /**
     * Auto generated setter method
     * @param param MESSAGE_V4
     */
    public void setMESSAGE_V4(
        com.nhry.webService.client.businessData.functions.MESSAGE_V4_type1 param) {
        localMESSAGE_V4Tracker = param != null;

        this.localMESSAGE_V4 = param;
    }

    public boolean isPARAMETERSpecified() {
        return localPARAMETERTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.PARAMETER_type1
     */
    public com.nhry.webService.client.businessData.functions.PARAMETER_type1 getPARAMETER() {
        return localPARAMETER;
    }

    /**
     * Auto generated setter method
     * @param param PARAMETER
     */
    public void setPARAMETER(
        com.nhry.webService.client.businessData.functions.PARAMETER_type1 param) {
        localPARAMETERTracker = param != null;

        this.localPARAMETER = param;
    }

    public boolean isROWSpecified() {
        return localROWTracker;
    }

    /**
     * Auto generated getter method
     * @return java.math.BigInteger
     */
    public java.math.BigInteger getROW() {
        return localROW;
    }

    /**
     * Auto generated setter method
     * @param param ROW
     */
    public void setROW(java.math.BigInteger param) {
        localROWTracker = param != null;

        this.localROW = param;
    }

    public boolean isFIELDSpecified() {
        return localFIELDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.FIELD_type1
     */
    public com.nhry.webService.client.businessData.functions.FIELD_type1 getFIELD() {
        return localFIELD;
    }

    /**
     * Auto generated setter method
     * @param param FIELD
     */
    public void setFIELD(
        com.nhry.webService.client.businessData.functions.FIELD_type1 param) {
        localFIELDTracker = param != null;

        this.localFIELD = param;
    }

    public boolean isSYSTEMSpecified() {
        return localSYSTEMTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.SYSTEM_type1
     */
    public com.nhry.webService.client.businessData.functions.SYSTEM_type1 getSYSTEM() {
        return localSYSTEM;
    }

    /**
     * Auto generated setter method
     * @param param SYSTEM
     */
    public void setSYSTEM(
        com.nhry.webService.client.businessData.functions.SYSTEM_type1 param) {
        localSYSTEMTracker = param != null;

        this.localSYSTEM = param;
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
        java.lang.String prefix = null;
        java.lang.String namespace = null;

        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();
        writeStartElement(prefix, namespace, parentQName.getLocalPart(),
            xmlWriter);

        if (serializeType) {
            java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                    "urn:sap-com:document:sap:rfc:functions");

            if ((namespacePrefix != null) &&
                    (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    namespacePrefix + ":BAPIRET2", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "BAPIRET2", xmlWriter);
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

        if (localPARAMETERTracker) {
            if (localPARAMETER == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PARAMETER cannot be null!!");
            }

            localPARAMETER.serialize(new javax.xml.namespace.QName("",
                    "PARAMETER"), xmlWriter);
        }

        if (localROWTracker) {
            namespace = "";
            writeStartElement(null, namespace, "ROW", xmlWriter);

            if (localROW == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                    "ROW cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localROW));
            }

            xmlWriter.writeEndElement();
        }

        if (localFIELDTracker) {
            if (localFIELD == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "FIELD cannot be null!!");
            }

            localFIELD.serialize(new javax.xml.namespace.QName("", "FIELD"),
                xmlWriter);
        }

        if (localSYSTEMTracker) {
            if (localSYSTEM == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SYSTEM cannot be null!!");
            }

            localSYSTEM.serialize(new javax.xml.namespace.QName("", "SYSTEM"),
                xmlWriter);
        }

        xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
        if (namespace.equals("urn:sap-com:document:sap:rfc:functions")) {
            return "ns1";
        }

        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix,
        java.lang.String namespace, java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

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
    private void writeAttribute(java.lang.String prefix,
        java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

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
    private void writeAttribute(java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue,
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
    private void writeQNameAttribute(java.lang.String namespace,
        java.lang.String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String attributeNamespace = qname.getNamespaceURI();
        java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

        if (attributePrefix == null) {
            attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
        }

        java.lang.String attributeValue;

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
        java.lang.String namespaceURI = qname.getNamespaceURI();

        if (namespaceURI != null) {
            java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

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
            java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
            java.lang.String namespaceURI = null;
            java.lang.String prefix = null;

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
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String prefix = xmlWriter.getPrefix(namespace);

        if (prefix == null) {
            prefix = generatePrefix(namespace);

            javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

            while (true) {
                java.lang.String uri = nsContext.getNamespaceURI(prefix);

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
        public static BAPIRET2 parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            BAPIRET2 object = new BAPIRET2();

            int event;
            javax.xml.namespace.QName currentQName = null;
            java.lang.String nillableValue = null;
            java.lang.String prefix = "";
            java.lang.String namespaceuri = "";

            try {
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                currentQName = reader.getName();

                if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "type");

                    if (fullTypeName != null) {
                        java.lang.String nsPrefix = null;

                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0,
                                    fullTypeName.indexOf(":"));
                        }

                        nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                        java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                        if (!"BAPIRET2".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (BAPIRET2) com.nhry.webService.client.businessData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                    object.setTYPE(com.nhry.webService.client.businessData.functions.TYPE_type1.Factory.parse(
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
                    object.setID(com.nhry.webService.client.businessData.functions.ID_type1.Factory.parse(
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
                    object.setNUMBER(com.nhry.webService.client.businessData.functions.NUMBER_type1.Factory.parse(
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
                    object.setMESSAGE(com.nhry.webService.client.businessData.functions.MESSAGE_type1.Factory.parse(
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
                    object.setLOG_NO(com.nhry.webService.client.businessData.functions.LOG_NO_type1.Factory.parse(
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
                    object.setLOG_MSG_NO(com.nhry.webService.client.businessData.functions.LOG_MSG_NO_type1.Factory.parse(
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
                    object.setMESSAGE_V1(com.nhry.webService.client.businessData.functions.MESSAGE_V1_type1.Factory.parse(
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
                    object.setMESSAGE_V2(com.nhry.webService.client.businessData.functions.MESSAGE_V2_type1.Factory.parse(
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
                    object.setMESSAGE_V3(com.nhry.webService.client.businessData.functions.MESSAGE_V3_type1.Factory.parse(
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
                    object.setMESSAGE_V4(com.nhry.webService.client.businessData.functions.MESSAGE_V4_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PARAMETER").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PARAMETER").equals(
                            reader.getName())) {
                    object.setPARAMETER(com.nhry.webService.client.businessData.functions.PARAMETER_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "ROW").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ROW").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "ROW" + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setROW(org.apache.axis2.databinding.utils.ConverterUtil.convertToInteger(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "FIELD").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "FIELD").equals(
                            reader.getName())) {
                    object.setFIELD(com.nhry.webService.client.businessData.functions.FIELD_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "SYSTEM").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "SYSTEM").equals(
                            reader.getName())) {
                    object.setSYSTEM(com.nhry.webService.client.businessData.functions.SYSTEM_type1.Factory.parse(
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
                throw new java.lang.Exception(e);
            }

            return object;
        }
    } //end of factory class
}
