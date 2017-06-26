/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.Address.functions;


/**
 *  ExtensionMapper class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ExtensionMapper {
    public static Object getTypeObject(
        String namespaceURI, String typeName,
        javax.xml.stream.XMLStreamReader reader) throws Exception {
        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "IV_MEMB_GUID_type1".equals(typeName)) {
            return IV_MEMB_GUID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "REGION_type1".equals(typeName)) {
            return REGION_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "TEL_NUMBER_type1".equals(typeName)) {
            return TEL_NUMBER_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "CITY1_type1".equals(typeName)) {
            return CITY1_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "NAME_CO_type1".equals(typeName)) {
            return NAME_CO_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "COUNTRY_type1".equals(typeName)) {
            return COUNTRY_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "FLAG_type1".equals(typeName)) {
            return FLAG_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "ZSCRM_ADDR_SHIP_TO".equals(typeName)) {
            return ZSCRM_ADDR_SHIP_TO.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "CITY2_type1".equals(typeName)) {
            return CITY2_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "ADDRESS_GUID_type1".equals(typeName)) {
            return ADDRESS_GUID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "ADDRESS_GUID_type3".equals(typeName)) {
            return ADDRESS_GUID_type3.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "STR_SUPPL1_type1".equals(typeName)) {
            return STR_SUPPL1_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "IV_MEMB_GUID_type1".equals(typeName)) {
            return IV_MEMB_GUID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "MSG_type1".equals(typeName)) {
            return MSG_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "MODE_type1".equals(typeName)) {
            return MODE_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "T_ADDR_type0".equals(typeName)) {
            return T_ADDR_type0.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "T_ADDR_type1".equals(typeName)) {
            return T_ADDR_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "POST_CODE1_type1".equals(typeName)) {
            return POST_CODE1_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "ZSCRM_ADDR_UPDATE_RETURN".equals(typeName)) {
            return ZSCRM_ADDR_UPDATE_RETURN.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "STREET_type1".equals(typeName)) {
            return STREET_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "STR_SUPPL2_type1".equals(typeName)) {
            return STR_SUPPL2_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "TEL_MOBILE_type1".equals(typeName)) {
            return TEL_MOBILE_type1.Factory.parse(reader);
        }

        throw new org.apache.axis2.databinding.ADBException("Unsupported type " +
            namespaceURI + " " + typeName);
    }
}
