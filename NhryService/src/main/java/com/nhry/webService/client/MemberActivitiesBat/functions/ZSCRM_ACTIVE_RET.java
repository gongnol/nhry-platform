/**
 * ZSCRM_ACTIVE_RET.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.MemberActivitiesBat.functions;


/**
 *  ZSCRM_ACTIVE_RET bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSCRM_ACTIVE_RET implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSCRM_ACTIVE_RET
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for FLAG
     */
    protected FLAG_type1 localFLAG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localFLAGTracker = false;

    /**
     * field for MSG
     */
    protected MSG_type1 localMSG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMSGTracker = false;

    /**
     * field for GUID
     */
    protected GUID_type1 localGUID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localGUIDTracker = false;

    /**
     * field for OBJECT_ID
     */
    protected OBJECT_ID_type1 localOBJECT_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localOBJECT_IDTracker = false;

    /**
     * field for ORDER_ID
     */
    protected ORDER_ID_type5 localORDER_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localORDER_IDTracker = false;

    /**
     * field for ITEM_NUM
     */
    protected ITEM_NUM_type3 localITEM_NUM;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localITEM_NUMTracker = false;

    public boolean isFLAGSpecified() {
        return localFLAGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.FLAG_type1
     */
    public FLAG_type1 getFLAG() {
        return localFLAG;
    }

    /**
     * Auto generated setter method
     * @param param FLAG
     */
    public void setFLAG(
        FLAG_type1 param) {
        localFLAGTracker = param != null;

        this.localFLAG = param;
    }

    public boolean isMSGSpecified() {
        return localMSGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.MSG_type1
     */
    public MSG_type1 getMSG() {
        return localMSG;
    }

    /**
     * Auto generated setter method
     * @param param MSG
     */
    public void setMSG(
        MSG_type1 param) {
        localMSGTracker = param != null;

        this.localMSG = param;
    }

    public boolean isGUIDSpecified() {
        return localGUIDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.GUID_type1
     */
    public GUID_type1 getGUID() {
        return localGUID;
    }

    /**
     * Auto generated setter method
     * @param param GUID
     */
    public void setGUID(
        GUID_type1 param) {
        localGUIDTracker = param != null;

        this.localGUID = param;
    }

    public boolean isOBJECT_IDSpecified() {
        return localOBJECT_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.OBJECT_ID_type1
     */
    public OBJECT_ID_type1 getOBJECT_ID() {
        return localOBJECT_ID;
    }

    /**
     * Auto generated setter method
     * @param param OBJECT_ID
     */
    public void setOBJECT_ID(
        OBJECT_ID_type1 param) {
        localOBJECT_IDTracker = param != null;

        this.localOBJECT_ID = param;
    }

    public boolean isORDER_IDSpecified() {
        return localORDER_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.ORDER_ID_type5
     */
    public ORDER_ID_type5 getORDER_ID() {
        return localORDER_ID;
    }

    /**
     * Auto generated setter method
     * @param param ORDER_ID
     */
    public void setORDER_ID(
        ORDER_ID_type5 param) {
        localORDER_IDTracker = param != null;

        this.localORDER_ID = param;
    }

    public boolean isITEM_NUMSpecified() {
        return localITEM_NUMTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.ITEM_NUM_type3
     */
    public ITEM_NUM_type3 getITEM_NUM() {
        return localITEM_NUM;
    }

    /**
     * Auto generated setter method
     * @param param ITEM_NUM
     */
    public void setITEM_NUM(
        ITEM_NUM_type3 param) {
        localITEM_NUMTracker = param != null;

        this.localITEM_NUM = param;
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
                    namespacePrefix + ":ZSCRM_ACTIVE_RET", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSCRM_ACTIVE_RET", xmlWriter);
            }
        }

        if (localFLAGTracker) {
            if (localFLAG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "FLAG cannot be null!!");
            }

            localFLAG.serialize(new javax.xml.namespace.QName("", "FLAG"),
                xmlWriter);
        }

        if (localMSGTracker) {
            if (localMSG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MSG cannot be null!!");
            }

            localMSG.serialize(new javax.xml.namespace.QName("", "MSG"),
                xmlWriter);
        }

        if (localGUIDTracker) {
            if (localGUID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "GUID cannot be null!!");
            }

            localGUID.serialize(new javax.xml.namespace.QName("", "GUID"),
                xmlWriter);
        }

        if (localOBJECT_IDTracker) {
            if (localOBJECT_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "OBJECT_ID cannot be null!!");
            }

            localOBJECT_ID.serialize(new javax.xml.namespace.QName("",
                    "OBJECT_ID"), xmlWriter);
        }

        if (localORDER_IDTracker) {
            if (localORDER_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ORDER_ID cannot be null!!");
            }

            localORDER_ID.serialize(new javax.xml.namespace.QName("", "ORDER_ID"),
                xmlWriter);
        }

        if (localITEM_NUMTracker) {
            if (localITEM_NUM == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ITEM_NUM cannot be null!!");
            }

            localITEM_NUM.serialize(new javax.xml.namespace.QName("", "ITEM_NUM"),
                xmlWriter);
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
        public static ZSCRM_ACTIVE_RET parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            ZSCRM_ACTIVE_RET object = new ZSCRM_ACTIVE_RET();

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

                        if (!"ZSCRM_ACTIVE_RET".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSCRM_ACTIVE_RET) ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "FLAG").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "FLAG").equals(
                            reader.getName())) {
                    object.setFLAG(FLAG_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MSG").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MSG").equals(
                            reader.getName())) {
                    object.setMSG(MSG_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "GUID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "GUID").equals(
                            reader.getName())) {
                    object.setGUID(GUID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "OBJECT_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "OBJECT_ID").equals(
                            reader.getName())) {
                    object.setOBJECT_ID(OBJECT_ID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "ORDER_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ORDER_ID").equals(
                            reader.getName())) {
                    object.setORDER_ID(ORDER_ID_type5.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "ITEM_NUM").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ITEM_NUM").equals(
                            reader.getName())) {
                    object.setITEM_NUM(ITEM_NUM_type3.Factory.parse(
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
                throw new Exception(e);
            }

            return object;
        }
    } //end of factory class
}
