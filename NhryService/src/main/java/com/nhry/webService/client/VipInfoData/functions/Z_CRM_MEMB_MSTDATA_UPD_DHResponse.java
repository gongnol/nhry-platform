/**
 * Z_CRM_MEMB_MSTDATA_UPD_DHResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.VipInfoData.functions;


/**
 *  Z_CRM_MEMB_MSTDATA_UPD_DHResponse bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class Z_CRM_MEMB_MSTDATA_UPD_DHResponse implements org.apache.axis2.databinding.ADBBean {
    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
            "Z_CRM_MEMB_MSTDATA_UPD_DH.Response", "ns1");

    /**
     * field for ES_RETURN
     */
    protected ZSCRM_MESSAGE localES_RETURN;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localES_RETURNTracker = false;

    /**
     * field for EV_MEMB_GUID
     */
    protected EV_MEMB_GUID_type1 localEV_MEMB_GUID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localEV_MEMB_GUIDTracker = false;

    /**
     * field for EV_MEMB_ID
     */
    protected EV_MEMB_ID_type1 localEV_MEMB_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localEV_MEMB_IDTracker = false;

    /**
     * field for T_ZTAB0000LQ
     */
    protected T_ZTAB0000LQ_type1 localT_ZTAB0000LQ;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localT_ZTAB0000LQTracker = false;

    public boolean isES_RETURNSpecified() {
        return localES_RETURNTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.ZSCRM_MESSAGE
     */
    public ZSCRM_MESSAGE getES_RETURN() {
        return localES_RETURN;
    }

    /**
     * Auto generated setter method
     * @param param ES_RETURN
     */
    public void setES_RETURN(
        ZSCRM_MESSAGE param) {
        localES_RETURNTracker = param != null;

        this.localES_RETURN = param;
    }

    public boolean isEV_MEMB_GUIDSpecified() {
        return localEV_MEMB_GUIDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.EV_MEMB_GUID_type1
     */
    public EV_MEMB_GUID_type1 getEV_MEMB_GUID() {
        return localEV_MEMB_GUID;
    }

    /**
     * Auto generated setter method
     * @param param EV_MEMB_GUID
     */
    public void setEV_MEMB_GUID(
        EV_MEMB_GUID_type1 param) {
        localEV_MEMB_GUIDTracker = param != null;

        this.localEV_MEMB_GUID = param;
    }

    public boolean isEV_MEMB_IDSpecified() {
        return localEV_MEMB_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.EV_MEMB_ID_type1
     */
    public EV_MEMB_ID_type1 getEV_MEMB_ID() {
        return localEV_MEMB_ID;
    }

    /**
     * Auto generated setter method
     * @param param EV_MEMB_ID
     */
    public void setEV_MEMB_ID(
        EV_MEMB_ID_type1 param) {
        localEV_MEMB_IDTracker = param != null;

        this.localEV_MEMB_ID = param;
    }

    public boolean isT_ZTAB0000LQSpecified() {
        return localT_ZTAB0000LQTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.VipInfoData.functions.T_ZTAB0000LQ_type1
     */
    public T_ZTAB0000LQ_type1 getT_ZTAB0000LQ() {
        return localT_ZTAB0000LQ;
    }

    /**
     * Auto generated setter method
     * @param param T_ZTAB0000LQ
     */
    public void setT_ZTAB0000LQ(
        T_ZTAB0000LQ_type1 param) {
        localT_ZTAB0000LQTracker = param != null;

        this.localT_ZTAB0000LQ = param;
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
                    namespacePrefix + ":Z_CRM_MEMB_MSTDATA_UPD_DH.Response",
                    xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "Z_CRM_MEMB_MSTDATA_UPD_DH.Response", xmlWriter);
            }
        }

        if (localES_RETURNTracker) {
            if (localES_RETURN == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ES_RETURN cannot be null!!");
            }

            localES_RETURN.serialize(new javax.xml.namespace.QName("",
                    "ES_RETURN"), xmlWriter);
        }

        if (localEV_MEMB_GUIDTracker) {
            if (localEV_MEMB_GUID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "EV_MEMB_GUID cannot be null!!");
            }

            localEV_MEMB_GUID.serialize(new javax.xml.namespace.QName("",
                    "EV_MEMB_GUID"), xmlWriter);
        }

        if (localEV_MEMB_IDTracker) {
            if (localEV_MEMB_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "EV_MEMB_ID cannot be null!!");
            }

            localEV_MEMB_ID.serialize(new javax.xml.namespace.QName("",
                    "EV_MEMB_ID"), xmlWriter);
        }

        if (localT_ZTAB0000LQTracker) {
            if (localT_ZTAB0000LQ == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "T_ZTAB0000LQ cannot be null!!");
            }

            localT_ZTAB0000LQ.serialize(new javax.xml.namespace.QName("",
                    "T_ZTAB0000LQ"), xmlWriter);
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
        public static Z_CRM_MEMB_MSTDATA_UPD_DHResponse parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            Z_CRM_MEMB_MSTDATA_UPD_DHResponse object = new Z_CRM_MEMB_MSTDATA_UPD_DHResponse();

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

                        if (!"Z_CRM_MEMB_MSTDATA_UPD_DH.Response".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (Z_CRM_MEMB_MSTDATA_UPD_DHResponse) ExtensionMapper.getTypeObject(nsUri,
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
                                new javax.xml.namespace.QName("", "ES_RETURN").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "ES_RETURN").equals(
                                    reader.getName())) {
                            object.setES_RETURN(ZSCRM_MESSAGE.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "EV_MEMB_GUID").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "EV_MEMB_GUID").equals(
                                    reader.getName())) {
                            object.setEV_MEMB_GUID(EV_MEMB_GUID_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "EV_MEMB_ID").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "EV_MEMB_ID").equals(
                                    reader.getName())) {
                            object.setEV_MEMB_ID(EV_MEMB_ID_type1.Factory.parse(
                                    reader));

                            reader.next();
                        } // End of if for expected property start element

                        else
                         if ((reader.isStartElement() &&
                                new javax.xml.namespace.QName("", "T_ZTAB0000LQ").equals(
                                    reader.getName())) ||
                                new javax.xml.namespace.QName("", "T_ZTAB0000LQ").equals(
                                    reader.getName())) {
                            object.setT_ZTAB0000LQ(T_ZTAB0000LQ_type1.Factory.parse(
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
