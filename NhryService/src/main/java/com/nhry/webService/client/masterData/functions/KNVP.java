/**
 * KNVP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.masterData.functions;


/**
 *  KNVP bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class KNVP implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = KNVP
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for MANDT
     */
    protected com.nhry.webService.client.masterData.functions.MANDT_type5 localMANDT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMANDTTracker = false;

    /**
     * field for KUNNR
     */
    protected com.nhry.webService.client.masterData.functions.KUNNR_type1 localKUNNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKUNNRTracker = false;

    /**
     * field for VKORG
     */
    protected com.nhry.webService.client.masterData.functions.VKORG_type5 localVKORG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVKORGTracker = false;

    /**
     * field for VTWEG
     */
    protected com.nhry.webService.client.masterData.functions.VTWEG_type5 localVTWEG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVTWEGTracker = false;

    /**
     * field for SPART
     */
    protected com.nhry.webService.client.masterData.functions.SPART_type3 localSPART;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSPARTTracker = false;

    /**
     * field for PARVW
     */
    protected com.nhry.webService.client.masterData.functions.PARVW_type1 localPARVW;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPARVWTracker = false;

    /**
     * field for PARZA
     */
    protected com.nhry.webService.client.masterData.functions.PARZA_type1 localPARZA;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPARZATracker = false;

    /**
     * field for KUNN2
     */
    protected com.nhry.webService.client.masterData.functions.KUNN2_type1 localKUNN2;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKUNN2Tracker = false;

    /**
     * field for LIFNR
     */
    protected com.nhry.webService.client.masterData.functions.LIFNR_type1 localLIFNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLIFNRTracker = false;

    /**
     * field for PERNR
     */
    protected com.nhry.webService.client.masterData.functions.PERNR_type1 localPERNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPERNRTracker = false;

    /**
     * field for PARNR
     */
    protected com.nhry.webService.client.masterData.functions.PARNR_type1 localPARNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPARNRTracker = false;

    /**
     * field for KNREF
     */
    protected com.nhry.webService.client.masterData.functions.KNREF_type1 localKNREF;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKNREFTracker = false;

    /**
     * field for DEFPA
     */
    protected com.nhry.webService.client.masterData.functions.DEFPA_type1 localDEFPA;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localDEFPATracker = false;

    public boolean isMANDTSpecified() {
        return localMANDTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.MANDT_type5
     */
    public com.nhry.webService.client.masterData.functions.MANDT_type5 getMANDT() {
        return localMANDT;
    }

    /**
     * Auto generated setter method
     * @param param MANDT
     */
    public void setMANDT(
        com.nhry.webService.client.masterData.functions.MANDT_type5 param) {
        localMANDTTracker = param != null;

        this.localMANDT = param;
    }

    public boolean isKUNNRSpecified() {
        return localKUNNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KUNNR_type1
     */
    public com.nhry.webService.client.masterData.functions.KUNNR_type1 getKUNNR() {
        return localKUNNR;
    }

    /**
     * Auto generated setter method
     * @param param KUNNR
     */
    public void setKUNNR(
        com.nhry.webService.client.masterData.functions.KUNNR_type1 param) {
        localKUNNRTracker = param != null;

        this.localKUNNR = param;
    }

    public boolean isVKORGSpecified() {
        return localVKORGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.VKORG_type5
     */
    public com.nhry.webService.client.masterData.functions.VKORG_type5 getVKORG() {
        return localVKORG;
    }

    /**
     * Auto generated setter method
     * @param param VKORG
     */
    public void setVKORG(
        com.nhry.webService.client.masterData.functions.VKORG_type5 param) {
        localVKORGTracker = param != null;

        this.localVKORG = param;
    }

    public boolean isVTWEGSpecified() {
        return localVTWEGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.VTWEG_type5
     */
    public com.nhry.webService.client.masterData.functions.VTWEG_type5 getVTWEG() {
        return localVTWEG;
    }

    /**
     * Auto generated setter method
     * @param param VTWEG
     */
    public void setVTWEG(
        com.nhry.webService.client.masterData.functions.VTWEG_type5 param) {
        localVTWEGTracker = param != null;

        this.localVTWEG = param;
    }

    public boolean isSPARTSpecified() {
        return localSPARTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.SPART_type3
     */
    public com.nhry.webService.client.masterData.functions.SPART_type3 getSPART() {
        return localSPART;
    }

    /**
     * Auto generated setter method
     * @param param SPART
     */
    public void setSPART(
        com.nhry.webService.client.masterData.functions.SPART_type3 param) {
        localSPARTTracker = param != null;

        this.localSPART = param;
    }

    public boolean isPARVWSpecified() {
        return localPARVWTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.PARVW_type1
     */
    public com.nhry.webService.client.masterData.functions.PARVW_type1 getPARVW() {
        return localPARVW;
    }

    /**
     * Auto generated setter method
     * @param param PARVW
     */
    public void setPARVW(
        com.nhry.webService.client.masterData.functions.PARVW_type1 param) {
        localPARVWTracker = param != null;

        this.localPARVW = param;
    }

    public boolean isPARZASpecified() {
        return localPARZATracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.PARZA_type1
     */
    public com.nhry.webService.client.masterData.functions.PARZA_type1 getPARZA() {
        return localPARZA;
    }

    /**
     * Auto generated setter method
     * @param param PARZA
     */
    public void setPARZA(
        com.nhry.webService.client.masterData.functions.PARZA_type1 param) {
        localPARZATracker = param != null;

        this.localPARZA = param;
    }

    public boolean isKUNN2Specified() {
        return localKUNN2Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KUNN2_type1
     */
    public com.nhry.webService.client.masterData.functions.KUNN2_type1 getKUNN2() {
        return localKUNN2;
    }

    /**
     * Auto generated setter method
     * @param param KUNN2
     */
    public void setKUNN2(
        com.nhry.webService.client.masterData.functions.KUNN2_type1 param) {
        localKUNN2Tracker = param != null;

        this.localKUNN2 = param;
    }

    public boolean isLIFNRSpecified() {
        return localLIFNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.LIFNR_type1
     */
    public com.nhry.webService.client.masterData.functions.LIFNR_type1 getLIFNR() {
        return localLIFNR;
    }

    /**
     * Auto generated setter method
     * @param param LIFNR
     */
    public void setLIFNR(
        com.nhry.webService.client.masterData.functions.LIFNR_type1 param) {
        localLIFNRTracker = param != null;

        this.localLIFNR = param;
    }

    public boolean isPERNRSpecified() {
        return localPERNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.PERNR_type1
     */
    public com.nhry.webService.client.masterData.functions.PERNR_type1 getPERNR() {
        return localPERNR;
    }

    /**
     * Auto generated setter method
     * @param param PERNR
     */
    public void setPERNR(
        com.nhry.webService.client.masterData.functions.PERNR_type1 param) {
        localPERNRTracker = param != null;

        this.localPERNR = param;
    }

    public boolean isPARNRSpecified() {
        return localPARNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.PARNR_type1
     */
    public com.nhry.webService.client.masterData.functions.PARNR_type1 getPARNR() {
        return localPARNR;
    }

    /**
     * Auto generated setter method
     * @param param PARNR
     */
    public void setPARNR(
        com.nhry.webService.client.masterData.functions.PARNR_type1 param) {
        localPARNRTracker = param != null;

        this.localPARNR = param;
    }

    public boolean isKNREFSpecified() {
        return localKNREFTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KNREF_type1
     */
    public com.nhry.webService.client.masterData.functions.KNREF_type1 getKNREF() {
        return localKNREF;
    }

    /**
     * Auto generated setter method
     * @param param KNREF
     */
    public void setKNREF(
        com.nhry.webService.client.masterData.functions.KNREF_type1 param) {
        localKNREFTracker = param != null;

        this.localKNREF = param;
    }

    public boolean isDEFPASpecified() {
        return localDEFPATracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.DEFPA_type1
     */
    public com.nhry.webService.client.masterData.functions.DEFPA_type1 getDEFPA() {
        return localDEFPA;
    }

    /**
     * Auto generated setter method
     * @param param DEFPA
     */
    public void setDEFPA(
        com.nhry.webService.client.masterData.functions.DEFPA_type1 param) {
        localDEFPATracker = param != null;

        this.localDEFPA = param;
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
                    namespacePrefix + ":KNVP", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "KNVP", xmlWriter);
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

        if (localKUNNRTracker) {
            if (localKUNNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KUNNR cannot be null!!");
            }

            localKUNNR.serialize(new javax.xml.namespace.QName("", "KUNNR"),
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

        if (localPARVWTracker) {
            if (localPARVW == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PARVW cannot be null!!");
            }

            localPARVW.serialize(new javax.xml.namespace.QName("", "PARVW"),
                xmlWriter);
        }

        if (localPARZATracker) {
            if (localPARZA == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PARZA cannot be null!!");
            }

            localPARZA.serialize(new javax.xml.namespace.QName("", "PARZA"),
                xmlWriter);
        }

        if (localKUNN2Tracker) {
            if (localKUNN2 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KUNN2 cannot be null!!");
            }

            localKUNN2.serialize(new javax.xml.namespace.QName("", "KUNN2"),
                xmlWriter);
        }

        if (localLIFNRTracker) {
            if (localLIFNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "LIFNR cannot be null!!");
            }

            localLIFNR.serialize(new javax.xml.namespace.QName("", "LIFNR"),
                xmlWriter);
        }

        if (localPERNRTracker) {
            if (localPERNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PERNR cannot be null!!");
            }

            localPERNR.serialize(new javax.xml.namespace.QName("", "PERNR"),
                xmlWriter);
        }

        if (localPARNRTracker) {
            if (localPARNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PARNR cannot be null!!");
            }

            localPARNR.serialize(new javax.xml.namespace.QName("", "PARNR"),
                xmlWriter);
        }

        if (localKNREFTracker) {
            if (localKNREF == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KNREF cannot be null!!");
            }

            localKNREF.serialize(new javax.xml.namespace.QName("", "KNREF"),
                xmlWriter);
        }

        if (localDEFPATracker) {
            if (localDEFPA == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "DEFPA cannot be null!!");
            }

            localDEFPA.serialize(new javax.xml.namespace.QName("", "DEFPA"),
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
        public static KNVP parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            KNVP object = new KNVP();

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

                        if (!"KNVP".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (KNVP) com.nhry.webService.client.masterData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                    object.setMANDT(com.nhry.webService.client.masterData.functions.MANDT_type5.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KUNNR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KUNNR").equals(
                            reader.getName())) {
                    object.setKUNNR(com.nhry.webService.client.masterData.functions.KUNNR_type1.Factory.parse(
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
                    object.setVKORG(com.nhry.webService.client.masterData.functions.VKORG_type5.Factory.parse(
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
                    object.setVTWEG(com.nhry.webService.client.masterData.functions.VTWEG_type5.Factory.parse(
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
                    object.setSPART(com.nhry.webService.client.masterData.functions.SPART_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PARVW").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PARVW").equals(
                            reader.getName())) {
                    object.setPARVW(com.nhry.webService.client.masterData.functions.PARVW_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PARZA").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PARZA").equals(
                            reader.getName())) {
                    object.setPARZA(com.nhry.webService.client.masterData.functions.PARZA_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KUNN2").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KUNN2").equals(
                            reader.getName())) {
                    object.setKUNN2(com.nhry.webService.client.masterData.functions.KUNN2_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "LIFNR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "LIFNR").equals(
                            reader.getName())) {
                    object.setLIFNR(com.nhry.webService.client.masterData.functions.LIFNR_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PERNR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PERNR").equals(
                            reader.getName())) {
                    object.setPERNR(com.nhry.webService.client.masterData.functions.PERNR_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PARNR").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PARNR").equals(
                            reader.getName())) {
                    object.setPARNR(com.nhry.webService.client.masterData.functions.PARNR_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KNREF").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KNREF").equals(
                            reader.getName())) {
                    object.setKNREF(com.nhry.webService.client.masterData.functions.KNREF_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "DEFPA").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "DEFPA").equals(
                            reader.getName())) {
                    object.setDEFPA(com.nhry.webService.client.masterData.functions.DEFPA_type1.Factory.parse(
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
