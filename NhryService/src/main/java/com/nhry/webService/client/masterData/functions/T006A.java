/**
 * T006A.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.masterData.functions;


/**
 *  T006A bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class T006A implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = T006A
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for MANDT
     */
    protected com.nhry.webService.client.masterData.functions.MANDT_type19 localMANDT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMANDTTracker = false;

    /**
     * field for SPRAS
     */
    protected com.nhry.webService.client.masterData.functions.SPRAS_type5 localSPRAS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSPRASTracker = false;

    /**
     * field for MSEHI
     */
    protected com.nhry.webService.client.masterData.functions.MSEHI_type3 localMSEHI;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMSEHITracker = false;

    /**
     * field for MSEH3
     */
    protected com.nhry.webService.client.masterData.functions.MSEH3_type1 localMSEH3;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMSEH3Tracker = false;

    /**
     * field for MSEH6
     */
    protected com.nhry.webService.client.masterData.functions.MSEH6_type1 localMSEH6;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMSEH6Tracker = false;

    /**
     * field for MSEHT
     */
    protected com.nhry.webService.client.masterData.functions.MSEHT_type1 localMSEHT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMSEHTTracker = false;

    /**
     * field for MSEHL
     */
    protected com.nhry.webService.client.masterData.functions.MSEHL_type3 localMSEHL;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMSEHLTracker = false;

    public boolean isMANDTSpecified() {
        return localMANDTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MANDT_type19
     */
    public com.nhry.webService.client.masterData.functions.MANDT_type19 getMANDT() {
        return localMANDT;
    }

    /**
     * Auto generated setter method
     * @param param MANDT
     */
    public void setMANDT(
        com.nhry.webService.client.masterData.functions.MANDT_type19 param) {
        localMANDTTracker = param != null;

        this.localMANDT = param;
    }

    public boolean isSPRASSpecified() {
        return localSPRASTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.SPRAS_type5
     */
    public com.nhry.webService.client.masterData.functions.SPRAS_type5 getSPRAS() {
        return localSPRAS;
    }

    /**
     * Auto generated setter method
     * @param param SPRAS
     */
    public void setSPRAS(
        com.nhry.webService.client.masterData.functions.SPRAS_type5 param) {
        localSPRASTracker = param != null;

        this.localSPRAS = param;
    }

    public boolean isMSEHISpecified() {
        return localMSEHITracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MSEHI_type3
     */
    public com.nhry.webService.client.masterData.functions.MSEHI_type3 getMSEHI() {
        return localMSEHI;
    }

    /**
     * Auto generated setter method
     * @param param MSEHI
     */
    public void setMSEHI(
        com.nhry.webService.client.masterData.functions.MSEHI_type3 param) {
        localMSEHITracker = param != null;

        this.localMSEHI = param;
    }

    public boolean isMSEH3Specified() {
        return localMSEH3Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MSEH3_type1
     */
    public com.nhry.webService.client.masterData.functions.MSEH3_type1 getMSEH3() {
        return localMSEH3;
    }

    /**
     * Auto generated setter method
     * @param param MSEH3
     */
    public void setMSEH3(
        com.nhry.webService.client.masterData.functions.MSEH3_type1 param) {
        localMSEH3Tracker = param != null;

        this.localMSEH3 = param;
    }

    public boolean isMSEH6Specified() {
        return localMSEH6Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MSEH6_type1
     */
    public com.nhry.webService.client.masterData.functions.MSEH6_type1 getMSEH6() {
        return localMSEH6;
    }

    /**
     * Auto generated setter method
     * @param param MSEH6
     */
    public void setMSEH6(
        com.nhry.webService.client.masterData.functions.MSEH6_type1 param) {
        localMSEH6Tracker = param != null;

        this.localMSEH6 = param;
    }

    public boolean isMSEHTSpecified() {
        return localMSEHTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MSEHT_type1
     */
    public com.nhry.webService.client.masterData.functions.MSEHT_type1 getMSEHT() {
        return localMSEHT;
    }

    /**
     * Auto generated setter method
     * @param param MSEHT
     */
    public void setMSEHT(
        com.nhry.webService.client.masterData.functions.MSEHT_type1 param) {
        localMSEHTTracker = param != null;

        this.localMSEHT = param;
    }

    public boolean isMSEHLSpecified() {
        return localMSEHLTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MSEHL_type3
     */
    public com.nhry.webService.client.masterData.functions.MSEHL_type3 getMSEHL() {
        return localMSEHL;
    }

    /**
     * Auto generated setter method
     * @param param MSEHL
     */
    public void setMSEHL(
        com.nhry.webService.client.masterData.functions.MSEHL_type3 param) {
        localMSEHLTracker = param != null;

        this.localMSEHL = param;
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
                    namespacePrefix + ":T006A", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "T006A", xmlWriter);
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

        if (localSPRASTracker) {
            if (localSPRAS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SPRAS cannot be null!!");
            }

            localSPRAS.serialize(new javax.xml.namespace.QName("", "SPRAS"),
                xmlWriter);
        }

        if (localMSEHITracker) {
            if (localMSEHI == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MSEHI cannot be null!!");
            }

            localMSEHI.serialize(new javax.xml.namespace.QName("", "MSEHI"),
                xmlWriter);
        }

        if (localMSEH3Tracker) {
            if (localMSEH3 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MSEH3 cannot be null!!");
            }

            localMSEH3.serialize(new javax.xml.namespace.QName("", "MSEH3"),
                xmlWriter);
        }

        if (localMSEH6Tracker) {
            if (localMSEH6 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MSEH6 cannot be null!!");
            }

            localMSEH6.serialize(new javax.xml.namespace.QName("", "MSEH6"),
                xmlWriter);
        }

        if (localMSEHTTracker) {
            if (localMSEHT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MSEHT cannot be null!!");
            }

            localMSEHT.serialize(new javax.xml.namespace.QName("", "MSEHT"),
                xmlWriter);
        }

        if (localMSEHLTracker) {
            if (localMSEHL == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MSEHL cannot be null!!");
            }

            localMSEHL.serialize(new javax.xml.namespace.QName("", "MSEHL"),
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
        public static T006A parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            T006A object = new T006A();

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

                        if (!"T006A".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (T006A) com.nhry.webService.client.masterData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                    object.setMANDT(com.nhry.webService.client.masterData.functions.MANDT_type19.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "SPRAS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "SPRAS").equals(
                            reader.getName())) {
                    object.setSPRAS(com.nhry.webService.client.masterData.functions.SPRAS_type5.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MSEHI").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MSEHI").equals(
                            reader.getName())) {
                    object.setMSEHI(com.nhry.webService.client.masterData.functions.MSEHI_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MSEH3").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MSEH3").equals(
                            reader.getName())) {
                    object.setMSEH3(com.nhry.webService.client.masterData.functions.MSEH3_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MSEH6").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MSEH6").equals(
                            reader.getName())) {
                    object.setMSEH6(com.nhry.webService.client.masterData.functions.MSEH6_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MSEHT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MSEHT").equals(
                            reader.getName())) {
                    object.setMSEHT(com.nhry.webService.client.masterData.functions.MSEHT_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MSEHL").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MSEHL").equals(
                            reader.getName())) {
                    object.setMSEHL(com.nhry.webService.client.masterData.functions.MSEHL_type3.Factory.parse(
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
