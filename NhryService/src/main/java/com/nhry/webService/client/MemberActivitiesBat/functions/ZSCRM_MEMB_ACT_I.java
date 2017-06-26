/**
 * ZSCRM_MEMB_ACT_I.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.MemberActivitiesBat.functions;


/**
 *  ZSCRM_MEMB_ACT_I bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSCRM_MEMB_ACT_I implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSCRM_MEMB_ACT_I
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for ORDER_ID
     */
    protected ORDER_ID_type3 localORDER_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localORDER_IDTracker = false;

    /**
     * field for ITEM_NUM
     */
    protected ITEM_NUM_type1 localITEM_NUM;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localITEM_NUMTracker = false;

    /**
     * field for HEAD_GUID
     */
    protected HEAD_GUID_type1 localHEAD_GUID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localHEAD_GUIDTracker = false;

    /**
     * field for AMOUNT
     */
    protected AMOUNT_type1 localAMOUNT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localAMOUNTTracker = false;

    /**
     * field for POINT_TYPE
     */
    protected POINT_TYPE_type1 localPOINT_TYPE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPOINT_TYPETracker = false;

    /**
     * field for POINTS
     */
    protected POINTS_type1 localPOINTS;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPOINTSTracker = false;

    /**
     * field for CURRENCY
     */
    protected CURRENCY_type1 localCURRENCY;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCURRENCYTracker = false;

    /**
     * field for PRODUCT_ID
     */
    protected PRODUCT_ID_type1 localPRODUCT_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPRODUCT_IDTracker = false;

    /**
     * field for PRODUCT_QUANTITY
     */
    protected com.nhry.webService.client.MemberActivitiesBat.functions.PRODUCT_QUANTITY_type1 localPRODUCT_QUANTITY;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPRODUCT_QUANTITYTracker = false;

    /**
     * field for UNIT
     */
    protected UNIT_type1 localUNIT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localUNITTracker = false;

    /**
     * field for RETAIL_STORE_ID
     */
    protected com.nhry.webService.client.MemberActivitiesBat.functions.RETAIL_STORE_ID_type1 localRETAIL_STORE_ID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localRETAIL_STORE_IDTracker = false;

    /**
     * field for TRAN_SEQ_NUM
     */
    protected com.nhry.webService.client.MemberActivitiesBat.functions.TRAN_SEQ_NUM_type1 localTRAN_SEQ_NUM;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTRAN_SEQ_NUMTracker = false;

    /**
     * field for TIER_GROUP
     */
    protected TIER_GROUP_type1 localTIER_GROUP;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTIER_GROUPTracker = false;

    /**
     * field for TIER
     */
    protected TIER_type1 localTIER;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTIERTracker = false;

    public boolean isORDER_IDSpecified() {
        return localORDER_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.ORDER_ID_type3
     */
    public ORDER_ID_type3 getORDER_ID() {
        return localORDER_ID;
    }

    /**
     * Auto generated setter method
     * @param param ORDER_ID
     */
    public void setORDER_ID(
        ORDER_ID_type3 param) {
        localORDER_IDTracker = param != null;

        this.localORDER_ID = param;
    }

    public boolean isITEM_NUMSpecified() {
        return localITEM_NUMTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.ITEM_NUM_type1
     */
    public ITEM_NUM_type1 getITEM_NUM() {
        return localITEM_NUM;
    }

    /**
     * Auto generated setter method
     * @param param ITEM_NUM
     */
    public void setITEM_NUM(
        ITEM_NUM_type1 param) {
        localITEM_NUMTracker = param != null;

        this.localITEM_NUM = param;
    }

    public boolean isHEAD_GUIDSpecified() {
        return localHEAD_GUIDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.HEAD_GUID_type1
     */
    public HEAD_GUID_type1 getHEAD_GUID() {
        return localHEAD_GUID;
    }

    /**
     * Auto generated setter method
     * @param param HEAD_GUID
     */
    public void setHEAD_GUID(
        HEAD_GUID_type1 param) {
        localHEAD_GUIDTracker = param != null;

        this.localHEAD_GUID = param;
    }

    public boolean isAMOUNTSpecified() {
        return localAMOUNTTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.AMOUNT_type1
     */
    public AMOUNT_type1 getAMOUNT() {
        return localAMOUNT;
    }

    /**
     * Auto generated setter method
     * @param param AMOUNT
     */
    public void setAMOUNT(
        AMOUNT_type1 param) {
        localAMOUNTTracker = param != null;

        this.localAMOUNT = param;
    }

    public boolean isPOINT_TYPESpecified() {
        return localPOINT_TYPETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.POINT_TYPE_type1
     */
    public POINT_TYPE_type1 getPOINT_TYPE() {
        return localPOINT_TYPE;
    }

    /**
     * Auto generated setter method
     * @param param POINT_TYPE
     */
    public void setPOINT_TYPE(
        POINT_TYPE_type1 param) {
        localPOINT_TYPETracker = param != null;

        this.localPOINT_TYPE = param;
    }

    public boolean isPOINTSSpecified() {
        return localPOINTSTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.POINTS_type1
     */
    public POINTS_type1 getPOINTS() {
        return localPOINTS;
    }

    /**
     * Auto generated setter method
     * @param param POINTS
     */
    public void setPOINTS(
        POINTS_type1 param) {
        localPOINTSTracker = param != null;

        this.localPOINTS = param;
    }

    public boolean isCURRENCYSpecified() {
        return localCURRENCYTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.CURRENCY_type1
     */
    public CURRENCY_type1 getCURRENCY() {
        return localCURRENCY;
    }

    /**
     * Auto generated setter method
     * @param param CURRENCY
     */
    public void setCURRENCY(
        CURRENCY_type1 param) {
        localCURRENCYTracker = param != null;

        this.localCURRENCY = param;
    }

    public boolean isPRODUCT_IDSpecified() {
        return localPRODUCT_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.PRODUCT_ID_type1
     */
    public PRODUCT_ID_type1 getPRODUCT_ID() {
        return localPRODUCT_ID;
    }

    /**
     * Auto generated setter method
     * @param param PRODUCT_ID
     */
    public void setPRODUCT_ID(
        PRODUCT_ID_type1 param) {
        localPRODUCT_IDTracker = param != null;

        this.localPRODUCT_ID = param;
    }

    public boolean isPRODUCT_QUANTITYSpecified() {
        return localPRODUCT_QUANTITYTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.PRODUCT_QUANTITY_type1
     */
    public com.nhry.webService.client.MemberActivitiesBat.functions.PRODUCT_QUANTITY_type1 getPRODUCT_QUANTITY() {
        return localPRODUCT_QUANTITY;
    }

    /**
     * Auto generated setter method
     * @param param PRODUCT_QUANTITY
     */
    public void setPRODUCT_QUANTITY(
        com.nhry.webService.client.MemberActivitiesBat.functions.PRODUCT_QUANTITY_type1 param) {
        localPRODUCT_QUANTITYTracker = param != null;

        this.localPRODUCT_QUANTITY = param;
    }

    public boolean isUNITSpecified() {
        return localUNITTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.UNIT_type1
     */
    public UNIT_type1 getUNIT() {
        return localUNIT;
    }

    /**
     * Auto generated setter method
     * @param param UNIT
     */
    public void setUNIT(
        UNIT_type1 param) {
        localUNITTracker = param != null;

        this.localUNIT = param;
    }

    public boolean isRETAIL_STORE_IDSpecified() {
        return localRETAIL_STORE_IDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.RETAIL_STORE_ID_type1
     */
    public com.nhry.webService.client.MemberActivitiesBat.functions.RETAIL_STORE_ID_type1 getRETAIL_STORE_ID() {
        return localRETAIL_STORE_ID;
    }

    /**
     * Auto generated setter method
     * @param param RETAIL_STORE_ID
     */
    public void setRETAIL_STORE_ID(
        com.nhry.webService.client.MemberActivitiesBat.functions.RETAIL_STORE_ID_type1 param) {
        localRETAIL_STORE_IDTracker = param != null;

        this.localRETAIL_STORE_ID = param;
    }

    public boolean isTRAN_SEQ_NUMSpecified() {
        return localTRAN_SEQ_NUMTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.TRAN_SEQ_NUM_type1
     */
    public com.nhry.webService.client.MemberActivitiesBat.functions.TRAN_SEQ_NUM_type1 getTRAN_SEQ_NUM() {
        return localTRAN_SEQ_NUM;
    }

    /**
     * Auto generated setter method
     * @param param TRAN_SEQ_NUM
     */
    public void setTRAN_SEQ_NUM(
        com.nhry.webService.client.MemberActivitiesBat.functions.TRAN_SEQ_NUM_type1 param) {
        localTRAN_SEQ_NUMTracker = param != null;

        this.localTRAN_SEQ_NUM = param;
    }

    public boolean isTIER_GROUPSpecified() {
        return localTIER_GROUPTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.TIER_GROUP_type1
     */
    public TIER_GROUP_type1 getTIER_GROUP() {
        return localTIER_GROUP;
    }

    /**
     * Auto generated setter method
     * @param param TIER_GROUP
     */
    public void setTIER_GROUP(
        TIER_GROUP_type1 param) {
        localTIER_GROUPTracker = param != null;

        this.localTIER_GROUP = param;
    }

    public boolean isTIERSpecified() {
        return localTIERTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.MemberActivitiesBat.functions.TIER_type1
     */
    public TIER_type1 getTIER() {
        return localTIER;
    }

    /**
     * Auto generated setter method
     * @param param TIER
     */
    public void setTIER(
        TIER_type1 param) {
        localTIERTracker = param != null;

        this.localTIER = param;
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
                    namespacePrefix + ":ZSCRM_MEMB_ACT_I", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSCRM_MEMB_ACT_I", xmlWriter);
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

        if (localITEM_NUMTracker) {
            if (localITEM_NUM == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ITEM_NUM cannot be null!!");
            }

            localITEM_NUM.serialize(new javax.xml.namespace.QName("", "ITEM_NUM"),
                xmlWriter);
        }

        if (localHEAD_GUIDTracker) {
            if (localHEAD_GUID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "HEAD_GUID cannot be null!!");
            }

            localHEAD_GUID.serialize(new javax.xml.namespace.QName("",
                    "HEAD_GUID"), xmlWriter);
        }

        if (localAMOUNTTracker) {
            if (localAMOUNT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "AMOUNT cannot be null!!");
            }

            localAMOUNT.serialize(new javax.xml.namespace.QName("", "AMOUNT"),
                xmlWriter);
        }

        if (localPOINT_TYPETracker) {
            if (localPOINT_TYPE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "POINT_TYPE cannot be null!!");
            }

            localPOINT_TYPE.serialize(new javax.xml.namespace.QName("",
                    "POINT_TYPE"), xmlWriter);
        }

        if (localPOINTSTracker) {
            if (localPOINTS == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "POINTS cannot be null!!");
            }

            localPOINTS.serialize(new javax.xml.namespace.QName("", "POINTS"),
                xmlWriter);
        }

        if (localCURRENCYTracker) {
            if (localCURRENCY == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CURRENCY cannot be null!!");
            }

            localCURRENCY.serialize(new javax.xml.namespace.QName("", "CURRENCY"),
                xmlWriter);
        }

        if (localPRODUCT_IDTracker) {
            if (localPRODUCT_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PRODUCT_ID cannot be null!!");
            }

            localPRODUCT_ID.serialize(new javax.xml.namespace.QName("",
                    "PRODUCT_ID"), xmlWriter);
        }

        if (localPRODUCT_QUANTITYTracker) {
            if (localPRODUCT_QUANTITY == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "PRODUCT_QUANTITY cannot be null!!");
            }

            localPRODUCT_QUANTITY.serialize(new javax.xml.namespace.QName("",
                    "PRODUCT_QUANTITY"), xmlWriter);
        }

        if (localUNITTracker) {
            if (localUNIT == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "UNIT cannot be null!!");
            }

            localUNIT.serialize(new javax.xml.namespace.QName("", "UNIT"),
                xmlWriter);
        }

        if (localRETAIL_STORE_IDTracker) {
            if (localRETAIL_STORE_ID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "RETAIL_STORE_ID cannot be null!!");
            }

            localRETAIL_STORE_ID.serialize(new javax.xml.namespace.QName("",
                    "RETAIL_STORE_ID"), xmlWriter);
        }

        if (localTRAN_SEQ_NUMTracker) {
            if (localTRAN_SEQ_NUM == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TRAN_SEQ_NUM cannot be null!!");
            }

            localTRAN_SEQ_NUM.serialize(new javax.xml.namespace.QName("",
                    "TRAN_SEQ_NUM"), xmlWriter);
        }

        if (localTIER_GROUPTracker) {
            if (localTIER_GROUP == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TIER_GROUP cannot be null!!");
            }

            localTIER_GROUP.serialize(new javax.xml.namespace.QName("",
                    "TIER_GROUP"), xmlWriter);
        }

        if (localTIERTracker) {
            if (localTIER == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TIER cannot be null!!");
            }

            localTIER.serialize(new javax.xml.namespace.QName("", "TIER"),
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
        public static ZSCRM_MEMB_ACT_I parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            ZSCRM_MEMB_ACT_I object = new ZSCRM_MEMB_ACT_I();

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

                        if (!"ZSCRM_MEMB_ACT_I".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSCRM_MEMB_ACT_I) ExtensionMapper.getTypeObject(nsUri,
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
                    object.setORDER_ID(ORDER_ID_type3.Factory.parse(
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
                    object.setITEM_NUM(ITEM_NUM_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "HEAD_GUID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "HEAD_GUID").equals(
                            reader.getName())) {
                    object.setHEAD_GUID(HEAD_GUID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "AMOUNT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "AMOUNT").equals(
                            reader.getName())) {
                    object.setAMOUNT(AMOUNT_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "POINT_TYPE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "POINT_TYPE").equals(
                            reader.getName())) {
                    object.setPOINT_TYPE(POINT_TYPE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "POINTS").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "POINTS").equals(
                            reader.getName())) {
                    object.setPOINTS(POINTS_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "CURRENCY").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "CURRENCY").equals(
                            reader.getName())) {
                    object.setCURRENCY(CURRENCY_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PRODUCT_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PRODUCT_ID").equals(
                            reader.getName())) {
                    object.setPRODUCT_ID(PRODUCT_ID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "PRODUCT_QUANTITY").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "PRODUCT_QUANTITY").equals(
                            reader.getName())) {
                    object.setPRODUCT_QUANTITY(com.nhry.webService.client.MemberActivitiesBat.functions.PRODUCT_QUANTITY_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "UNIT").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "UNIT").equals(
                            reader.getName())) {
                    object.setUNIT(UNIT_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "RETAIL_STORE_ID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "RETAIL_STORE_ID").equals(
                            reader.getName())) {
                    object.setRETAIL_STORE_ID(com.nhry.webService.client.MemberActivitiesBat.functions.RETAIL_STORE_ID_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TRAN_SEQ_NUM").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TRAN_SEQ_NUM").equals(
                            reader.getName())) {
                    object.setTRAN_SEQ_NUM(com.nhry.webService.client.MemberActivitiesBat.functions.TRAN_SEQ_NUM_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TIER_GROUP").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TIER_GROUP").equals(
                            reader.getName())) {
                    object.setTIER_GROUP(TIER_GROUP_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TIER").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TIER").equals(
                            reader.getName())) {
                    object.setTIER(TIER_type1.Factory.parse(
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
