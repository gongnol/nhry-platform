/**
 * ZSCRM_TRANSACTIONS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.VipDetailData.functions;


/**
 *  ZSCRM_TRANSACTIONS bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSCRM_TRANSACTIONS implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSCRM_TRANSACTIONS
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for POSTING_DATE
     */
    protected POSTING_DATE_type1 localPOSTING_DATE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPOSTING_DATETracker = false;

    /**
     * field for TXN_TYPE
     */
    protected TXN_TYPE_type1 localTXN_TYPE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTXN_TYPETracker = false;

    /**
     * field for TXN_TYPE_DESC
     */
    protected com.nhry.webService.client.VipDetailData.functions.TXN_TYPE_DESC_type1 localTXN_TYPE_DESC;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTXN_TYPE_DESCTracker = false;

    /**
     * field for TXN_REASON
     */
    protected TXN_REASON_type1 localTXN_REASON;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTXN_REASONTracker = false;

    /**
     * field for TXN_REASON_DESC
     */
    protected com.nhry.webService.client.VipDetailData.functions.TXN_REASON_DESC_type1 localTXN_REASON_DESC;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTXN_REASON_DESCTracker = false;

    /**
     * field for QUAL_TYPE
     */
    protected QUAL_TYPE_type1 localQUAL_TYPE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localQUAL_TYPETracker = false;

    /**
     * field for QUAL_TYPE_DESC
     */
    protected com.nhry.webService.client.VipDetailData.functions.QUAL_TYPE_DESC_type1 localQUAL_TYPE_DESC;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localQUAL_TYPE_DESCTracker = false;

    /**
     * field for EXPIRY_DATE
     */
    protected Date localEXPIRY_DATE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localEXPIRY_DATETracker = false;

    /**
     * field for MEMB_ID
     */
    protected MEMB_ID_type3 localMEMB_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMEMB_IDTracker = false;

    /**
     * field for ACTIVITY_ID
     */
    protected ACTIVITY_ID_type1 localACTIVITY_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localACTIVITY_IDTracker = false;

    /**
     * field for POINTS
     */
    protected POINTS_type1 localPOINTS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPOINTSTracker = false;

    /**
     * field for QUAL_POINTS
     */
    protected QUAL_POINTS_type1 localQUAL_POINTS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localQUAL_POINTSTracker = false;

    public boolean isPOSTING_DATESpecified() {
        return localPOSTING_DATETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.POSTING_DATE_type1
     */
    public POSTING_DATE_type1 getPOSTING_DATE() {
        return localPOSTING_DATE;
    }

    /**
     * Auto generated setter method
     * @param param POSTING_DATE
     */
    public void setPOSTING_DATE(
        POSTING_DATE_type1 param) {
        localPOSTING_DATETracker = param != null;

        this.localPOSTING_DATE = param;
    }

    public boolean isTXN_TYPESpecified() {
        return localTXN_TYPETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.TXN_TYPE_type1
     */
    public TXN_TYPE_type1 getTXN_TYPE() {
        return localTXN_TYPE;
    }

    /**
     * Auto generated setter method
     * @param param TXN_TYPE
     */
    public void setTXN_TYPE(
        TXN_TYPE_type1 param) {
        localTXN_TYPETracker = param != null;

        this.localTXN_TYPE = param;
    }

    public boolean isTXN_TYPE_DESCSpecified() {
        return localTXN_TYPE_DESCTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.TXN_TYPE_DESC_type1
     */
    public com.nhry.webService.client.VipDetailData.functions.TXN_TYPE_DESC_type1 getTXN_TYPE_DESC() {
        return localTXN_TYPE_DESC;
    }

    /**
     * Auto generated setter method
     * @param param TXN_TYPE_DESC
     */
    public void setTXN_TYPE_DESC(
        com.nhry.webService.client.VipDetailData.functions.TXN_TYPE_DESC_type1 param) {
        localTXN_TYPE_DESCTracker = param != null;

        this.localTXN_TYPE_DESC = param;
    }

    public boolean isTXN_REASONSpecified() {
        return localTXN_REASONTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.TXN_REASON_type1
     */
    public TXN_REASON_type1 getTXN_REASON() {
        return localTXN_REASON;
    }

    /**
     * Auto generated setter method
     * @param param TXN_REASON
     */
    public void setTXN_REASON(
        TXN_REASON_type1 param) {
        localTXN_REASONTracker = param != null;

        this.localTXN_REASON = param;
    }

    public boolean isTXN_REASON_DESCSpecified() {
        return localTXN_REASON_DESCTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.TXN_REASON_DESC_type1
     */
    public com.nhry.webService.client.VipDetailData.functions.TXN_REASON_DESC_type1 getTXN_REASON_DESC() {
        return localTXN_REASON_DESC;
    }

    /**
     * Auto generated setter method
     * @param param TXN_REASON_DESC
     */
    public void setTXN_REASON_DESC(
        com.nhry.webService.client.VipDetailData.functions.TXN_REASON_DESC_type1 param) {
        localTXN_REASON_DESCTracker = param != null;

        this.localTXN_REASON_DESC = param;
    }

    public boolean isQUAL_TYPESpecified() {
        return localQUAL_TYPETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.QUAL_TYPE_type1
     */
    public QUAL_TYPE_type1 getQUAL_TYPE() {
        return localQUAL_TYPE;
    }

    /**
     * Auto generated setter method
     * @param param QUAL_TYPE
     */
    public void setQUAL_TYPE(
        QUAL_TYPE_type1 param) {
        localQUAL_TYPETracker = param != null;

        this.localQUAL_TYPE = param;
    }

    public boolean isQUAL_TYPE_DESCSpecified() {
        return localQUAL_TYPE_DESCTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.QUAL_TYPE_DESC_type1
     */
    public com.nhry.webService.client.VipDetailData.functions.QUAL_TYPE_DESC_type1 getQUAL_TYPE_DESC() {
        return localQUAL_TYPE_DESC;
    }

    /**
     * Auto generated setter method
     * @param param QUAL_TYPE_DESC
     */
    public void setQUAL_TYPE_DESC(
        com.nhry.webService.client.VipDetailData.functions.QUAL_TYPE_DESC_type1 param) {
        localQUAL_TYPE_DESCTracker = param != null;

        this.localQUAL_TYPE_DESC = param;
    }

    public boolean isEXPIRY_DATESpecified() {
        return localEXPIRY_DATETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.Date
     */
    public Date getEXPIRY_DATE() {
        return localEXPIRY_DATE;
    }

    /**
     * Auto generated setter method
     * @param param EXPIRY_DATE
     */
    public void setEXPIRY_DATE(
        Date param) {
        localEXPIRY_DATETracker = param != null;

        this.localEXPIRY_DATE = param;
    }

    public boolean isMEMB_IDSpecified() {
        return localMEMB_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.MEMB_ID_type3
     */
    public MEMB_ID_type3 getMEMB_ID() {
        return localMEMB_ID;
    }

    /**
     * Auto generated setter method
     * @param param MEMB_ID
     */
    public void setMEMB_ID(
        MEMB_ID_type3 param) {
        localMEMB_IDTracker = param != null;

        this.localMEMB_ID = param;
    }

    public boolean isACTIVITY_IDSpecified() {
        return localACTIVITY_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.ACTIVITY_ID_type1
     */
    public ACTIVITY_ID_type1 getACTIVITY_ID() {
        return localACTIVITY_ID;
    }

    /**
     * Auto generated setter method
     * @param param ACTIVITY_ID
     */
    public void setACTIVITY_ID(
        ACTIVITY_ID_type1 param) {
        localACTIVITY_IDTracker = param != null;

        this.localACTIVITY_ID = param;
    }

    public boolean isPOINTSSpecified() {
        return localPOINTSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.POINTS_type1
     */
    public POINTS_type1 getPOINTS() {
        return localPOINTS;
    }

    /**
     * Auto generated setter method
     * @param param POINTS
     */
    public void setPOINTS(
        POINTS_type1 param) {
        localPOINTSTracker = param != null;

        this.localPOINTS = param;
    }

    public boolean isQUAL_POINTSSpecified() {
        return localQUAL_POINTSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipDetailData.functions.QUAL_POINTS_type1
     */
    public QUAL_POINTS_type1 getQUAL_POINTS() {
        return localQUAL_POINTS;
    }

    /**
     * Auto generated setter method
     * @param param QUAL_POINTS
     */
    public void setQUAL_POINTS(
        QUAL_POINTS_type1 param) {
        localQUAL_POINTSTracker = param != null;

        this.localQUAL_POINTS = param;
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
                    namespacePrefix + ":ZSCRM_TRANSACTIONS", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSCRM_TRANSACTIONS", xmlWriter);
            }
        }

        if (localPOSTING_DATETracker) {
            if (localPOSTING_DATE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "POSTING_DATE cannot be null!!");
            }

            localPOSTING_DATE.serialize(new javax.xml.namespace.QName("",
                    "POSTING_DATE"), xmlWriter);
        }

        if (localTXN_TYPETracker) {
            if (localTXN_TYPE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TXN_TYPE cannot be null!!");
            }

            localTXN_TYPE.serialize(new javax.xml.namespace.QName("", "TXN_TYPE"),
                xmlWriter);
        }

        if (localTXN_TYPE_DESCTracker) {
            if (localTXN_TYPE_DESC == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TXN_TYPE_DESC cannot be null!!");
            }

            localTXN_TYPE_DESC.serialize(new javax.xml.namespace.QName("",
                    "TXN_TYPE_DESC"), xmlWriter);
        }

        if (localTXN_REASONTracker) {
            if (localTXN_REASON == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TXN_REASON cannot be null!!");
            }

            localTXN_REASON.serialize(new javax.xml.namespace.QName("",
                    "TXN_REASON"), xmlWriter);
        }

        if (localTXN_REASON_DESCTracker) {
            if (localTXN_REASON_DESC == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TXN_REASON_DESC cannot be null!!");
            }

            localTXN_REASON_DESC.serialize(new javax.xml.namespace.QName("",
                    "TXN_REASON_DESC"), xmlWriter);
        }

        if (localQUAL_TYPETracker) {
            if (localQUAL_TYPE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "QUAL_TYPE cannot be null!!");
            }

            localQUAL_TYPE.serialize(new javax.xml.namespace.QName("",
                    "QUAL_TYPE"), xmlWriter);
        }

        if (localQUAL_TYPE_DESCTracker) {
            if (localQUAL_TYPE_DESC == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "QUAL_TYPE_DESC cannot be null!!");
            }

            localQUAL_TYPE_DESC.serialize(new javax.xml.namespace.QName("",
                    "QUAL_TYPE_DESC"), xmlWriter);
        }

        if (localEXPIRY_DATETracker) {
            if (localEXPIRY_DATE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "EXPIRY_DATE cannot be null!!");
            }

            localEXPIRY_DATE.serialize(new javax.xml.namespace.QName("",
                    "EXPIRY_DATE"), xmlWriter);
        }

        if (localMEMB_IDTracker) {
            if (localMEMB_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MEMB_ID cannot be null!!");
            }

            localMEMB_ID.serialize(new javax.xml.namespace.QName("", "MEMB_ID"),
                xmlWriter);
        }

        if (localACTIVITY_IDTracker) {
            if (localACTIVITY_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ACTIVITY_ID cannot be null!!");
            }

            localACTIVITY_ID.serialize(new javax.xml.namespace.QName("",
                    "ACTIVITY_ID"), xmlWriter);
        }

        if (localPOINTSTracker) {
            if (localPOINTS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "POINTS cannot be null!!");
            }

            localPOINTS.serialize(new javax.xml.namespace.QName("", "POINTS"),
                xmlWriter);
        }

        if (localQUAL_POINTSTracker) {
            if (localQUAL_POINTS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "QUAL_POINTS cannot be null!!");
            }

            localQUAL_POINTS.serialize(new javax.xml.namespace.QName("",
                    "QUAL_POINTS"), xmlWriter);
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
        public static ZSCRM_TRANSACTIONS parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            ZSCRM_TRANSACTIONS object = new ZSCRM_TRANSACTIONS();

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

                        if (!"ZSCRM_TRANSACTIONS".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSCRM_TRANSACTIONS) ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "POSTING_DATE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "POSTING_DATE").equals(
                            reader.getName())) {
                    object.setPOSTING_DATE(POSTING_DATE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TXN_TYPE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TXN_TYPE").equals(
                            reader.getName())) {
                    object.setTXN_TYPE(TXN_TYPE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TXN_TYPE_DESC").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TXN_TYPE_DESC").equals(
                            reader.getName())) {
                    object.setTXN_TYPE_DESC(com.nhry.webService.client.VipDetailData.functions.TXN_TYPE_DESC_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TXN_REASON").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TXN_REASON").equals(
                            reader.getName())) {
                    object.setTXN_REASON(TXN_REASON_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TXN_REASON_DESC").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TXN_REASON_DESC").equals(
                            reader.getName())) {
                    object.setTXN_REASON_DESC(com.nhry.webService.client.VipDetailData.functions.TXN_REASON_DESC_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "QUAL_TYPE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "QUAL_TYPE").equals(
                            reader.getName())) {
                    object.setQUAL_TYPE(QUAL_TYPE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "QUAL_TYPE_DESC").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "QUAL_TYPE_DESC").equals(
                            reader.getName())) {
                    object.setQUAL_TYPE_DESC(com.nhry.webService.client.VipDetailData.functions.QUAL_TYPE_DESC_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "EXPIRY_DATE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "EXPIRY_DATE").equals(
                            reader.getName())) {
                    object.setEXPIRY_DATE(Date.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MEMB_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MEMB_ID").equals(
                            reader.getName())) {
                    object.setMEMB_ID(MEMB_ID_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "ACTIVITY_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ACTIVITY_ID").equals(
                            reader.getName())) {
                    object.setACTIVITY_ID(ACTIVITY_ID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "POINTS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "POINTS").equals(
                            reader.getName())) {
                    object.setPOINTS(POINTS_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "QUAL_POINTS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "QUAL_POINTS").equals(
                            reader.getName())) {
                    object.setQUAL_POINTS(QUAL_POINTS_type1.Factory.parse(
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
