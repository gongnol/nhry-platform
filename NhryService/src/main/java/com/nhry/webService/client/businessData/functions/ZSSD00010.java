/**
 * ZSSD00010.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:48:01 BST)
 */
package com.nhry.webService.client.businessData.functions;


/**
 *  ZSSD00010 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSSD00010 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSSD00010
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for KUNNR
     */
    protected com.nhry.webService.client.businessData.functions.KUNNR_type1 localKUNNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKUNNRTracker = false;

    /**
     * field for KUNWE
     */
    protected com.nhry.webService.client.businessData.functions.KUNWE_type1 localKUNWE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKUNWETracker = false;

    /**
     * field for VKORG
     */
    protected com.nhry.webService.client.businessData.functions.VKORG_type1 localVKORG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVKORGTracker = false;

    /**
     * field for VTWEG
     */
    protected com.nhry.webService.client.businessData.functions.VTWEG_type1 localVTWEG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVTWEGTracker = false;

    /**
     * field for SPART
     */
    protected com.nhry.webService.client.businessData.functions.SPART_type1 localSPART;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSPARTTracker = false;

    /**
     * field for AUART
     */
    protected com.nhry.webService.client.businessData.functions.AUART_type1 localAUART;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localAUARTTracker = false;

    /**
     * field for BSTKD
     */
    protected com.nhry.webService.client.businessData.functions.BSTKD_type1 localBSTKD;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBSTKDTracker = false;

    /**
     * field for LFDAT
     */
    protected com.nhry.webService.client.businessData.functions.Date localLFDAT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLFDATTracker = false;

    /**
     * field for AUGRU
     */
    protected com.nhry.webService.client.businessData.functions.AUGRU_type1 localAUGRU;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localAUGRUTracker = false;

    /**
     * field for ZZ001
     */
    protected com.nhry.webService.client.businessData.functions.ZZ001_type1 localZZ001;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localZZ001Tracker = false;

    /**
     * field for KOSTL
     */
    protected com.nhry.webService.client.businessData.functions.KOSTL_type1 localKOSTL;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKOSTLTracker = false;

    /**
     * field for AUDAT
     */
    protected com.nhry.webService.client.businessData.functions.Date localAUDAT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localAUDATTracker = false;

    /**
     * field for CMPGN_EXTID
     */
    protected com.nhry.webService.client.businessData.functions.CMPGN_EXTID_type1 localCMPGN_EXTID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCMPGN_EXTIDTracker = false;

    /**
     * field for KUNWE2
     */
    protected com.nhry.webService.client.businessData.functions.KUNWE2_type1 localKUNWE2;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKUNWE2Tracker = false;

    /**
     * field for IHREZ
     */
    protected com.nhry.webService.client.businessData.functions.IHREZ_type1 localIHREZ;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIHREZTracker = false;

    public boolean isKUNNRSpecified() {
        return localKUNNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.KUNNR_type1
     */
    public com.nhry.webService.client.businessData.functions.KUNNR_type1 getKUNNR() {
        return localKUNNR;
    }

    /**
     * Auto generated setter method
     * @param param KUNNR
     */
    public void setKUNNR(
        com.nhry.webService.client.businessData.functions.KUNNR_type1 param) {
        localKUNNRTracker = param != null;

        this.localKUNNR = param;
    }

    public boolean isKUNWESpecified() {
        return localKUNWETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.KUNWE_type1
     */
    public com.nhry.webService.client.businessData.functions.KUNWE_type1 getKUNWE() {
        return localKUNWE;
    }

    /**
     * Auto generated setter method
     * @param param KUNWE
     */
    public void setKUNWE(
        com.nhry.webService.client.businessData.functions.KUNWE_type1 param) {
        localKUNWETracker = param != null;

        this.localKUNWE = param;
    }

    public boolean isVKORGSpecified() {
        return localVKORGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.VKORG_type1
     */
    public com.nhry.webService.client.businessData.functions.VKORG_type1 getVKORG() {
        return localVKORG;
    }

    /**
     * Auto generated setter method
     * @param param VKORG
     */
    public void setVKORG(
        com.nhry.webService.client.businessData.functions.VKORG_type1 param) {
        localVKORGTracker = param != null;

        this.localVKORG = param;
    }

    public boolean isVTWEGSpecified() {
        return localVTWEGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.VTWEG_type1
     */
    public com.nhry.webService.client.businessData.functions.VTWEG_type1 getVTWEG() {
        return localVTWEG;
    }

    /**
     * Auto generated setter method
     * @param param VTWEG
     */
    public void setVTWEG(
        com.nhry.webService.client.businessData.functions.VTWEG_type1 param) {
        localVTWEGTracker = param != null;

        this.localVTWEG = param;
    }

    public boolean isSPARTSpecified() {
        return localSPARTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.SPART_type1
     */
    public com.nhry.webService.client.businessData.functions.SPART_type1 getSPART() {
        return localSPART;
    }

    /**
     * Auto generated setter method
     * @param param SPART
     */
    public void setSPART(
        com.nhry.webService.client.businessData.functions.SPART_type1 param) {
        localSPARTTracker = param != null;

        this.localSPART = param;
    }

    public boolean isAUARTSpecified() {
        return localAUARTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.AUART_type1
     */
    public com.nhry.webService.client.businessData.functions.AUART_type1 getAUART() {
        return localAUART;
    }

    /**
     * Auto generated setter method
     * @param param AUART
     */
    public void setAUART(
        com.nhry.webService.client.businessData.functions.AUART_type1 param) {
        localAUARTTracker = param != null;

        this.localAUART = param;
    }

    public boolean isBSTKDSpecified() {
        return localBSTKDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.BSTKD_type1
     */
    public com.nhry.webService.client.businessData.functions.BSTKD_type1 getBSTKD() {
        return localBSTKD;
    }

    /**
     * Auto generated setter method
     * @param param BSTKD
     */
    public void setBSTKD(
        com.nhry.webService.client.businessData.functions.BSTKD_type1 param) {
        localBSTKDTracker = param != null;

        this.localBSTKD = param;
    }

    public boolean isLFDATSpecified() {
        return localLFDATTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.Date
     */
    public com.nhry.webService.client.businessData.functions.Date getLFDAT() {
        return localLFDAT;
    }

    /**
     * Auto generated setter method
     * @param param LFDAT
     */
    public void setLFDAT(
        com.nhry.webService.client.businessData.functions.Date param) {
        localLFDATTracker = param != null;

        this.localLFDAT = param;
    }

    public boolean isAUGRUSpecified() {
        return localAUGRUTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.AUGRU_type1
     */
    public com.nhry.webService.client.businessData.functions.AUGRU_type1 getAUGRU() {
        return localAUGRU;
    }

    /**
     * Auto generated setter method
     * @param param AUGRU
     */
    public void setAUGRU(
        com.nhry.webService.client.businessData.functions.AUGRU_type1 param) {
        localAUGRUTracker = param != null;

        this.localAUGRU = param;
    }

    public boolean isZZ001Specified() {
        return localZZ001Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.ZZ001_type1
     */
    public com.nhry.webService.client.businessData.functions.ZZ001_type1 getZZ001() {
        return localZZ001;
    }

    /**
     * Auto generated setter method
     * @param param ZZ001
     */
    public void setZZ001(
        com.nhry.webService.client.businessData.functions.ZZ001_type1 param) {
        localZZ001Tracker = param != null;

        this.localZZ001 = param;
    }

    public boolean isKOSTLSpecified() {
        return localKOSTLTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.KOSTL_type1
     */
    public com.nhry.webService.client.businessData.functions.KOSTL_type1 getKOSTL() {
        return localKOSTL;
    }

    /**
     * Auto generated setter method
     * @param param KOSTL
     */
    public void setKOSTL(
        com.nhry.webService.client.businessData.functions.KOSTL_type1 param) {
        localKOSTLTracker = param != null;

        this.localKOSTL = param;
    }

    public boolean isAUDATSpecified() {
        return localAUDATTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.Date
     */
    public com.nhry.webService.client.businessData.functions.Date getAUDAT() {
        return localAUDAT;
    }

    /**
     * Auto generated setter method
     * @param param AUDAT
     */
    public void setAUDAT(
        com.nhry.webService.client.businessData.functions.Date param) {
        localAUDATTracker = param != null;

        this.localAUDAT = param;
    }

    public boolean isCMPGN_EXTIDSpecified() {
        return localCMPGN_EXTIDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.CMPGN_EXTID_type1
     */
    public com.nhry.webService.client.businessData.functions.CMPGN_EXTID_type1 getCMPGN_EXTID() {
        return localCMPGN_EXTID;
    }

    /**
     * Auto generated setter method
     * @param param CMPGN_EXTID
     */
    public void setCMPGN_EXTID(
        com.nhry.webService.client.businessData.functions.CMPGN_EXTID_type1 param) {
        localCMPGN_EXTIDTracker = param != null;

        this.localCMPGN_EXTID = param;
    }

    public boolean isKUNWE2Specified() {
        return localKUNWE2Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.KUNWE2_type1
     */
    public com.nhry.webService.client.businessData.functions.KUNWE2_type1 getKUNWE2() {
        return localKUNWE2;
    }

    /**
     * Auto generated setter method
     * @param param KUNWE2
     */
    public void setKUNWE2(
        com.nhry.webService.client.businessData.functions.KUNWE2_type1 param) {
        localKUNWE2Tracker = param != null;

        this.localKUNWE2 = param;
    }

    public boolean isIHREZSpecified() {
        return localIHREZTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.IHREZ_type1
     */
    public com.nhry.webService.client.businessData.functions.IHREZ_type1 getIHREZ() {
        return localIHREZ;
    }

    /**
     * Auto generated setter method
     * @param param IHREZ
     */
    public void setIHREZ(
        com.nhry.webService.client.businessData.functions.IHREZ_type1 param) {
        localIHREZTracker = param != null;

        this.localIHREZ = param;
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
                    namespacePrefix + ":ZSSD00010", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSSD00010", xmlWriter);
            }
        }

        if (localKUNNRTracker) {
            if (localKUNNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KUNNR cannot be null!!");
            }

            localKUNNR.serialize(new javax.xml.namespace.QName("", "KUNNR"),
                xmlWriter);
        }

        if (localKUNWETracker) {
            if (localKUNWE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KUNWE cannot be null!!");
            }

            localKUNWE.serialize(new javax.xml.namespace.QName("", "KUNWE"),
                xmlWriter);
        }

        if (localVKORGTracker) {
            if (localVKORG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "VKORG cannot be null!!");
            }

            localVKORG.serialize(new javax.xml.namespace.QName("", "VKORG"),
                xmlWriter);
        }

        if (localVTWEGTracker) {
            if (localVTWEG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "VTWEG cannot be null!!");
            }

            localVTWEG.serialize(new javax.xml.namespace.QName("", "VTWEG"),
                xmlWriter);
        }

        if (localSPARTTracker) {
            if (localSPART == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SPART cannot be null!!");
            }

            localSPART.serialize(new javax.xml.namespace.QName("", "SPART"),
                xmlWriter);
        }

        if (localAUARTTracker) {
            if (localAUART == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "AUART cannot be null!!");
            }

            localAUART.serialize(new javax.xml.namespace.QName("", "AUART"),
                xmlWriter);
        }

        if (localBSTKDTracker) {
            if (localBSTKD == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BSTKD cannot be null!!");
            }

            localBSTKD.serialize(new javax.xml.namespace.QName("", "BSTKD"),
                xmlWriter);
        }

        if (localLFDATTracker) {
            if (localLFDAT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "LFDAT cannot be null!!");
            }

            localLFDAT.serialize(new javax.xml.namespace.QName("", "LFDAT"),
                xmlWriter);
        }

        if (localAUGRUTracker) {
            if (localAUGRU == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "AUGRU cannot be null!!");
            }

            localAUGRU.serialize(new javax.xml.namespace.QName("", "AUGRU"),
                xmlWriter);
        }

        if (localZZ001Tracker) {
            if (localZZ001 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ZZ001 cannot be null!!");
            }

            localZZ001.serialize(new javax.xml.namespace.QName("", "ZZ001"),
                xmlWriter);
        }

        if (localKOSTLTracker) {
            if (localKOSTL == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KOSTL cannot be null!!");
            }

            localKOSTL.serialize(new javax.xml.namespace.QName("", "KOSTL"),
                xmlWriter);
        }

        if (localAUDATTracker) {
            if (localAUDAT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "AUDAT cannot be null!!");
            }

            localAUDAT.serialize(new javax.xml.namespace.QName("", "AUDAT"),
                xmlWriter);
        }

        if (localCMPGN_EXTIDTracker) {
            if (localCMPGN_EXTID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CMPGN_EXTID cannot be null!!");
            }

            localCMPGN_EXTID.serialize(new javax.xml.namespace.QName("",
                    "CMPGN_EXTID"), xmlWriter);
        }

        if (localKUNWE2Tracker) {
            if (localKUNWE2 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KUNWE2 cannot be null!!");
            }

            localKUNWE2.serialize(new javax.xml.namespace.QName("", "KUNWE2"),
                xmlWriter);
        }

        if (localIHREZTracker) {
            if (localIHREZ == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "IHREZ cannot be null!!");
            }

            localIHREZ.serialize(new javax.xml.namespace.QName("", "IHREZ"),
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
        public static ZSSD00010 parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            ZSSD00010 object = new ZSSD00010();

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

                        if (!"ZSSD00010".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSSD00010) com.nhry.webService.client.businessData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "KUNNR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KUNNR").equals(
                            reader.getName())) {
                    object.setKUNNR(com.nhry.webService.client.businessData.functions.KUNNR_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KUNWE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KUNWE").equals(
                            reader.getName())) {
                    object.setKUNWE(com.nhry.webService.client.businessData.functions.KUNWE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "VKORG").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "VKORG").equals(
                            reader.getName())) {
                    object.setVKORG(com.nhry.webService.client.businessData.functions.VKORG_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "VTWEG").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "VTWEG").equals(
                            reader.getName())) {
                    object.setVTWEG(com.nhry.webService.client.businessData.functions.VTWEG_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "SPART").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "SPART").equals(
                            reader.getName())) {
                    object.setSPART(com.nhry.webService.client.businessData.functions.SPART_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "AUART").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "AUART").equals(
                            reader.getName())) {
                    object.setAUART(com.nhry.webService.client.businessData.functions.AUART_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BSTKD").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BSTKD").equals(
                            reader.getName())) {
                    object.setBSTKD(com.nhry.webService.client.businessData.functions.BSTKD_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "LFDAT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "LFDAT").equals(
                            reader.getName())) {
                    object.setLFDAT(com.nhry.webService.client.businessData.functions.Date.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "AUGRU").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "AUGRU").equals(
                            reader.getName())) {
                    object.setAUGRU(com.nhry.webService.client.businessData.functions.AUGRU_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "ZZ001").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ZZ001").equals(
                            reader.getName())) {
                    object.setZZ001(com.nhry.webService.client.businessData.functions.ZZ001_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KOSTL").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KOSTL").equals(
                            reader.getName())) {
                    object.setKOSTL(com.nhry.webService.client.businessData.functions.KOSTL_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "AUDAT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "AUDAT").equals(
                            reader.getName())) {
                    object.setAUDAT(com.nhry.webService.client.businessData.functions.Date.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "CMPGN_EXTID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "CMPGN_EXTID").equals(
                            reader.getName())) {
                    object.setCMPGN_EXTID(com.nhry.webService.client.businessData.functions.CMPGN_EXTID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KUNWE2").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KUNWE2").equals(
                            reader.getName())) {
                    object.setKUNWE2(com.nhry.webService.client.businessData.functions.KUNWE2_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "IHREZ").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "IHREZ").equals(
                            reader.getName())) {
                    object.setIHREZ(com.nhry.webService.client.businessData.functions.IHREZ_type1.Factory.parse(
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
