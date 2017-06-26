package com.nhry.webService.client.masterData.model;

import java.io.Serializable;

public class ET_KNVP  implements Serializable{
	private static final long serialVersionUID = -3627651387808776834L;
	private String mandt;//客户端
	private String kunnr;//客户编码
	private String vokrg;//销售组织
	private String vtweg;//分销渠道
	private String spart;//产品组
	private String parvw;//合作伙伴
	private String parza;//合作伙伴计数器
	private String kunn2;//业务伙伴客户号
	private String lifnr;//供应商或债权人的账号
	private String pernr;//人员编号
	private String parnr;//联系人号码
	private String knref;//业务合作伙伴客户描述
	private String defpa;//却省合作伙伴
	public String getMandt() {
		return mandt;
	}
	public void setMandt(String mandt) {
		this.mandt = mandt;
	}
	public String getKunnr() {
		return kunnr;
	}
	public void setKunnr(String kunnr) {
		this.kunnr = kunnr;
	}
	public String getVokrg() {
		return vokrg;
	}
	public void setVokrg(String vokrg) {
		this.vokrg = vokrg;
	}
	public String getVtweg() {
		return vtweg;
	}
	public void setVtweg(String vtweg) {
		this.vtweg = vtweg;
	}
	public String getSpart() {
		return spart;
	}
	public void setSpart(String spart) {
		this.spart = spart;
	}
	public String getParvw() {
		return parvw;
	}
	public void setParvw(String parvw) {
		this.parvw = parvw;
	}
	public String getParza() {
		return parza;
	}
	public void setParza(String parza) {
		this.parza = parza;
	}
	public String getKunn2() {
		return kunn2;
	}
	public void setKunn2(String kunn2) {
		this.kunn2 = kunn2;
	}
	public String getLifnr() {
		return lifnr;
	}
	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}
	public String getPernr() {
		return pernr;
	}
	public void setPernr(String pernr) {
		this.pernr = pernr;
	}
	public String getParnr() {
		return parnr;
	}
	public void setParnr(String parnr) {
		this.parnr = parnr;
	}
	public String getKnref() {
		return knref;
	}
	public void setKnref(String knref) {
		this.knref = knref;
	}
	public String getDefpa() {
		return defpa;
	}
	public void setDefpa(String defpa) {
		this.defpa = defpa;
	}
}
