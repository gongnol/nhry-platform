/**
 * ZSD_T005_DATAResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.masterData.functions;


/**
 *  ZSD_T005_DATAResponse bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSD_T005_DATAResponse implements org.apache.axis2.databinding.ADBBean {
    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
            "ZSD_T005_DATA.Response", "ns1");

    /**
     * field for ET_BUKRS
     */
    protected com.nhry.webService.client.masterData.functions.ET_BUKRS_type1 localET_BUKRS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_BUKRSTracker = false;

    /**
     * field for ET_T005T
     */
    protected com.nhry.webService.client.masterData.functions.ET_T005T_type1 localET_T005T;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_T005TTracker = false;

    /**
     * field for ET_T005U
     */
    protected com.nhry.webService.client.masterData.functions.ET_T005U_type1 localET_T005U;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_T005UTracker = false;

    /**
     * field for ET_T024
     */
    protected com.nhry.webService.client.masterData.functions.ET_T024_type1 localET_T024;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_T024Tracker = false;

    /**
     * field for ET_T024E
     */
    protected com.nhry.webService.client.masterData.functions.ET_T024E_type1 localET_T024E;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_T024ETracker = false;

    public boolean isET_BUKRSSpecified() {
        return localET_BUKRSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_BUKRS_type1
     */
    public com.nhry.webService.client.masterData.functions.ET_BUKRS_type1 getET_BUKRS() {
        return localET_BUKRS;
    }

    /**
     * Auto generated setter method
     * @param param ET_BUKRS
     */
    public void setET_BUKRS(
        com.nhry.webService.client.masterData.functions.ET_BUKRS_type1 param) {
        localET_BUKRSTracker = param != null;

        this.localET_BUKRS = param;
    }

    public boolean isET_T005TSpecified() {
        return localET_T005TTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_T005T_type1
     */
    public com.nhry.webService.client.masterData.functions.ET_T005T_type1 getET_T005T() {
        return localET_T005T;
    }

    /**
     * Auto generated setter method
     * @param param ET_T005T
     */
    public void setET_T005T(
        com.nhry.webService.client.masterData.functions.ET_T005T_type1 param) {
        localET_T005TTracker = param != null;

        this.localET_T005T = param;
    }

    public boolean isET_T005USpecified() {
        return localET_T005UTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_T005U_type1
     */
    public com.nhry.webService.client.masterData.functions.ET_T005U_type1 getET_T005U() {
        return localET_T005U;
    }

    /**
     * Auto generated setter method
     * @param param ET_T005U
     */
    public void setET_T005U(
        com.nhry.webService.client.masterData.functions.ET_T005U_type1 param) {
        localET_T005UTracker = param != null;

        this.localET_T005U = param;
    }

    public boolean isET_T024Specified() {
        return localET_T024Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_T024_type1
     */
    public com.nhry.webService.client.masterData.functions.ET_T024_type1 getET_T024() {
        return localET_T024;
    }

    /**
     * Auto generated setter method
     * @param param ET_T024
     */
    public void setET_T024(
        com.nhry.webService.client.masterData.functions.ET_T024_type1 param) {
        localET_T024Tracker = param != null;

        this.localET_T024 = param;
    }

    public boolean isET_T024ESpecified() {
        return localET_T024ETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.ET_T024E_type1
     */
    public com.nhry.webService.client.masterData.functions.ET_T024E_type1 getET_T024E() {
        return localET_T024E;
    }

    /**
     * Auto generated setter method
     * @param param ET_T024E
     */
    public void setET_T024E(
        com.nhry.webService.client.masterData.functions.ET_T024E_type1 param) {
        localET_T024ETracker = param != null;

        this.localET_T024E = param;
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
                    namespacePrefix + ":ZSD_T005_DATA.Response", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSD_T005_DATA.Response", xmlWriter);
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

        if (localET_T005TTracker) {
            if (localET_T005T == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_T005T cannot be null!!");
            }

            localET_T005T.serialize(new javax.xml.namespace.QName("", "ET_T005T"),
                xmlWriter);
        }

        if (localET_T005UTracker) {
            if (localET_T005U == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_T005U cannot be null!!");
            }

            localET_T005U.serialize(new javax.xml.namespace.QName("", "ET_T005U"),
                xmlWriter);
        }

        if (localET_T024Tracker) {
            if (localET_T024 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_T024 cannot be null!!");
            }

            localET_T024.serialize(new javax.xml.namespace.QName("", "ET_T024"),
                xmlWriter);
        }

        if (localET_T024ETracker) {
            if (localET_T024E == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_T024E cannot be null!!");
            }

            localET_T024E.serialize(new javax.xml.namespace.QName("", "ET_T024E"),
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
        public static ZSD_T005_DATAResponse parse(
            javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            ZSD_T005_DATAResponse object = new ZSD_T005_DATAResponse();

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

                        if (!"ZSD_T005_DATA.Response".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSD_T005_DATAResponse) com.nhry.webService.client.masterData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                            object.setET_BUKRS(com.nhry.webService.client.masterData.functions.ET_BUKRS_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_T005T").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_T005T").equals(
                                    reader.getName())) {
                            object.setET_T005T(com.nhry.webService.client.masterData.functions.ET_T005T_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_T005U").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_T005U").equals(
                                    reader.getName())) {
                            object.setET_T005U(com.nhry.webService.client.masterData.functions.ET_T005U_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_T024").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_T024").equals(
                                    reader.getName())) {
                            object.setET_T024(com.nhry.webService.client.masterData.functions.ET_T024_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_T024E").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_T024E").equals(
                                    reader.getName())) {
                            object.setET_T024E(com.nhry.webService.client.masterData.functions.ET_T024E_type1.Factory.parse(
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
