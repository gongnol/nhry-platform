package com.nhry.common.exception;

public class ServiceException extends BaseException {
   
	
	/**
	 * Constructors
	 * @param code  错误代码
	 */
	public ServiceException(String code) {
		super(code, null, code, null);
	}

	/**
	 * Constructors
	 * @param cause  异常接口
	 * @param code   错误代码
	 */
	public ServiceException(Throwable cause, String code) {
		super(code, cause, code, null);
	}

	/**
	 * Constructors
	 * @param code 错误代码
	 * @param value  自定义异常信息
	 */
	public ServiceException(String code, Object value) {
		super(code, null, code, value);
	}

	/**
	 * Constructors
	 * @param cause  异常接口
	 * @param code  错误代码
	 * @param value  自定义异常信息
	 */
	public ServiceException(Throwable cause, String code, Object value) {
		super(code, null, code, value);
	}
}
