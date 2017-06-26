/**
 * Z_CRM_PT_QUERY_RFC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.VipPoint.functions;


/**
 *  Z_CRM_PT_QUERY_RFC bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class Z_CRM_PT_QUERY_RFC implements org.apache.axis2.databinding.ADBBean {
    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
            "Z_CRM_PT_QUERY_RFC", "ns1");

    /**
     * field for IV_CARD_ID
     */
    protected IV_CARD_ID_type1 localIV_CARD_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIV_CARD_IDTracker = false;

    /**
     * field for IV_GUID
     */
    protected IV_GUID_type1 localIV_GUID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIV_GUIDTracker = false;

    /**
     * field for IV_TEL
     */
    protected IV_TEL_type1 localIV_TEL;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIV_TELTracker = false;

    /**
     * field for T_BALANCE_OUT
     */
    protected T_BALANCE_OUT_type1 localT_BALANCE_OUT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localT_BALANCE_OUTTracker = false;

    public boolean isIV_CARD_IDSpecified() {
        return localIV_CARD_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipPoint.functions.IV_CARD_ID_type1
     */
    public IV_CARD_ID_type1 getIV_CARD_ID() {
        return localIV_CARD_ID;
    }

    /**
     * Auto generated setter method
     * @param param IV_CARD_ID
     */
    public void setIV_CARD_ID(
        IV_CARD_ID_type1 param) {
        localIV_CARD_IDTracker = param != null;

        this.localIV_CARD_ID = param;
    }

    public boolean isIV_GUIDSpecified() {
        return localIV_GUIDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipPoint.functions.IV_GUID_type1
     */
    public IV_GUID_type1 getIV_GUID() {
        return localIV_GUID;
    }

    /**
     * Auto generated setter method
     * @param param IV_GUID
     */
    public void setIV_GUID(
        IV_GUID_type1 param) {
        localIV_GUIDTracker = param != null;

        this.localIV_GUID = param;
    }

    public boolean isIV_TELSpecified() {
        return localIV_TELTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipPoint.functions.IV_TEL_type1
     */
    public IV_TEL_type1 getIV_TEL() {
        return localIV_TEL;
    }

    /**
     * Auto generated setter method
     * @param param IV_TEL
     */
    public void setIV_TEL(
        IV_TEL_type1 param) {
        localIV_TELTracker = param != null;

        this.localIV_TEL = param;
    }

    public boolean isT_BALANCE_OUTSpecified() {
        return localT_BALANCE_OUTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipPoint.functions.T_BALANCE_OUT_type1
     */
    public T_BALANCE_OUT_type1 getT_BALANCE_OUT() {
        return localT_BALANCE_OUT;
    }

    /**
     * Auto generated setter method
     * @param param T_BALANCE_OUT
     */
    public void setT_BALANCE_OUT(
        T_BALANCE_OUT_type1 param) {
        localT_BALANCE_OUTTracker = param != null;

        this.localT_BALANCE_OUT = param;
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
                this, MY_QNAME));
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
        String prefix = null;
        String namespace = null;

        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();
        writeStartElement(prefix, namespace, parentQName.getLocalPart(),
            xmlWriter);

        if (serializeType) {
            String namespacePrefix = registerPrefix(xmlWriter,
                    "urn:sap-com:document:sap:rfc:functions");

            if ((namespacePrefix != null) &&
                    (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    namespacePrefix + ":Z_CRM_PT_QUERY_RFC", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "Z_CRM_PT_QUERY_RFC", xmlWriter);
            }
        }

        if (localIV_CARD_IDTracker) {
            if (localIV_CARD_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "IV_CARD_ID cannot be null!!");
            }

            localIV_CARD_ID.serialize(new javax.xml.namespace.QName("",
                    "IV_CARD_ID"), xmlWriter);
        }

        if (localIV_GUIDTracker) {
            if (localIV_GUID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "IV_GUID cannot be null!!");
            }

            localIV_GUID.serialize(new javax.xml.namespace.QName("", "IV_GUID"),
                xmlWriter);
        }

        if (localIV_TELTracker) {
            if (localIV_TEL == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "IV_TEL cannot be null!!");
            }

            localIV_TEL.serialize(new javax.xml.namespace.QName("", "IV_TEL"),
                xmlWriter);
        }

        if (localT_BALANCE_OUTTracker) {
            if (localT_BALANCE_OUT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "T_BALANCE_OUT cannot be null!!");
            }

            localT_BALANCE_OUT.serialize(new javax.xml.namespace.QName("",
                    "T_BALANCE_OUT"), xmlWriter);
        }

        xmlWriter.writeEndElement();
    }

    private static String generatePrefix(String namespace) {
        if (namespace.equals("urn:sap-com:document:sap:rfc:functions")) {
            return "ns1";
        }

        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(String prefix,
        String namespace, String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        String writerPrefix = xmlWriter.getPrefix(namespace);

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
    private void writeAttribute(String prefix,
        String namespace, String attName,
        String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        String writerPrefix = xmlWriter.getPrefix(namespace);

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
    private void writeAttribute(String namespace,
        String attName, String attValue,
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
    private void writeQNameAttribute(String namespace,
        String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        String attributeNamespace = qname.getNamespaceURI();
        String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

        if (attributePrefix == null) {
            attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
        }

        String attributeValue;

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
        String namespaceURI = qname.getNamespaceURI();

        if (namespaceURI != null) {
            String prefix = xmlWriter.getPrefix(namespaceURI);

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
            StringBuffer stringToWrite = new StringBuffer();
            String namespaceURI = null;
            String prefix = null;

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
    private String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, String namespace)
        throws javax.xml.stream.XMLStreamException {
        String prefix = xmlWriter.getPrefix(namespace);

        if (prefix == null) {
            prefix = generatePrefix(namespace);

            javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

            while (true) {
                String uri = nsContext.getNamespaceURI(prefix);

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
        public static Z_CRM_PT_QUERY_RFC parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            Z_CRM_PT_QUERY_RFC object = new Z_CRM_PT_QUERY_RFC();

            int event;
            javax.xml.namespace.QName currentQName = null;
            String nillableValue = null;
            String prefix = "";
            String namespaceuri = "";

            try {
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                currentQName = reader.getName();

                if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "type");

                    if (fullTypeName != null) {
                        String nsPrefix = null;

                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0,
                                    fullTypeName.indexOf(":"));
                        }

                        nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                        String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                        if (!"Z_CRM_PT_QUERY_RFC".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (Z_CRM_PT_QUERY_RFC) ExtensionMapper.getTypeObject(nsUri,
                                type, reader);
                        }
                    }
                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                while (!reader.isEndElement()) {
                    if (reader.isStartElement()) {
                        if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "IV_CARD_ID").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "IV_CARD_ID").equals(
                                    reader.getName())) {
                            object.setIV_CARD_ID(IV_CARD_ID_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "IV_GUID").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "IV_GUID").equals(
                                    reader.getName())) {
                            object.setIV_GUID(IV_GUID_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "IV_TEL").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "IV_TEL").equals(
                                    reader.getName())) {
                            object.setIV_TEL(IV_TEL_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("",
                                    "T_BALANCE_OUT").equals(reader.getName())) ||
                                new javax.xml.namespace.QName("",
                                    "T_BALANCE_OUT").equals(reader.getName())) {
                            object.setT_BALANCE_OUT(T_BALANCE_OUT_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else {
                            // 3 - A start element we are not expecting indicates an invalid parameter was passed
                            throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                        }
                    } else {
                        reader.next();
                    }
                } // end of while loop
            } catch (javax.xml.stream.XMLStreamException e) {
                throw new Exception(e);
            }

            return object;
        }
    } //end of factory class
}
