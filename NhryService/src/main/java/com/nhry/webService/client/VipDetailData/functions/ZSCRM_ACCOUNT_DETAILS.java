/**
 * ZSCRM_ACCOUNT_DETAILS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.VipDetailData.functions;


/**
 *  ZSCRM_ACCOUNT_DETAILS bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSCRM_ACCOUNT_DETAILS implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSCRM_ACCOUNT_DETAILS
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for ACCOUNT_SET_ID
     */
    protected ACCOUNT_SET_ID_type1 localACCOUNT_SET_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localACCOUNT_SET_IDTracker = false;

    /**
     * field for ACCOUNT_ID
     */
    protected ACCOUNT_ID_type1 localACCOUNT_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localACCOUNT_IDTracker = false;

    /**
     * field for EXTERNAL_ID
     */
    protected EXTERNAL_ID_type1 localEXTERNAL_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localEXTERNAL_IDTracker = false;

    /**
     * field for EXTERNAL_ID_DESC
     */
    protected com.nhry.webService.client.VipDetailData.functions.EXTERNAL_ID_DESC_type1 localEXTERNAL_ID_DESC;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localEXTERNAL_ID_DESCTracker = false;

    /**
     * field for PT_TYPE
     */
    protected PT_TYPE_type1 localPT_TYPE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPT_TYPETracker = false;

    /**
     * field for PT_TYPE_DESC
     */
    protected PT_TYPE_DESC_type1 localPT_TYPE_DESC;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPT_TYPE_DESCTracker = false;

    /**
     * field for EARNED
     */
    protected EARNED_type1 localEARNED;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localEARNEDTracker = false;

    /**
     * field for CONSUMED
     */
    protected CONSUMED_type1 localCONSUMED;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCONSUMEDTracker = false;

    /**
     * field for EXPIRED
     */
    protected EXPIRED_type1 localEXPIRED;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localEXPIREDTracker = false;

    /**
     * field for BALANCE
     */
    protected BALANCE_type1 localBALANCE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBALANCETracker = false;

    /**
     * field for TRANSACTIONS
     */
    protected ZSCRM_TRANSACTIONS_T localTRANSACTIONS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTRANSACTIONSTracker = false;

    public boolean isACCOUNT_SET_IDSpecified() {
        return localACCOUNT_SET_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.ACCOUNT_SET_ID_type1
     */
    public ACCOUNT_SET_ID_type1 getACCOUNT_SET_ID() {
        return localACCOUNT_SET_ID;
    }

    /**
     * Auto generated setter method
     * @param param ACCOUNT_SET_ID
     */
    public void setACCOUNT_SET_ID(
        ACCOUNT_SET_ID_type1 param) {
        localACCOUNT_SET_IDTracker = param != null;

        this.localACCOUNT_SET_ID = param;
    }

    public boolean isACCOUNT_IDSpecified() {
        return localACCOUNT_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.ACCOUNT_ID_type1
     */
    public ACCOUNT_ID_type1 getACCOUNT_ID() {
        return localACCOUNT_ID;
    }

    /**
     * Auto generated setter method
     * @param param ACCOUNT_ID
     */
    public void setACCOUNT_ID(
        ACCOUNT_ID_type1 param) {
        localACCOUNT_IDTracker = param != null;

        this.localACCOUNT_ID = param;
    }

    public boolean isEXTERNAL_IDSpecified() {
        return localEXTERNAL_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.EXTERNAL_ID_type1
     */
    public EXTERNAL_ID_type1 getEXTERNAL_ID() {
        return localEXTERNAL_ID;
    }

    /**
     * Auto generated setter method
     * @param param EXTERNAL_ID
     */
    public void setEXTERNAL_ID(
        EXTERNAL_ID_type1 param) {
        localEXTERNAL_IDTracker = param != null;

        this.localEXTERNAL_ID = param;
    }

    public boolean isEXTERNAL_ID_DESCSpecified() {
        return localEXTERNAL_ID_DESCTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.EXTERNAL_ID_DESC_type1
     */
    public com.nhry.webService.client.VipDetailData.functions.EXTERNAL_ID_DESC_type1 getEXTERNAL_ID_DESC() {
        return localEXTERNAL_ID_DESC;
    }

    /**
     * Auto generated setter method
     * @param param EXTERNAL_ID_DESC
     */
    public void setEXTERNAL_ID_DESC(
        com.nhry.webService.client.VipDetailData.functions.EXTERNAL_ID_DESC_type1 param) {
        localEXTERNAL_ID_DESCTracker = param != null;

        this.localEXTERNAL_ID_DESC = param;
    }

    public boolean isPT_TYPESpecified() {
        return localPT_TYPETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.PT_TYPE_type1
     */
    public PT_TYPE_type1 getPT_TYPE() {
        return localPT_TYPE;
    }

    /**
     * Auto generated setter method
     * @param param PT_TYPE
     */
    public void setPT_TYPE(
        PT_TYPE_type1 param) {
        localPT_TYPETracker = param != null;

        this.localPT_TYPE = param;
    }

    public boolean isPT_TYPE_DESCSpecified() {
        return localPT_TYPE_DESCTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.PT_TYPE_DESC_type1
     */
    public PT_TYPE_DESC_type1 getPT_TYPE_DESC() {
        return localPT_TYPE_DESC;
    }

    /**
     * Auto generated setter method
     * @param param PT_TYPE_DESC
     */
    public void setPT_TYPE_DESC(
        PT_TYPE_DESC_type1 param) {
        localPT_TYPE_DESCTracker = param != null;

        this.localPT_TYPE_DESC = param;
    }

    public boolean isEARNEDSpecified() {
        return localEARNEDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.EARNED_type1
     */
    public EARNED_type1 getEARNED() {
        return localEARNED;
    }

    /**
     * Auto generated setter method
     * @param param EARNED
     */
    public void setEARNED(
        EARNED_type1 param) {
        localEARNEDTracker = param != null;

        this.localEARNED = param;
    }

    public boolean isCONSUMEDSpecified() {
        return localCONSUMEDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.CONSUMED_type1
     */
    public CONSUMED_type1 getCONSUMED() {
        return localCONSUMED;
    }

    /**
     * Auto generated setter method
     * @param param CONSUMED
     */
    public void setCONSUMED(
        CONSUMED_type1 param) {
        localCONSUMEDTracker = param != null;

        this.localCONSUMED = param;
    }

    public boolean isEXPIREDSpecified() {
        return localEXPIREDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.EXPIRED_type1
     */
    public EXPIRED_type1 getEXPIRED() {
        return localEXPIRED;
    }

    /**
     * Auto generated setter method
     * @param param EXPIRED
     */
    public void setEXPIRED(
        EXPIRED_type1 param) {
        localEXPIREDTracker = param != null;

        this.localEXPIRED = param;
    }

    public boolean isBALANCESpecified() {
        return localBALANCETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.BALANCE_type1
     */
    public BALANCE_type1 getBALANCE() {
        return localBALANCE;
    }

    /**
     * Auto generated setter method
     * @param param BALANCE
     */
    public void setBALANCE(
        BALANCE_type1 param) {
        localBALANCETracker = param != null;

        this.localBALANCE = param;
    }

    public boolean isTRANSACTIONSSpecified() {
        return localTRANSACTIONSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.ZSCRM_TRANSACTIONS_T
     */
    public ZSCRM_TRANSACTIONS_T getTRANSACTIONS() {
        return localTRANSACTIONS;
    }

    /**
     * Auto generated setter method
     * @param param TRANSACTIONS
     */
    public void setTRANSACTIONS(
        ZSCRM_TRANSACTIONS_T param) {
        localTRANSACTIONSTracker = param != null;

        this.localTRANSACTIONS = param;
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
                    namespacePrefix + ":ZSCRM_ACCOUNT_DETAILS", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSCRM_ACCOUNT_DETAILS", xmlWriter);
            }
        }

        if (localACCOUNT_SET_IDTracker) {
            if (localACCOUNT_SET_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ACCOUNT_SET_ID cannot be null!!");
            }

            localACCOUNT_SET_ID.serialize(new javax.xml.namespace.QName("",
                    "ACCOUNT_SET_ID"), xmlWriter);
        }

        if (localACCOUNT_IDTracker) {
            if (localACCOUNT_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ACCOUNT_ID cannot be null!!");
            }

            localACCOUNT_ID.serialize(new javax.xml.namespace.QName("",
                    "ACCOUNT_ID"), xmlWriter);
        }

        if (localEXTERNAL_IDTracker) {
            if (localEXTERNAL_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "EXTERNAL_ID cannot be null!!");
            }

            localEXTERNAL_ID.serialize(new javax.xml.namespace.QName("",
                    "EXTERNAL_ID"), xmlWriter);
        }

        if (localEXTERNAL_ID_DESCTracker) {
            if (localEXTERNAL_ID_DESC == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "EXTERNAL_ID_DESC cannot be null!!");
            }

            localEXTERNAL_ID_DESC.serialize(new javax.xml.namespace.QName("",
                    "EXTERNAL_ID_DESC"), xmlWriter);
        }

        if (localPT_TYPETracker) {
            if (localPT_TYPE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PT_TYPE cannot be null!!");
            }

            localPT_TYPE.serialize(new javax.xml.namespace.QName("", "PT_TYPE"),
                xmlWriter);
        }

        if (localPT_TYPE_DESCTracker) {
            if (localPT_TYPE_DESC == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PT_TYPE_DESC cannot be null!!");
            }

            localPT_TYPE_DESC.serialize(new javax.xml.namespace.QName("",
                    "PT_TYPE_DESC"), xmlWriter);
        }

        if (localEARNEDTracker) {
            if (localEARNED == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "EARNED cannot be null!!");
            }

            localEARNED.serialize(new javax.xml.namespace.QName("", "EARNED"),
                xmlWriter);
        }

        if (localCONSUMEDTracker) {
            if (localCONSUMED == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CONSUMED cannot be null!!");
            }

            localCONSUMED.serialize(new javax.xml.namespace.QName("", "CONSUMED"),
                xmlWriter);
        }

        if (localEXPIREDTracker) {
            if (localEXPIRED == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "EXPIRED cannot be null!!");
            }

            localEXPIRED.serialize(new javax.xml.namespace.QName("", "EXPIRED"),
                xmlWriter);
        }

        if (localBALANCETracker) {
            if (localBALANCE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BALANCE cannot be null!!");
            }

            localBALANCE.serialize(new javax.xml.namespace.QName("", "BALANCE"),
                xmlWriter);
        }

        if (localTRANSACTIONSTracker) {
            if (localTRANSACTIONS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TRANSACTIONS cannot be null!!");
            }

            localTRANSACTIONS.serialize(new javax.xml.namespace.QName("",
                    "TRANSACTIONS"), xmlWriter);
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
        public static ZSCRM_ACCOUNT_DETAILS parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            ZSCRM_ACCOUNT_DETAILS object = new ZSCRM_ACCOUNT_DETAILS();

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

                        if (!"ZSCRM_ACCOUNT_DETAILS".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSCRM_ACCOUNT_DETAILS) ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "ACCOUNT_SET_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ACCOUNT_SET_ID").equals(
                            reader.getName())) {
                    object.setACCOUNT_SET_ID(ACCOUNT_SET_ID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "ACCOUNT_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ACCOUNT_ID").equals(
                            reader.getName())) {
                    object.setACCOUNT_ID(ACCOUNT_ID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "EXTERNAL_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "EXTERNAL_ID").equals(
                            reader.getName())) {
                    object.setEXTERNAL_ID(EXTERNAL_ID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "EXTERNAL_ID_DESC").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "EXTERNAL_ID_DESC").equals(
                            reader.getName())) {
                    object.setEXTERNAL_ID_DESC(com.nhry.webService.client.VipDetailData.functions.EXTERNAL_ID_DESC_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PT_TYPE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PT_TYPE").equals(
                            reader.getName())) {
                    object.setPT_TYPE(PT_TYPE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PT_TYPE_DESC").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PT_TYPE_DESC").equals(
                            reader.getName())) {
                    object.setPT_TYPE_DESC(PT_TYPE_DESC_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "EARNED").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "EARNED").equals(
                            reader.getName())) {
                    object.setEARNED(EARNED_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "CONSUMED").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "CONSUMED").equals(
                            reader.getName())) {
                    object.setCONSUMED(CONSUMED_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "EXPIRED").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "EXPIRED").equals(
                            reader.getName())) {
                    object.setEXPIRED(EXPIRED_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BALANCE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BALANCE").equals(
                            reader.getName())) {
                    object.setBALANCE(BALANCE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TRANSACTIONS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TRANSACTIONS").equals(
                            reader.getName())) {
                    object.setTRANSACTIONS(ZSCRM_TRANSACTIONS_T.Factory.parse(
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
