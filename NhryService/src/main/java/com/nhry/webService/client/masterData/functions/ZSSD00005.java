/**
 * ZSSD00005.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.masterData.functions;


/**
 *  ZSSD00005 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSSD00005 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSSD00005
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for MATNR
     */
    protected com.nhry.webService.client.masterData.functions.MATNR_type7 localMATNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMATNRTracker = false;

    /**
     * field for MTART
     */
    protected com.nhry.webService.client.masterData.functions.MTART_type1 localMTART;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMTARTTracker = false;

    /**
     * field for MEINS
     */
    protected com.nhry.webService.client.masterData.functions.MEINS_type3 localMEINS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMEINSTracker = false;

    /**
     * field for SPART
     */
    protected com.nhry.webService.client.masterData.functions.SPART_type1 localSPART;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSPARTTracker = false;

    /**
     * field for MTPOS_MARA
     */
    protected com.nhry.webService.client.masterData.functions.MTPOS_MARA_type1 localMTPOS_MARA;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMTPOS_MARATracker = false;

    /**
     * field for VKORG
     */
    protected com.nhry.webService.client.masterData.functions.VKORG_type3 localVKORG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVKORGTracker = false;

    /**
     * field for VTWEG
     */
    protected com.nhry.webService.client.masterData.functions.VTWEG_type3 localVTWEG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVTWEGTracker = false;

    /**
     * field for WERKS
     */
    protected com.nhry.webService.client.masterData.functions.WERKS_type3 localWERKS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localWERKSTracker = false;

    /**
     * field for BOMX
     */
    protected com.nhry.webService.client.masterData.functions.BOMX_type1 localBOMX;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBOMXTracker = false;

    /**
     * field for NTGEW
     */
    protected com.nhry.webService.client.masterData.functions.NTGEW_type1 localNTGEW;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localNTGEWTracker = false;

    /**
     * field for GEWEI
     */
    protected com.nhry.webService.client.masterData.functions.GEWEI_type3 localGEWEI;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localGEWEITracker = false;

    /**
     * field for JMEINS
     */
    protected com.nhry.webService.client.masterData.functions.JMEINS_type1 localJMEINS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localJMEINSTracker = false;

    public boolean isMATNRSpecified() {
        return localMATNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MATNR_type7
     */
    public com.nhry.webService.client.masterData.functions.MATNR_type7 getMATNR() {
        return localMATNR;
    }

    /**
     * Auto generated setter method
     * @param param MATNR
     */
    public void setMATNR(
        com.nhry.webService.client.masterData.functions.MATNR_type7 param) {
        localMATNRTracker = param != null;

        this.localMATNR = param;
    }

    public boolean isMTARTSpecified() {
        return localMTARTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MTART_type1
     */
    public com.nhry.webService.client.masterData.functions.MTART_type1 getMTART() {
        return localMTART;
    }

    /**
     * Auto generated setter method
     * @param param MTART
     */
    public void setMTART(
        com.nhry.webService.client.masterData.functions.MTART_type1 param) {
        localMTARTTracker = param != null;

        this.localMTART = param;
    }

    public boolean isMEINSSpecified() {
        return localMEINSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MEINS_type3
     */
    public com.nhry.webService.client.masterData.functions.MEINS_type3 getMEINS() {
        return localMEINS;
    }

    /**
     * Auto generated setter method
     * @param param MEINS
     */
    public void setMEINS(
        com.nhry.webService.client.masterData.functions.MEINS_type3 param) {
        localMEINSTracker = param != null;

        this.localMEINS = param;
    }

    public boolean isSPARTSpecified() {
        return localSPARTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.SPART_type1
     */
    public com.nhry.webService.client.masterData.functions.SPART_type1 getSPART() {
        return localSPART;
    }

    /**
     * Auto generated setter method
     * @param param SPART
     */
    public void setSPART(
        com.nhry.webService.client.masterData.functions.SPART_type1 param) {
        localSPARTTracker = param != null;

        this.localSPART = param;
    }

    public boolean isMTPOS_MARASpecified() {
        return localMTPOS_MARATracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MTPOS_MARA_type1
     */
    public com.nhry.webService.client.masterData.functions.MTPOS_MARA_type1 getMTPOS_MARA() {
        return localMTPOS_MARA;
    }

    /**
     * Auto generated setter method
     * @param param MTPOS_MARA
     */
    public void setMTPOS_MARA(
        com.nhry.webService.client.masterData.functions.MTPOS_MARA_type1 param) {
        localMTPOS_MARATracker = param != null;

        this.localMTPOS_MARA = param;
    }

    public boolean isVKORGSpecified() {
        return localVKORGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.VKORG_type3
     */
    public com.nhry.webService.client.masterData.functions.VKORG_type3 getVKORG() {
        return localVKORG;
    }

    /**
     * Auto generated setter method
     * @param param VKORG
     */
    public void setVKORG(
        com.nhry.webService.client.masterData.functions.VKORG_type3 param) {
        localVKORGTracker = param != null;

        this.localVKORG = param;
    }

    public boolean isVTWEGSpecified() {
        return localVTWEGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.VTWEG_type3
     */
    public com.nhry.webService.client.masterData.functions.VTWEG_type3 getVTWEG() {
        return localVTWEG;
    }

    /**
     * Auto generated setter method
     * @param param VTWEG
     */
    public void setVTWEG(
        com.nhry.webService.client.masterData.functions.VTWEG_type3 param) {
        localVTWEGTracker = param != null;

        this.localVTWEG = param;
    }

    public boolean isWERKSSpecified() {
        return localWERKSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.WERKS_type3
     */
    public com.nhry.webService.client.masterData.functions.WERKS_type3 getWERKS() {
        return localWERKS;
    }

    /**
     * Auto generated setter method
     * @param param WERKS
     */
    public void setWERKS(
        com.nhry.webService.client.masterData.functions.WERKS_type3 param) {
        localWERKSTracker = param != null;

        this.localWERKS = param;
    }

    public boolean isBOMXSpecified() {
        return localBOMXTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.BOMX_type1
     */
    public com.nhry.webService.client.masterData.functions.BOMX_type1 getBOMX() {
        return localBOMX;
    }

    /**
     * Auto generated setter method
     * @param param BOMX
     */
    public void setBOMX(
        com.nhry.webService.client.masterData.functions.BOMX_type1 param) {
        localBOMXTracker = param != null;

        this.localBOMX = param;
    }

    public boolean isNTGEWSpecified() {
        return localNTGEWTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.NTGEW_type1
     */
    public com.nhry.webService.client.masterData.functions.NTGEW_type1 getNTGEW() {
        return localNTGEW;
    }

    /**
     * Auto generated setter method
     * @param param NTGEW
     */
    public void setNTGEW(
        com.nhry.webService.client.masterData.functions.NTGEW_type1 param) {
        localNTGEWTracker = param != null;

        this.localNTGEW = param;
    }

    public boolean isGEWEISpecified() {
        return localGEWEITracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.GEWEI_type3
     */
    public com.nhry.webService.client.masterData.functions.GEWEI_type3 getGEWEI() {
        return localGEWEI;
    }

    /**
     * Auto generated setter method
     * @param param GEWEI
     */
    public void setGEWEI(
        com.nhry.webService.client.masterData.functions.GEWEI_type3 param) {
        localGEWEITracker = param != null;

        this.localGEWEI = param;
    }

    public boolean isJMEINSSpecified() {
        return localJMEINSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.JMEINS_type1
     */
    public com.nhry.webService.client.masterData.functions.JMEINS_type1 getJMEINS() {
        return localJMEINS;
    }

    /**
     * Auto generated setter method
     * @param param JMEINS
     */
    public void setJMEINS(
        com.nhry.webService.client.masterData.functions.JMEINS_type1 param) {
        localJMEINSTracker = param != null;

        this.localJMEINS = param;
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
                    namespacePrefix + ":ZSSD00005", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSSD00005", xmlWriter);
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

        if (localMTARTTracker) {
            if (localMTART == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MTART cannot be null!!");
            }

            localMTART.serialize(new javax.xml.namespace.QName("", "MTART"),
                xmlWriter);
        }

        if (localMEINSTracker) {
            if (localMEINS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MEINS cannot be null!!");
            }

            localMEINS.serialize(new javax.xml.namespace.QName("", "MEINS"),
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

        if (localMTPOS_MARATracker) {
            if (localMTPOS_MARA == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MTPOS_MARA cannot be null!!");
            }

            localMTPOS_MARA.serialize(new javax.xml.namespace.QName("",
                    "MTPOS_MARA"), xmlWriter);
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

        if (localWERKSTracker) {
            if (localWERKS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "WERKS cannot be null!!");
            }

            localWERKS.serialize(new javax.xml.namespace.QName("", "WERKS"),
                xmlWriter);
        }

        if (localBOMXTracker) {
            if (localBOMX == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "BOMX cannot be null!!");
            }

            localBOMX.serialize(new javax.xml.namespace.QName("", "BOMX"),
                xmlWriter);
        }

        if (localNTGEWTracker) {
            if (localNTGEW == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NTGEW cannot be null!!");
            }

            localNTGEW.serialize(new javax.xml.namespace.QName("", "NTGEW"),
                xmlWriter);
        }

        if (localGEWEITracker) {
            if (localGEWEI == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "GEWEI cannot be null!!");
            }

            localGEWEI.serialize(new javax.xml.namespace.QName("", "GEWEI"),
                xmlWriter);
        }

        if (localJMEINSTracker) {
            if (localJMEINS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "JMEINS cannot be null!!");
            }

            localJMEINS.serialize(new javax.xml.namespace.QName("", "JMEINS"),
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
        public static ZSSD00005 parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            ZSSD00005 object = new ZSSD00005();

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

                        if (!"ZSSD00005".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSSD00005) com.nhry.webService.client.masterData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                    object.setMATNR(com.nhry.webService.client.masterData.functions.MATNR_type7.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MTART").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MTART").equals(
                            reader.getName())) {
                    object.setMTART(com.nhry.webService.client.masterData.functions.MTART_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MEINS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MEINS").equals(
                            reader.getName())) {
                    object.setMEINS(com.nhry.webService.client.masterData.functions.MEINS_type3.Factory.parse(
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
                    object.setSPART(com.nhry.webService.client.masterData.functions.SPART_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MTPOS_MARA").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MTPOS_MARA").equals(
                            reader.getName())) {
                    object.setMTPOS_MARA(com.nhry.webService.client.masterData.functions.MTPOS_MARA_type1.Factory.parse(
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
                    object.setVKORG(com.nhry.webService.client.masterData.functions.VKORG_type3.Factory.parse(
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
                    object.setVTWEG(com.nhry.webService.client.masterData.functions.VTWEG_type3.Factory.parse(
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
                    object.setWERKS(com.nhry.webService.client.masterData.functions.WERKS_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "BOMX").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "BOMX").equals(
                            reader.getName())) {
                    object.setBOMX(com.nhry.webService.client.masterData.functions.BOMX_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "NTGEW").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "NTGEW").equals(
                            reader.getName())) {
                    object.setNTGEW(com.nhry.webService.client.masterData.functions.NTGEW_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "GEWEI").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "GEWEI").equals(
                            reader.getName())) {
                    object.setGEWEI(com.nhry.webService.client.masterData.functions.GEWEI_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "JMEINS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "JMEINS").equals(
                            reader.getName())) {
                    object.setJMEINS(com.nhry.webService.client.masterData.functions.JMEINS_type1.Factory.parse(
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
