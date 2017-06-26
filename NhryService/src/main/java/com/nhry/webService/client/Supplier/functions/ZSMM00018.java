/**
 * ZSMM00018.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.Supplier.functions;


/**
 *  ZSMM00018 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSMM00018 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSMM00018
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for KOSTL
     */
    protected com.nhry.webService.client.Supplier.functions.KOSTL_type3 localKOSTL;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKOSTLTracker = false;

    /**
     * field for DATBI
     */
    protected com.nhry.webService.client.Supplier.functions.Date localDATBI;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localDATBITracker = false;

    /**
     * field for DATAB
     */
    protected com.nhry.webService.client.Supplier.functions.Date localDATAB;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localDATABTracker = false;

    /**
     * field for BUKRS
     */
    protected com.nhry.webService.client.Supplier.functions.BUKRS_type7 localBUKRS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBUKRSTracker = false;

    /**
     * field for VERAK
     */
    protected com.nhry.webService.client.Supplier.functions.VERAK_type1 localVERAK;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVERAKTracker = false;

    /**
     * field for PRCTR
     */
    protected com.nhry.webService.client.Supplier.functions.PRCTR_type3 localPRCTR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPRCTRTracker = false;

    /**
     * field for KTEXT
     */
    protected com.nhry.webService.client.Supplier.functions.KTEXT_type3 localKTEXT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKTEXTTracker = false;

    /**
     * field for KOSAR
     */
    protected com.nhry.webService.client.Supplier.functions.KOSAR_type1 localKOSAR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKOSARTracker = false;

    /**
     * field for KTEXT1
     */
    protected com.nhry.webService.client.Supplier.functions.KTEXT1_type1 localKTEXT1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKTEXT1Tracker = false;

    /**
     * field for WAERS
     */
    protected com.nhry.webService.client.Supplier.functions.WAERS_type5 localWAERS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localWAERSTracker = false;

    /**
     * field for GSBER
     */
    protected com.nhry.webService.client.Supplier.functions.GSBER_type3 localGSBER;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localGSBERTracker = false;

    /**
     * field for NAME1
     */
    protected com.nhry.webService.client.Supplier.functions.NAME1_type3 localNAME1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localNAME1Tracker = false;

    /**
     * field for FUNC_AREA
     */
    protected com.nhry.webService.client.Supplier.functions.FUNC_AREA_type3 localFUNC_AREA;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localFUNC_AREATracker = false;

    /**
     * field for KHINR
     */
    protected com.nhry.webService.client.Supplier.functions.KHINR_type1 localKHINR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKHINRTracker = false;

    public boolean isKOSTLSpecified() {
        return localKOSTLTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.KOSTL_type3
     */
    public com.nhry.webService.client.Supplier.functions.KOSTL_type3 getKOSTL() {
        return localKOSTL;
    }

    /**
     * Auto generated setter method
     * @param param KOSTL
     */
    public void setKOSTL(
        com.nhry.webService.client.Supplier.functions.KOSTL_type3 param) {
        localKOSTLTracker = param != null;

        this.localKOSTL = param;
    }

    public boolean isDATBISpecified() {
        return localDATBITracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.Date
     */
    public com.nhry.webService.client.Supplier.functions.Date getDATBI() {
        return localDATBI;
    }

    /**
     * Auto generated setter method
     * @param param DATBI
     */
    public void setDATBI(
        com.nhry.webService.client.Supplier.functions.Date param) {
        localDATBITracker = param != null;

        this.localDATBI = param;
    }

    public boolean isDATABSpecified() {
        return localDATABTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.Date
     */
    public com.nhry.webService.client.Supplier.functions.Date getDATAB() {
        return localDATAB;
    }

    /**
     * Auto generated setter method
     * @param param DATAB
     */
    public void setDATAB(
        com.nhry.webService.client.Supplier.functions.Date param) {
        localDATABTracker = param != null;

        this.localDATAB = param;
    }

    public boolean isBUKRSSpecified() {
        return localBUKRSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.BUKRS_type7
     */
    public com.nhry.webService.client.Supplier.functions.BUKRS_type7 getBUKRS() {
        return localBUKRS;
    }

    /**
     * Auto generated setter method
     * @param param BUKRS
     */
    public void setBUKRS(
        com.nhry.webService.client.Supplier.functions.BUKRS_type7 param) {
        localBUKRSTracker = param != null;

        this.localBUKRS = param;
    }

    public boolean isVERAKSpecified() {
        return localVERAKTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.VERAK_type1
     */
    public com.nhry.webService.client.Supplier.functions.VERAK_type1 getVERAK() {
        return localVERAK;
    }

    /**
     * Auto generated setter method
     * @param param VERAK
     */
    public void setVERAK(
        com.nhry.webService.client.Supplier.functions.VERAK_type1 param) {
        localVERAKTracker = param != null;

        this.localVERAK = param;
    }

    public boolean isPRCTRSpecified() {
        return localPRCTRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.PRCTR_type3
     */
    public com.nhry.webService.client.Supplier.functions.PRCTR_type3 getPRCTR() {
        return localPRCTR;
    }

    /**
     * Auto generated setter method
     * @param param PRCTR
     */
    public void setPRCTR(
        com.nhry.webService.client.Supplier.functions.PRCTR_type3 param) {
        localPRCTRTracker = param != null;

        this.localPRCTR = param;
    }

    public boolean isKTEXTSpecified() {
        return localKTEXTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.KTEXT_type3
     */
    public com.nhry.webService.client.Supplier.functions.KTEXT_type3 getKTEXT() {
        return localKTEXT;
    }

    /**
     * Auto generated setter method
     * @param param KTEXT
     */
    public void setKTEXT(
        com.nhry.webService.client.Supplier.functions.KTEXT_type3 param) {
        localKTEXTTracker = param != null;

        this.localKTEXT = param;
    }

    public boolean isKOSARSpecified() {
        return localKOSARTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.KOSAR_type1
     */
    public com.nhry.webService.client.Supplier.functions.KOSAR_type1 getKOSAR() {
        return localKOSAR;
    }

    /**
     * Auto generated setter method
     * @param param KOSAR
     */
    public void setKOSAR(
        com.nhry.webService.client.Supplier.functions.KOSAR_type1 param) {
        localKOSARTracker = param != null;

        this.localKOSAR = param;
    }

    public boolean isKTEXT1Specified() {
        return localKTEXT1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.KTEXT1_type1
     */
    public com.nhry.webService.client.Supplier.functions.KTEXT1_type1 getKTEXT1() {
        return localKTEXT1;
    }

    /**
     * Auto generated setter method
     * @param param KTEXT1
     */
    public void setKTEXT1(
        com.nhry.webService.client.Supplier.functions.KTEXT1_type1 param) {
        localKTEXT1Tracker = param != null;

        this.localKTEXT1 = param;
    }

    public boolean isWAERSSpecified() {
        return localWAERSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.WAERS_type5
     */
    public com.nhry.webService.client.Supplier.functions.WAERS_type5 getWAERS() {
        return localWAERS;
    }

    /**
     * Auto generated setter method
     * @param param WAERS
     */
    public void setWAERS(
        com.nhry.webService.client.Supplier.functions.WAERS_type5 param) {
        localWAERSTracker = param != null;

        this.localWAERS = param;
    }

    public boolean isGSBERSpecified() {
        return localGSBERTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.GSBER_type3
     */
    public com.nhry.webService.client.Supplier.functions.GSBER_type3 getGSBER() {
        return localGSBER;
    }

    /**
     * Auto generated setter method
     * @param param GSBER
     */
    public void setGSBER(
        com.nhry.webService.client.Supplier.functions.GSBER_type3 param) {
        localGSBERTracker = param != null;

        this.localGSBER = param;
    }

    public boolean isNAME1Specified() {
        return localNAME1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.NAME1_type3
     */
    public com.nhry.webService.client.Supplier.functions.NAME1_type3 getNAME1() {
        return localNAME1;
    }

    /**
     * Auto generated setter method
     * @param param NAME1
     */
    public void setNAME1(
        com.nhry.webService.client.Supplier.functions.NAME1_type3 param) {
        localNAME1Tracker = param != null;

        this.localNAME1 = param;
    }

    public boolean isFUNC_AREASpecified() {
        return localFUNC_AREATracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.FUNC_AREA_type3
     */
    public com.nhry.webService.client.Supplier.functions.FUNC_AREA_type3 getFUNC_AREA() {
        return localFUNC_AREA;
    }

    /**
     * Auto generated setter method
     * @param param FUNC_AREA
     */
    public void setFUNC_AREA(
        com.nhry.webService.client.Supplier.functions.FUNC_AREA_type3 param) {
        localFUNC_AREATracker = param != null;

        this.localFUNC_AREA = param;
    }

    public boolean isKHINRSpecified() {
        return localKHINRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Supplier.functions.KHINR_type1
     */
    public com.nhry.webService.client.Supplier.functions.KHINR_type1 getKHINR() {
        return localKHINR;
    }

    /**
     * Auto generated setter method
     * @param param KHINR
     */
    public void setKHINR(
        com.nhry.webService.client.Supplier.functions.KHINR_type1 param) {
        localKHINRTracker = param != null;

        this.localKHINR = param;
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
                    namespacePrefix + ":ZSMM00018", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSMM00018", xmlWriter);
            }
        }

        if (localKOSTLTracker) {
            if (localKOSTL == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KOSTL cannot be null!!");
            }

            localKOSTL.serialize(new javax.xml.namespace.QName("", "KOSTL"),
                xmlWriter);
        }

        if (localDATBITracker) {
            if (localDATBI == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "DATBI cannot be null!!");
            }

            localDATBI.serialize(new javax.xml.namespace.QName("", "DATBI"),
                xmlWriter);
        }

        if (localDATABTracker) {
            if (localDATAB == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "DATAB cannot be null!!");
            }

            localDATAB.serialize(new javax.xml.namespace.QName("", "DATAB"),
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

        if (localVERAKTracker) {
            if (localVERAK == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "VERAK cannot be null!!");
            }

            localVERAK.serialize(new javax.xml.namespace.QName("", "VERAK"),
                xmlWriter);
        }

        if (localPRCTRTracker) {
            if (localPRCTR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PRCTR cannot be null!!");
            }

            localPRCTR.serialize(new javax.xml.namespace.QName("", "PRCTR"),
                xmlWriter);
        }

        if (localKTEXTTracker) {
            if (localKTEXT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KTEXT cannot be null!!");
            }

            localKTEXT.serialize(new javax.xml.namespace.QName("", "KTEXT"),
                xmlWriter);
        }

        if (localKOSARTracker) {
            if (localKOSAR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KOSAR cannot be null!!");
            }

            localKOSAR.serialize(new javax.xml.namespace.QName("", "KOSAR"),
                xmlWriter);
        }

        if (localKTEXT1Tracker) {
            if (localKTEXT1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KTEXT1 cannot be null!!");
            }

            localKTEXT1.serialize(new javax.xml.namespace.QName("", "KTEXT1"),
                xmlWriter);
        }

        if (localWAERSTracker) {
            if (localWAERS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "WAERS cannot be null!!");
            }

            localWAERS.serialize(new javax.xml.namespace.QName("", "WAERS"),
                xmlWriter);
        }

        if (localGSBERTracker) {
            if (localGSBER == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "GSBER cannot be null!!");
            }

            localGSBER.serialize(new javax.xml.namespace.QName("", "GSBER"),
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

        if (localFUNC_AREATracker) {
            if (localFUNC_AREA == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "FUNC_AREA cannot be null!!");
            }

            localFUNC_AREA.serialize(new javax.xml.namespace.QName("",
                    "FUNC_AREA"), xmlWriter);
        }

        if (localKHINRTracker) {
            if (localKHINR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KHINR cannot be null!!");
            }

            localKHINR.serialize(new javax.xml.namespace.QName("", "KHINR"),
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
        public static ZSMM00018 parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            ZSMM00018 object = new ZSMM00018();

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

                        if (!"ZSMM00018".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSMM00018) com.nhry.webService.client.Supplier.functions.ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "KOSTL").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KOSTL").equals(
                            reader.getName())) {
                    object.setKOSTL(com.nhry.webService.client.Supplier.functions.KOSTL_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "DATBI").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "DATBI").equals(
                            reader.getName())) {
                    object.setDATBI(com.nhry.webService.client.Supplier.functions.Date.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "DATAB").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "DATAB").equals(
                            reader.getName())) {
                    object.setDATAB(com.nhry.webService.client.Supplier.functions.Date.Factory.parse(
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
                    object.setBUKRS(com.nhry.webService.client.Supplier.functions.BUKRS_type7.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "VERAK").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "VERAK").equals(
                            reader.getName())) {
                    object.setVERAK(com.nhry.webService.client.Supplier.functions.VERAK_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PRCTR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PRCTR").equals(
                            reader.getName())) {
                    object.setPRCTR(com.nhry.webService.client.Supplier.functions.PRCTR_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KTEXT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KTEXT").equals(
                            reader.getName())) {
                    object.setKTEXT(com.nhry.webService.client.Supplier.functions.KTEXT_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KOSAR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KOSAR").equals(
                            reader.getName())) {
                    object.setKOSAR(com.nhry.webService.client.Supplier.functions.KOSAR_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KTEXT1").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KTEXT1").equals(
                            reader.getName())) {
                    object.setKTEXT1(com.nhry.webService.client.Supplier.functions.KTEXT1_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "WAERS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "WAERS").equals(
                            reader.getName())) {
                    object.setWAERS(com.nhry.webService.client.Supplier.functions.WAERS_type5.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "GSBER").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "GSBER").equals(
                            reader.getName())) {
                    object.setGSBER(com.nhry.webService.client.Supplier.functions.GSBER_type3.Factory.parse(
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
                    object.setNAME1(com.nhry.webService.client.Supplier.functions.NAME1_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "FUNC_AREA").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "FUNC_AREA").equals(
                            reader.getName())) {
                    object.setFUNC_AREA(com.nhry.webService.client.Supplier.functions.FUNC_AREA_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KHINR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KHINR").equals(
                            reader.getName())) {
                    object.setKHINR(com.nhry.webService.client.Supplier.functions.KHINR_type1.Factory.parse(
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
