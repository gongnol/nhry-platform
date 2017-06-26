/**
 * ZSD_MATERAIL_DATA_RFCResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.masterData.functions;


/**
 *  ZSD_MATERAIL_DATA_RFCResponse bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSD_MATERAIL_DATA_RFCResponse implements org.apache.axis2.databinding.ADBBean {
    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
            "ZSD_MATERAIL_DATA_RFC.Response", "ns1");

    /**
     * field for ET_BOM
     */
    protected com.nhry.webService.client.masterData.functions.ET_BOM_type1 localET_BOM;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_BOMTracker = false;

    /**
     * field for ET_MAKTX
     */
    protected com.nhry.webService.client.masterData.functions.ET_MAKTX_type1 localET_MAKTX;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_MAKTXTracker = false;

    /**
     * field for ET_MARM
     */
    protected com.nhry.webService.client.masterData.functions.ET_MARM_type1 localET_MARM;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_MARMTracker = false;

    /**
     * field for ET_MATNR
     */
    protected com.nhry.webService.client.masterData.functions.ET_MATNR_type1 localET_MATNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_MATNRTracker = false;

    /**
     * field for ET_ZTMM00037
     */
    protected com.nhry.webService.client.masterData.functions.ET_ZTMM00037_type1 localET_ZTMM00037;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_ZTMM00037Tracker = false;

    /**
     * field for IT_MATNR
     */
    protected com.nhry.webService.client.masterData.functions.IT_MATNR_type1 localIT_MATNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIT_MATNRTracker = false;

    /**
     * field for IT_MTART
     */
    protected com.nhry.webService.client.masterData.functions.IT_MTART_type1 localIT_MTART;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIT_MTARTTracker = false;

    /**
     * field for IT_VTWEG
     */
    protected com.nhry.webService.client.masterData.functions.IT_VTWEG_type3 localIT_VTWEG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIT_VTWEGTracker = false;

    public boolean isET_BOMSpecified() {
        return localET_BOMTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_BOM_type1
     */
    public com.nhry.webService.client.masterData.functions.ET_BOM_type1 getET_BOM() {
        return localET_BOM;
    }

    /**
     * Auto generated setter method
     * @param param ET_BOM
     */
    public void setET_BOM(
        com.nhry.webService.client.masterData.functions.ET_BOM_type1 param) {
        localET_BOMTracker = param != null;

        this.localET_BOM = param;
    }

    public boolean isET_MAKTXSpecified() {
        return localET_MAKTXTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_MAKTX_type1
     */
    public com.nhry.webService.client.masterData.functions.ET_MAKTX_type1 getET_MAKTX() {
        return localET_MAKTX;
    }

    /**
     * Auto generated setter method
     * @param param ET_MAKTX
     */
    public void setET_MAKTX(
        com.nhry.webService.client.masterData.functions.ET_MAKTX_type1 param) {
        localET_MAKTXTracker = param != null;

        this.localET_MAKTX = param;
    }

    public boolean isET_MARMSpecified() {
        return localET_MARMTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_MARM_type1
     */
    public com.nhry.webService.client.masterData.functions.ET_MARM_type1 getET_MARM() {
        return localET_MARM;
    }

    /**
     * Auto generated setter method
     * @param param ET_MARM
     */
    public void setET_MARM(
        com.nhry.webService.client.masterData.functions.ET_MARM_type1 param) {
        localET_MARMTracker = param != null;

        this.localET_MARM = param;
    }

    public boolean isET_MATNRSpecified() {
        return localET_MATNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_MATNR_type1
     */
    public com.nhry.webService.client.masterData.functions.ET_MATNR_type1 getET_MATNR() {
        return localET_MATNR;
    }

    /**
     * Auto generated setter method
     * @param param ET_MATNR
     */
    public void setET_MATNR(
        com.nhry.webService.client.masterData.functions.ET_MATNR_type1 param) {
        localET_MATNRTracker = param != null;

        this.localET_MATNR = param;
    }

    public boolean isET_ZTMM00037Specified() {
        return localET_ZTMM00037Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_ZTMM00037_type1
     */
    public com.nhry.webService.client.masterData.functions.ET_ZTMM00037_type1 getET_ZTMM00037() {
        return localET_ZTMM00037;
    }

    /**
     * Auto generated setter method
     * @param param ET_ZTMM00037
     */
    public void setET_ZTMM00037(
        com.nhry.webService.client.masterData.functions.ET_ZTMM00037_type1 param) {
        localET_ZTMM00037Tracker = param != null;

        this.localET_ZTMM00037 = param;
    }

    public boolean isIT_MATNRSpecified() {
        return localIT_MATNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.IT_MATNR_type1
     */
    public com.nhry.webService.client.masterData.functions.IT_MATNR_type1 getIT_MATNR() {
        return localIT_MATNR;
    }

    /**
     * Auto generated setter method
     * @param param IT_MATNR
     */
    public void setIT_MATNR(
        com.nhry.webService.client.masterData.functions.IT_MATNR_type1 param) {
        localIT_MATNRTracker = param != null;

        this.localIT_MATNR = param;
    }

    public boolean isIT_MTARTSpecified() {
        return localIT_MTARTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.IT_MTART_type1
     */
    public com.nhry.webService.client.masterData.functions.IT_MTART_type1 getIT_MTART() {
        return localIT_MTART;
    }

    /**
     * Auto generated setter method
     * @param param IT_MTART
     */
    public void setIT_MTART(
        com.nhry.webService.client.masterData.functions.IT_MTART_type1 param) {
        localIT_MTARTTracker = param != null;

        this.localIT_MTART = param;
    }

    public boolean isIT_VTWEGSpecified() {
        return localIT_VTWEGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.IT_VTWEG_type3
     */
    public com.nhry.webService.client.masterData.functions.IT_VTWEG_type3 getIT_VTWEG() {
        return localIT_VTWEG;
    }

    /**
     * Auto generated setter method
     * @param param IT_VTWEG
     */
    public void setIT_VTWEG(
        com.nhry.webService.client.masterData.functions.IT_VTWEG_type3 param) {
        localIT_VTWEGTracker = param != null;

        this.localIT_VTWEG = param;
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
                this, MY_QNAME));
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
                    namespacePrefix + ":ZSD_MATERAIL_DATA_RFC.Response",
                    xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSD_MATERAIL_DATA_RFC.Response", xmlWriter);
            }
        }

        if (localET_BOMTracker) {
            if (localET_BOM == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_BOM cannot be null!!");
            }

            localET_BOM.serialize(new javax.xml.namespace.QName("", "ET_BOM"),
                xmlWriter);
        }

        if (localET_MAKTXTracker) {
            if (localET_MAKTX == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_MAKTX cannot be null!!");
            }

            localET_MAKTX.serialize(new javax.xml.namespace.QName("", "ET_MAKTX"),
                xmlWriter);
        }

        if (localET_MARMTracker) {
            if (localET_MARM == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_MARM cannot be null!!");
            }

            localET_MARM.serialize(new javax.xml.namespace.QName("", "ET_MARM"),
                xmlWriter);
        }

        if (localET_MATNRTracker) {
            if (localET_MATNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_MATNR cannot be null!!");
            }

            localET_MATNR.serialize(new javax.xml.namespace.QName("", "ET_MATNR"),
                xmlWriter);
        }

        if (localET_ZTMM00037Tracker) {
            if (localET_ZTMM00037 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_ZTMM00037 cannot be null!!");
            }

            localET_ZTMM00037.serialize(new javax.xml.namespace.QName("",
                    "ET_ZTMM00037"), xmlWriter);
        }

        if (localIT_MATNRTracker) {
            if (localIT_MATNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "IT_MATNR cannot be null!!");
            }

            localIT_MATNR.serialize(new javax.xml.namespace.QName("", "IT_MATNR"),
                xmlWriter);
        }

        if (localIT_MTARTTracker) {
            if (localIT_MTART == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "IT_MTART cannot be null!!");
            }

            localIT_MTART.serialize(new javax.xml.namespace.QName("", "IT_MTART"),
                xmlWriter);
        }

        if (localIT_VTWEGTracker) {
            if (localIT_VTWEG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "IT_VTWEG cannot be null!!");
            }

            localIT_VTWEG.serialize(new javax.xml.namespace.QName("", "IT_VTWEG"),
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
        public static ZSD_MATERAIL_DATA_RFCResponse parse(
            javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            ZSD_MATERAIL_DATA_RFCResponse object = new ZSD_MATERAIL_DATA_RFCResponse();

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

                        if (!"ZSD_MATERAIL_DATA_RFC.Response".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSD_MATERAIL_DATA_RFCResponse) com.nhry.webService.client.masterData.functions.ExtensionMapper.getTypeObject(nsUri,
                                type, reader);
                        }
                    }
                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                while (!reader.isEndElement()) {
                    if (reader.isStartElement()) {
                        if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_BOM").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_BOM").equals(
                                    reader.getName())) {
                            object.setET_BOM(com.nhry.webService.client.masterData.functions.ET_BOM_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_MAKTX").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_MAKTX").equals(
                                    reader.getName())) {
                            object.setET_MAKTX(com.nhry.webService.client.masterData.functions.ET_MAKTX_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_MARM").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_MARM").equals(
                                    reader.getName())) {
                            object.setET_MARM(com.nhry.webService.client.masterData.functions.ET_MARM_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_MATNR").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_MATNR").equals(
                                    reader.getName())) {
                            object.setET_MATNR(com.nhry.webService.client.masterData.functions.ET_MATNR_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_ZTMM00037").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_ZTMM00037").equals(
                                    reader.getName())) {
                            object.setET_ZTMM00037(com.nhry.webService.client.masterData.functions.ET_ZTMM00037_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "IT_MATNR").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "IT_MATNR").equals(
                                    reader.getName())) {
                            object.setIT_MATNR(com.nhry.webService.client.masterData.functions.IT_MATNR_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "IT_MTART").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "IT_MTART").equals(
                                    reader.getName())) {
                            object.setIT_MTART(com.nhry.webService.client.masterData.functions.IT_MTART_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "IT_VTWEG").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "IT_VTWEG").equals(
                                    reader.getName())) {
                            object.setIT_VTWEG(com.nhry.webService.client.masterData.functions.IT_VTWEG_type3.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else {
                            // 3 - A start element we are not expecting indicates an invalid parameter was passed
                            throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                        }
                    } else {
                        reader.next();
                    }
                } // end of while loop
            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }
    } //end of factory class
}
