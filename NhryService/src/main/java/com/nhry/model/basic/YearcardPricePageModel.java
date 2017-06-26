package com.nhry.model.basic;

/**
 * Created by chen on 2017/5/18.
 */
public class YearcardPricePageModel extends YearcardPriceQueryModel {
    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    String pageSize;
    String pageNum;


}
