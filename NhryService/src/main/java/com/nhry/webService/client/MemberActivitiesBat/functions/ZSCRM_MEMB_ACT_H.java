/**
 * ZSCRM_MEMB_ACT_H.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.MemberActivitiesBat.functions;


/**
 *  ZSCRM_MEMB_ACT_H bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSCRM_MEMB_ACT_H implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSCRM_MEMB_ACT_H
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for ORDER_ID
     */
    protected ORDER_ID_type1 localORDER_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localORDER_IDTracker = false;

    /**
     * field for CATEGORY
     */
    protected CATEGORY_type1 localCATEGORY;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCATEGORYTracker = false;

    /**
     * field for PROCESS_TYPE
     */
    protected com.nhry.webService.client.MemberActivitiesBat.functions.PROCESS_TYPE_type1 localPROCESS_TYPE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPROCESS_TYPETracker = false;

    /**
     * field for MEMBERSHIP_GUID
     */
    protected com.nhry.webService.client.MemberActivitiesBat.functions.MEMBERSHIP_GUID_type1 localMEMBERSHIP_GUID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMEMBERSHIP_GUIDTracker = false;

    /**
     * field for SALES_ORG
     */
    protected SALES_ORG_type1 localSALES_ORG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSALES_ORGTracker = false;

    /**
     * field for CARD_ID
     */
    protected CARD_ID_type1 localCARD_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCARD_IDTracker = false;

    /**
     * field for ACTIVITY_DATE
     */
    protected com.nhry.webService.client.MemberActivitiesBat.functions.ACTIVITY_DATE_type1 localACTIVITY_DATE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localACTIVITY_DATETracker = false;

    /**
     * field for COMMIT
     */
    protected COMMIT_type1 localCOMMIT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCOMMITTracker = false;

    public boolean isORDER_IDSpecified() {
        return localORDER_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.ORDER_ID_type1
     */
    public ORDER_ID_type1 getORDER_ID() {
        return localORDER_ID;
    }

    /**
     * Auto generated setter method
     * @param param ORDER_ID
     */
    public void setORDER_ID(
        ORDER_ID_type1 param) {
        localORDER_IDTracker = param != null;

        this.localORDER_ID = param;
    }

    public boolean isCATEGORYSpecified() {
        return localCATEGORYTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.CATEGORY_type1
     */
    public CATEGORY_type1 getCATEGORY() {
        return localCATEGORY;
    }

    /**
     * Auto generated setter method
     * @param param CATEGORY
     */
    public void setCATEGORY(
        CATEGORY_type1 param) {
        localCATEGORYTracker = param != null;

        this.localCATEGORY = param;
    }

    public boolean isPROCESS_TYPESpecified() {
        return localPROCESS_TYPETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.PROCESS_TYPE_type1
     */
    public com.nhry.webService.client.MemberActivitiesBat.functions.PROCESS_TYPE_type1 getPROCESS_TYPE() {
        return localPROCESS_TYPE;
    }

    /**
     * Auto generated setter method
     * @param param PROCESS_TYPE
     */
    public void setPROCESS_TYPE(
        com.nhry.webService.client.MemberActivitiesBat.functions.PROCESS_TYPE_type1 param) {
        localPROCESS_TYPETracker = param != null;

        this.localPROCESS_TYPE = param;
    }

    public boolean isMEMBERSHIP_GUIDSpecified() {
        return localMEMBERSHIP_GUIDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.MEMBERSHIP_GUID_type1
     */
    public com.nhry.webService.client.MemberActivitiesBat.functions.MEMBERSHIP_GUID_type1 getMEMBERSHIP_GUID() {
        return localMEMBERSHIP_GUID;
    }

    /**
     * Auto generated setter method
     * @param param MEMBERSHIP_GUID
     */
    public void setMEMBERSHIP_GUID(
        com.nhry.webService.client.MemberActivitiesBat.functions.MEMBERSHIP_GUID_type1 param) {
        localMEMBERSHIP_GUIDTracker = param != null;

        this.localMEMBERSHIP_GUID = param;
    }

    public boolean isSALES_ORGSpecified() {
        return localSALES_ORGTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.SALES_ORG_type1
     */
    public SALES_ORG_type1 getSALES_ORG() {
        return localSALES_ORG;
    }

    /**
     * Auto generated setter method
     * @param param SALES_ORG
     */
    public void setSALES_ORG(
        SALES_ORG_type1 param) {
        localSALES_ORGTracker = param != null;

        this.localSALES_ORG = param;
    }

    public boolean isCARD_IDSpecified() {
        return localCARD_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.CARD_ID_type1
     */
    public CARD_ID_type1 getCARD_ID() {
        return localCARD_ID;
    }

    /**
     * Auto generated setter method
     * @param param CARD_ID
     */
    public void setCARD_ID(
        CARD_ID_type1 param) {
        localCARD_IDTracker = param != null;

        this.localCARD_ID = param;
    }

    public boolean isACTIVITY_DATESpecified() {
        return localACTIVITY_DATETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.ACTIVITY_DATE_type1
     */
    public com.nhry.webService.client.MemberActivitiesBat.functions.ACTIVITY_DATE_type1 getACTIVITY_DATE() {
        return localACTIVITY_DATE;
    }

    /**
     * Auto generated setter method
     * @param param ACTIVITY_DATE
     */
    public void setACTIVITY_DATE(
        com.nhry.webService.client.MemberActivitiesBat.functions.ACTIVITY_DATE_type1 param) {
        localACTIVITY_DATETracker = param != null;

        this.localACTIVITY_DATE = param;
    }

    public boolean isCOMMITSpecified() {
        return localCOMMITTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.COMMIT_type1
     */
    public COMMIT_type1 getCOMMIT() {
        return localCOMMIT;
    }

    /**
     * Auto generated setter method
     * @param param COMMIT
     */
    public void setCOMMIT(
        COMMIT_type1 param) {
        localCOMMITTracker = param != null;

        this.localCOMMIT = param;
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
                    namespacePrefix + ":ZSCRM_MEMB_ACT_H", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSCRM_MEMB_ACT_H", xmlWriter);
            }
        }

        if (localORDER_IDTracker) {
            if (localORDER_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ORDER_ID cannot be null!!");
            }

            localORDER_ID.serialize(new javax.xml.namespace.QName("", "ORDER_ID"),
                xmlWriter);
        }

        if (localCATEGORYTracker) {
            if (localCATEGORY == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CATEGORY cannot be null!!");
            }

            localCATEGORY.serialize(new javax.xml.namespace.QName("", "CATEGORY"),
                xmlWriter);
        }

        if (localPROCESS_TYPETracker) {
            if (localPROCESS_TYPE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PROCESS_TYPE cannot be null!!");
            }

            localPROCESS_TYPE.serialize(new javax.xml.namespace.QName("",
                    "PROCESS_TYPE"), xmlWriter);
        }

        if (localMEMBERSHIP_GUIDTracker) {
            if (localMEMBERSHIP_GUID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MEMBERSHIP_GUID cannot be null!!");
            }

            localMEMBERSHIP_GUID.serialize(new javax.xml.namespace.QName("",
                    "MEMBERSHIP_GUID"), xmlWriter);
        }

        if (localSALES_ORGTracker) {
            if (localSALES_ORG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SALES_ORG cannot be null!!");
            }

            localSALES_ORG.serialize(new javax.xml.namespace.QName("",
                    "SALES_ORG"), xmlWriter);
        }

        if (localCARD_IDTracker) {
            if (localCARD_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CARD_ID cannot be null!!");
            }

            localCARD_ID.serialize(new javax.xml.namespace.QName("", "CARD_ID"),
                xmlWriter);
        }

        if (localACTIVITY_DATETracker) {
            if (localACTIVITY_DATE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ACTIVITY_DATE cannot be null!!");
            }

            localACTIVITY_DATE.serialize(new javax.xml.namespace.QName("",
                    "ACTIVITY_DATE"), xmlWriter);
        }

        if (localCOMMITTracker) {
            if (localCOMMIT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "COMMIT cannot be null!!");
            }

            localCOMMIT.serialize(new javax.xml.namespace.QName("", "COMMIT"),
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
        public static ZSCRM_MEMB_ACT_H parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            ZSCRM_MEMB_ACT_H object = new ZSCRM_MEMB_ACT_H();

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

                        if (!"ZSCRM_MEMB_ACT_H".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSCRM_MEMB_ACT_H) ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "ORDER_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ORDER_ID").equals(
                            reader.getName())) {
                    object.setORDER_ID(ORDER_ID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "CATEGORY").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "CATEGORY").equals(
                            reader.getName())) {
                    object.setCATEGORY(CATEGORY_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PROCESS_TYPE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PROCESS_TYPE").equals(
                            reader.getName())) {
                    object.setPROCESS_TYPE(com.nhry.webService.client.MemberActivitiesBat.functions.PROCESS_TYPE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MEMBERSHIP_GUID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MEMBERSHIP_GUID").equals(
                            reader.getName())) {
                    object.setMEMBERSHIP_GUID(com.nhry.webService.client.MemberActivitiesBat.functions.MEMBERSHIP_GUID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "SALES_ORG").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "SALES_ORG").equals(
                            reader.getName())) {
                    object.setSALES_ORG(SALES_ORG_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "CARD_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "CARD_ID").equals(
                            reader.getName())) {
                    object.setCARD_ID(CARD_ID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "ACTIVITY_DATE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ACTIVITY_DATE").equals(
                            reader.getName())) {
                    object.setACTIVITY_DATE(com.nhry.webService.client.MemberActivitiesBat.functions.ACTIVITY_DATE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "COMMIT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "COMMIT").equals(
                            reader.getName())) {
                    object.setCOMMIT(COMMIT_type1.Factory.parse(
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
