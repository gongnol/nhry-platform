
package com.nhry.webService.client.masterData.model;

/**
 * <p>Java class for ZSSD00002 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZSSD00002">
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
 *         &lt;element name="NAME1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NAME2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ORT01" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="STRAS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TELF1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BUKRS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="REGIO" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NAME3" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NAMEV" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
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
//@XmlType(name = "ZSSD00002", propOrder = {
//    "kunnr",
//    "name1",
//    "name2",
//    "ort01",
//    "stras",
//    "telf1",
//    "bukrs",
//    "regio",
//    "name3",
//    "namev"
//})
public class ET_KUNNR {
    protected String kunnr;
    protected String name1;
    protected String name2;
    protected String ort01;
    protected String stras;
    protected String telf1;
    protected String bukrs;
    protected String regio;
    protected String name3;
    protected String namev;
    protected String sort2;
    

    public String getSort2() {
		return sort2;
	}

	public void setSort2(String sort2) {
		this.sort2 = sort2;
	}

	/**
     * Gets the value of the kunnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *
     * @param s
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
     * Gets the value of the name1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *
     * @param s
     */
    public String getNAME1() {
        return name1;
    }

    /**
     * Sets the value of the name1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME1(String value) {
        this.name1 = value;
    }

    /**
     * Gets the value of the name2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *
     * @param s
     */
    public String getNAME2() {
        return name2;
    }

    /**
     * Sets the value of the name2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME2(String value) {
        this.name2 = value;
    }

    /**
     * Gets the value of the ort01 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORT01() {
        return ort01;
    }

    /**
     * Sets the value of the ort01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORT01(String value) {
        this.ort01 = value;
    }

    /**
     * Gets the value of the stras property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTRAS() {
        return stras;
    }

    /**
     * Sets the value of the stras property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTRAS(String value) {
        this.stras = value;
    }

    /**
     * Gets the value of the telf1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTELF1() {
        return telf1;
    }

    /**
     * Sets the value of the telf1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTELF1(String value) {
        this.telf1 = value;
    }

    /**
     * Gets the value of the bukrs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUKRS() {
        return bukrs;
    }

    /**
     * Sets the value of the bukrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUKRS(String value) {
        this.bukrs = value;
    }

    /**
     * Gets the value of the regio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREGIO() {
        return regio;
    }

    /**
     * Sets the value of the regio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREGIO(String value) {
        this.regio = value;
    }

    /**
     * Gets the value of the name3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *
     * @param s
     */
    public String getNAME3(String s) {
        return name3;
    }

    /**
     * Sets the value of the name3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME3(String value) {
        this.name3 = value;
    }

    /**
     * Gets the value of the namev property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAMEV() {
        return namev;
    }

    /**
     * Sets the value of the namev property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAMEV(String value) {
        this.namev = value;
    }

}
