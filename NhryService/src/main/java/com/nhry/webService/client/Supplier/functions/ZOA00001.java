/**
 * ZOA00001.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.Supplier.functions;


/**
 *  ZOA00001 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZOA00001 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZOA00001
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for MANDT
     */
    protected com.nhry.webService.client.Supplier.functions.MANDT_type25 localMANDT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMANDTTracker = false;

    /**
     * field for KURST
     */
    protected com.nhry.webService.client.Supplier.functions.KURST_type1 localKURST;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKURSTTracker = false;

    /**
     * field for FCURR
     */
    protected com.nhry.webService.client.Supplier.functions.FCURR_type1 localFCURR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localFCURRTracker = false;

    /**
     * field for TCURR
     */
    protected com.nhry.webService.client.Supplier.functions.TCURR_type1 localTCURR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTCURRTracker = false;

    /**
     * field for GDATU
     */
    protected com.nhry.webService.client.Supplier.functions.GDATU_type1 localGDATU;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localGDATUTracker = false;

    /**
     * field for UKURS
     */
    protected com.nhry.webService.client.Supplier.functions.UKURS_type1 localUKURS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localUKURSTracker = false;

    /**
     * field for FFACT
     */
    protected com.nhry.webService.client.Supplier.functions.FFACT_type1 localFFACT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localFFACTTracker = false;

    /**
     * field for TFACT
     */
    protected com.nhry.webService.client.Supplier.functions.TFACT_type1 localTFACT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTFACTTracker = false;

    public boolean isMANDTSpecified() {
        return localMANDTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.MANDT_type25
     */
    public com.nhry.webService.client.Supplier.functions.MANDT_type25 getMANDT() {
        return localMANDT;
    }

    /**
     * Auto generated setter method
     * @param param MANDT
     */
    public void setMANDT(
        com.nhry.webService.client.Supplier.functions.MANDT_type25 param) {
        localMANDTTracker = param != null;

        this.localMANDT = param;
    }

    public boolean isKURSTSpecified() {
        return localKURSTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.KURST_type1
     */
    public com.nhry.webService.client.Supplier.functions.KURST_type1 getKURST() {
        return localKURST;
    }

    /**
     * Auto generated setter method
     * @param param KURST
     */
    public void setKURST(
        com.nhry.webService.client.Supplier.functions.KURST_type1 param) {
        localKURSTTracker = param != null;

        this.localKURST = param;
    }

    public boolean isFCURRSpecified() {
        return localFCURRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.FCURR_type1
     */
    public com.nhry.webService.client.Supplier.functions.FCURR_type1 getFCURR() {
        return localFCURR;
    }

    /**
     * Auto generated setter method
     * @param param FCURR
     */
    public void setFCURR(
        com.nhry.webService.client.Supplier.functions.FCURR_type1 param) {
        localFCURRTracker = param != null;

        this.localFCURR = param;
    }

    public boolean isTCURRSpecified() {
        return localTCURRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.TCURR_type1
     */
    public com.nhry.webService.client.Supplier.functions.TCURR_type1 getTCURR() {
        return localTCURR;
    }

    /**
     * Auto generated setter method
     * @param param TCURR
     */
    public void setTCURR(
        com.nhry.webService.client.Supplier.functions.TCURR_type1 param) {
        localTCURRTracker = param != null;

        this.localTCURR = param;
    }

    public boolean isGDATUSpecified() {
        return localGDATUTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.GDATU_type1
     */
    public com.nhry.webService.client.Supplier.functions.GDATU_type1 getGDATU() {
        return localGDATU;
    }

    /**
     * Auto generated setter method
     * @param param GDATU
     */
    public void setGDATU(
        com.nhry.webService.client.Supplier.functions.GDATU_type1 param) {
        localGDATUTracker = param != null;

        this.localGDATU = param;
    }

    public boolean isUKURSSpecified() {
        return localUKURSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.UKURS_type1
     */
    public com.nhry.webService.client.Supplier.functions.UKURS_type1 getUKURS() {
        return localUKURS;
    }

    /**
     * Auto generated setter method
     * @param param UKURS
     */
    public void setUKURS(
        com.nhry.webService.client.Supplier.functions.UKURS_type1 param) {
        localUKURSTracker = param != null;

        this.localUKURS = param;
    }

    public boolean isFFACTSpecified() {
        return localFFACTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.FFACT_type1
     */
    public com.nhry.webService.client.Supplier.functions.FFACT_type1 getFFACT() {
        return localFFACT;
    }

    /**
     * Auto generated setter method
     * @param param FFACT
     */
    public void setFFACT(
        com.nhry.webService.client.Supplier.functions.FFACT_type1 param) {
        localFFACTTracker = param != null;

        this.localFFACT = param;
    }

    public boolean isTFACTSpecified() {
        return localTFACTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.TFACT_type1
     */
    public com.nhry.webService.client.Supplier.functions.TFACT_type1 getTFACT() {
        return localTFACT;
    }

    /**
     * Auto generated setter method
     * @param param TFACT
     */
    public void setTFACT(
        com.nhry.webService.client.Supplier.functions.TFACT_type1 param) {
        localTFACTTracker = param != null;

        this.localTFACT = param;
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
                    namespacePrefix + ":ZOA00001", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZOA00001", xmlWriter);
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

        if (localKURSTTracker) {
            if (localKURST == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KURST cannot be null!!");
            }

            localKURST.serialize(new javax.xml.namespace.QName("", "KURST"),
                xmlWriter);
        }

        if (localFCURRTracker) {
            if (localFCURR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "FCURR cannot be null!!");
            }

            localFCURR.serialize(new javax.xml.namespace.QName("", "FCURR"),
                xmlWriter);
        }

        if (localTCURRTracker) {
            if (localTCURR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TCURR cannot be null!!");
            }

            localTCURR.serialize(new javax.xml.namespace.QName("", "TCURR"),
                xmlWriter);
        }

        if (localGDATUTracker) {
            if (localGDATU == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "GDATU cannot be null!!");
            }

            localGDATU.serialize(new javax.xml.namespace.QName("", "GDATU"),
                xmlWriter);
        }

        if (localUKURSTracker) {
            if (localUKURS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "UKURS cannot be null!!");
            }

            localUKURS.serialize(new javax.xml.namespace.QName("", "UKURS"),
                xmlWriter);
        }

        if (localFFACTTracker) {
            if (localFFACT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "FFACT cannot be null!!");
            }

            localFFACT.serialize(new javax.xml.namespace.QName("", "FFACT"),
                xmlWriter);
        }

        if (localTFACTTracker) {
            if (localTFACT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TFACT cannot be null!!");
            }

            localTFACT.serialize(new javax.xml.namespace.QName("", "TFACT"),
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
        public static ZOA00001 parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            ZOA00001 object = new ZOA00001();

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

                        if (!"ZOA00001".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZOA00001) com.nhry.webService.client.Supplier.functions.ExtensionMapper.getTypeObject(nsUri,
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
                    object.setMANDT(com.nhry.webService.client.Supplier.functions.MANDT_type25.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KURST").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KURST").equals(
                            reader.getName())) {
                    object.setKURST(com.nhry.webService.client.Supplier.functions.KURST_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "FCURR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "FCURR").equals(
                            reader.getName())) {
                    object.setFCURR(com.nhry.webService.client.Supplier.functions.FCURR_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TCURR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TCURR").equals(
                            reader.getName())) {
                    object.setTCURR(com.nhry.webService.client.Supplier.functions.TCURR_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "GDATU").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "GDATU").equals(
                            reader.getName())) {
                    object.setGDATU(com.nhry.webService.client.Supplier.functions.GDATU_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "UKURS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "UKURS").equals(
                            reader.getName())) {
                    object.setUKURS(com.nhry.webService.client.Supplier.functions.UKURS_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "FFACT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "FFACT").equals(
                            reader.getName())) {
                    object.setFFACT(com.nhry.webService.client.Supplier.functions.FFACT_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TFACT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TFACT").equals(
                            reader.getName())) {
                    object.setTFACT(com.nhry.webService.client.Supplier.functions.TFACT_type1.Factory.parse(
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
