/**
 * T030K.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.Supplier.functions;


/**
 *  T030K bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class T030K implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = T030K
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for MANDT
     */
    protected com.nhry.webService.client.Supplier.functions.MANDT_type13 localMANDT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMANDTTracker = false;

    /**
     * field for KTOPL
     */
    protected com.nhry.webService.client.Supplier.functions.KTOPL_type3 localKTOPL;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKTOPLTracker = false;

    /**
     * field for KTOSL
     */
    protected com.nhry.webService.client.Supplier.functions.KTOSL_type1 localKTOSL;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKTOSLTracker = false;

    /**
     * field for MWSKZ
     */
    protected com.nhry.webService.client.Supplier.functions.MWSKZ_type5 localMWSKZ;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMWSKZTracker = false;

    /**
     * field for KONTS
     */
    protected com.nhry.webService.client.Supplier.functions.KONTS_type1 localKONTS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKONTSTracker = false;

    /**
     * field for KONTH
     */
    protected com.nhry.webService.client.Supplier.functions.KONTH_type1 localKONTH;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKONTHTracker = false;

    public boolean isMANDTSpecified() {
        return localMANDTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.MANDT_type13
     */
    public com.nhry.webService.client.Supplier.functions.MANDT_type13 getMANDT() {
        return localMANDT;
    }

    /**
     * Auto generated setter method
     * @param param MANDT
     */
    public void setMANDT(
        com.nhry.webService.client.Supplier.functions.MANDT_type13 param) {
        localMANDTTracker = param != null;

        this.localMANDT = param;
    }

    public boolean isKTOPLSpecified() {
        return localKTOPLTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.KTOPL_type3
     */
    public com.nhry.webService.client.Supplier.functions.KTOPL_type3 getKTOPL() {
        return localKTOPL;
    }

    /**
     * Auto generated setter method
     * @param param KTOPL
     */
    public void setKTOPL(
        com.nhry.webService.client.Supplier.functions.KTOPL_type3 param) {
        localKTOPLTracker = param != null;

        this.localKTOPL = param;
    }

    public boolean isKTOSLSpecified() {
        return localKTOSLTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.KTOSL_type1
     */
    public com.nhry.webService.client.Supplier.functions.KTOSL_type1 getKTOSL() {
        return localKTOSL;
    }

    /**
     * Auto generated setter method
     * @param param KTOSL
     */
    public void setKTOSL(
        com.nhry.webService.client.Supplier.functions.KTOSL_type1 param) {
        localKTOSLTracker = param != null;

        this.localKTOSL = param;
    }

    public boolean isMWSKZSpecified() {
        return localMWSKZTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.MWSKZ_type5
     */
    public com.nhry.webService.client.Supplier.functions.MWSKZ_type5 getMWSKZ() {
        return localMWSKZ;
    }

    /**
     * Auto generated setter method
     * @param param MWSKZ
     */
    public void setMWSKZ(
        com.nhry.webService.client.Supplier.functions.MWSKZ_type5 param) {
        localMWSKZTracker = param != null;

        this.localMWSKZ = param;
    }

    public boolean isKONTSSpecified() {
        return localKONTSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.KONTS_type1
     */
    public com.nhry.webService.client.Supplier.functions.KONTS_type1 getKONTS() {
        return localKONTS;
    }

    /**
     * Auto generated setter method
     * @param param KONTS
     */
    public void setKONTS(
        com.nhry.webService.client.Supplier.functions.KONTS_type1 param) {
        localKONTSTracker = param != null;

        this.localKONTS = param;
    }

    public boolean isKONTHSpecified() {
        return localKONTHTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.KONTH_type1
     */
    public com.nhry.webService.client.Supplier.functions.KONTH_type1 getKONTH() {
        return localKONTH;
    }

    /**
     * Auto generated setter method
     * @param param KONTH
     */
    public void setKONTH(
        com.nhry.webService.client.Supplier.functions.KONTH_type1 param) {
        localKONTHTracker = param != null;

        this.localKONTH = param;
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
                    namespacePrefix + ":T030K", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "T030K", xmlWriter);
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

        if (localKTOPLTracker) {
            if (localKTOPL == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KTOPL cannot be null!!");
            }

            localKTOPL.serialize(new javax.xml.namespace.QName("", "KTOPL"),
                xmlWriter);
        }

        if (localKTOSLTracker) {
            if (localKTOSL == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KTOSL cannot be null!!");
            }

            localKTOSL.serialize(new javax.xml.namespace.QName("", "KTOSL"),
                xmlWriter);
        }

        if (localMWSKZTracker) {
            if (localMWSKZ == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MWSKZ cannot be null!!");
            }

            localMWSKZ.serialize(new javax.xml.namespace.QName("", "MWSKZ"),
                xmlWriter);
        }

        if (localKONTSTracker) {
            if (localKONTS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KONTS cannot be null!!");
            }

            localKONTS.serialize(new javax.xml.namespace.QName("", "KONTS"),
                xmlWriter);
        }

        if (localKONTHTracker) {
            if (localKONTH == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KONTH cannot be null!!");
            }

            localKONTH.serialize(new javax.xml.namespace.QName("", "KONTH"),
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
        public static T030K parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            T030K object = new T030K();

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

                        if (!"T030K".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (T030K) com.nhry.webService.client.Supplier.functions.ExtensionMapper.getTypeObject(nsUri,
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
                    object.setMANDT(com.nhry.webService.client.Supplier.functions.MANDT_type13.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KTOPL").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KTOPL").equals(
                            reader.getName())) {
                    object.setKTOPL(com.nhry.webService.client.Supplier.functions.KTOPL_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KTOSL").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KTOSL").equals(
                            reader.getName())) {
                    object.setKTOSL(com.nhry.webService.client.Supplier.functions.KTOSL_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MWSKZ").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MWSKZ").equals(
                            reader.getName())) {
                    object.setMWSKZ(com.nhry.webService.client.Supplier.functions.MWSKZ_type5.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KONTS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KONTS").equals(
                            reader.getName())) {
                    object.setKONTS(com.nhry.webService.client.Supplier.functions.KONTS_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KONTH").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KONTH").equals(
                            reader.getName())) {
                    object.setKONTH(com.nhry.webService.client.Supplier.functions.KONTH_type1.Factory.parse(
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
