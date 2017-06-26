package com.nhry.model.webService.base;

import java.io.Serializable;

/**
 * Created by gongjk on 2016/7/29.
 */
public class BussinessInputModel implements Serializable {
    private String businessno;
    private Object body;

    public String getBusinessno() {
        return businessno;
    }

    public void setBusinessno(String businessno) {
        this.businessno = businessno;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "BussinessInputModel{}";
    }
}
