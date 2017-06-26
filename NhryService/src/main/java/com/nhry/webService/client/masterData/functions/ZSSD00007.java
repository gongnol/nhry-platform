/**
 * ZSSD00007.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.masterData.functions;


/**
 *  ZSSD00007 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSSD00007 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSSD00007
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for MATNR
     */
    protected com.nhry.webService.client.masterData.functions.MATNR_type1 localMATNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMATNRTracker = false;

    /**
     * field for WERKS
     */
    protected com.nhry.webService.client.masterData.functions.WERKS_type1 localWERKS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localWERKSTracker = false;

    /**
     * field for POSNR
     */
    protected com.nhry.webService.client.masterData.functions.POSNR_type1 localPOSNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPOSNRTracker = false;

    /**
     * field for IDNRK
     */
    protected com.nhry.webService.client.masterData.functions.IDNRK_type1 localIDNRK;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIDNRKTracker = false;

    /**
     * field for MEINS
     */
    protected com.nhry.webService.client.masterData.functions.MEINS_type1 localMEINS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMEINSTracker = false;

    /**
     * field for MENGE
     */
    protected com.nhry.webService.client.masterData.functions.MENGE_type1 localMENGE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMENGETracker = false;

    /**
     * field for VKORG
     */
    protected com.nhry.webService.client.masterData.functions.VKORG_type1 localVKORG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVKORGTracker = false;

    /**
     * field for VTWEG
     */
    protected com.nhry.webService.client.masterData.functions.VTWEG_type1 localVTWEG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVTWEGTracker = false;

    /**
     * field for AENRL
     */
    protected com.nhry.webService.client.masterData.functions.AENRL_type1 localAENRL;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localAENRLTracker = false;

    /**
     * field for DATUV
     */
    protected com.nhry.webService.client.masterData.functions.Date localDATUV;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localDATUVTracker = false;

    public boolean isMATNRSpecified() {
        return localMATNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MATNR_type1
     */
    public com.nhry.webService.client.masterData.functions.MATNR_type1 getMATNR() {
        return localMATNR;
    }

    /**
     * Auto generated setter method
     * @param param MATNR
     */
    public void setMATNR(
        com.nhry.webService.client.masterData.functions.MATNR_type1 param) {
        localMATNRTracker = param != null;

        this.localMATNR = param;
    }

    public boolean isWERKSSpecified() {
        return localWERKSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.WERKS_type1
     */
    public com.nhry.webService.client.masterData.functions.WERKS_type1 getWERKS() {
        return localWERKS;
    }

    /**
     * Auto generated setter method
     * @param param WERKS
     */
    public void setWERKS(
        com.nhry.webService.client.masterData.functions.WERKS_type1 param) {
        localWERKSTracker = param != null;

        this.localWERKS = param;
    }

    public boolean isPOSNRSpecified() {
        return localPOSNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.POSNR_type1
     */
    public com.nhry.webService.client.masterData.functions.POSNR_type1 getPOSNR() {
        return localPOSNR;
    }

    /**
     * Auto generated setter method
     * @param param POSNR
     */
    public void setPOSNR(
        com.nhry.webService.client.masterData.functions.POSNR_type1 param) {
        localPOSNRTracker = param != null;

        this.localPOSNR = param;
    }

    public boolean isIDNRKSpecified() {
        return localIDNRKTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.IDNRK_type1
     */
    public com.nhry.webService.client.masterData.functions.IDNRK_type1 getIDNRK() {
        return localIDNRK;
    }

    /**
     * Auto generated setter method
     * @param param IDNRK
     */
    public void setIDNRK(
        com.nhry.webService.client.masterData.functions.IDNRK_type1 param) {
        localIDNRKTracker = param != null;

        this.localIDNRK = param;
    }

    public boolean isMEINSSpecified() {
        return localMEINSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MEINS_type1
     */
    public com.nhry.webService.client.masterData.functions.MEINS_type1 getMEINS() {
        return localMEINS;
    }

    /**
     * Auto generated setter method
     * @param param MEINS
     */
    public void setMEINS(
        com.nhry.webService.client.masterData.functions.MEINS_type1 param) {
        localMEINSTracker = param != null;

        this.localMEINS = param;
    }

    public boolean isMENGESpecified() {
        return localMENGETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MENGE_type1
     */
    public com.nhry.webService.client.masterData.functions.MENGE_type1 getMENGE() {
        return localMENGE;
    }

    /**
     * Auto generated setter method
     * @param param MENGE
     */
    public void setMENGE(
        com.nhry.webService.client.masterData.functions.MENGE_type1 param) {
        localMENGETracker = param != null;

        this.localMENGE = param;
    }

    public boolean isVKORGSpecified() {
        return localVKORGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.VKORG_type1
     */
    public com.nhry.webService.client.masterData.functions.VKORG_type1 getVKORG() {
        return localVKORG;
    }

    /**
     * Auto generated setter method
     * @param param VKORG
     */
    public void setVKORG(
        com.nhry.webService.client.masterData.functions.VKORG_type1 param) {
        localVKORGTracker = param != null;

        this.localVKORG = param;
    }

    public boolean isVTWEGSpecified() {
        return localVTWEGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.VTWEG_type1
     */
    public com.nhry.webService.client.masterData.functions.VTWEG_type1 getVTWEG() {
        return localVTWEG;
    }

    /**
     * Auto generated setter method
     * @param param VTWEG
     */
    public void setVTWEG(
        com.nhry.webService.client.masterData.functions.VTWEG_type1 param) {
        localVTWEGTracker = param != null;

        this.localVTWEG = param;
    }

    public boolean isAENRLSpecified() {
        return localAENRLTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.AENRL_type1
     */
    public com.nhry.webService.client.masterData.functions.AENRL_type1 getAENRL() {
        return localAENRL;
    }

    /**
     * Auto generated setter method
     * @param param AENRL
     */
    public void setAENRL(
        com.nhry.webService.client.masterData.functions.AENRL_type1 param) {
        localAENRLTracker = param != null;

        this.localAENRL = param;
    }

    public boolean isDATUVSpecified() {
        return localDATUVTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.Date
     */
    public com.nhry.webService.client.masterData.functions.Date getDATUV() {
        return localDATUV;
    }

    /**
     * Auto generated setter method
     * @param param DATUV
     */
    public void setDATUV(
        com.nhry.webService.client.masterData.functions.Date param) {
        localDATUVTracker = param != null;

        this.localDATUV = param;
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
                    namespacePrefix + ":ZSSD00007", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSSD00007", xmlWriter);
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

        if (localWERKSTracker) {
            if (localWERKS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "WERKS cannot be null!!");
            }

            localWERKS.serialize(new javax.xml.namespace.QName("", "WERKS"),
                xmlWriter);
        }

        if (localPOSNRTracker) {
            if (localPOSNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "POSNR cannot be null!!");
            }

            localPOSNR.serialize(new javax.xml.namespace.QName("", "POSNR"),
                xmlWriter);
        }

        if (localIDNRKTracker) {
            if (localIDNRK == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "IDNRK cannot be null!!");
            }

            localIDNRK.serialize(new javax.xml.namespace.QName("", "IDNRK"),
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

        if (localMENGETracker) {
            if (localMENGE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MENGE cannot be null!!");
            }

            localMENGE.serialize(new javax.xml.namespace.QName("", "MENGE"),
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

        if (localAENRLTracker) {
            if (localAENRL == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "AENRL cannot be null!!");
            }

            localAENRL.serialize(new javax.xml.namespace.QName("", "AENRL"),
                xmlWriter);
        }

        if (localDATUVTracker) {
            if (localDATUV == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "DATUV cannot be null!!");
            }

            localDATUV.serialize(new javax.xml.namespace.QName("", "DATUV"),
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
        public static ZSSD00007 parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            ZSSD00007 object = new ZSSD00007();

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

                        if (!"ZSSD00007".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSSD00007) com.nhry.webService.client.masterData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                    object.setMATNR(com.nhry.webService.client.masterData.functions.MATNR_type1.Factory.parse(
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
                    object.setWERKS(com.nhry.webService.client.masterData.functions.WERKS_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "POSNR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "POSNR").equals(
                            reader.getName())) {
                    object.setPOSNR(com.nhry.webService.client.masterData.functions.POSNR_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "IDNRK").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "IDNRK").equals(
                            reader.getName())) {
                    object.setIDNRK(com.nhry.webService.client.masterData.functions.IDNRK_type1.Factory.parse(
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
                    object.setMEINS(com.nhry.webService.client.masterData.functions.MEINS_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MENGE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MENGE").equals(
                            reader.getName())) {
                    object.setMENGE(com.nhry.webService.client.masterData.functions.MENGE_type1.Factory.parse(
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
                    object.setVKORG(com.nhry.webService.client.masterData.functions.VKORG_type1.Factory.parse(
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
                    object.setVTWEG(com.nhry.webService.client.masterData.functions.VTWEG_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "AENRL").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "AENRL").equals(
                            reader.getName())) {
                    object.setAENRL(com.nhry.webService.client.masterData.functions.AENRL_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "DATUV").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "DATUV").equals(
                            reader.getName())) {
                    object.setDATUV(com.nhry.webService.client.masterData.functions.Date.Factory.parse(
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
