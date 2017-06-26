package com.nhry.webService.client;

import org.apache.poi.ss.formula.functions.T;

/**
 * Created by cbz on 8/1/2016.
 */
public class PISuccessTMessage<T> {
    private boolean success;
    private T data;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
