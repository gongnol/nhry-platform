/**
 * ZSMM00010.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.Supplier.functions;


/**
 *  ZSMM00010 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSMM00010 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSMM00010
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for BUKRS
     */
    protected com.nhry.webService.client.Supplier.functions.BUKRS_type13 localBUKRS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBUKRSTracker = false;

    /**
     * field for BUTXT
     */
    protected com.nhry.webService.client.Supplier.functions.BUTXT_type1 localBUTXT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBUTXTTracker = false;

    /**
     * field for WERKS
     */
    protected com.nhry.webService.client.Supplier.functions.WERKS_type3 localWERKS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localWERKSTracker = false;

    /**
     * field for NAME1
     */
    protected com.nhry.webService.client.Supplier.functions.NAME1_type5 localNAME1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localNAME1Tracker = false;

    /**
     * field for PSTLZ
     */
    protected com.nhry.webService.client.Supplier.functions.PSTLZ_type3 localPSTLZ;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPSTLZTracker = false;

    /**
     * field for STRAS
     */
    protected com.nhry.webService.client.Supplier.functions.STRAS_type3 localSTRAS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSTRASTracker = false;

    /**
     * field for TEL_NUMBER
     */
    protected com.nhry.webService.client.Supplier.functions.TEL_NUMBER_type1 localTEL_NUMBER;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTEL_NUMBERTracker = false;

    /**
     * field for NAME_CO
     */
    protected com.nhry.webService.client.Supplier.functions.NAME_CO_type1 localNAME_CO;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localNAME_COTracker = false;

    /**
     * field for STREET
     */
    protected com.nhry.webService.client.Supplier.functions.STREET_type1 localSTREET;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSTREETTracker = false;

    public boolean isBUKRSSpecified() {
        return localBUKRSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.BUKRS_type13
     */
    public com.nhry.webService.client.Supplier.functions.BUKRS_type13 getBUKRS() {
        return localBUKRS;
    }

    /**
     * Auto generated setter method
     * @param param BUKRS
     */
    public void setBUKRS(
        com.nhry.webService.client.Supplier.functions.BUKRS_type13 param) {
        localBUKRSTracker = param != null;

        this.localBUKRS = param;
    }

    public boolean isBUTXTSpecified() {
        return localBUTXTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.BUTXT_type1
     */
    public com.nhry.webService.client.Supplier.functions.BUTXT_type1 getBUTXT() {
        return localBUTXT;
    }

    /**
     * Auto generated setter method
     * @param param BUTXT
     */
    public void setBUTXT(
        com.nhry.webService.client.Supplier.functions.BUTXT_type1 param) {
        localBUTXTTracker = param != null;

        this.localBUTXT = param;
    }

    public boolean isWERKSSpecified() {
        return localWERKSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.WERKS_type3
     */
    public com.nhry.webService.client.Supplier.functions.WERKS_type3 getWERKS() {
        return localWERKS;
    }

    /**
     * Auto generated setter method
     * @param param WERKS
     */
    public void setWERKS(
        com.nhry.webService.client.Supplier.functions.WERKS_type3 param) {
        localWERKSTracker = param != null;

        this.localWERKS = param;
    }

    public boolean isNAME1Specified() {
        return localNAME1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.NAME1_type5
     */
    public com.nhry.webService.client.Supplier.functions.NAME1_type5 getNAME1() {
        return localNAME1;
    }

    /**
     * Auto generated setter method
     * @param param NAME1
     */
    public void setNAME1(
        com.nhry.webService.client.Supplier.functions.NAME1_type5 param) {
        localNAME1Tracker = param != null;

        this.localNAME1 = param;
    }

    public boolean isPSTLZSpecified() {
        return localPSTLZTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.PSTLZ_type3
     */
    public com.nhry.webService.client.Supplier.functions.PSTLZ_type3 getPSTLZ() {
        return localPSTLZ;
    }

    /**
     * Auto generated setter method
     * @param param PSTLZ
     */
    public void setPSTLZ(
        com.nhry.webService.client.Supplier.functions.PSTLZ_type3 param) {
        localPSTLZTracker = param != null;

        this.localPSTLZ = param;
    }

    public boolean isSTRASSpecified() {
        return localSTRASTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.STRAS_type3
     */
    public com.nhry.webService.client.Supplier.functions.STRAS_type3 getSTRAS() {
        return localSTRAS;
    }

    /**
     * Auto generated setter method
     * @param param STRAS
     */
    public void setSTRAS(
        com.nhry.webService.client.Supplier.functions.STRAS_type3 param) {
        localSTRASTracker = param != null;

        this.localSTRAS = param;
    }

    public boolean isTEL_NUMBERSpecified() {
        return localTEL_NUMBERTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.TEL_NUMBER_type1
     */
    public com.nhry.webService.client.Supplier.functions.TEL_NUMBER_type1 getTEL_NUMBER() {
        return localTEL_NUMBER;
    }

    /**
     * Auto generated setter method
     * @param param TEL_NUMBER
     */
    public void setTEL_NUMBER(
        com.nhry.webService.client.Supplier.functions.TEL_NUMBER_type1 param) {
        localTEL_NUMBERTracker = param != null;

        this.localTEL_NUMBER = param;
    }

    public boolean isNAME_COSpecified() {
        return localNAME_COTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.NAME_CO_type1
     */
    public com.nhry.webService.client.Supplier.functions.NAME_CO_type1 getNAME_CO() {
        return localNAME_CO;
    }

    /**
     * Auto generated setter method
     * @param param NAME_CO
     */
    public void setNAME_CO(
        com.nhry.webService.client.Supplier.functions.NAME_CO_type1 param) {
        localNAME_COTracker = param != null;

        this.localNAME_CO = param;
    }

    public boolean isSTREETSpecified() {
        return localSTREETTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.STREET_type1
     */
    public com.nhry.webService.client.Supplier.functions.STREET_type1 getSTREET() {
        return localSTREET;
    }

    /**
     * Auto generated setter method
     * @param param STREET
     */
    public void setSTREET(
        com.nhry.webService.client.Supplier.functions.STREET_type1 param) {
        localSTREETTracker = param != null;

        this.localSTREET = param;
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
                    namespacePrefix + ":ZSMM00010", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSMM00010", xmlWriter);
            }
        }

        if (localBUKRSTracker) {
            if (localBUKRS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BUKRS cannot be null!!");
            }

            localBUKRS.serialize(new javax.xml.namespace.QName("", "BUKRS"),
                xmlWriter);
        }

        if (localBUTXTTracker) {
            if (localBUTXT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BUTXT cannot be null!!");
            }

            localBUTXT.serialize(new javax.xml.namespace.QName("", "BUTXT"),
                xmlWriter);
        }

        if (localWERKSTracker) {
            if (localWERKS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "WERKS cannot be null!!");
            }

            localWERKS.serialize(new javax.xml.namespace.QName("", "WERKS"),
                xmlWriter);
        }

        if (localNAME1Tracker) {
            if (localNAME1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NAME1 cannot be null!!");
            }

            localNAME1.serialize(new javax.xml.namespace.QName("", "NAME1"),
                xmlWriter);
        }

        if (localPSTLZTracker) {
            if (localPSTLZ == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PSTLZ cannot be null!!");
            }

            localPSTLZ.serialize(new javax.xml.namespace.QName("", "PSTLZ"),
                xmlWriter);
        }

        if (localSTRASTracker) {
            if (localSTRAS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "STRAS cannot be null!!");
            }

            localSTRAS.serialize(new javax.xml.namespace.QName("", "STRAS"),
                xmlWriter);
        }

        if (localTEL_NUMBERTracker) {
            if (localTEL_NUMBER == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TEL_NUMBER cannot be null!!");
            }

            localTEL_NUMBER.serialize(new javax.xml.namespace.QName("",
                    "TEL_NUMBER"), xmlWriter);
        }

        if (localNAME_COTracker) {
            if (localNAME_CO == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NAME_CO cannot be null!!");
            }

            localNAME_CO.serialize(new javax.xml.namespace.QName("", "NAME_CO"),
                xmlWriter);
        }

        if (localSTREETTracker) {
            if (localSTREET == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "STREET cannot be null!!");
            }

            localSTREET.serialize(new javax.xml.namespace.QName("", "STREET"),
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
        public static ZSMM00010 parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            ZSMM00010 object = new ZSMM00010();

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

                        if (!"ZSMM00010".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSMM00010) com.nhry.webService.client.Supplier.functions.ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "BUKRS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BUKRS").equals(
                            reader.getName())) {
                    object.setBUKRS(com.nhry.webService.client.Supplier.functions.BUKRS_type13.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BUTXT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BUTXT").equals(
                            reader.getName())) {
                    object.setBUTXT(com.nhry.webService.client.Supplier.functions.BUTXT_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "WERKS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "WERKS").equals(
                            reader.getName())) {
                    object.setWERKS(com.nhry.webService.client.Supplier.functions.WERKS_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "NAME1").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "NAME1").equals(
                            reader.getName())) {
                    object.setNAME1(com.nhry.webService.client.Supplier.functions.NAME1_type5.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PSTLZ").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PSTLZ").equals(
                            reader.getName())) {
                    object.setPSTLZ(com.nhry.webService.client.Supplier.functions.PSTLZ_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "STRAS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "STRAS").equals(
                            reader.getName())) {
                    object.setSTRAS(com.nhry.webService.client.Supplier.functions.STRAS_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TEL_NUMBER").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TEL_NUMBER").equals(
                            reader.getName())) {
                    object.setTEL_NUMBER(com.nhry.webService.client.Supplier.functions.TEL_NUMBER_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "NAME_CO").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "NAME_CO").equals(
                            reader.getName())) {
                    object.setNAME_CO(com.nhry.webService.client.Supplier.functions.NAME_CO_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "STREET").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "STREET").equals(
                            reader.getName())) {
                    object.setSTREET(com.nhry.webService.client.Supplier.functions.STREET_type1.Factory.parse(
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
