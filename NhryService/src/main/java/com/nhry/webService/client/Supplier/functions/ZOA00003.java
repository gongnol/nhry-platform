/**
 * ZOA00003.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.Supplier.functions;


/**
 *  ZOA00003 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZOA00003 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZOA00003
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for LIFNR
     */
    protected com.nhry.webService.client.Supplier.functions.LIFNR_type7 localLIFNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLIFNRTracker = false;

    /**
     * field for BANKN
     */
    protected com.nhry.webService.client.Supplier.functions.BANKN_type3 localBANKN;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBANKNTracker = false;

    /**
     * field for BANKA
     */
    protected com.nhry.webService.client.Supplier.functions.BANKA_type3 localBANKA;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBANKATracker = false;

    /**
     * field for BRNCH
     */
    protected com.nhry.webService.client.Supplier.functions.BRNCH_type1 localBRNCH;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBRNCHTracker = false;

    /**
     * field for BANKL
     */
    protected com.nhry.webService.client.Supplier.functions.BANKL_type3 localBANKL;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBANKLTracker = false;

    /**
     * field for BNKLZ
     */
    protected com.nhry.webService.client.Supplier.functions.BNKLZ_type1 localBNKLZ;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBNKLZTracker = false;

    /**
     * field for BKREF
     */
    protected com.nhry.webService.client.Supplier.functions.BKREF_type1 localBKREF;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBKREFTracker = false;

    /**
     * field for KOINH
     */
    protected com.nhry.webService.client.Supplier.functions.KOINH_type1 localKOINH;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKOINHTracker = false;

    public boolean isLIFNRSpecified() {
        return localLIFNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.LIFNR_type7
     */
    public com.nhry.webService.client.Supplier.functions.LIFNR_type7 getLIFNR() {
        return localLIFNR;
    }

    /**
     * Auto generated setter method
     * @param param LIFNR
     */
    public void setLIFNR(
        com.nhry.webService.client.Supplier.functions.LIFNR_type7 param) {
        localLIFNRTracker = param != null;

        this.localLIFNR = param;
    }

    public boolean isBANKNSpecified() {
        return localBANKNTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.BANKN_type3
     */
    public com.nhry.webService.client.Supplier.functions.BANKN_type3 getBANKN() {
        return localBANKN;
    }

    /**
     * Auto generated setter method
     * @param param BANKN
     */
    public void setBANKN(
        com.nhry.webService.client.Supplier.functions.BANKN_type3 param) {
        localBANKNTracker = param != null;

        this.localBANKN = param;
    }

    public boolean isBANKASpecified() {
        return localBANKATracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.BANKA_type3
     */
    public com.nhry.webService.client.Supplier.functions.BANKA_type3 getBANKA() {
        return localBANKA;
    }

    /**
     * Auto generated setter method
     * @param param BANKA
     */
    public void setBANKA(
        com.nhry.webService.client.Supplier.functions.BANKA_type3 param) {
        localBANKATracker = param != null;

        this.localBANKA = param;
    }

    public boolean isBRNCHSpecified() {
        return localBRNCHTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.BRNCH_type1
     */
    public com.nhry.webService.client.Supplier.functions.BRNCH_type1 getBRNCH() {
        return localBRNCH;
    }

    /**
     * Auto generated setter method
     * @param param BRNCH
     */
    public void setBRNCH(
        com.nhry.webService.client.Supplier.functions.BRNCH_type1 param) {
        localBRNCHTracker = param != null;

        this.localBRNCH = param;
    }

    public boolean isBANKLSpecified() {
        return localBANKLTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.BANKL_type3
     */
    public com.nhry.webService.client.Supplier.functions.BANKL_type3 getBANKL() {
        return localBANKL;
    }

    /**
     * Auto generated setter method
     * @param param BANKL
     */
    public void setBANKL(
        com.nhry.webService.client.Supplier.functions.BANKL_type3 param) {
        localBANKLTracker = param != null;

        this.localBANKL = param;
    }

    public boolean isBNKLZSpecified() {
        return localBNKLZTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.BNKLZ_type1
     */
    public com.nhry.webService.client.Supplier.functions.BNKLZ_type1 getBNKLZ() {
        return localBNKLZ;
    }

    /**
     * Auto generated setter method
     * @param param BNKLZ
     */
    public void setBNKLZ(
        com.nhry.webService.client.Supplier.functions.BNKLZ_type1 param) {
        localBNKLZTracker = param != null;

        this.localBNKLZ = param;
    }

    public boolean isBKREFSpecified() {
        return localBKREFTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.BKREF_type1
     */
    public com.nhry.webService.client.Supplier.functions.BKREF_type1 getBKREF() {
        return localBKREF;
    }

    /**
     * Auto generated setter method
     * @param param BKREF
     */
    public void setBKREF(
        com.nhry.webService.client.Supplier.functions.BKREF_type1 param) {
        localBKREFTracker = param != null;

        this.localBKREF = param;
    }

    public boolean isKOINHSpecified() {
        return localKOINHTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.KOINH_type1
     */
    public com.nhry.webService.client.Supplier.functions.KOINH_type1 getKOINH() {
        return localKOINH;
    }

    /**
     * Auto generated setter method
     * @param param KOINH
     */
    public void setKOINH(
        com.nhry.webService.client.Supplier.functions.KOINH_type1 param) {
        localKOINHTracker = param != null;

        this.localKOINH = param;
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
                    namespacePrefix + ":ZOA00003", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZOA00003", xmlWriter);
            }
        }

        if (localLIFNRTracker) {
            if (localLIFNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "LIFNR cannot be null!!");
            }

            localLIFNR.serialize(new javax.xml.namespace.QName("", "LIFNR"),
                xmlWriter);
        }

        if (localBANKNTracker) {
            if (localBANKN == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BANKN cannot be null!!");
            }

            localBANKN.serialize(new javax.xml.namespace.QName("", "BANKN"),
                xmlWriter);
        }

        if (localBANKATracker) {
            if (localBANKA == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BANKA cannot be null!!");
            }

            localBANKA.serialize(new javax.xml.namespace.QName("", "BANKA"),
                xmlWriter);
        }

        if (localBRNCHTracker) {
            if (localBRNCH == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BRNCH cannot be null!!");
            }

            localBRNCH.serialize(new javax.xml.namespace.QName("", "BRNCH"),
                xmlWriter);
        }

        if (localBANKLTracker) {
            if (localBANKL == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BANKL cannot be null!!");
            }

            localBANKL.serialize(new javax.xml.namespace.QName("", "BANKL"),
                xmlWriter);
        }

        if (localBNKLZTracker) {
            if (localBNKLZ == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BNKLZ cannot be null!!");
            }

            localBNKLZ.serialize(new javax.xml.namespace.QName("", "BNKLZ"),
                xmlWriter);
        }

        if (localBKREFTracker) {
            if (localBKREF == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BKREF cannot be null!!");
            }

            localBKREF.serialize(new javax.xml.namespace.QName("", "BKREF"),
                xmlWriter);
        }

        if (localKOINHTracker) {
            if (localKOINH == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KOINH cannot be null!!");
            }

            localKOINH.serialize(new javax.xml.namespace.QName("", "KOINH"),
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
        public static ZOA00003 parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            ZOA00003 object = new ZOA00003();

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

                        if (!"ZOA00003".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZOA00003) com.nhry.webService.client.Supplier.functions.ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "LIFNR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "LIFNR").equals(
                            reader.getName())) {
                    object.setLIFNR(com.nhry.webService.client.Supplier.functions.LIFNR_type7.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BANKN").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BANKN").equals(
                            reader.getName())) {
                    object.setBANKN(com.nhry.webService.client.Supplier.functions.BANKN_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BANKA").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BANKA").equals(
                            reader.getName())) {
                    object.setBANKA(com.nhry.webService.client.Supplier.functions.BANKA_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BRNCH").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BRNCH").equals(
                            reader.getName())) {
                    object.setBRNCH(com.nhry.webService.client.Supplier.functions.BRNCH_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BANKL").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BANKL").equals(
                            reader.getName())) {
                    object.setBANKL(com.nhry.webService.client.Supplier.functions.BANKL_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BNKLZ").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BNKLZ").equals(
                            reader.getName())) {
                    object.setBNKLZ(com.nhry.webService.client.Supplier.functions.BNKLZ_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BKREF").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BKREF").equals(
                            reader.getName())) {
                    object.setBKREF(com.nhry.webService.client.Supplier.functions.BKREF_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KOINH").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KOINH").equals(
                            reader.getName())) {
                    object.setKOINH(com.nhry.webService.client.Supplier.functions.KOINH_type1.Factory.parse(
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
