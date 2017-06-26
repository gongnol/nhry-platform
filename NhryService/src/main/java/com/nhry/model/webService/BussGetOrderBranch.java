package com.nhry.model.webService;

/**
 * Created by gongjk on 2016/7/29.
 */
public class BussGetOrderBranch {
    private String serviceName;
    private CustInfoModel data;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public CustInfoModel getData() {
        return data;
    }

    public void setData(CustInfoModel data) {
        this.data = data;
    }
}
