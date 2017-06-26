
package com.nhry.webService.client.masterData.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZSSD00030 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZSSD00030">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KUNNR" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="VKORG" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="VTWEG" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SPART" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="KUNWE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "ZSSD00030", propOrder = {
//    "kunnr",
//    "vkorg",
//    "vtweg",
//    "spart",
//    "kunwe"
//})
public class ET_PARTNER {
    protected String kunnr;
    protected String vkorg;
    protected String vtweg;
    protected String spart;
    protected String kunwe;

    /**
     * Gets the value of the kunnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKUNNR() {
        return kunnr;
    }

    /**
     * Sets the value of the kunnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKUNNR(String value) {
        this.kunnr = value;
    }

    /**
     * Gets the value of the vkorg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVKORG() {
        return vkorg;
    }

    /**
     * Sets the value of the vkorg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVKORG(String value) {
        this.vkorg = value;
    }

    /**
     * Gets the value of the vtweg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTWEG() {
        return vtweg;
    }

    /**
     * Sets the value of the vtweg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTWEG(String value) {
        this.vtweg = value;
    }

    /**
     * Gets the value of the spart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPART() {
        return spart;
    }

    /**
     * Sets the value of the spart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPART(String value) {
        this.spart = value;
    }

    /**
     * Gets the value of the kunwe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKUNWE() {
        return kunwe;
    }

    /**
     * Sets the value of the kunwe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKUNWE(String value) {
        this.kunwe = value;
    }

}
