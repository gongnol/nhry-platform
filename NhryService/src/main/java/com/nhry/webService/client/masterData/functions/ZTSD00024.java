/**
 * ZTSD00024.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.masterData.functions;


/**
 *  ZTSD00024 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZTSD00024 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZTSD00024
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for MANDT
     */
    protected com.nhry.webService.client.masterData.functions.MANDT_type15 localMANDT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMANDTTracker = false;

    /**
     * field for BUKRS
     */
    protected com.nhry.webService.client.masterData.functions.BUKRS_type7 localBUKRS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBUKRSTracker = false;

    /**
     * field for POSNR
     */
    protected com.nhry.webService.client.masterData.functions.POSNR_type3 localPOSNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPOSNRTracker = false;

    /**
     * field for MATNR
     */
    protected com.nhry.webService.client.masterData.functions.MATNR_type11 localMATNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMATNRTracker = false;

    /**
     * field for PRODH
     */
    protected com.nhry.webService.client.masterData.functions.PRODH_type1 localPRODH;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPRODHTracker = false;

    /**
     * field for KUNNR1
     */
    protected com.nhry.webService.client.masterData.functions.KUNNR1_type1 localKUNNR1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKUNNR1Tracker = false;

    /**
     * field for KUNNR2
     */
    protected com.nhry.webService.client.masterData.functions.KUNNR2_type1 localKUNNR2;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKUNNR2Tracker = false;

    /**
     * field for LGORT
     */
    protected com.nhry.webService.client.masterData.functions.LGORT_type1 localLGORT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLGORTTracker = false;

    /**
     * field for VKBUR
     */
    protected com.nhry.webService.client.masterData.functions.VKBUR_type1 localVKBUR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVKBURTracker = false;

    public boolean isMANDTSpecified() {
        return localMANDTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MANDT_type15
     */
    public com.nhry.webService.client.masterData.functions.MANDT_type15 getMANDT() {
        return localMANDT;
    }

    /**
     * Auto generated setter method
     * @param param MANDT
     */
    public void setMANDT(
        com.nhry.webService.client.masterData.functions.MANDT_type15 param) {
        localMANDTTracker = param != null;

        this.localMANDT = param;
    }

    public boolean isBUKRSSpecified() {
        return localBUKRSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.BUKRS_type7
     */
    public com.nhry.webService.client.masterData.functions.BUKRS_type7 getBUKRS() {
        return localBUKRS;
    }

    /**
     * Auto generated setter method
     * @param param BUKRS
     */
    public void setBUKRS(
        com.nhry.webService.client.masterData.functions.BUKRS_type7 param) {
        localBUKRSTracker = param != null;

        this.localBUKRS = param;
    }

    public boolean isPOSNRSpecified() {
        return localPOSNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.POSNR_type3
     */
    public com.nhry.webService.client.masterData.functions.POSNR_type3 getPOSNR() {
        return localPOSNR;
    }

    /**
     * Auto generated setter method
     * @param param POSNR
     */
    public void setPOSNR(
        com.nhry.webService.client.masterData.functions.POSNR_type3 param) {
        localPOSNRTracker = param != null;

        this.localPOSNR = param;
    }

    public boolean isMATNRSpecified() {
        return localMATNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MATNR_type11
     */
    public com.nhry.webService.client.masterData.functions.MATNR_type11 getMATNR() {
        return localMATNR;
    }

    /**
     * Auto generated setter method
     * @param param MATNR
     */
    public void setMATNR(
        com.nhry.webService.client.masterData.functions.MATNR_type11 param) {
        localMATNRTracker = param != null;

        this.localMATNR = param;
    }

    public boolean isPRODHSpecified() {
        return localPRODHTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.PRODH_type1
     */
    public com.nhry.webService.client.masterData.functions.PRODH_type1 getPRODH() {
        return localPRODH;
    }

    /**
     * Auto generated setter method
     * @param param PRODH
     */
    public void setPRODH(
        com.nhry.webService.client.masterData.functions.PRODH_type1 param) {
        localPRODHTracker = param != null;

        this.localPRODH = param;
    }

    public boolean isKUNNR1Specified() {
        return localKUNNR1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KUNNR1_type1
     */
    public com.nhry.webService.client.masterData.functions.KUNNR1_type1 getKUNNR1() {
        return localKUNNR1;
    }

    /**
     * Auto generated setter method
     * @param param KUNNR1
     */
    public void setKUNNR1(
        com.nhry.webService.client.masterData.functions.KUNNR1_type1 param) {
        localKUNNR1Tracker = param != null;

        this.localKUNNR1 = param;
    }

    public boolean isKUNNR2Specified() {
        return localKUNNR2Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KUNNR2_type1
     */
    public com.nhry.webService.client.masterData.functions.KUNNR2_type1 getKUNNR2() {
        return localKUNNR2;
    }

    /**
     * Auto generated setter method
     * @param param KUNNR2
     */
    public void setKUNNR2(
        com.nhry.webService.client.masterData.functions.KUNNR2_type1 param) {
        localKUNNR2Tracker = param != null;

        this.localKUNNR2 = param;
    }

    public boolean isLGORTSpecified() {
        return localLGORTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.LGORT_type1
     */
    public com.nhry.webService.client.masterData.functions.LGORT_type1 getLGORT() {
        return localLGORT;
    }

    /**
     * Auto generated setter method
     * @param param LGORT
     */
    public void setLGORT(
        com.nhry.webService.client.masterData.functions.LGORT_type1 param) {
        localLGORTTracker = param != null;

        this.localLGORT = param;
    }

    public boolean isVKBURSpecified() {
        return localVKBURTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.VKBUR_type1
     */
    public com.nhry.webService.client.masterData.functions.VKBUR_type1 getVKBUR() {
        return localVKBUR;
    }

    /**
     * Auto generated setter method
     * @param param VKBUR
     */
    public void setVKBUR(
        com.nhry.webService.client.masterData.functions.VKBUR_type1 param) {
        localVKBURTracker = param != null;

        this.localVKBUR = param;
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
                    namespacePrefix + ":ZTSD00024", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZTSD00024", xmlWriter);
            }
        }

        if (localMANDTTracker) {
            if (localMANDT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MANDT cannot be null!!");
            }

            localMANDT.serialize(new javax.xml.namespace.QName("", "MANDT"),
                xmlWriter);
        }

        if (localBUKRSTracker) {
            if (localBUKRS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BUKRS cannot be null!!");
            }

            localBUKRS.serialize(new javax.xml.namespace.QName("", "BUKRS"),
                xmlWriter);
        }

        if (localPOSNRTracker) {
            if (localPOSNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "POSNR cannot be null!!");
            }

            localPOSNR.serialize(new javax.xml.namespace.QName("", "POSNR"),
                xmlWriter);
        }

        if (localMATNRTracker) {
            if (localMATNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MATNR cannot be null!!");
            }

            localMATNR.serialize(new javax.xml.namespace.QName("", "MATNR"),
                xmlWriter);
        }

        if (localPRODHTracker) {
            if (localPRODH == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PRODH cannot be null!!");
            }

            localPRODH.serialize(new javax.xml.namespace.QName("", "PRODH"),
                xmlWriter);
        }

        if (localKUNNR1Tracker) {
            if (localKUNNR1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KUNNR1 cannot be null!!");
            }

            localKUNNR1.serialize(new javax.xml.namespace.QName("", "KUNNR1"),
                xmlWriter);
        }

        if (localKUNNR2Tracker) {
            if (localKUNNR2 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KUNNR2 cannot be null!!");
            }

            localKUNNR2.serialize(new javax.xml.namespace.QName("", "KUNNR2"),
                xmlWriter);
        }

        if (localLGORTTracker) {
            if (localLGORT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "LGORT cannot be null!!");
            }

            localLGORT.serialize(new javax.xml.namespace.QName("", "LGORT"),
                xmlWriter);
        }

        if (localVKBURTracker) {
            if (localVKBUR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "VKBUR cannot be null!!");
            }

            localVKBUR.serialize(new javax.xml.namespace.QName("", "VKBUR"),
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
        public static ZTSD00024 parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            ZTSD00024 object = new ZTSD00024();

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

                        if (!"ZTSD00024".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZTSD00024) com.nhry.webService.client.masterData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "MANDT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MANDT").equals(
                            reader.getName())) {
                    object.setMANDT(com.nhry.webService.client.masterData.functions.MANDT_type15.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BUKRS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BUKRS").equals(
                            reader.getName())) {
                    object.setBUKRS(com.nhry.webService.client.masterData.functions.BUKRS_type7.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "POSNR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "POSNR").equals(
                            reader.getName())) {
                    object.setPOSNR(com.nhry.webService.client.masterData.functions.POSNR_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MATNR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MATNR").equals(
                            reader.getName())) {
                    object.setMATNR(com.nhry.webService.client.masterData.functions.MATNR_type11.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PRODH").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PRODH").equals(
                            reader.getName())) {
                    object.setPRODH(com.nhry.webService.client.masterData.functions.PRODH_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KUNNR1").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KUNNR1").equals(
                            reader.getName())) {
                    object.setKUNNR1(com.nhry.webService.client.masterData.functions.KUNNR1_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KUNNR2").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KUNNR2").equals(
                            reader.getName())) {
                    object.setKUNNR2(com.nhry.webService.client.masterData.functions.KUNNR2_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "LGORT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "LGORT").equals(
                            reader.getName())) {
                    object.setLGORT(com.nhry.webService.client.masterData.functions.LGORT_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "VKBUR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "VKBUR").equals(
                            reader.getName())) {
                    object.setVKBUR(com.nhry.webService.client.masterData.functions.VKBUR_type1.Factory.parse(
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
