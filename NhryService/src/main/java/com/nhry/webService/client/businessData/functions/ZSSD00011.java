/**
 * ZSSD00011.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:48:01 BST)
 */
package com.nhry.webService.client.businessData.functions;


/**
 *  ZSSD00011 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSSD00011 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSSD00011
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for MATNR
     */
    protected com.nhry.webService.client.businessData.functions.MATNR_type1 localMATNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMATNRTracker = false;

    /**
     * field for KWMENG
     */
    protected com.nhry.webService.client.businessData.functions.KWMENG_type1 localKWMENG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKWMENGTracker = false;

    /**
     * field for VRKME
     */
    protected com.nhry.webService.client.businessData.functions.VRKME_type1 localVRKME;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVRKMETracker = false;

    /**
     * field for WERKS
     */
    protected com.nhry.webService.client.businessData.functions.WERKS_type1 localWERKS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localWERKSTracker = false;

    /**
     * field for LGORT
     */
    protected com.nhry.webService.client.businessData.functions.LGORT_type1 localLGORT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLGORTTracker = false;

    /**
     * field for POSEX
     */
    protected com.nhry.webService.client.businessData.functions.POSEX_type1 localPOSEX;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPOSEXTracker = false;

    /**
     * field for AUGRU
     */
    protected com.nhry.webService.client.businessData.functions.AUGRU_type3 localAUGRU;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localAUGRUTracker = false;

    /**
     * field for KBETR
     */
    protected com.nhry.webService.client.businessData.functions.KBETR_type1 localKBETR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKBETRTracker = false;

    /**
     * field for REQ_DATE
     */
    protected com.nhry.webService.client.businessData.functions.Date localREQ_DATE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localREQ_DATETracker = false;

    /**
     * field for PSTYV
     */
    protected com.nhry.webService.client.businessData.functions.PSTYV_type1 localPSTYV;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPSTYVTracker = false;

    /**
     * field for PR_REF_MAT
     */
    protected com.nhry.webService.client.businessData.functions.PR_REF_MAT_type1 localPR_REF_MAT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPR_REF_MATTracker = false;

    /**
     * field for WBS_ELEM
     */
    protected com.nhry.webService.client.businessData.functions.WBS_ELEM_type1 localWBS_ELEM;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localWBS_ELEMTracker = false;

    /**
     * field for YK01
     */
    protected com.nhry.webService.client.businessData.functions.YK01_type1 localYK01;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localYK01Tracker = false;

    /**
     * field for YK21
     */
    protected com.nhry.webService.client.businessData.functions.YK21_type1 localYK21;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localYK21Tracker = false;

    public boolean isMATNRSpecified() {
        return localMATNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.MATNR_type1
     */
    public com.nhry.webService.client.businessData.functions.MATNR_type1 getMATNR() {
        return localMATNR;
    }

    /**
     * Auto generated setter method
     * @param param MATNR
     */
    public void setMATNR(
        com.nhry.webService.client.businessData.functions.MATNR_type1 param) {
        localMATNRTracker = param != null;

        this.localMATNR = param;
    }

    public boolean isKWMENGSpecified() {
        return localKWMENGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.KWMENG_type1
     */
    public com.nhry.webService.client.businessData.functions.KWMENG_type1 getKWMENG() {
        return localKWMENG;
    }

    /**
     * Auto generated setter method
     * @param param KWMENG
     */
    public void setKWMENG(
        com.nhry.webService.client.businessData.functions.KWMENG_type1 param) {
        localKWMENGTracker = param != null;

        this.localKWMENG = param;
    }

    public boolean isVRKMESpecified() {
        return localVRKMETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.VRKME_type1
     */
    public com.nhry.webService.client.businessData.functions.VRKME_type1 getVRKME() {
        return localVRKME;
    }

    /**
     * Auto generated setter method
     * @param param VRKME
     */
    public void setVRKME(
        com.nhry.webService.client.businessData.functions.VRKME_type1 param) {
        localVRKMETracker = param != null;

        this.localVRKME = param;
    }

    public boolean isWERKSSpecified() {
        return localWERKSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.WERKS_type1
     */
    public com.nhry.webService.client.businessData.functions.WERKS_type1 getWERKS() {
        return localWERKS;
    }

    /**
     * Auto generated setter method
     * @param param WERKS
     */
    public void setWERKS(
        com.nhry.webService.client.businessData.functions.WERKS_type1 param) {
        localWERKSTracker = param != null;

        this.localWERKS = param;
    }

    public boolean isLGORTSpecified() {
        return localLGORTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.LGORT_type1
     */
    public com.nhry.webService.client.businessData.functions.LGORT_type1 getLGORT() {
        return localLGORT;
    }

    /**
     * Auto generated setter method
     * @param param LGORT
     */
    public void setLGORT(
        com.nhry.webService.client.businessData.functions.LGORT_type1 param) {
        localLGORTTracker = param != null;

        this.localLGORT = param;
    }

    public boolean isPOSEXSpecified() {
        return localPOSEXTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.POSEX_type1
     */
    public com.nhry.webService.client.businessData.functions.POSEX_type1 getPOSEX() {
        return localPOSEX;
    }

    /**
     * Auto generated setter method
     * @param param POSEX
     */
    public void setPOSEX(
        com.nhry.webService.client.businessData.functions.POSEX_type1 param) {
        localPOSEXTracker = param != null;

        this.localPOSEX = param;
    }

    public boolean isAUGRUSpecified() {
        return localAUGRUTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.AUGRU_type3
     */
    public com.nhry.webService.client.businessData.functions.AUGRU_type3 getAUGRU() {
        return localAUGRU;
    }

    /**
     * Auto generated setter method
     * @param param AUGRU
     */
    public void setAUGRU(
        com.nhry.webService.client.businessData.functions.AUGRU_type3 param) {
        localAUGRUTracker = param != null;

        this.localAUGRU = param;
    }

    public boolean isKBETRSpecified() {
        return localKBETRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.KBETR_type1
     */
    public com.nhry.webService.client.businessData.functions.KBETR_type1 getKBETR() {
        return localKBETR;
    }

    /**
     * Auto generated setter method
     * @param param KBETR
     */
    public void setKBETR(
        com.nhry.webService.client.businessData.functions.KBETR_type1 param) {
        localKBETRTracker = param != null;

        this.localKBETR = param;
    }

    public boolean isREQ_DATESpecified() {
        return localREQ_DATETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.Date
     */
    public com.nhry.webService.client.businessData.functions.Date getREQ_DATE() {
        return localREQ_DATE;
    }

    /**
     * Auto generated setter method
     * @param param REQ_DATE
     */
    public void setREQ_DATE(
        com.nhry.webService.client.businessData.functions.Date param) {
        localREQ_DATETracker = param != null;

        this.localREQ_DATE = param;
    }

    public boolean isPSTYVSpecified() {
        return localPSTYVTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.PSTYV_type1
     */
    public com.nhry.webService.client.businessData.functions.PSTYV_type1 getPSTYV() {
        return localPSTYV;
    }

    /**
     * Auto generated setter method
     * @param param PSTYV
     */
    public void setPSTYV(
        com.nhry.webService.client.businessData.functions.PSTYV_type1 param) {
        localPSTYVTracker = param != null;

        this.localPSTYV = param;
    }

    public boolean isPR_REF_MATSpecified() {
        return localPR_REF_MATTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.PR_REF_MAT_type1
     */
    public com.nhry.webService.client.businessData.functions.PR_REF_MAT_type1 getPR_REF_MAT() {
        return localPR_REF_MAT;
    }

    /**
     * Auto generated setter method
     * @param param PR_REF_MAT
     */
    public void setPR_REF_MAT(
        com.nhry.webService.client.businessData.functions.PR_REF_MAT_type1 param) {
        localPR_REF_MATTracker = param != null;

        this.localPR_REF_MAT = param;
    }

    public boolean isWBS_ELEMSpecified() {
        return localWBS_ELEMTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.WBS_ELEM_type1
     */
    public com.nhry.webService.client.businessData.functions.WBS_ELEM_type1 getWBS_ELEM() {
        return localWBS_ELEM;
    }

    /**
     * Auto generated setter method
     * @param param WBS_ELEM
     */
    public void setWBS_ELEM(
        com.nhry.webService.client.businessData.functions.WBS_ELEM_type1 param) {
        localWBS_ELEMTracker = param != null;

        this.localWBS_ELEM = param;
    }

    public boolean isYK01Specified() {
        return localYK01Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.YK01_type1
     */
    public com.nhry.webService.client.businessData.functions.YK01_type1 getYK01() {
        return localYK01;
    }

    /**
     * Auto generated setter method
     * @param param YK01
     */
    public void setYK01(
        com.nhry.webService.client.businessData.functions.YK01_type1 param) {
        localYK01Tracker = param != null;

        this.localYK01 = param;
    }

    public boolean isYK21Specified() {
        return localYK21Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.YK21_type1
     */
    public com.nhry.webService.client.businessData.functions.YK21_type1 getYK21() {
        return localYK21;
    }

    /**
     * Auto generated setter method
     * @param param YK21
     */
    public void setYK21(
        com.nhry.webService.client.businessData.functions.YK21_type1 param) {
        localYK21Tracker = param != null;

        this.localYK21 = param;
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
                    namespacePrefix + ":ZSSD00011", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSSD00011", xmlWriter);
            }
        }

        if (localMATNRTracker) {
            if (localMATNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MATNR cannot be null!!");
            }

            localMATNR.serialize(new javax.xml.namespace.QName("", "MATNR"),
                xmlWriter);
        }

        if (localKWMENGTracker) {
            if (localKWMENG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KWMENG cannot be null!!");
            }

            localKWMENG.serialize(new javax.xml.namespace.QName("", "KWMENG"),
                xmlWriter);
        }

        if (localVRKMETracker) {
            if (localVRKME == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "VRKME cannot be null!!");
            }

            localVRKME.serialize(new javax.xml.namespace.QName("", "VRKME"),
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

        if (localLGORTTracker) {
            if (localLGORT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "LGORT cannot be null!!");
            }

            localLGORT.serialize(new javax.xml.namespace.QName("", "LGORT"),
                xmlWriter);
        }

        if (localPOSEXTracker) {
            if (localPOSEX == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "POSEX cannot be null!!");
            }

            localPOSEX.serialize(new javax.xml.namespace.QName("", "POSEX"),
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

        if (localKBETRTracker) {
            if (localKBETR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KBETR cannot be null!!");
            }

            localKBETR.serialize(new javax.xml.namespace.QName("", "KBETR"),
                xmlWriter);
        }

        if (localREQ_DATETracker) {
            if (localREQ_DATE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "REQ_DATE cannot be null!!");
            }

            localREQ_DATE.serialize(new javax.xml.namespace.QName("", "REQ_DATE"),
                xmlWriter);
        }

        if (localPSTYVTracker) {
            if (localPSTYV == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PSTYV cannot be null!!");
            }

            localPSTYV.serialize(new javax.xml.namespace.QName("", "PSTYV"),
                xmlWriter);
        }

        if (localPR_REF_MATTracker) {
            if (localPR_REF_MAT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PR_REF_MAT cannot be null!!");
            }

            localPR_REF_MAT.serialize(new javax.xml.namespace.QName("",
                    "PR_REF_MAT"), xmlWriter);
        }

        if (localWBS_ELEMTracker) {
            if (localWBS_ELEM == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "WBS_ELEM cannot be null!!");
            }

            localWBS_ELEM.serialize(new javax.xml.namespace.QName("", "WBS_ELEM"),
                xmlWriter);
        }

        if (localYK01Tracker) {
            if (localYK01 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "YK01 cannot be null!!");
            }

            localYK01.serialize(new javax.xml.namespace.QName("", "YK01"),
                xmlWriter);
        }

        if (localYK21Tracker) {
            if (localYK21 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "YK21 cannot be null!!");
            }

            localYK21.serialize(new javax.xml.namespace.QName("", "YK21"),
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
        public static ZSSD00011 parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            ZSSD00011 object = new ZSSD00011();

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

                        if (!"ZSSD00011".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSSD00011) com.nhry.webService.client.businessData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "MATNR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MATNR").equals(
                            reader.getName())) {
                    object.setMATNR(com.nhry.webService.client.businessData.functions.MATNR_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KWMENG").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KWMENG").equals(
                            reader.getName())) {
                    object.setKWMENG(com.nhry.webService.client.businessData.functions.KWMENG_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "VRKME").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "VRKME").equals(
                            reader.getName())) {
                    object.setVRKME(com.nhry.webService.client.businessData.functions.VRKME_type1.Factory.parse(
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
                    object.setWERKS(com.nhry.webService.client.businessData.functions.WERKS_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "LGORT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "LGORT").equals(
                            reader.getName())) {
                    object.setLGORT(com.nhry.webService.client.businessData.functions.LGORT_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "POSEX").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "POSEX").equals(
                            reader.getName())) {
                    object.setPOSEX(com.nhry.webService.client.businessData.functions.POSEX_type1.Factory.parse(
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
                    object.setAUGRU(com.nhry.webService.client.businessData.functions.AUGRU_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KBETR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KBETR").equals(
                            reader.getName())) {
                    object.setKBETR(com.nhry.webService.client.businessData.functions.KBETR_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "REQ_DATE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "REQ_DATE").equals(
                            reader.getName())) {
                    object.setREQ_DATE(com.nhry.webService.client.businessData.functions.Date.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PSTYV").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PSTYV").equals(
                            reader.getName())) {
                    object.setPSTYV(com.nhry.webService.client.businessData.functions.PSTYV_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PR_REF_MAT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PR_REF_MAT").equals(
                            reader.getName())) {
                    object.setPR_REF_MAT(com.nhry.webService.client.businessData.functions.PR_REF_MAT_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "WBS_ELEM").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "WBS_ELEM").equals(
                            reader.getName())) {
                    object.setWBS_ELEM(com.nhry.webService.client.businessData.functions.WBS_ELEM_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "YK01").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "YK01").equals(
                            reader.getName())) {
                    object.setYK01(com.nhry.webService.client.businessData.functions.YK01_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "YK21").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "YK21").equals(
                            reader.getName())) {
                    object.setYK21(com.nhry.webService.client.businessData.functions.YK21_type1.Factory.parse(
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
