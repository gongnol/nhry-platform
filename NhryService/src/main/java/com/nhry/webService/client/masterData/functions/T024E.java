/**
 * T024E.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.masterData.functions;


/**
 *  T024E bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class T024E implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = T024E
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for MANDT
     */
    protected com.nhry.webService.client.masterData.functions.MANDT_type13 localMANDT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMANDTTracker = false;

    /**
     * field for EKORG
     */
    protected com.nhry.webService.client.masterData.functions.EKORG_type1 localEKORG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localEKORGTracker = false;

    /**
     * field for EKOTX
     */
    protected com.nhry.webService.client.masterData.functions.EKOTX_type1 localEKOTX;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localEKOTXTracker = false;

    /**
     * field for BUKRS
     */
    protected com.nhry.webService.client.masterData.functions.BUKRS_type5 localBUKRS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBUKRSTracker = false;

    /**
     * field for TXADR
     */
    protected com.nhry.webService.client.masterData.functions.TXADR_type1 localTXADR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTXADRTracker = false;

    /**
     * field for TXKOP
     */
    protected com.nhry.webService.client.masterData.functions.TXKOP_type1 localTXKOP;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTXKOPTracker = false;

    /**
     * field for TXFUS
     */
    protected com.nhry.webService.client.masterData.functions.TXFUS_type1 localTXFUS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTXFUSTracker = false;

    /**
     * field for TXGRU
     */
    protected com.nhry.webService.client.masterData.functions.TXGRU_type1 localTXGRU;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTXGRUTracker = false;

    /**
     * field for KALSE
     */
    protected com.nhry.webService.client.masterData.functions.KALSE_type1 localKALSE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKALSETracker = false;

    /**
     * field for MKALS
     */
    protected com.nhry.webService.client.masterData.functions.MKALS_type1 localMKALS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMKALSTracker = false;

    /**
     * field for BPEFF
     */
    protected com.nhry.webService.client.masterData.functions.BPEFF_type1 localBPEFF;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBPEFFTracker = false;

    /**
     * field for BUKRS_NTR
     */
    protected com.nhry.webService.client.masterData.functions.BUKRS_NTR_type1 localBUKRS_NTR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBUKRS_NTRTracker = false;

    public boolean isMANDTSpecified() {
        return localMANDTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MANDT_type13
     */
    public com.nhry.webService.client.masterData.functions.MANDT_type13 getMANDT() {
        return localMANDT;
    }

    /**
     * Auto generated setter method
     * @param param MANDT
     */
    public void setMANDT(
        com.nhry.webService.client.masterData.functions.MANDT_type13 param) {
        localMANDTTracker = param != null;

        this.localMANDT = param;
    }

    public boolean isEKORGSpecified() {
        return localEKORGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.EKORG_type1
     */
    public com.nhry.webService.client.masterData.functions.EKORG_type1 getEKORG() {
        return localEKORG;
    }

    /**
     * Auto generated setter method
     * @param param EKORG
     */
    public void setEKORG(
        com.nhry.webService.client.masterData.functions.EKORG_type1 param) {
        localEKORGTracker = param != null;

        this.localEKORG = param;
    }

    public boolean isEKOTXSpecified() {
        return localEKOTXTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.EKOTX_type1
     */
    public com.nhry.webService.client.masterData.functions.EKOTX_type1 getEKOTX() {
        return localEKOTX;
    }

    /**
     * Auto generated setter method
     * @param param EKOTX
     */
    public void setEKOTX(
        com.nhry.webService.client.masterData.functions.EKOTX_type1 param) {
        localEKOTXTracker = param != null;

        this.localEKOTX = param;
    }

    public boolean isBUKRSSpecified() {
        return localBUKRSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.BUKRS_type5
     */
    public com.nhry.webService.client.masterData.functions.BUKRS_type5 getBUKRS() {
        return localBUKRS;
    }

    /**
     * Auto generated setter method
     * @param param BUKRS
     */
    public void setBUKRS(
        com.nhry.webService.client.masterData.functions.BUKRS_type5 param) {
        localBUKRSTracker = param != null;

        this.localBUKRS = param;
    }

    public boolean isTXADRSpecified() {
        return localTXADRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.TXADR_type1
     */
    public com.nhry.webService.client.masterData.functions.TXADR_type1 getTXADR() {
        return localTXADR;
    }

    /**
     * Auto generated setter method
     * @param param TXADR
     */
    public void setTXADR(
        com.nhry.webService.client.masterData.functions.TXADR_type1 param) {
        localTXADRTracker = param != null;

        this.localTXADR = param;
    }

    public boolean isTXKOPSpecified() {
        return localTXKOPTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.TXKOP_type1
     */
    public com.nhry.webService.client.masterData.functions.TXKOP_type1 getTXKOP() {
        return localTXKOP;
    }

    /**
     * Auto generated setter method
     * @param param TXKOP
     */
    public void setTXKOP(
        com.nhry.webService.client.masterData.functions.TXKOP_type1 param) {
        localTXKOPTracker = param != null;

        this.localTXKOP = param;
    }

    public boolean isTXFUSSpecified() {
        return localTXFUSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.TXFUS_type1
     */
    public com.nhry.webService.client.masterData.functions.TXFUS_type1 getTXFUS() {
        return localTXFUS;
    }

    /**
     * Auto generated setter method
     * @param param TXFUS
     */
    public void setTXFUS(
        com.nhry.webService.client.masterData.functions.TXFUS_type1 param) {
        localTXFUSTracker = param != null;

        this.localTXFUS = param;
    }

    public boolean isTXGRUSpecified() {
        return localTXGRUTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.TXGRU_type1
     */
    public com.nhry.webService.client.masterData.functions.TXGRU_type1 getTXGRU() {
        return localTXGRU;
    }

    /**
     * Auto generated setter method
     * @param param TXGRU
     */
    public void setTXGRU(
        com.nhry.webService.client.masterData.functions.TXGRU_type1 param) {
        localTXGRUTracker = param != null;

        this.localTXGRU = param;
    }

    public boolean isKALSESpecified() {
        return localKALSETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KALSE_type1
     */
    public com.nhry.webService.client.masterData.functions.KALSE_type1 getKALSE() {
        return localKALSE;
    }

    /**
     * Auto generated setter method
     * @param param KALSE
     */
    public void setKALSE(
        com.nhry.webService.client.masterData.functions.KALSE_type1 param) {
        localKALSETracker = param != null;

        this.localKALSE = param;
    }

    public boolean isMKALSSpecified() {
        return localMKALSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MKALS_type1
     */
    public com.nhry.webService.client.masterData.functions.MKALS_type1 getMKALS() {
        return localMKALS;
    }

    /**
     * Auto generated setter method
     * @param param MKALS
     */
    public void setMKALS(
        com.nhry.webService.client.masterData.functions.MKALS_type1 param) {
        localMKALSTracker = param != null;

        this.localMKALS = param;
    }

    public boolean isBPEFFSpecified() {
        return localBPEFFTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.BPEFF_type1
     */
    public com.nhry.webService.client.masterData.functions.BPEFF_type1 getBPEFF() {
        return localBPEFF;
    }

    /**
     * Auto generated setter method
     * @param param BPEFF
     */
    public void setBPEFF(
        com.nhry.webService.client.masterData.functions.BPEFF_type1 param) {
        localBPEFFTracker = param != null;

        this.localBPEFF = param;
    }

    public boolean isBUKRS_NTRSpecified() {
        return localBUKRS_NTRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.BUKRS_NTR_type1
     */
    public com.nhry.webService.client.masterData.functions.BUKRS_NTR_type1 getBUKRS_NTR() {
        return localBUKRS_NTR;
    }

    /**
     * Auto generated setter method
     * @param param BUKRS_NTR
     */
    public void setBUKRS_NTR(
        com.nhry.webService.client.masterData.functions.BUKRS_NTR_type1 param) {
        localBUKRS_NTRTracker = param != null;

        this.localBUKRS_NTR = param;
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
                    namespacePrefix + ":T024E", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "T024E", xmlWriter);
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

        if (localEKORGTracker) {
            if (localEKORG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "EKORG cannot be null!!");
            }

            localEKORG.serialize(new javax.xml.namespace.QName("", "EKORG"),
                xmlWriter);
        }

        if (localEKOTXTracker) {
            if (localEKOTX == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "EKOTX cannot be null!!");
            }

            localEKOTX.serialize(new javax.xml.namespace.QName("", "EKOTX"),
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

        if (localTXADRTracker) {
            if (localTXADR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TXADR cannot be null!!");
            }

            localTXADR.serialize(new javax.xml.namespace.QName("", "TXADR"),
                xmlWriter);
        }

        if (localTXKOPTracker) {
            if (localTXKOP == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TXKOP cannot be null!!");
            }

            localTXKOP.serialize(new javax.xml.namespace.QName("", "TXKOP"),
                xmlWriter);
        }

        if (localTXFUSTracker) {
            if (localTXFUS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TXFUS cannot be null!!");
            }

            localTXFUS.serialize(new javax.xml.namespace.QName("", "TXFUS"),
                xmlWriter);
        }

        if (localTXGRUTracker) {
            if (localTXGRU == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TXGRU cannot be null!!");
            }

            localTXGRU.serialize(new javax.xml.namespace.QName("", "TXGRU"),
                xmlWriter);
        }

        if (localKALSETracker) {
            if (localKALSE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KALSE cannot be null!!");
            }

            localKALSE.serialize(new javax.xml.namespace.QName("", "KALSE"),
                xmlWriter);
        }

        if (localMKALSTracker) {
            if (localMKALS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MKALS cannot be null!!");
            }

            localMKALS.serialize(new javax.xml.namespace.QName("", "MKALS"),
                xmlWriter);
        }

        if (localBPEFFTracker) {
            if (localBPEFF == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BPEFF cannot be null!!");
            }

            localBPEFF.serialize(new javax.xml.namespace.QName("", "BPEFF"),
                xmlWriter);
        }

        if (localBUKRS_NTRTracker) {
            if (localBUKRS_NTR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BUKRS_NTR cannot be null!!");
            }

            localBUKRS_NTR.serialize(new javax.xml.namespace.QName("",
                    "BUKRS_NTR"), xmlWriter);
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
        public static T024E parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            T024E object = new T024E();

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

                        if (!"T024E".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (T024E) com.nhry.webService.client.masterData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                    object.setMANDT(com.nhry.webService.client.masterData.functions.MANDT_type13.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "EKORG").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "EKORG").equals(
                            reader.getName())) {
                    object.setEKORG(com.nhry.webService.client.masterData.functions.EKORG_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "EKOTX").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "EKOTX").equals(
                            reader.getName())) {
                    object.setEKOTX(com.nhry.webService.client.masterData.functions.EKOTX_type1.Factory.parse(
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
                    object.setBUKRS(com.nhry.webService.client.masterData.functions.BUKRS_type5.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TXADR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TXADR").equals(
                            reader.getName())) {
                    object.setTXADR(com.nhry.webService.client.masterData.functions.TXADR_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TXKOP").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TXKOP").equals(
                            reader.getName())) {
                    object.setTXKOP(com.nhry.webService.client.masterData.functions.TXKOP_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TXFUS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TXFUS").equals(
                            reader.getName())) {
                    object.setTXFUS(com.nhry.webService.client.masterData.functions.TXFUS_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TXGRU").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TXGRU").equals(
                            reader.getName())) {
                    object.setTXGRU(com.nhry.webService.client.masterData.functions.TXGRU_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KALSE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KALSE").equals(
                            reader.getName())) {
                    object.setKALSE(com.nhry.webService.client.masterData.functions.KALSE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MKALS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MKALS").equals(
                            reader.getName())) {
                    object.setMKALS(com.nhry.webService.client.masterData.functions.MKALS_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BPEFF").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BPEFF").equals(
                            reader.getName())) {
                    object.setBPEFF(com.nhry.webService.client.masterData.functions.BPEFF_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BUKRS_NTR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BUKRS_NTR").equals(
                            reader.getName())) {
                    object.setBUKRS_NTR(com.nhry.webService.client.masterData.functions.BUKRS_NTR_type1.Factory.parse(
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
