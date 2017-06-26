package com.nhry.data.auth.domain;

import java.io.Serializable;
import java.util.Date;

public class TSysAccesskey  implements Serializable {
    private String loginname;

    private Date visitFirstTime;

    private Date visitLastTime;

    private String visitIp;

    private String visitUrl;

    private Integer visitAmount;
    
    private String accesskey;

    private String type;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public Date getVisitFirstTime() {
        return visitFirstTime;
    }

    public void setVisitFirstTime(Date visitFirstTime) {
        this.visitFirstTime = visitFirstTime;
    }

    public Date getVisitLastTime() {
        return visitLastTime;
    }

    public void setVisitLastTime(Date visitLastTime) {
        this.visitLastTime = visitLastTime;
    }

    public String getVisitIp() {
        return visitIp;
    }

    public void setVisitIp(String visitIp) {
        this.visitIp = visitIp == null ? null : visitIp.trim();
    }

    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl == null ? null : visitUrl.trim();
    }

    public Integer getVisitAmount() {
        return visitAmount;
    }

    public void setVisitAmount(Integer visitAmount) {
        this.visitAmount = visitAmount;
    }

	public String getAccesskey() {
		return accesskey;
	}

	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}