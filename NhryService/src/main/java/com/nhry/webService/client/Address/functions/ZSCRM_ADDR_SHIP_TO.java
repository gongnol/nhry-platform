/**
 * ZSCRM_ADDR_SHIP_TO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.Address.functions;


/**
 *  ZSCRM_ADDR_SHIP_TO bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ZSCRM_ADDR_SHIP_TO implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = ZSCRM_ADDR_SHIP_TO
       Namespace URI = urn:sap-com:document:sap:rfc:functions
       Namespace Prefix = ns1
     */

    /**
     * field for ADDRESS_GUID
     */
    protected ADDRESS_GUID_type3 localADDRESS_GUID;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localADDRESS_GUIDTracker = false;

    /**
     * field for COUNTRY
     */
    protected COUNTRY_type1 localCOUNTRY;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCOUNTRYTracker = false;

    /**
     * field for REGION
     */
    protected REGION_type1 localREGION;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localREGIONTracker = false;

    /**
     * field for CITY1
     */
    protected CITY1_type1 localCITY1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCITY1Tracker = false;

    /**
     * field for CITY2
     */
    protected CITY2_type1 localCITY2;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCITY2Tracker = false;

    /**
     * field for STREET
     */
    protected STREET_type1 localSTREET;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSTREETTracker = false;

    /**
     * field for STR_SUPPL1
     */
    protected STR_SUPPL1_type1 localSTR_SUPPL1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSTR_SUPPL1Tracker = false;

    /**
     * field for STR_SUPPL2
     */
    protected STR_SUPPL2_type1 localSTR_SUPPL2;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSTR_SUPPL2Tracker = false;

    /**
     * field for POST_CODE1
     */
    protected POST_CODE1_type1 localPOST_CODE1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPOST_CODE1Tracker = false;

    /**
     * field for NAME_CO
     */
    protected NAME_CO_type1 localNAME_CO;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localNAME_COTracker = false;

    /**
     * field for TEL_MOBILE
     */
    protected TEL_MOBILE_type1 localTEL_MOBILE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTEL_MOBILETracker = false;

    /**
     * field for TEL_NUMBER
     */
    protected TEL_NUMBER_type1 localTEL_NUMBER;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTEL_NUMBERTracker = false;

    /**
     * field for MODE
     */
    protected MODE_type1 localMODE;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMODETracker = false;

    public boolean isADDRESS_GUIDSpecified() {
        return localADDRESS_GUIDTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.ADDRESS_GUID_type3
     */
    public ADDRESS_GUID_type3 getADDRESS_GUID() {
        return localADDRESS_GUID;
    }

    /**
     * Auto generated setter method
     * @param param ADDRESS_GUID
     */
    public void setADDRESS_GUID(
        ADDRESS_GUID_type3 param) {
        localADDRESS_GUIDTracker = param != null;

        this.localADDRESS_GUID = param;
    }

    public boolean isCOUNTRYSpecified() {
        return localCOUNTRYTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.COUNTRY_type1
     */
    public COUNTRY_type1 getCOUNTRY() {
        return localCOUNTRY;
    }

    /**
     * Auto generated setter method
     * @param param COUNTRY
     */
    public void setCOUNTRY(
        COUNTRY_type1 param) {
        localCOUNTRYTracker = param != null;

        this.localCOUNTRY = param;
    }

    public boolean isREGIONSpecified() {
        return localREGIONTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.REGION_type1
     */
    public REGION_type1 getREGION() {
        return localREGION;
    }

    /**
     * Auto generated setter method
     * @param param REGION
     */
    public void setREGION(
        REGION_type1 param) {
        localREGIONTracker = param != null;

        this.localREGION = param;
    }

    public boolean isCITY1Specified() {
        return localCITY1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.CITY1_type1
     */
    public CITY1_type1 getCITY1() {
        return localCITY1;
    }

    /**
     * Auto generated setter method
     * @param param CITY1
     */
    public void setCITY1(
        CITY1_type1 param) {
        localCITY1Tracker = param != null;

        this.localCITY1 = param;
    }

    public boolean isCITY2Specified() {
        return localCITY2Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.CITY2_type1
     */
    public CITY2_type1 getCITY2() {
        return localCITY2;
    }

    /**
     * Auto generated setter method
     * @param param CITY2
     */
    public void setCITY2(
        CITY2_type1 param) {
        localCITY2Tracker = param != null;

        this.localCITY2 = param;
    }

    public boolean isSTREETSpecified() {
        return localSTREETTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.STREET_type1
     */
    public STREET_type1 getSTREET() {
        return localSTREET;
    }

    /**
     * Auto generated setter method
     * @param param STREET
     */
    public void setSTREET(
        STREET_type1 param) {
        localSTREETTracker = param != null;

        this.localSTREET = param;
    }

    public boolean isSTR_SUPPL1Specified() {
        return localSTR_SUPPL1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.STR_SUPPL1_type1
     */
    public STR_SUPPL1_type1 getSTR_SUPPL1() {
        return localSTR_SUPPL1;
    }

    /**
     * Auto generated setter method
     * @param param STR_SUPPL1
     */
    public void setSTR_SUPPL1(
        STR_SUPPL1_type1 param) {
        localSTR_SUPPL1Tracker = param != null;

        this.localSTR_SUPPL1 = param;
    }

    public boolean isSTR_SUPPL2Specified() {
        return localSTR_SUPPL2Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.STR_SUPPL2_type1
     */
    public STR_SUPPL2_type1 getSTR_SUPPL2() {
        return localSTR_SUPPL2;
    }

    /**
     * Auto generated setter method
     * @param param STR_SUPPL2
     */
    public void setSTR_SUPPL2(
        STR_SUPPL2_type1 param) {
        localSTR_SUPPL2Tracker = param != null;

        this.localSTR_SUPPL2 = param;
    }

    public boolean isPOST_CODE1Specified() {
        return localPOST_CODE1Tracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.POST_CODE1_type1
     */
    public POST_CODE1_type1 getPOST_CODE1() {
        return localPOST_CODE1;
    }

    /**
     * Auto generated setter method
     * @param param POST_CODE1
     */
    public void setPOST_CODE1(
        POST_CODE1_type1 param) {
        localPOST_CODE1Tracker = param != null;

        this.localPOST_CODE1 = param;
    }

    public boolean isNAME_COSpecified() {
        return localNAME_COTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.NAME_CO_type1
     */
    public NAME_CO_type1 getNAME_CO() {
        return localNAME_CO;
    }

    /**
     * Auto generated setter method
     * @param param NAME_CO
     */
    public void setNAME_CO(
        NAME_CO_type1 param) {
        localNAME_COTracker = param != null;

        this.localNAME_CO = param;
    }

    public boolean isTEL_MOBILESpecified() {
        return localTEL_MOBILETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.TEL_MOBILE_type1
     */
    public TEL_MOBILE_type1 getTEL_MOBILE() {
        return localTEL_MOBILE;
    }

    /**
     * Auto generated setter method
     * @param param TEL_MOBILE
     */
    public void setTEL_MOBILE(
        TEL_MOBILE_type1 param) {
        localTEL_MOBILETracker = param != null;

        this.localTEL_MOBILE = param;
    }

    public boolean isTEL_NUMBERSpecified() {
        return localTEL_NUMBERTracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.TEL_NUMBER_type1
     */
    public TEL_NUMBER_type1 getTEL_NUMBER() {
        return localTEL_NUMBER;
    }

    /**
     * Auto generated setter method
     * @param param TEL_NUMBER
     */
    public void setTEL_NUMBER(
        TEL_NUMBER_type1 param) {
        localTEL_NUMBERTracker = param != null;

        this.localTEL_NUMBER = param;
    }

    public boolean isMODESpecified() {
        return localMODETracker;
    }

    /**
     * Auto generated getter method
     * @return com.nhry.webService.client.Address.functions.MODE_type1
     */
    public MODE_type1 getMODE() {
        return localMODE;
    }

    /**
     * Auto generated setter method
     * @param param MODE
     */
    public void setMODE(
        MODE_type1 param) {
        localMODETracker = param != null;

        this.localMODE = param;
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
                    namespacePrefix + ":ZSCRM_ADDR_SHIP_TO", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "ZSCRM_ADDR_SHIP_TO", xmlWriter);
            }
        }

        if (localADDRESS_GUIDTracker) {
            if (localADDRESS_GUID == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ADDRESS_GUID cannot be null!!");
            }

            localADDRESS_GUID.serialize(new javax.xml.namespace.QName("",
                    "ADDRESS_GUID"), xmlWriter);
        }

        if (localCOUNTRYTracker) {
            if (localCOUNTRY == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "COUNTRY cannot be null!!");
            }

            localCOUNTRY.serialize(new javax.xml.namespace.QName("", "COUNTRY"),
                xmlWriter);
        }

        if (localREGIONTracker) {
            if (localREGION == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "REGION cannot be null!!");
            }

            localREGION.serialize(new javax.xml.namespace.QName("", "REGION"),
                xmlWriter);
        }

        if (localCITY1Tracker) {
            if (localCITY1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CITY1 cannot be null!!");
            }

            localCITY1.serialize(new javax.xml.namespace.QName("", "CITY1"),
                xmlWriter);
        }

        if (localCITY2Tracker) {
            if (localCITY2 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CITY2 cannot be null!!");
            }

            localCITY2.serialize(new javax.xml.namespace.QName("", "CITY2"),
                xmlWriter);
        }

        if (localSTREETTracker) {
            if (localSTREET == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "STREET cannot be null!!");
            }

            localSTREET.serialize(new javax.xml.namespace.QName("", "STREET"),
                xmlWriter);
        }

        if (localSTR_SUPPL1Tracker) {
            if (localSTR_SUPPL1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "STR_SUPPL1 cannot be null!!");
            }

            localSTR_SUPPL1.serialize(new javax.xml.namespace.QName("",
                    "STR_SUPPL1"), xmlWriter);
        }

        if (localSTR_SUPPL2Tracker) {
            if (localSTR_SUPPL2 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "STR_SUPPL2 cannot be null!!");
            }

            localSTR_SUPPL2.serialize(new javax.xml.namespace.QName("",
                    "STR_SUPPL2"), xmlWriter);
        }

        if (localPOST_CODE1Tracker) {
            if (localPOST_CODE1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "POST_CODE1 cannot be null!!");
            }

            localPOST_CODE1.serialize(new javax.xml.namespace.QName("",
                    "POST_CODE1"), xmlWriter);
        }

        if (localNAME_COTracker) {
            if (localNAME_CO == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NAME_CO cannot be null!!");
            }

            localNAME_CO.serialize(new javax.xml.namespace.QName("", "NAME_CO"),
                xmlWriter);
        }

        if (localTEL_MOBILETracker) {
            if (localTEL_MOBILE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TEL_MOBILE cannot be null!!");
            }

            localTEL_MOBILE.serialize(new javax.xml.namespace.QName("",
                    "TEL_MOBILE"), xmlWriter);
        }

        if (localTEL_NUMBERTracker) {
            if (localTEL_NUMBER == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "TEL_NUMBER cannot be null!!");
            }

            localTEL_NUMBER.serialize(new javax.xml.namespace.QName("",
                    "TEL_NUMBER"), xmlWriter);
        }

        if (localMODETracker) {
            if (localMODE == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MODE cannot be null!!");
            }

            localMODE.serialize(new javax.xml.namespace.QName("", "MODE"),
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
        public static ZSCRM_ADDR_SHIP_TO parse(
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            ZSCRM_ADDR_SHIP_TO object = new ZSCRM_ADDR_SHIP_TO();

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

                        if (!"ZSCRM_ADDR_SHIP_TO".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (ZSCRM_ADDR_SHIP_TO) ExtensionMapper.getTypeObject(nsUri,
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
                        new javax.xml.namespace.QName("", "ADDRESS_GUID").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "ADDRESS_GUID").equals(
                            reader.getName())) {
                    object.setADDRESS_GUID(ADDRESS_GUID_type3.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "COUNTRY").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "COUNTRY").equals(
                            reader.getName())) {
                    object.setCOUNTRY(COUNTRY_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "REGION").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "REGION").equals(
                            reader.getName())) {
                    object.setREGION(REGION_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "CITY1").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "CITY1").equals(
                            reader.getName())) {
                    object.setCITY1(CITY1_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "CITY2").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "CITY2").equals(
                            reader.getName())) {
                    object.setCITY2(CITY2_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "STREET").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "STREET").equals(
                            reader.getName())) {
                    object.setSTREET(STREET_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "STR_SUPPL1").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "STR_SUPPL1").equals(
                            reader.getName())) {
                    object.setSTR_SUPPL1(STR_SUPPL1_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "STR_SUPPL2").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "STR_SUPPL2").equals(
                            reader.getName())) {
                    object.setSTR_SUPPL2(STR_SUPPL2_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "POST_CODE1").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "POST_CODE1").equals(
                            reader.getName())) {
                    object.setPOST_CODE1(POST_CODE1_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "NAME_CO").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "NAME_CO").equals(
                            reader.getName())) {
                    object.setNAME_CO(NAME_CO_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TEL_MOBILE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TEL_MOBILE").equals(
                            reader.getName())) {
                    object.setTEL_MOBILE(TEL_MOBILE_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "TEL_NUMBER").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "TEL_NUMBER").equals(
                            reader.getName())) {
                    object.setTEL_NUMBER(TEL_NUMBER_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if ((reader.isStartElement() &&
                        new javax.xml.namespace.QName("", "MODE").equals(
                            reader.getName())) ||
                        new javax.xml.namespace.QName("", "MODE").equals(
                            reader.getName())) {
                    object.setMODE(MODE_type1.Factory.parse(
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
