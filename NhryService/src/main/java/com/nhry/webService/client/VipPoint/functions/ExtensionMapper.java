/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.VipPoint.functions;


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
                "IV_TEL_type1".equals(typeName)) {
            return IV_TEL_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "ZSCRM_MESSAGE".equals(typeName)) {
            return ZSCRM_MESSAGE.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "PT_TYPE_type1".equals(typeName)) {
            return PT_TYPE_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "BALANCE_type1".equals(typeName)) {
            return BALANCE_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "IV_CARD_ID_type1".equals(typeName)) {
            return IV_CARD_ID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "GUID_type1".equals(typeName)) {
            return GUID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "FLAG_type1".equals(typeName)) {
            return FLAG_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "IV_GUID_type1".equals(typeName)) {
            return IV_GUID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "MEMB_ID_type1".equals(typeName)) {
            return MEMB_ID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "T_BALANCE_OUT_type0".equals(typeName)) {
            return T_BALANCE_OUT_type0.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "ZSCRM_PT_BALANCE".equals(typeName)) {
            return ZSCRM_PT_BALANCE.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "MSG_type1".equals(typeName)) {
            return MSG_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "T_BALANCE_OUT_type1".equals(typeName)) {
            return T_BALANCE_OUT_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "IV_TEL_type1".equals(typeName)) {
            return IV_TEL_type1.Factory.parse(reader);
        }

        throw new org.apache.axis2.databinding.ADBException("Unsupported type " +
            namespaceURI + " " + typeName);
    }
}
