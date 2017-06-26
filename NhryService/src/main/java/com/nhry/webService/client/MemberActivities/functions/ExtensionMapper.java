/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */
package com.nhry.webService.client.MemberActivities.functions;


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
                "EV_OBJECT_ID_type1".equals(typeName)) {
            return EV_OBJECT_ID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "ITEM_NUM_type1".equals(typeName)) {
            return ITEM_NUM_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "ZSCRM_MEMB_ACTIVITIES".equals(typeName)) {
            return ZSCRM_MEMB_ACTIVITIES.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "CURRENCY_type1".equals(typeName)) {
            return CURRENCY_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "TRAN_SEQ_NUM_type1".equals(typeName)) {
            return TRAN_SEQ_NUM_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "FLAG_type1".equals(typeName)) {
            return FLAG_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "CARD_ID_type1".equals(typeName)) {
            return CARD_ID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "EV_GUID_type1".equals(typeName)) {
            return EV_GUID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "POINT_TYPE_type1".equals(typeName)) {
            return POINT_TYPE_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "PRODUCT_ID_type1".equals(typeName)) {
            return PRODUCT_ID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "SALES_ORG_type1".equals(typeName)) {
            return SALES_ORG_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "COMMIT_type1".equals(typeName)) {
            return COMMIT_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "TIER_type1".equals(typeName)) {
            return TIER_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "PROCESS_TYPE_type1".equals(typeName)) {
            return PROCESS_TYPE_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "EV_OBJECT_ID_type1".equals(typeName)) {
            return EV_OBJECT_ID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "PRODUCT_QUANTITY_type1".equals(typeName)) {
            return PRODUCT_QUANTITY_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "CATEGORY_type1".equals(typeName)) {
            return CATEGORY_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "ZSCRM_MESSAGE".equals(typeName)) {
            return ZSCRM_MESSAGE.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "TIER_GROUP_type1".equals(typeName)) {
            return TIER_GROUP_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "MEMBERSHIP_GUID_type1".equals(typeName)) {
            return MEMBERSHIP_GUID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "POINTS_type1".equals(typeName)) {
            return POINTS_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "ORDER_ID_type1".equals(typeName)) {
            return ORDER_ID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "PROCESS_type1".equals(typeName)) {
            return PROCESS_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "MSG_type1".equals(typeName)) {
            return MSG_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "AMOUNT_type1".equals(typeName)) {
            return AMOUNT_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "RETAIL_STORE_ID_type1".equals(typeName)) {
            return RETAIL_STORE_ID_type1.Factory.parse(reader);
        }

        if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                "ACTIVITY_DATE_type1".equals(typeName)) {
            return ACTIVITY_DATE_type1.Factory.parse(reader);
        }

        throw new org.apache.axis2.databinding.ADBException("Unsupported type " +
            namespaceURI + " " + typeName);
    }
}
