package com.nhry.common.exception;

public class BaseException extends RuntimeException {

	private String code;

    private Object value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BaseException(String message, Throwable cause, String code, Object value) {
        super(message, cause);
        this.code = code;
        this.value = value;
    }

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
