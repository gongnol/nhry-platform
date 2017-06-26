/**
 * ReplyConfirmRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.sms.functions;


/**
 *  ReplyConfirmRequest bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ReplyConfirmRequest implements org.apache.axis2.databinding.ADBBean {
    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://ws.flaginfo.com.cn",
            "ReplyConfirmRequest", "ns1");

    /**
     * field for In0
     */
    protected String localIn0;

    /**
     * field for In1
     */
    protected String localIn1;

    /**
     * field for In2
     */
    protected String localIn2;

    /**
     * field for In3
     */
    protected String localIn3;

    /**
     * field for In4
     */
    protected String localIn4;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localIn4Tracker = false;

    /**
     * Auto generated getter method
     * @return java.lang.String
     */
    public String getIn0() {
        return localIn0;
    }

    /**
     * Auto generated setter method
     * @param param In0
     */
    public void setIn0(String param) {
        this.localIn0 = param;
    }

    /**
     * Auto generated getter method
     * @return java.lang.String
     */
    public String getIn1() {
        return localIn1;
    }

    /**
     * Auto generated setter method
     * @param param In1
     */
    public void setIn1(String param) {
        this.localIn1 = param;
    }

    /**
     * Auto generated getter method
     * @return java.lang.String
     */
    public String getIn2() {
        return localIn2;
    }

    /**
     * Auto generated setter method
     * @param param In2
     */
    public void setIn2(String param) {
        this.localIn2 = param;
    }

    /**
     * Auto generated getter method
     * @return java.lang.String
     */
    public String getIn3() {
        return localIn3;
    }

    /**
     * Auto generated setter method
     * @param param In3
     */
    public void setIn3(String param) {
        this.localIn3 = param;
    }

    public boolean isIn4Specified() {
        return localIn4Tracker;
    }

    /**
     * Auto generated getter method
     * @return java.lang.String
     */
    public String getIn4() {
        return localIn4;
    }

    /**
     * Auto generated setter method
     * @param param In4
     */
    public void setIn4(String param) {
        localIn4Tracker = true;

        this.localIn4 = param;
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
                    "http://ws.flaginfo.com.cn");

            if ((namespacePrefix != null) &&
                    (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    namespacePrefix + ":ReplyConfirmRequest", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ReplyConfirmRequest", xmlWriter);
            }
        }

        namespace = "http://ws.flaginfo.com.cn";
        writeStartElement(null, namespace, "in0", xmlWriter);

        if (localIn0 == null) {
            // write the nil attribute
            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
                "nil", "1", xmlWriter);
        } else {
            xmlWriter.writeCharacters(localIn0);
        }

        xmlWriter.writeEndElement();

        namespace = "http://ws.flaginfo.com.cn";
        writeStartElement(null, namespace, "in1", xmlWriter);

        if (localIn1 == null) {
            // write the nil attribute
            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
                "nil", "1", xmlWriter);
        } else {
            xmlWriter.writeCharacters(localIn1);
        }

        xmlWriter.writeEndElement();

        namespace = "http://ws.flaginfo.com.cn";
        writeStartElement(null, namespace, "in2", xmlWriter);

        if (localIn2 == null) {
            // write the nil attribute
            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
                "nil", "1", xmlWriter);
        } else {
            xmlWriter.writeCharacters(localIn2);
        }

        xmlWriter.writeEndElement();

        namespace = "http://ws.flaginfo.com.cn";
        writeStartElement(null, namespace, "in3", xmlWriter);

        if (localIn3 == null) {
            // write the nil attribute
            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
                "nil", "1", xmlWriter);
        } else {
            xmlWriter.writeCharacters(localIn3);
        }

        xmlWriter.writeEndElement();

        if (localIn4Tracker) {
            namespace = "http://ws.flaginfo.com.cn";
            writeStartElement(null, namespace, "in4", xmlWriter);

            if (localIn4 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localIn4);
            }

            xmlWriter.writeEndElement();
        }

        xmlWriter.writeEndElement();
    }

    private static String generatePrefix(String namespace) {
        if (namespace.equals("http://ws.flaginfo.com.cn")) {
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
        public static ReplyConfirmRequest parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            ReplyConfirmRequest object = new ReplyConfirmRequest();

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

                        if (!"ReplyConfirmRequest".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ReplyConfirmRequest) ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName(
                            "http://ws.flaginfo.com.cn", "in0").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "in0").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        String content = reader.getElementText();

                        object.setIn0(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://ws.flaginfo.com.cn", "in1").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "in1").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        String content = reader.getElementText();

                        object.setIn1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://ws.flaginfo.com.cn", "in2").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "in2").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        String content = reader.getElementText();

                        object.setIn2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://ws.flaginfo.com.cn", "in3").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "in3").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        String content = reader.getElementText();

                        object.setIn3(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();
                } // End of if for expected property start element

                else {
                    // 1 - A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://ws.flaginfo.com.cn", "in4").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "in4").equals(
                            reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if (!"true".equals(nillableValue) &&
                            !"1".equals(nillableValue)) {
                        String content = reader.getElementText();

                        object.setIn4(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));
                    } else {
                        reader.getElementText(); // throw away text nodes if any.
                    }

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
                throw new Exception(e);
            }

            return object;
        }
    } //end of factory class
}
