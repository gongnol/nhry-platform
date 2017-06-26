/**
 * ZSD_REQ_EKKO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:48:01 BST)
 */
package com.nhry.webService.client.businessData.functions;


/**
 *  ZSD_REQ_EKKO bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSD_REQ_EKKO implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSD_REQ_EKKO
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for COMP_CODE
     */
    protected com.nhry.webService.client.businessData.functions.COMP_CODE_type1 localCOMP_CODE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCOMP_CODETracker = false;

    /**
     * field for DOC_TYPE
     */
    protected com.nhry.webService.client.businessData.functions.DOC_TYPE_type1 localDOC_TYPE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localDOC_TYPETracker = false;

    /**
     * field for PURCH_ORG
     */
    protected com.nhry.webService.client.businessData.functions.PURCH_ORG_type1 localPURCH_ORG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPURCH_ORGTracker = false;

    /**
     * field for PUR_GROUP
     */
    protected com.nhry.webService.client.businessData.functions.PUR_GROUP_type1 localPUR_GROUP;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPUR_GROUPTracker = false;

    /**
     * field for SUPPL_PLNT
     */
    protected com.nhry.webService.client.businessData.functions.SUPPL_PLNT_type1 localSUPPL_PLNT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSUPPL_PLNTTracker = false;

    /**
     * field for I_DATUM
     */
    protected com.nhry.webService.client.businessData.functions.Date localI_DATUM;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localI_DATUMTracker = false;

    public boolean isCOMP_CODESpecified() {
        return localCOMP_CODETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.COMP_CODE_type1
     */
    public com.nhry.webService.client.businessData.functions.COMP_CODE_type1 getCOMP_CODE() {
        return localCOMP_CODE;
    }

    /**
     * Auto generated setter method
     * @param param COMP_CODE
     */
    public void setCOMP_CODE(
        com.nhry.webService.client.businessData.functions.COMP_CODE_type1 param) {
        localCOMP_CODETracker = param != null;

        this.localCOMP_CODE = param;
    }

    public boolean isDOC_TYPESpecified() {
        return localDOC_TYPETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.DOC_TYPE_type1
     */
    public com.nhry.webService.client.businessData.functions.DOC_TYPE_type1 getDOC_TYPE() {
        return localDOC_TYPE;
    }

    /**
     * Auto generated setter method
     * @param param DOC_TYPE
     */
    public void setDOC_TYPE(
        com.nhry.webService.client.businessData.functions.DOC_TYPE_type1 param) {
        localDOC_TYPETracker = param != null;

        this.localDOC_TYPE = param;
    }

    public boolean isPURCH_ORGSpecified() {
        return localPURCH_ORGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.PURCH_ORG_type1
     */
    public com.nhry.webService.client.businessData.functions.PURCH_ORG_type1 getPURCH_ORG() {
        return localPURCH_ORG;
    }

    /**
     * Auto generated setter method
     * @param param PURCH_ORG
     */
    public void setPURCH_ORG(
        com.nhry.webService.client.businessData.functions.PURCH_ORG_type1 param) {
        localPURCH_ORGTracker = param != null;

        this.localPURCH_ORG = param;
    }

    public boolean isPUR_GROUPSpecified() {
        return localPUR_GROUPTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.PUR_GROUP_type1
     */
    public com.nhry.webService.client.businessData.functions.PUR_GROUP_type1 getPUR_GROUP() {
        return localPUR_GROUP;
    }

    /**
     * Auto generated setter method
     * @param param PUR_GROUP
     */
    public void setPUR_GROUP(
        com.nhry.webService.client.businessData.functions.PUR_GROUP_type1 param) {
        localPUR_GROUPTracker = param != null;

        this.localPUR_GROUP = param;
    }

    public boolean isSUPPL_PLNTSpecified() {
        return localSUPPL_PLNTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.SUPPL_PLNT_type1
     */
    public com.nhry.webService.client.businessData.functions.SUPPL_PLNT_type1 getSUPPL_PLNT() {
        return localSUPPL_PLNT;
    }

    /**
     * Auto generated setter method
     * @param param SUPPL_PLNT
     */
    public void setSUPPL_PLNT(
        com.nhry.webService.client.businessData.functions.SUPPL_PLNT_type1 param) {
        localSUPPL_PLNTTracker = param != null;

        this.localSUPPL_PLNT = param;
    }

    public boolean isI_DATUMSpecified() {
        return localI_DATUMTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.businessData.functions.Date
     */
    public com.nhry.webService.client.businessData.functions.Date getI_DATUM() {
        return localI_DATUM;
    }

    /**
     * Auto generated setter method
     * @param param I_DATUM
     */
    public void setI_DATUM(
        com.nhry.webService.client.businessData.functions.Date param) {
        localI_DATUMTracker = param != null;

        this.localI_DATUM = param;
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
                    namespacePrefix + ":ZSD_REQ_EKKO", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSD_REQ_EKKO", xmlWriter);
            }
        }

        if (localCOMP_CODETracker) {
            if (localCOMP_CODE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "COMP_CODE cannot be null!!");
            }

            localCOMP_CODE.serialize(new javax.xml.namespace.QName("",
                    "COMP_CODE"), xmlWriter);
        }

        if (localDOC_TYPETracker) {
            if (localDOC_TYPE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "DOC_TYPE cannot be null!!");
            }

            localDOC_TYPE.serialize(new javax.xml.namespace.QName("", "DOC_TYPE"),
                xmlWriter);
        }

        if (localPURCH_ORGTracker) {
            if (localPURCH_ORG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PURCH_ORG cannot be null!!");
            }

            localPURCH_ORG.serialize(new javax.xml.namespace.QName("",
                    "PURCH_ORG"), xmlWriter);
        }

        if (localPUR_GROUPTracker) {
            if (localPUR_GROUP == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PUR_GROUP cannot be null!!");
            }

            localPUR_GROUP.serialize(new javax.xml.namespace.QName("",
                    "PUR_GROUP"), xmlWriter);
        }

        if (localSUPPL_PLNTTracker) {
            if (localSUPPL_PLNT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SUPPL_PLNT cannot be null!!");
            }

            localSUPPL_PLNT.serialize(new javax.xml.namespace.QName("",
                    "SUPPL_PLNT"), xmlWriter);
        }

        if (localI_DATUMTracker) {
            if (localI_DATUM == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "I_DATUM cannot be null!!");
            }

            localI_DATUM.serialize(new javax.xml.namespace.QName("", "I_DATUM"),
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
        public static ZSD_REQ_EKKO parse(
            javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            ZSD_REQ_EKKO object = new ZSD_REQ_EKKO();

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

                        if (!"ZSD_REQ_EKKO".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSD_REQ_EKKO) com.nhry.webService.client.businessData.functions.ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "COMP_CODE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "COMP_CODE").equals(
                            reader.getName())) {
                    object.setCOMP_CODE(com.nhry.webService.client.businessData.functions.COMP_CODE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "DOC_TYPE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "DOC_TYPE").equals(
                            reader.getName())) {
                    object.setDOC_TYPE(com.nhry.webService.client.businessData.functions.DOC_TYPE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PURCH_ORG").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PURCH_ORG").equals(
                            reader.getName())) {
                    object.setPURCH_ORG(com.nhry.webService.client.businessData.functions.PURCH_ORG_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PUR_GROUP").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PUR_GROUP").equals(
                            reader.getName())) {
                    object.setPUR_GROUP(com.nhry.webService.client.businessData.functions.PUR_GROUP_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "SUPPL_PLNT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "SUPPL_PLNT").equals(
                            reader.getName())) {
                    object.setSUPPL_PLNT(com.nhry.webService.client.businessData.functions.SUPPL_PLNT_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "I_DATUM").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "I_DATUM").equals(
                            reader.getName())) {
                    object.setI_DATUM(com.nhry.webService.client.businessData.functions.Date.Factory.parse(
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
