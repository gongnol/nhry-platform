
package com.nhry.webService.client.masterData.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "ET_MATNR", propOrder = {
//    "matnr",
//    "mtart",
//    "meins",
//    "spart",
//    "mtposmara",
//    "vkorg",
//    "vtweg",
//    "werks",
//    "bomx",
//    "ntgew",
//    "gewei"
//})
public class ET_MATNR {

    protected String matnr;
    protected String mtart;
    protected String meins;
    protected String spart;
    protected String mtposmara;
    protected String vkorg;
    protected String vtweg;
    protected String werks;
    protected String bomx;
    protected BigDecimal ntgew;
    protected String gewei;

    /**
     * Gets the value of the matnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMATNR() {
        return matnr;
    }

    /**
     * Sets the value of the matnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMATNR(String value) {
        this.matnr = value;
    }

    /**
     * Gets the value of the mtart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMTART() {
        return mtart;
    }

    /**
     * Sets the value of the mtart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMTART(String value) {
        this.mtart = value;
    }

    /**
     * Gets the value of the meins property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String  getMEINS() {
        return meins;
    }

    /**
     * Sets the value of the meins property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMEINS(String value) {
        this.meins = value;
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
     * Gets the value of the mtposmara property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMTPOSMARA() {
        return mtposmara;
    }

    /**
     * Sets the value of the mtposmara property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMTPOSMARA(String value) {
        this.mtposmara = value;
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
     * Gets the value of the werks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWERKS() {
        return werks;
    }

    /**
     * Sets the value of the werks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWERKS(String value) {
        this.werks = value;
    }

    /**
     * Gets the value of the bomx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBOMX() {
        return bomx;
    }

    /**
     * Sets the value of the bomx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBOMX(String value) {
        this.bomx = value;
    }

    /**
     * Gets the value of the ntgew property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNTGEW() {
        return ntgew;
    }

    /**
     * Sets the value of the ntgew property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNTGEW(BigDecimal value) {
        this.ntgew = value;
    }

    /**
     * Gets the value of the gewei property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGEWEI() {
        return gewei;
    }

    /**
     * Sets the value of the gewei property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGEWEI(String value) {
        this.gewei = value;
    }

}
