/**
 * T005T.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.masterData.functions;


/**
 *  T005T bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class T005T implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = T005T
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for MANDT
     */
    protected com.nhry.webService.client.masterData.functions.MANDT_type7 localMANDT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMANDTTracker = false;

    /**
     * field for SPRAS
     */
    protected com.nhry.webService.client.masterData.functions.SPRAS_type1 localSPRAS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSPRASTracker = false;

    /**
     * field for LAND1
     */
    protected com.nhry.webService.client.masterData.functions.LAND1_type1 localLAND1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLAND1Tracker = false;

    /**
     * field for LANDX
     */
    protected com.nhry.webService.client.masterData.functions.LANDX_type1 localLANDX;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLANDXTracker = false;

    /**
     * field for NATIO
     */
    protected com.nhry.webService.client.masterData.functions.NATIO_type1 localNATIO;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localNATIOTracker = false;

    /**
     * field for LANDX50
     */
    protected com.nhry.webService.client.masterData.functions.LANDX50_type1 localLANDX50;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLANDX50Tracker = false;

    /**
     * field for NATIO50
     */
    protected com.nhry.webService.client.masterData.functions.NATIO50_type1 localNATIO50;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localNATIO50Tracker = false;

    /**
     * field for PRQ_SPREGT
     */
    protected com.nhry.webService.client.masterData.functions.PRQ_SPREGT_type1 localPRQ_SPREGT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPRQ_SPREGTTracker = false;

    public boolean isMANDTSpecified() {
        return localMANDTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MANDT_type7
     */
    public com.nhry.webService.client.masterData.functions.MANDT_type7 getMANDT() {
        return localMANDT;
    }

    /**
     * Auto generated setter method
     * @param param MANDT
     */
    public void setMANDT(
        com.nhry.webService.client.masterData.functions.MANDT_type7 param) {
        localMANDTTracker = param != null;

        this.localMANDT = param;
    }

    public boolean isSPRASSpecified() {
        return localSPRASTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.SPRAS_type1
     */
    public com.nhry.webService.client.masterData.functions.SPRAS_type1 getSPRAS() {
        return localSPRAS;
    }

    /**
     * Auto generated setter method
     * @param param SPRAS
     */
    public void setSPRAS(
        com.nhry.webService.client.masterData.functions.SPRAS_type1 param) {
        localSPRASTracker = param != null;

        this.localSPRAS = param;
    }

    public boolean isLAND1Specified() {
        return localLAND1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.LAND1_type1
     */
    public com.nhry.webService.client.masterData.functions.LAND1_type1 getLAND1() {
        return localLAND1;
    }

    /**
     * Auto generated setter method
     * @param param LAND1
     */
    public void setLAND1(
        com.nhry.webService.client.masterData.functions.LAND1_type1 param) {
        localLAND1Tracker = param != null;

        this.localLAND1 = param;
    }

    public boolean isLANDXSpecified() {
        return localLANDXTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.LANDX_type1
     */
    public com.nhry.webService.client.masterData.functions.LANDX_type1 getLANDX() {
        return localLANDX;
    }

    /**
     * Auto generated setter method
     * @param param LANDX
     */
    public void setLANDX(
        com.nhry.webService.client.masterData.functions.LANDX_type1 param) {
        localLANDXTracker = param != null;

        this.localLANDX = param;
    }

    public boolean isNATIOSpecified() {
        return localNATIOTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.NATIO_type1
     */
    public com.nhry.webService.client.masterData.functions.NATIO_type1 getNATIO() {
        return localNATIO;
    }

    /**
     * Auto generated setter method
     * @param param NATIO
     */
    public void setNATIO(
        com.nhry.webService.client.masterData.functions.NATIO_type1 param) {
        localNATIOTracker = param != null;

        this.localNATIO = param;
    }

    public boolean isLANDX50Specified() {
        return localLANDX50Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.LANDX50_type1
     */
    public com.nhry.webService.client.masterData.functions.LANDX50_type1 getLANDX50() {
        return localLANDX50;
    }

    /**
     * Auto generated setter method
     * @param param LANDX50
     */
    public void setLANDX50(
        com.nhry.webService.client.masterData.functions.LANDX50_type1 param) {
        localLANDX50Tracker = param != null;

        this.localLANDX50 = param;
    }

    public boolean isNATIO50Specified() {
        return localNATIO50Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.NATIO50_type1
     */
    public com.nhry.webService.client.masterData.functions.NATIO50_type1 getNATIO50() {
        return localNATIO50;
    }

    /**
     * Auto generated setter method
     * @param param NATIO50
     */
    public void setNATIO50(
        com.nhry.webService.client.masterData.functions.NATIO50_type1 param) {
        localNATIO50Tracker = param != null;

        this.localNATIO50 = param;
    }

    public boolean isPRQ_SPREGTSpecified() {
        return localPRQ_SPREGTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.PRQ_SPREGT_type1
     */
    public com.nhry.webService.client.masterData.functions.PRQ_SPREGT_type1 getPRQ_SPREGT() {
        return localPRQ_SPREGT;
    }

    /**
     * Auto generated setter method
     * @param param PRQ_SPREGT
     */
    public void setPRQ_SPREGT(
        com.nhry.webService.client.masterData.functions.PRQ_SPREGT_type1 param) {
        localPRQ_SPREGTTracker = param != null;

        this.localPRQ_SPREGT = param;
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
                    namespacePrefix + ":T005T", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "T005T", xmlWriter);
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

        if (localLAND1Tracker) {
            if (localLAND1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "LAND1 cannot be null!!");
            }

            localLAND1.serialize(new javax.xml.namespace.QName("", "LAND1"),
                xmlWriter);
        }

        if (localLANDXTracker) {
            if (localLANDX == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "LANDX cannot be null!!");
            }

            localLANDX.serialize(new javax.xml.namespace.QName("", "LANDX"),
                xmlWriter);
        }

        if (localNATIOTracker) {
            if (localNATIO == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NATIO cannot be null!!");
            }

            localNATIO.serialize(new javax.xml.namespace.QName("", "NATIO"),
                xmlWriter);
        }

        if (localLANDX50Tracker) {
            if (localLANDX50 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "LANDX50 cannot be null!!");
            }

            localLANDX50.serialize(new javax.xml.namespace.QName("", "LANDX50"),
                xmlWriter);
        }

        if (localNATIO50Tracker) {
            if (localNATIO50 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NATIO50 cannot be null!!");
            }

            localNATIO50.serialize(new javax.xml.namespace.QName("", "NATIO50"),
                xmlWriter);
        }

        if (localPRQ_SPREGTTracker) {
            if (localPRQ_SPREGT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PRQ_SPREGT cannot be null!!");
            }

            localPRQ_SPREGT.serialize(new javax.xml.namespace.QName("",
                    "PRQ_SPREGT"), xmlWriter);
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
        public static T005T parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            T005T object = new T005T();

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

                        if (!"T005T".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (T005T) com.nhry.webService.client.masterData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                    object.setMANDT(com.nhry.webService.client.masterData.functions.MANDT_type7.Factory.parse(
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
                    object.setSPRAS(com.nhry.webService.client.masterData.functions.SPRAS_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "LAND1").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "LAND1").equals(
                            reader.getName())) {
                    object.setLAND1(com.nhry.webService.client.masterData.functions.LAND1_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "LANDX").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "LANDX").equals(
                            reader.getName())) {
                    object.setLANDX(com.nhry.webService.client.masterData.functions.LANDX_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "NATIO").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "NATIO").equals(
                            reader.getName())) {
                    object.setNATIO(com.nhry.webService.client.masterData.functions.NATIO_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "LANDX50").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "LANDX50").equals(
                            reader.getName())) {
                    object.setLANDX50(com.nhry.webService.client.masterData.functions.LANDX50_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "NATIO50").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "NATIO50").equals(
                            reader.getName())) {
                    object.setNATIO50(com.nhry.webService.client.masterData.functions.NATIO50_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PRQ_SPREGT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PRQ_SPREGT").equals(
                            reader.getName())) {
                    object.setPRQ_SPREGT(com.nhry.webService.client.masterData.functions.PRQ_SPREGT_type1.Factory.parse(
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
