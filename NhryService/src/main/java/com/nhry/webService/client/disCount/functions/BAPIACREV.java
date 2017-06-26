/**
 * BAPIACREV.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.disCount.functions;


/**
 *  BAPIACREV bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class BAPIACREV implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = BAPIACREV
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for OBJ_TYPE
     */
    protected com.nhry.webService.client.disCount.functions.OBJ_TYPE_type1 localOBJ_TYPE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localOBJ_TYPETracker = false;

    /**
     * field for OBJ_KEY
     */
    protected com.nhry.webService.client.disCount.functions.OBJ_KEY_type1 localOBJ_KEY;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localOBJ_KEYTracker = false;

    /**
     * field for OBJ_SYS
     */
    protected com.nhry.webService.client.disCount.functions.OBJ_SYS_type1 localOBJ_SYS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localOBJ_SYSTracker = false;

    /**
     * field for OBJ_KEY_R
     */
    protected com.nhry.webService.client.disCount.functions.OBJ_KEY_R_type1 localOBJ_KEY_R;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localOBJ_KEY_RTracker = false;

    /**
     * field for PSTNG_DATE
     */
    protected Date localPSTNG_DATE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPSTNG_DATETracker = false;

    /**
     * field for FIS_PERIOD
     */
    protected com.nhry.webService.client.disCount.functions.FIS_PERIOD_type1 localFIS_PERIOD;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localFIS_PERIODTracker = false;

    /**
     * field for COMP_CODE
     */
    protected com.nhry.webService.client.disCount.functions.COMP_CODE_type1 localCOMP_CODE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCOMP_CODETracker = false;

    /**
     * field for REASON_REV
     */
    protected com.nhry.webService.client.disCount.functions.REASON_REV_type1 localREASON_REV;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localREASON_REVTracker = false;

    /**
     * field for AC_DOC_NO
     */
    protected com.nhry.webService.client.disCount.functions.AC_DOC_NO_type1 localAC_DOC_NO;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localAC_DOC_NOTracker = false;

    /**
     * field for ACC_PRINCIPLE
     */
    protected com.nhry.webService.client.disCount.functions.ACC_PRINCIPLE_type1 localACC_PRINCIPLE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localACC_PRINCIPLETracker = false;

    public boolean isOBJ_TYPESpecified() {
        return localOBJ_TYPETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.OBJ_TYPE_type1
     */
    public com.nhry.webService.client.disCount.functions.OBJ_TYPE_type1 getOBJ_TYPE() {
        return localOBJ_TYPE;
    }

    /**
     * Auto generated setter method
     * @param param OBJ_TYPE
     */
    public void setOBJ_TYPE(
        com.nhry.webService.client.disCount.functions.OBJ_TYPE_type1 param) {
        localOBJ_TYPETracker = param != null;

        this.localOBJ_TYPE = param;
    }

    public boolean isOBJ_KEYSpecified() {
        return localOBJ_KEYTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.OBJ_KEY_type1
     */
    public com.nhry.webService.client.disCount.functions.OBJ_KEY_type1 getOBJ_KEY() {
        return localOBJ_KEY;
    }

    /**
     * Auto generated setter method
     * @param param OBJ_KEY
     */
    public void setOBJ_KEY(
        com.nhry.webService.client.disCount.functions.OBJ_KEY_type1 param) {
        localOBJ_KEYTracker = param != null;

        this.localOBJ_KEY = param;
    }

    public boolean isOBJ_SYSSpecified() {
        return localOBJ_SYSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.OBJ_SYS_type1
     */
    public com.nhry.webService.client.disCount.functions.OBJ_SYS_type1 getOBJ_SYS() {
        return localOBJ_SYS;
    }

    /**
     * Auto generated setter method
     * @param param OBJ_SYS
     */
    public void setOBJ_SYS(
        com.nhry.webService.client.disCount.functions.OBJ_SYS_type1 param) {
        localOBJ_SYSTracker = param != null;

        this.localOBJ_SYS = param;
    }

    public boolean isOBJ_KEY_RSpecified() {
        return localOBJ_KEY_RTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.OBJ_KEY_R_type1
     */
    public com.nhry.webService.client.disCount.functions.OBJ_KEY_R_type1 getOBJ_KEY_R() {
        return localOBJ_KEY_R;
    }

    /**
     * Auto generated setter method
     * @param param OBJ_KEY_R
     */
    public void setOBJ_KEY_R(
        com.nhry.webService.client.disCount.functions.OBJ_KEY_R_type1 param) {
        localOBJ_KEY_RTracker = param != null;

        this.localOBJ_KEY_R = param;
    }

    public boolean isPSTNG_DATESpecified() {
        return localPSTNG_DATETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.Date
     */
    public Date getPSTNG_DATE() {
        return localPSTNG_DATE;
    }

    /**
     * Auto generated setter method
     * @param param PSTNG_DATE
     */
    public void setPSTNG_DATE(
        Date param) {
        localPSTNG_DATETracker = param != null;

        this.localPSTNG_DATE = param;
    }

    public boolean isFIS_PERIODSpecified() {
        return localFIS_PERIODTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.FIS_PERIOD_type1
     */
    public com.nhry.webService.client.disCount.functions.FIS_PERIOD_type1 getFIS_PERIOD() {
        return localFIS_PERIOD;
    }

    /**
     * Auto generated setter method
     * @param param FIS_PERIOD
     */
    public void setFIS_PERIOD(
        com.nhry.webService.client.disCount.functions.FIS_PERIOD_type1 param) {
        localFIS_PERIODTracker = param != null;

        this.localFIS_PERIOD = param;
    }

    public boolean isCOMP_CODESpecified() {
        return localCOMP_CODETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.COMP_CODE_type1
     */
    public com.nhry.webService.client.disCount.functions.COMP_CODE_type1 getCOMP_CODE() {
        return localCOMP_CODE;
    }

    /**
     * Auto generated setter method
     * @param param COMP_CODE
     */
    public void setCOMP_CODE(
        com.nhry.webService.client.disCount.functions.COMP_CODE_type1 param) {
        localCOMP_CODETracker = param != null;

        this.localCOMP_CODE = param;
    }

    public boolean isREASON_REVSpecified() {
        return localREASON_REVTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.REASON_REV_type1
     */
    public com.nhry.webService.client.disCount.functions.REASON_REV_type1 getREASON_REV() {
        return localREASON_REV;
    }

    /**
     * Auto generated setter method
     * @param param REASON_REV
     */
    public void setREASON_REV(
        com.nhry.webService.client.disCount.functions.REASON_REV_type1 param) {
        localREASON_REVTracker = param != null;

        this.localREASON_REV = param;
    }

    public boolean isAC_DOC_NOSpecified() {
        return localAC_DOC_NOTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.AC_DOC_NO_type1
     */
    public com.nhry.webService.client.disCount.functions.AC_DOC_NO_type1 getAC_DOC_NO() {
        return localAC_DOC_NO;
    }

    /**
     * Auto generated setter method
     * @param param AC_DOC_NO
     */
    public void setAC_DOC_NO(
        com.nhry.webService.client.disCount.functions.AC_DOC_NO_type1 param) {
        localAC_DOC_NOTracker = param != null;

        this.localAC_DOC_NO = param;
    }

    public boolean isACC_PRINCIPLESpecified() {
        return localACC_PRINCIPLETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.ACC_PRINCIPLE_type1
     */
    public com.nhry.webService.client.disCount.functions.ACC_PRINCIPLE_type1 getACC_PRINCIPLE() {
        return localACC_PRINCIPLE;
    }

    /**
     * Auto generated setter method
     * @param param ACC_PRINCIPLE
     */
    public void setACC_PRINCIPLE(
        com.nhry.webService.client.disCount.functions.ACC_PRINCIPLE_type1 param) {
        localACC_PRINCIPLETracker = param != null;

        this.localACC_PRINCIPLE = param;
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
                    namespacePrefix + ":BAPIACREV", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "BAPIACREV", xmlWriter);
            }
        }

        if (localOBJ_TYPETracker) {
            if (localOBJ_TYPE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "OBJ_TYPE cannot be null!!");
            }

            localOBJ_TYPE.serialize(new javax.xml.namespace.QName("", "OBJ_TYPE"),
                xmlWriter);
        }

        if (localOBJ_KEYTracker) {
            if (localOBJ_KEY == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "OBJ_KEY cannot be null!!");
            }

            localOBJ_KEY.serialize(new javax.xml.namespace.QName("", "OBJ_KEY"),
                xmlWriter);
        }

        if (localOBJ_SYSTracker) {
            if (localOBJ_SYS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "OBJ_SYS cannot be null!!");
            }

            localOBJ_SYS.serialize(new javax.xml.namespace.QName("", "OBJ_SYS"),
                xmlWriter);
        }

        if (localOBJ_KEY_RTracker) {
            if (localOBJ_KEY_R == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "OBJ_KEY_R cannot be null!!");
            }

            localOBJ_KEY_R.serialize(new javax.xml.namespace.QName("",
                    "OBJ_KEY_R"), xmlWriter);
        }

        if (localPSTNG_DATETracker) {
            if (localPSTNG_DATE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PSTNG_DATE cannot be null!!");
            }

            localPSTNG_DATE.serialize(new javax.xml.namespace.QName("",
                    "PSTNG_DATE"), xmlWriter);
        }

        if (localFIS_PERIODTracker) {
            if (localFIS_PERIOD == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "FIS_PERIOD cannot be null!!");
            }

            localFIS_PERIOD.serialize(new javax.xml.namespace.QName("",
                    "FIS_PERIOD"), xmlWriter);
        }

        if (localCOMP_CODETracker) {
            if (localCOMP_CODE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "COMP_CODE cannot be null!!");
            }

            localCOMP_CODE.serialize(new javax.xml.namespace.QName("",
                    "COMP_CODE"), xmlWriter);
        }

        if (localREASON_REVTracker) {
            if (localREASON_REV == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "REASON_REV cannot be null!!");
            }

            localREASON_REV.serialize(new javax.xml.namespace.QName("",
                    "REASON_REV"), xmlWriter);
        }

        if (localAC_DOC_NOTracker) {
            if (localAC_DOC_NO == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "AC_DOC_NO cannot be null!!");
            }

            localAC_DOC_NO.serialize(new javax.xml.namespace.QName("",
                    "AC_DOC_NO"), xmlWriter);
        }

        if (localACC_PRINCIPLETracker) {
            if (localACC_PRINCIPLE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ACC_PRINCIPLE cannot be null!!");
            }

            localACC_PRINCIPLE.serialize(new javax.xml.namespace.QName("",
                    "ACC_PRINCIPLE"), xmlWriter);
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
        public static BAPIACREV parse(javax.xml.stream.XMLStreamReader reader)
            throws Exception {
            BAPIACREV object = new BAPIACREV();

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

                        if (!"BAPIACREV".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (BAPIACREV) com.nhry.webService.client.disCount.functions.ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "OBJ_TYPE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "OBJ_TYPE").equals(
                            reader.getName())) {
                    object.setOBJ_TYPE(com.nhry.webService.client.disCount.functions.OBJ_TYPE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "OBJ_KEY").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "OBJ_KEY").equals(
                            reader.getName())) {
                    object.setOBJ_KEY(com.nhry.webService.client.disCount.functions.OBJ_KEY_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "OBJ_SYS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "OBJ_SYS").equals(
                            reader.getName())) {
                    object.setOBJ_SYS(com.nhry.webService.client.disCount.functions.OBJ_SYS_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "OBJ_KEY_R").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "OBJ_KEY_R").equals(
                            reader.getName())) {
                    object.setOBJ_KEY_R(com.nhry.webService.client.disCount.functions.OBJ_KEY_R_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PSTNG_DATE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PSTNG_DATE").equals(
                            reader.getName())) {
                    object.setPSTNG_DATE(Date.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "FIS_PERIOD").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "FIS_PERIOD").equals(
                            reader.getName())) {
                    object.setFIS_PERIOD(com.nhry.webService.client.disCount.functions.FIS_PERIOD_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "COMP_CODE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "COMP_CODE").equals(
                            reader.getName())) {
                    object.setCOMP_CODE(com.nhry.webService.client.disCount.functions.COMP_CODE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "REASON_REV").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "REASON_REV").equals(
                            reader.getName())) {
                    object.setREASON_REV(com.nhry.webService.client.disCount.functions.REASON_REV_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "AC_DOC_NO").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "AC_DOC_NO").equals(
                            reader.getName())) {
                    object.setAC_DOC_NO(com.nhry.webService.client.disCount.functions.AC_DOC_NO_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "ACC_PRINCIPLE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ACC_PRINCIPLE").equals(
                            reader.getName())) {
                    object.setACC_PRINCIPLE(com.nhry.webService.client.disCount.functions.ACC_PRINCIPLE_type1.Factory.parse(
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
