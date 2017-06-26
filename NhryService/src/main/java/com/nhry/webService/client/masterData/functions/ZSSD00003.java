/**
 * ZSSD00003.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.masterData.functions;


/**
 *  ZSSD00003 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSSD00003 implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSSD00003
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for KUNNR
     */
    protected com.nhry.webService.client.masterData.functions.KUNNR_type9 localKUNNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKUNNRTracker = false;

    /**
     * field for VKORG
     */
    protected com.nhry.webService.client.masterData.functions.VKORG_type11 localVKORG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVKORGTracker = false;

    /**
     * field for VTWEG
     */
    protected com.nhry.webService.client.masterData.functions.VTWEG_type11 localVTWEG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVTWEGTracker = false;

    /**
     * field for SPART
     */
    protected com.nhry.webService.client.masterData.functions.SPART_type9 localSPART;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSPARTTracker = false;

    /**
     * field for KVGR1
     */
    protected com.nhry.webService.client.masterData.functions.KVGR1_type1 localKVGR1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKVGR1Tracker = false;

    /**
     * field for KUNWE
     */
    protected com.nhry.webService.client.masterData.functions.KUNWE_type3 localKUNWE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKUNWETracker = false;

    /**
     * field for KDGRP
     */
    protected com.nhry.webService.client.masterData.functions.KDGRP_type1 localKDGRP;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKDGRPTracker = false;

    /**
     * field for KVGR2
     */
    protected com.nhry.webService.client.masterData.functions.KVGR2_type1 localKVGR2;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKVGR2Tracker = false;

    /**
     * field for LOEVM
     */
    protected com.nhry.webService.client.masterData.functions.LOEVM_type3 localLOEVM;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLOEVMTracker = false;

    /**
     * field for KONDA
     */
    protected com.nhry.webService.client.masterData.functions.KONDA_type1 localKONDA;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localKONDATracker = false;

    public boolean isKUNNRSpecified() {
        return localKUNNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KUNNR_type9
     */
    public com.nhry.webService.client.masterData.functions.KUNNR_type9 getKUNNR() {
        return localKUNNR;
    }

    /**
     * Auto generated setter method
     * @param param KUNNR
     */
    public void setKUNNR(
        com.nhry.webService.client.masterData.functions.KUNNR_type9 param) {
        localKUNNRTracker = param != null;

        this.localKUNNR = param;
    }

    public boolean isVKORGSpecified() {
        return localVKORGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.VKORG_type11
     */
    public com.nhry.webService.client.masterData.functions.VKORG_type11 getVKORG() {
        return localVKORG;
    }

    /**
     * Auto generated setter method
     * @param param VKORG
     */
    public void setVKORG(
        com.nhry.webService.client.masterData.functions.VKORG_type11 param) {
        localVKORGTracker = param != null;

        this.localVKORG = param;
    }

    public boolean isVTWEGSpecified() {
        return localVTWEGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.VTWEG_type11
     */
    public com.nhry.webService.client.masterData.functions.VTWEG_type11 getVTWEG() {
        return localVTWEG;
    }

    /**
     * Auto generated setter method
     * @param param VTWEG
     */
    public void setVTWEG(
        com.nhry.webService.client.masterData.functions.VTWEG_type11 param) {
        localVTWEGTracker = param != null;

        this.localVTWEG = param;
    }

    public boolean isSPARTSpecified() {
        return localSPARTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.SPART_type9
     */
    public com.nhry.webService.client.masterData.functions.SPART_type9 getSPART() {
        return localSPART;
    }

    /**
     * Auto generated setter method
     * @param param SPART
     */
    public void setSPART(
        com.nhry.webService.client.masterData.functions.SPART_type9 param) {
        localSPARTTracker = param != null;

        this.localSPART = param;
    }

    public boolean isKVGR1Specified() {
        return localKVGR1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KVGR1_type1
     */
    public com.nhry.webService.client.masterData.functions.KVGR1_type1 getKVGR1() {
        return localKVGR1;
    }

    /**
     * Auto generated setter method
     * @param param KVGR1
     */
    public void setKVGR1(
        com.nhry.webService.client.masterData.functions.KVGR1_type1 param) {
        localKVGR1Tracker = param != null;

        this.localKVGR1 = param;
    }

    public boolean isKUNWESpecified() {
        return localKUNWETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KUNWE_type3
     */
    public com.nhry.webService.client.masterData.functions.KUNWE_type3 getKUNWE() {
        return localKUNWE;
    }

    /**
     * Auto generated setter method
     * @param param KUNWE
     */
    public void setKUNWE(
        com.nhry.webService.client.masterData.functions.KUNWE_type3 param) {
        localKUNWETracker = param != null;

        this.localKUNWE = param;
    }

    public boolean isKDGRPSpecified() {
        return localKDGRPTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KDGRP_type1
     */
    public com.nhry.webService.client.masterData.functions.KDGRP_type1 getKDGRP() {
        return localKDGRP;
    }

    /**
     * Auto generated setter method
     * @param param KDGRP
     */
    public void setKDGRP(
        com.nhry.webService.client.masterData.functions.KDGRP_type1 param) {
        localKDGRPTracker = param != null;

        this.localKDGRP = param;
    }

    public boolean isKVGR2Specified() {
        return localKVGR2Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KVGR2_type1
     */
    public com.nhry.webService.client.masterData.functions.KVGR2_type1 getKVGR2() {
        return localKVGR2;
    }

    /**
     * Auto generated setter method
     * @param param KVGR2
     */
    public void setKVGR2(
        com.nhry.webService.client.masterData.functions.KVGR2_type1 param) {
        localKVGR2Tracker = param != null;

        this.localKVGR2 = param;
    }

    public boolean isLOEVMSpecified() {
        return localLOEVMTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.LOEVM_type3
     */
    public com.nhry.webService.client.masterData.functions.LOEVM_type3 getLOEVM() {
        return localLOEVM;
    }

    /**
     * Auto generated setter method
     * @param param LOEVM
     */
    public void setLOEVM(
        com.nhry.webService.client.masterData.functions.LOEVM_type3 param) {
        localLOEVMTracker = param != null;

        this.localLOEVM = param;
    }

    public boolean isKONDASpecified() {
        return localKONDATracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.masterData.functions.KONDA_type1
     */
    public com.nhry.webService.client.masterData.functions.KONDA_type1 getKONDA() {
        return localKONDA;
    }

    /**
     * Auto generated setter method
     * @param param KONDA
     */
    public void setKONDA(
        com.nhry.webService.client.masterData.functions.KONDA_type1 param) {
        localKONDATracker = param != null;

        this.localKONDA = param;
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
                    namespacePrefix + ":ZSSD00003", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSSD00003", xmlWriter);
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

        if (localKVGR1Tracker) {
            if (localKVGR1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KVGR1 cannot be null!!");
            }

            localKVGR1.serialize(new javax.xml.namespace.QName("", "KVGR1"),
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

        if (localKDGRPTracker) {
            if (localKDGRP == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KDGRP cannot be null!!");
            }

            localKDGRP.serialize(new javax.xml.namespace.QName("", "KDGRP"),
                xmlWriter);
        }

        if (localKVGR2Tracker) {
            if (localKVGR2 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KVGR2 cannot be null!!");
            }

            localKVGR2.serialize(new javax.xml.namespace.QName("", "KVGR2"),
                xmlWriter);
        }

        if (localLOEVMTracker) {
            if (localLOEVM == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "LOEVM cannot be null!!");
            }

            localLOEVM.serialize(new javax.xml.namespace.QName("", "LOEVM"),
                xmlWriter);
        }

        if (localKONDATracker) {
            if (localKONDA == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "KONDA cannot be null!!");
            }

            localKONDA.serialize(new javax.xml.namespace.QName("", "KONDA"),
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
        public static ZSSD00003 parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            ZSSD00003 object = new ZSSD00003();

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

                        if (!"ZSSD00003".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSSD00003) com.nhry.webService.client.masterData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                    object.setKUNNR(com.nhry.webService.client.masterData.functions.KUNNR_type9.Factory.parse(
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
                    object.setVKORG(com.nhry.webService.client.masterData.functions.VKORG_type11.Factory.parse(
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
                    object.setVTWEG(com.nhry.webService.client.masterData.functions.VTWEG_type11.Factory.parse(
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
                    object.setSPART(com.nhry.webService.client.masterData.functions.SPART_type9.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KVGR1").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KVGR1").equals(
                            reader.getName())) {
                    object.setKVGR1(com.nhry.webService.client.masterData.functions.KVGR1_type1.Factory.parse(
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
                    object.setKUNWE(com.nhry.webService.client.masterData.functions.KUNWE_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KDGRP").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KDGRP").equals(
                            reader.getName())) {
                    object.setKDGRP(com.nhry.webService.client.masterData.functions.KDGRP_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KVGR2").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KVGR2").equals(
                            reader.getName())) {
                    object.setKVGR2(com.nhry.webService.client.masterData.functions.KVGR2_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "LOEVM").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "LOEVM").equals(
                            reader.getName())) {
                    object.setLOEVM(com.nhry.webService.client.masterData.functions.LOEVM_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "KONDA").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "KONDA").equals(
                            reader.getName())) {
                    object.setKONDA(com.nhry.webService.client.masterData.functions.KONDA_type1.Factory.parse(
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
