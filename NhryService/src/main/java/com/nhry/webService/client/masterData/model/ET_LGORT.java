
package com.nhry.webService.client.masterData.model;

/**
 * Storage Locations
 * 
 * <p>Java class for T001L complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T001L">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MANDT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WERKS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LGORT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LGOBE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
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
 *         &lt;element name="XLONG" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="XBUFX" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DISKZ" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="XBLGO" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="XRESS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="XHUPF" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PARLG" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
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
 *         &lt;element name="VSTEL" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LIFNR" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="KUNNR" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MESBS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MESST" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OIH_LICNO" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OIG_ITRFL" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OIB_TNKASSIGN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
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

public class ET_LGORT {
    protected String mandt;
    protected String werks;
    protected String lgort;
    protected String lgobe;
    protected String spart;
    protected String xlong;
    protected String xbufx;
    protected String diskz;
    protected String xblgo;
    protected String xress;
    protected String xhupf;
    protected String parlg;
    protected String vkorg;
    protected String vtweg;
    protected String vstel;
    protected String lifnr;
    protected String kunnr;
    protected String mesbs;
    protected String messt;
    protected String oihlicno;
    protected String oigitrfl;
    protected String oibtnkassign;

    /**
     * Gets the value of the mandt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMANDT() {
        return mandt;
    }

    /**
     * Sets the value of the mandt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMANDT(String value) {
        this.mandt = value;
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
     * Gets the value of the lgort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLGORT() {
        return lgort;
    }

    /**
     * Sets the value of the lgort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLGORT(String value) {
        this.lgort = value;
    }

    /**
     * Gets the value of the lgobe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLGOBE() {
        return lgobe;
    }

    /**
     * Sets the value of the lgobe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLGOBE(String value) {
        this.lgobe = value;
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
     * Gets the value of the xlong property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXLONG() {
        return xlong;
    }

    /**
     * Sets the value of the xlong property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXLONG(String value) {
        this.xlong = value;
    }

    /**
     * Gets the value of the xbufx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXBUFX() {
        return xbufx;
    }

    /**
     * Sets the value of the xbufx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXBUFX(String value) {
        this.xbufx = value;
    }

    /**
     * Gets the value of the diskz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDISKZ() {
        return diskz;
    }

    /**
     * Sets the value of the diskz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDISKZ(String value) {
        this.diskz = value;
    }

    /**
     * Gets the value of the xblgo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXBLGO() {
        return xblgo;
    }

    /**
     * Sets the value of the xblgo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXBLGO(String value) {
        this.xblgo = value;
    }

    /**
     * Gets the value of the xress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXRESS() {
        return xress;
    }

    /**
     * Sets the value of the xress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXRESS(String value) {
        this.xress = value;
    }

    /**
     * Gets the value of the xhupf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXHUPF() {
        return xhupf;
    }

    /**
     * Sets the value of the xhupf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXHUPF(String value) {
        this.xhupf = value;
    }

    /**
     * Gets the value of the parlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARLG() {
        return parlg;
    }

    /**
     * Sets the value of the parlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARLG(String value) {
        this.parlg = value;
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
     * Gets the value of the vstel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVSTEL() {
        return vstel;
    }

    /**
     * Sets the value of the vstel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVSTEL(String value) {
        this.vstel = value;
    }

    /**
     * Gets the value of the lifnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLIFNR() {
        return lifnr;
    }

    /**
     * Sets the value of the lifnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLIFNR(String value) {
        this.lifnr = value;
    }

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
     * Gets the value of the mesbs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMESBS() {
        return mesbs;
    }

    /**
     * Sets the value of the mesbs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMESBS(String value) {
        this.mesbs = value;
    }

    /**
     * Gets the value of the messt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMESST() {
        return messt;
    }

    /**
     * Sets the value of the messt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMESST(String value) {
        this.messt = value;
    }

    /**
     * Gets the value of the oihlicno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOIHLICNO() {
        return oihlicno;
    }

    /**
     * Sets the value of the oihlicno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOIHLICNO(String value) {
        this.oihlicno = value;
    }

    /**
     * Gets the value of the oigitrfl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOIGITRFL() {
        return oigitrfl;
    }

    /**
     * Sets the value of the oigitrfl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOIGITRFL(String value) {
        this.oigitrfl = value;
    }

    /**
     * Gets the value of the oibtnkassign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOIBTNKASSIGN() {
        return oibtnkassign;
    }

    /**
     * Sets the value of the oibtnkassign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOIBTNKASSIGN(String value) {
        this.oibtnkassign = value;
    }

}
