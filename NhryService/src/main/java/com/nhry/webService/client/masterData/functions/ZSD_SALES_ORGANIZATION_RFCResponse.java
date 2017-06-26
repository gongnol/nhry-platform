/**
 * ZSD_SALES_ORGANIZATION_RFCResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.masterData.functions;


/**
 *  ZSD_SALES_ORGANIZATION_RFCResponse bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSD_SALES_ORGANIZATION_RFCResponse implements org.apache.axis2.databinding.ADBBean {
    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
            "ZSD_SALES_ORGANIZATION_RFC.Response", "ns1");

    /**
     * field for ET_BUKRS
     */
    protected com.nhry.webService.client.masterData.functions.ET_BUKRS_type2 localET_BUKRS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_BUKRSTracker = false;

    /**
     * field for ET_LGORT
     */
    protected com.nhry.webService.client.masterData.functions.ET_LGORT_type2 localET_LGORT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_LGORTTracker = false;

    /**
     * field for ET_T006A
     */
    protected com.nhry.webService.client.masterData.functions.ET_T006A_type0 localET_T006A;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_T006ATracker = false;

    /**
     * field for ET_VKORG
     */
    protected com.nhry.webService.client.masterData.functions.ET_VKORG_type2 localET_VKORG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_VKORGTracker = false;

    /**
     * field for ET_WERKS
     */
    protected com.nhry.webService.client.masterData.functions.ET_WERKS_type0 localET_WERKS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_WERKSTracker = false;

    public boolean isET_BUKRSSpecified() {
        return localET_BUKRSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_BUKRS_type2
     */
    public com.nhry.webService.client.masterData.functions.ET_BUKRS_type2 getET_BUKRS() {
        return localET_BUKRS;
    }

    /**
     * Auto generated setter method
     * @param param ET_BUKRS
     */
    public void setET_BUKRS(
        com.nhry.webService.client.masterData.functions.ET_BUKRS_type2 param) {
        localET_BUKRSTracker = param != null;

        this.localET_BUKRS = param;
    }

    public boolean isET_LGORTSpecified() {
        return localET_LGORTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_LGORT_type2
     */
    public com.nhry.webService.client.masterData.functions.ET_LGORT_type2 getET_LGORT() {
        return localET_LGORT;
    }

    /**
     * Auto generated setter method
     * @param param ET_LGORT
     */
    public void setET_LGORT(
        com.nhry.webService.client.masterData.functions.ET_LGORT_type2 param) {
        localET_LGORTTracker = param != null;

        this.localET_LGORT = param;
    }

    public boolean isET_T006ASpecified() {
        return localET_T006ATracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_T006A_type0
     */
    public com.nhry.webService.client.masterData.functions.ET_T006A_type0 getET_T006A() {
        return localET_T006A;
    }

    /**
     * Auto generated setter method
     * @param param ET_T006A
     */
    public void setET_T006A(
        com.nhry.webService.client.masterData.functions.ET_T006A_type0 param) {
        localET_T006ATracker = param != null;

        this.localET_T006A = param;
    }

    public boolean isET_VKORGSpecified() {
        return localET_VKORGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_VKORG_type2
     */
    public com.nhry.webService.client.masterData.functions.ET_VKORG_type2 getET_VKORG() {
        return localET_VKORG;
    }

    /**
     * Auto generated setter method
     * @param param ET_VKORG
     */
    public void setET_VKORG(
        com.nhry.webService.client.masterData.functions.ET_VKORG_type2 param) {
        localET_VKORGTracker = param != null;

        this.localET_VKORG = param;
    }

    public boolean isET_WERKSSpecified() {
        return localET_WERKSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_WERKS_type0
     */
    public com.nhry.webService.client.masterData.functions.ET_WERKS_type0 getET_WERKS() {
        return localET_WERKS;
    }

    /**
     * Auto generated setter method
     * @param param ET_WERKS
     */
    public void setET_WERKS(
        com.nhry.webService.client.masterData.functions.ET_WERKS_type0 param) {
        localET_WERKSTracker = param != null;

        this.localET_WERKS = param;
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
                    namespacePrefix + ":ZSD_SALES_ORGANIZATION_RFC.Response",
                    xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSD_SALES_ORGANIZATION_RFC.Response", xmlWriter);
            }
        }

        if (localET_BUKRSTracker) {
            if (localET_BUKRS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_BUKRS cannot be null!!");
            }

            localET_BUKRS.serialize(new javax.xml.namespace.QName("", "ET_BUKRS"),
                xmlWriter);
        }

        if (localET_LGORTTracker) {
            if (localET_LGORT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_LGORT cannot be null!!");
            }

            localET_LGORT.serialize(new javax.xml.namespace.QName("", "ET_LGORT"),
                xmlWriter);
        }

        if (localET_T006ATracker) {
            if (localET_T006A == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_T006A cannot be null!!");
            }

            localET_T006A.serialize(new javax.xml.namespace.QName("", "ET_T006A"),
                xmlWriter);
        }

        if (localET_VKORGTracker) {
            if (localET_VKORG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_VKORG cannot be null!!");
            }

            localET_VKORG.serialize(new javax.xml.namespace.QName("", "ET_VKORG"),
                xmlWriter);
        }

        if (localET_WERKSTracker) {
            if (localET_WERKS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_WERKS cannot be null!!");
            }

            localET_WERKS.serialize(new javax.xml.namespace.QName("", "ET_WERKS"),
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
        public static ZSD_SALES_ORGANIZATION_RFCResponse parse(
            javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            ZSD_SALES_ORGANIZATION_RFCResponse object = new ZSD_SALES_ORGANIZATION_RFCResponse();

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

                        if (!"ZSD_SALES_ORGANIZATION_RFC.Response".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSD_SALES_ORGANIZATION_RFCResponse) com.nhry.webService.client.masterData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                                new javax.xml.namespace.QName("", "ET_BUKRS").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_BUKRS").equals(
                                    reader.getName())) {
                            object.setET_BUKRS(com.nhry.webService.client.masterData.functions.ET_BUKRS_type2.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_LGORT").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_LGORT").equals(
                                    reader.getName())) {
                            object.setET_LGORT(com.nhry.webService.client.masterData.functions.ET_LGORT_type2.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_T006A").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_T006A").equals(
                                    reader.getName())) {
                            object.setET_T006A(com.nhry.webService.client.masterData.functions.ET_T006A_type0.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_VKORG").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_VKORG").equals(
                                    reader.getName())) {
                            object.setET_VKORG(com.nhry.webService.client.masterData.functions.ET_VKORG_type2.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_WERKS").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_WERKS").equals(
                                    reader.getName())) {
                            object.setET_WERKS(com.nhry.webService.client.masterData.functions.ET_WERKS_type0.Factory.parse(
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
