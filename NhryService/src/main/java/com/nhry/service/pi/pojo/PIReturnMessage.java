package com.nhry.service.pi.pojo;

/**
 * Created by cbz on 7/6/2016.
 */
public class PIReturnMessage {
    private boolean success;
    private Order data;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Order getData() {
        return data;
    }

    public void setData(Order data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
