/**
 * ZSCRM_SNG_TS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.VipInfoData.functions;


/**
 *  ZSCRM_SNG_TS bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSCRM_SNG_TS implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSCRM_SNG_TS
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for SALES_ORG
     */
    protected SALES_ORG_type3 localSALES_ORG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSALES_ORGTracker = false;

    /**
     * field for ZZOBJECT_ID
     */
    protected ZZOBJECT_ID_type1 localZZOBJECT_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localZZOBJECT_IDTracker = false;

    /**
     * field for CATEGORY1
     */
    protected CATEGORY1_type1 localCATEGORY1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCATEGORY1Tracker = false;

    /**
     * field for CATEGORY2
     */
    protected CATEGORY2_type1 localCATEGORY2;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCATEGORY2Tracker = false;

    /**
     * field for CATEGORY3
     */
    protected CATEGORY3_type1 localCATEGORY3;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCATEGORY3Tracker = false;

    /**
     * field for NZBH
     */
    protected NZBH_type3 localNZBH;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localNZBHTracker = false;

    /**
     * field for SNGBH
     */
    protected SNGBH_type3 localSNGBH;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSNGBHTracker = false;

    /**
     * field for DESCRIPTION
     */
    protected DESCRIPTION_type1 localDESCRIPTION;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localDESCRIPTIONTracker = false;

    /**
     * field for CREATE_DATE
     */
    protected Date localCREATE_DATE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCREATE_DATETracker = false;

    public boolean isSALES_ORGSpecified() {
        return localSALES_ORGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.SALES_ORG_type3
     */
    public SALES_ORG_type3 getSALES_ORG() {
        return localSALES_ORG;
    }

    /**
     * Auto generated setter method
     * @param param SALES_ORG
     */
    public void setSALES_ORG(
        SALES_ORG_type3 param) {
        localSALES_ORGTracker = param != null;

        this.localSALES_ORG = param;
    }

    public boolean isZZOBJECT_IDSpecified() {
        return localZZOBJECT_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.ZZOBJECT_ID_type1
     */
    public ZZOBJECT_ID_type1 getZZOBJECT_ID() {
        return localZZOBJECT_ID;
    }

    /**
     * Auto generated setter method
     * @param param ZZOBJECT_ID
     */
    public void setZZOBJECT_ID(
        ZZOBJECT_ID_type1 param) {
        localZZOBJECT_IDTracker = param != null;

        this.localZZOBJECT_ID = param;
    }

    public boolean isCATEGORY1Specified() {
        return localCATEGORY1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.CATEGORY1_type1
     */
    public CATEGORY1_type1 getCATEGORY1() {
        return localCATEGORY1;
    }

    /**
     * Auto generated setter method
     * @param param CATEGORY1
     */
    public void setCATEGORY1(
        CATEGORY1_type1 param) {
        localCATEGORY1Tracker = param != null;

        this.localCATEGORY1 = param;
    }

    public boolean isCATEGORY2Specified() {
        return localCATEGORY2Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.CATEGORY2_type1
     */
    public CATEGORY2_type1 getCATEGORY2() {
        return localCATEGORY2;
    }

    /**
     * Auto generated setter method
     * @param param CATEGORY2
     */
    public void setCATEGORY2(
        CATEGORY2_type1 param) {
        localCATEGORY2Tracker = param != null;

        this.localCATEGORY2 = param;
    }

    public boolean isCATEGORY3Specified() {
        return localCATEGORY3Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.CATEGORY3_type1
     */
    public CATEGORY3_type1 getCATEGORY3() {
        return localCATEGORY3;
    }

    /**
     * Auto generated setter method
     * @param param CATEGORY3
     */
    public void setCATEGORY3(
        CATEGORY3_type1 param) {
        localCATEGORY3Tracker = param != null;

        this.localCATEGORY3 = param;
    }

    public boolean isNZBHSpecified() {
        return localNZBHTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.NZBH_type3
     */
    public NZBH_type3 getNZBH() {
        return localNZBH;
    }

    /**
     * Auto generated setter method
     * @param param NZBH
     */
    public void setNZBH(
        NZBH_type3 param) {
        localNZBHTracker = param != null;

        this.localNZBH = param;
    }

    public boolean isSNGBHSpecified() {
        return localSNGBHTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.SNGBH_type3
     */
    public SNGBH_type3 getSNGBH() {
        return localSNGBH;
    }

    /**
     * Auto generated setter method
     * @param param SNGBH
     */
    public void setSNGBH(
        SNGBH_type3 param) {
        localSNGBHTracker = param != null;

        this.localSNGBH = param;
    }

    public boolean isDESCRIPTIONSpecified() {
        return localDESCRIPTIONTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.DESCRIPTION_type1
     */
    public DESCRIPTION_type1 getDESCRIPTION() {
        return localDESCRIPTION;
    }

    /**
     * Auto generated setter method
     * @param param DESCRIPTION
     */
    public void setDESCRIPTION(
        DESCRIPTION_type1 param) {
        localDESCRIPTIONTracker = param != null;

        this.localDESCRIPTION = param;
    }

    public boolean isCREATE_DATESpecified() {
        return localCREATE_DATETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.Date
     */
    public Date getCREATE_DATE() {
        return localCREATE_DATE;
    }

    /**
     * Auto generated setter method
     * @param param CREATE_DATE
     */
    public void setCREATE_DATE(
        Date param) {
        localCREATE_DATETracker = param != null;

        this.localCREATE_DATE = param;
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
                    namespacePrefix + ":ZSCRM_SNG_TS", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSCRM_SNG_TS", xmlWriter);
            }
        }

        if (localSALES_ORGTracker) {
            if (localSALES_ORG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SALES_ORG cannot be null!!");
            }

            localSALES_ORG.serialize(new javax.xml.namespace.QName("",
                    "SALES_ORG"), xmlWriter);
        }

        if (localZZOBJECT_IDTracker) {
            if (localZZOBJECT_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ZZOBJECT_ID cannot be null!!");
            }

            localZZOBJECT_ID.serialize(new javax.xml.namespace.QName("",
                    "ZZOBJECT_ID"), xmlWriter);
        }

        if (localCATEGORY1Tracker) {
            if (localCATEGORY1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CATEGORY1 cannot be null!!");
            }

            localCATEGORY1.serialize(new javax.xml.namespace.QName("",
                    "CATEGORY1"), xmlWriter);
        }

        if (localCATEGORY2Tracker) {
            if (localCATEGORY2 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CATEGORY2 cannot be null!!");
            }

            localCATEGORY2.serialize(new javax.xml.namespace.QName("",
                    "CATEGORY2"), xmlWriter);
        }

        if (localCATEGORY3Tracker) {
            if (localCATEGORY3 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CATEGORY3 cannot be null!!");
            }

            localCATEGORY3.serialize(new javax.xml.namespace.QName("",
                    "CATEGORY3"), xmlWriter);
        }

        if (localNZBHTracker) {
            if (localNZBH == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NZBH cannot be null!!");
            }

            localNZBH.serialize(new javax.xml.namespace.QName("", "NZBH"),
                xmlWriter);
        }

        if (localSNGBHTracker) {
            if (localSNGBH == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SNGBH cannot be null!!");
            }

            localSNGBH.serialize(new javax.xml.namespace.QName("", "SNGBH"),
                xmlWriter);
        }

        if (localDESCRIPTIONTracker) {
            if (localDESCRIPTION == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "DESCRIPTION cannot be null!!");
            }

            localDESCRIPTION.serialize(new javax.xml.namespace.QName("",
                    "DESCRIPTION"), xmlWriter);
        }

        if (localCREATE_DATETracker) {
            if (localCREATE_DATE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CREATE_DATE cannot be null!!");
            }

            localCREATE_DATE.serialize(new javax.xml.namespace.QName("",
                    "CREATE_DATE"), xmlWriter);
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
        public static ZSCRM_SNG_TS parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            ZSCRM_SNG_TS object = new ZSCRM_SNG_TS();

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

                        if (!"ZSCRM_SNG_TS".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSCRM_SNG_TS) ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "SALES_ORG").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "SALES_ORG").equals(
                            reader.getName())) {
                    object.setSALES_ORG(SALES_ORG_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "ZZOBJECT_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ZZOBJECT_ID").equals(
                            reader.getName())) {
                    object.setZZOBJECT_ID(ZZOBJECT_ID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "CATEGORY1").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "CATEGORY1").equals(
                            reader.getName())) {
                    object.setCATEGORY1(CATEGORY1_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "CATEGORY2").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "CATEGORY2").equals(
                            reader.getName())) {
                    object.setCATEGORY2(CATEGORY2_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "CATEGORY3").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "CATEGORY3").equals(
                            reader.getName())) {
                    object.setCATEGORY3(CATEGORY3_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "NZBH").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "NZBH").equals(
                            reader.getName())) {
                    object.setNZBH(NZBH_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "SNGBH").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "SNGBH").equals(
                            reader.getName())) {
                    object.setSNGBH(SNGBH_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "DESCRIPTION").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "DESCRIPTION").equals(
                            reader.getName())) {
                    object.setDESCRIPTION(DESCRIPTION_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "CREATE_DATE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "CREATE_DATE").equals(
                            reader.getName())) {
                    object.setCREATE_DATE(Date.Factory.parse(
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
