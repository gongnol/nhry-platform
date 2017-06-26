/**
 * @project:NhryService
 * @package:com.nhry.pojo.query
 * @copyright: Copyright[2016-2999] [Markor Investment Group Co. LTD]. All Rights Reserved.
 * @filename: ProductInfoExModel.java
 * @description:<描述>
 * @author: Himari
 * @date: 3 Jun 2016-3:50:25 pm
 * @version: 1.0
 * @since: JDK 1.8
 */
package com.nhry.service.basic.pojo;

import java.util.Date;

public class ProductInfoExModel
{
	private String matnr;

   private String matnrTxt;

   private String baseUnit;

   private String status;

   private Date lastModified;

   private Date createAt;

   private String firstCat;

   private String secCate;

   private String brand;

   private Float weight;

   private String weightUnit;

   private String importantPrdFlag;

   private String spec;

   private String specUnit;

   private String botSpec;

   private String zbotCode;
   
   private String shortTxt;

   private Integer preDays;
   
   private String botType;


   public String getBotType()
	{
		return botType;
	}

	public void setBotType(String botType)
	{
		this.botType = botType;
	}

	public String getShortTxt()
	{
		return shortTxt;
	}

	public void setShortTxt(String shortTxt)
	{
		this.shortTxt = shortTxt;
	}

	public Integer getPreDays()
	{
		return preDays;
	}

	public void setPreDays(Integer preDays)
	{
		this.preDays = preDays;
	}

	public String getMatnr() {
       return matnr;
   }

   public void setMatnr(String matnr) {
       this.matnr = matnr == null ? null : matnr.trim();
   }

   public String getMatnrTxt() {
       return matnrTxt;
   }

   public void setMatnrTxt(String matnrTxt) {
       this.matnrTxt = matnrTxt == null ? null : matnrTxt.trim();
   }

   public String getBaseUnit() {
       return baseUnit;
   }

   public void setBaseUnit(String baseUnit) {
       this.baseUnit = baseUnit == null ? null : baseUnit.trim();
   }

   public String getStatus() {
       return status;
   }

   public void setStatus(String status) {
       this.status = status == null ? null : status.trim();
   }

   public Date getLastModified() {
       return lastModified;
   }

   public void setLastModified(Date lastModified) {
       this.lastModified = lastModified;
   }

   public Date getCreateAt() {
       return createAt;
   }

   public void setCreateAt(Date createAt) {
       this.createAt = createAt;
   }

   public String getFirstCat() {
       return firstCat;
   }

   public void setFirstCat(String firstCat) {
       this.firstCat = firstCat == null ? null : firstCat.trim();
   }

   public String getSecCate() {
       return secCate;
   }

   public void setSecCate(String secCate) {
       this.secCate = secCate == null ? null : secCate.trim();
   }

   public String getBrand() {
       return brand;
   }

   public void setBrand(String brand) {
       this.brand = brand == null ? null : brand.trim();
   }

   public Float getWeight() {
       return weight;
   }

   public void setWeight(Float weight) {
       this.weight = weight;
   }

   public String getWeightUnit() {
       return weightUnit;
   }

   public void setWeightUnit(String weightUnit) {
       this.weightUnit = weightUnit == null ? null : weightUnit.trim();
   }

   public String getImportantPrdFlag() {
       return importantPrdFlag;
   }

   public void setImportantPrdFlag(String importantPrdFlag) {
       this.importantPrdFlag = importantPrdFlag == null ? null : importantPrdFlag.trim();
   }

   public String getSpec() {
       return spec;
   }

   public void setSpec(String spec) {
       this.spec = spec == null ? null : spec.trim();
   }

   public String getSpecUnit() {
       return specUnit;
   }

   public void setSpecUnit(String specUnit) {
       this.specUnit = specUnit == null ? null : specUnit.trim();
   }

   public String getBotSpec() {
       return botSpec;
   }

   public void setBotSpec(String botSpec) {
       this.botSpec = botSpec == null ? null : botSpec.trim();
   }

   public String getZbotCode() {
       return zbotCode;
   }

   public void setZbotCode(String zbotCode) {
       this.zbotCode = zbotCode == null ? null : zbotCode.trim();
   }
}
