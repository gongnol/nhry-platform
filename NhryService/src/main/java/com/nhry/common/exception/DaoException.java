package com.nhry.common.exception;

public class DaoException extends BaseException {
	/**
	 * Constructors
	 * @param code  错误代码
	 */
	public DaoException(String code) {
		super(code, null, code, null);
	}

	/**
	 * Constructors
	 * @param cause 异常接口
	 * @param code 错误代码
	 */
	public DaoException(Throwable cause, String code) {
		super(code, cause, code, null);
	}

	/**
	 * Constructors
	 * @param code  错误代码
	 * @param values  一组异常信息待定参数
	 */
	public DaoException(String code, Object value) {
		super(code, null, code, value);
	}

	/**
	 * Constructors
	 * @param cause 异常接口
	 * @param code  错误代码
	 * @param values  一组异常信息待定参数
	 */
	public DaoException(Throwable cause, String code, Object value) {
		super(code, null, code, value);
	}
}
