package com.nhry.model.statistics;

import com.nhry.model.basic.BaseQueryModel;

/**
 * Created by gongjk on 2016/10/20.
 */
public class RefuseResendDetailModel extends BaseQueryModel {
    private String resendOrderNo;

    public String getResendOrderNo() {
        return resendOrderNo;
    }

    public void setResendOrderNo(String resendOrderNo) {
        this.resendOrderNo = resendOrderNo;
    }
}
