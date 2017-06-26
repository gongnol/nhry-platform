package com.nhry.model.milktrans;

/**
 * Created by gongjk on 2016/7/11.
 */
public class UpdateReturnBoxModel {
    private String detLsh;
    private String spec;
    private int realNum;

    public int getRealNum() {
        return realNum;
    }

    public void setRealNum(int realNum) {
        this.realNum = realNum;
    }

    public String getDetLsh() {
        return detLsh;
    }

    public void setDetLsh(String detLsh) {
        this.detLsh = detLsh;
    }


    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
