/**
 * ZOA_ACC_DOCUMENT_REV_POSTResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.disCount.functions;


/**
 *  ZOA_ACC_DOCUMENT_REV_POSTResponse bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZOA_ACC_DOCUMENT_REV_POSTResponse implements org.apache.axis2.databinding.ADBBean {
    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
            "ZOA_ACC_DOCUMENT_REV_POST.Response", "ns1");

    /**
     * field for E_BUKRS
     */
    protected E_BUKRS_type1 localE_BUKRS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localE_BUKRSTracker = false;

    /**
     * field for E_EBLNR
     */
    protected E_EBLNR_type1 localE_EBLNR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localE_EBLNRTracker = false;

    /**
     * field for E_GJAHR
     */
    protected E_GJAHR_type1 localE_GJAHR;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localE_GJAHRTracker = false;

    /**
     * field for E_KEY
     */
    protected E_KEY_type1 localE_KEY;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localE_KEYTracker = false;

    /**
     * field for E_SYS
     */
    protected E_SYS_type1 localE_SYS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localE_SYSTracker = false;

    /**
     * field for E_TYPE
     */
    protected E_TYPE_type1 localE_TYPE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localE_TYPETracker = false;

    /**
     * field for ET_RETURN
     */
    protected ET_RETURN_type1 localET_RETURN;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localET_RETURNTracker = false;

    public boolean isE_BUKRSSpecified() {
        return localE_BUKRSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.E_BUKRS_type1
     */
    public E_BUKRS_type1 getE_BUKRS() {
        return localE_BUKRS;
    }

    /**
     * Auto generated setter method
     * @param param E_BUKRS
     */
    public void setE_BUKRS(
        E_BUKRS_type1 param) {
        localE_BUKRSTracker = param != null;

        this.localE_BUKRS = param;
    }

    public boolean isE_EBLNRSpecified() {
        return localE_EBLNRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.E_EBLNR_type1
     */
    public E_EBLNR_type1 getE_EBLNR() {
        return localE_EBLNR;
    }

    /**
     * Auto generated setter method
     * @param param E_EBLNR
     */
    public void setE_EBLNR(
        E_EBLNR_type1 param) {
        localE_EBLNRTracker = param != null;

        this.localE_EBLNR = param;
    }

    public boolean isE_GJAHRSpecified() {
        return localE_GJAHRTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.E_GJAHR_type1
     */
    public E_GJAHR_type1 getE_GJAHR() {
        return localE_GJAHR;
    }

    /**
     * Auto generated setter method
     * @param param E_GJAHR
     */
    public void setE_GJAHR(
        E_GJAHR_type1 param) {
        localE_GJAHRTracker = param != null;

        this.localE_GJAHR = param;
    }

    public boolean isE_KEYSpecified() {
        return localE_KEYTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.E_KEY_type1
     */
    public E_KEY_type1 getE_KEY() {
        return localE_KEY;
    }

    /**
     * Auto generated setter method
     * @param param E_KEY
     */
    public void setE_KEY(
        E_KEY_type1 param) {
        localE_KEYTracker = param != null;

        this.localE_KEY = param;
    }

    public boolean isE_SYSSpecified() {
        return localE_SYSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.E_SYS_type1
     */
    public E_SYS_type1 getE_SYS() {
        return localE_SYS;
    }

    /**
     * Auto generated setter method
     * @param param E_SYS
     */
    public void setE_SYS(
        E_SYS_type1 param) {
        localE_SYSTracker = param != null;

        this.localE_SYS = param;
    }

    public boolean isE_TYPESpecified() {
        return localE_TYPETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.E_TYPE_type1
     */
    public E_TYPE_type1 getE_TYPE() {
        return localE_TYPE;
    }

    /**
     * Auto generated setter method
     * @param param E_TYPE
     */
    public void setE_TYPE(
        E_TYPE_type1 param) {
        localE_TYPETracker = param != null;

        this.localE_TYPE = param;
    }

    public boolean isET_RETURNSpecified() {
        return localET_RETURNTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.disCount.functions.ET_RETURN_type1
     */
    public ET_RETURN_type1 getET_RETURN() {
        return localET_RETURN;
    }

    /**
     * Auto generated setter method
     * @param param ET_RETURN
     */
    public void setET_RETURN(
        ET_RETURN_type1 param) {
        localET_RETURNTracker = param != null;

        this.localET_RETURN = param;
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
                    namespacePrefix + ":ZOA_ACC_DOCUMENT_REV_POST.Response",
                    xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZOA_ACC_DOCUMENT_REV_POST.Response", xmlWriter);
            }
        }

        if (localE_BUKRSTracker) {
            if (localE_BUKRS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "E_BUKRS cannot be null!!");
            }

            localE_BUKRS.serialize(new javax.xml.namespace.QName("", "E_BUKRS"),
                xmlWriter);
        }

        if (localE_EBLNRTracker) {
            if (localE_EBLNR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "E_EBLNR cannot be null!!");
            }

            localE_EBLNR.serialize(new javax.xml.namespace.QName("", "E_EBLNR"),
                xmlWriter);
        }

        if (localE_GJAHRTracker) {
            if (localE_GJAHR == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "E_GJAHR cannot be null!!");
            }

            localE_GJAHR.serialize(new javax.xml.namespace.QName("", "E_GJAHR"),
                xmlWriter);
        }

        if (localE_KEYTracker) {
            if (localE_KEY == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "E_KEY cannot be null!!");
            }

            localE_KEY.serialize(new javax.xml.namespace.QName("", "E_KEY"),
                xmlWriter);
        }

        if (localE_SYSTracker) {
            if (localE_SYS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "E_SYS cannot be null!!");
            }

            localE_SYS.serialize(new javax.xml.namespace.QName("", "E_SYS"),
                xmlWriter);
        }

        if (localE_TYPETracker) {
            if (localE_TYPE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "E_TYPE cannot be null!!");
            }

            localE_TYPE.serialize(new javax.xml.namespace.QName("", "E_TYPE"),
                xmlWriter);
        }

        if (localET_RETURNTracker) {
            if (localET_RETURN == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ET_RETURN cannot be null!!");
            }

            localET_RETURN.serialize(new javax.xml.namespace.QName("",
                    "ET_RETURN"), xmlWriter);
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
        public static ZOA_ACC_DOCUMENT_REV_POSTResponse parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            ZOA_ACC_DOCUMENT_REV_POSTResponse object = new ZOA_ACC_DOCUMENT_REV_POSTResponse();

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

                        if (!"ZOA_ACC_DOCUMENT_REV_POST.Response".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZOA_ACC_DOCUMENT_REV_POSTResponse) ExtensionMapper.getTypeObject(nsUri,
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
                                new javax.xml.namespace.QName("", "E_BUKRS").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "E_BUKRS").equals(
                                    reader.getName())) {
                            object.setE_BUKRS(E_BUKRS_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "E_EBLNR").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "E_EBLNR").equals(
                                    reader.getName())) {
                            object.setE_EBLNR(E_EBLNR_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "E_GJAHR").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "E_GJAHR").equals(
                                    reader.getName())) {
                            object.setE_GJAHR(E_GJAHR_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "E_KEY").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "E_KEY").equals(
                                    reader.getName())) {
                            object.setE_KEY(E_KEY_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "E_SYS").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "E_SYS").equals(
                                    reader.getName())) {
                            object.setE_SYS(E_SYS_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "E_TYPE").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "E_TYPE").equals(
                                    reader.getName())) {
                            object.setE_TYPE(E_TYPE_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "ET_RETURN").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ET_RETURN").equals(
                                    reader.getName())) {
                            object.setET_RETURN(ET_RETURN_type1.Factory.parse(
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
