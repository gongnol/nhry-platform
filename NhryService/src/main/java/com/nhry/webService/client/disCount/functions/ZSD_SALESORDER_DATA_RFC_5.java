/**
 * ZSD_SALESORDER_DATA_RFC_5.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.disCount.functions;


/**
 *  ZSD_SALESORDER_DATA_RFC_5 bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSD_SALESORDER_DATA_RFC_5 implements org.apache.axis2.databinding.ADBBean {
    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
            "ZSD_SALESORDER_DATA_RFC_5", "ns1");

    /**
     * field for IT_ZSSD00010
     */
    protected ZSSD00010 localIT_ZSSD00010;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIT_ZSSD00010Tracker = false;

    /**
     * field for I_MONI
     */
    protected I_MONI_type1 localI_MONI;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localI_MONITracker = false;

    /**
     * field for ET_BAPIRETURN1
     */
    protected ET_BAPIRETURN1_type1 localET_BAPIRETURN1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_BAPIRETURN1Tracker = false;

    /**
     * field for IT_ZSSD00011
     */
    protected IT_ZSSD00011_type1 localIT_ZSSD00011;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIT_ZSSD00011Tracker = false;

    public boolean isIT_ZSSD00010Specified() {
        return localIT_ZSSD00010Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.ZSSD00010
     */
    public ZSSD00010 getIT_ZSSD00010() {
        return localIT_ZSSD00010;
    }

    /**
     * Auto generated setter method
     * @param param IT_ZSSD00010
     */
    public void setIT_ZSSD00010(
        ZSSD00010 param) {
        localIT_ZSSD00010Tracker = param != null;

        this.localIT_ZSSD00010 = param;
    }

    public boolean isI_MONISpecified() {
        return localI_MONITracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.I_MONI_type1
     */
    public I_MONI_type1 getI_MONI() {
        return localI_MONI;
    }

    /**
     * Auto generated setter method
     * @param param I_MONI
     */
    public void setI_MONI(
        I_MONI_type1 param) {
        localI_MONITracker = param != null;

        this.localI_MONI = param;
    }

    public boolean isET_BAPIRETURN1Specified() {
        return localET_BAPIRETURN1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.ET_BAPIRETURN1_type1
     */
    public ET_BAPIRETURN1_type1 getET_BAPIRETURN1() {
        return localET_BAPIRETURN1;
    }

    /**
     * Auto generated setter method
     * @param param ET_BAPIRETURN1
     */
    public void setET_BAPIRETURN1(
        ET_BAPIRETURN1_type1 param) {
        localET_BAPIRETURN1Tracker = param != null;

        this.localET_BAPIRETURN1 = param;
    }

    public boolean isIT_ZSSD00011Specified() {
        return localIT_ZSSD00011Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.IT_ZSSD00011_type1
     */
    public IT_ZSSD00011_type1 getIT_ZSSD00011() {
        return localIT_ZSSD00011;
    }

    /**
     * Auto generated setter method
     * @param param IT_ZSSD00011
     */
    public void setIT_ZSSD00011(
        IT_ZSSD00011_type1 param) {
        localIT_ZSSD00011Tracker = param != null;

        this.localIT_ZSSD00011 = param;
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
                    namespacePrefix + ":ZSD_SALESORDER_DATA_RFC_5", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSD_SALESORDER_DATA_RFC_5", xmlWriter);
            }
        }

        if (localIT_ZSSD00010Tracker) {
            if (localIT_ZSSD00010 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "IT_ZSSD00010 cannot be null!!");
            }

            localIT_ZSSD00010.serialize(new javax.xml.namespace.QName("",
                    "IT_ZSSD00010"), xmlWriter);
        }

        if (localI_MONITracker) {
            if (localI_MONI == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "I_MONI cannot be null!!");
            }

            localI_MONI.serialize(new javax.xml.namespace.QName("", "I_MONI"),
                xmlWriter);
        }

        if (localET_BAPIRETURN1Tracker) {
            if (localET_BAPIRETURN1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_BAPIRETURN1 cannot be null!!");
            }

            localET_BAPIRETURN1.serialize(new javax.xml.namespace.QName("",
                    "ET_BAPIRETURN1"), xmlWriter);
        }

        if (localIT_ZSSD00011Tracker) {
            if (localIT_ZSSD00011 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "IT_ZSSD00011 cannot be null!!");
            }

            localIT_ZSSD00011.serialize(new javax.xml.namespace.QName("",
                    "IT_ZSSD00011"), xmlWriter);
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
        public static ZSD_SALESORDER_DATA_RFC_5 parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            ZSD_SALESORDER_DATA_RFC_5 object = new ZSD_SALESORDER_DATA_RFC_5();

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

                        if (!"ZSD_SALESORDER_DATA_RFC_5".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSD_SALESORDER_DATA_RFC_5) ExtensionMapper.getTypeObject(nsUri,
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
                                new javax.xml.namespace.QName("", "IT_ZSSD00010").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "IT_ZSSD00010").equals(
                                    reader.getName())) {
                            object.setIT_ZSSD00010(ZSSD00010.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "I_MONI").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "I_MONI").equals(
                                    reader.getName())) {
                            object.setI_MONI(I_MONI_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("",
                                    "ET_BAPIRETURN1").equals(reader.getName())) ||
                                new javax.xml.namespace.QName("",
                                    "ET_BAPIRETURN1").equals(reader.getName())) {
                            object.setET_BAPIRETURN1(ET_BAPIRETURN1_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "IT_ZSSD00011").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "IT_ZSSD00011").equals(
                                    reader.getName())) {
                            object.setIT_ZSSD00011(IT_ZSSD00011_type1.Factory.parse(
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
