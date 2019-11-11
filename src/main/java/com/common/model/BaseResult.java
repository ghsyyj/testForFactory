package com.common.model;

import java.io.Serializable;

/**
 * 返回。
 * @author Bruce
 * @date 2019年11月11日
 */
public class BaseResult implements Serializable{

	private static final long serialVersionUID = 2546486688845380337L;
	
	private static final String successStatus = "00";
	private static final String errorStatus = "01";

	/**
	 * 00或者01，状态码.
	 */
	private String code;
	
	/**
	 * 返回参数（success,fail）
	 */
	private String message;
	
	/**
	 * 具体的返回数据
	 */
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static BaseResult success() {
		BaseResult result = new BaseResult();
		result.setCode(successStatus);
		return result;
	}
	
	public static BaseResult successAndMsg(String message, Object o) {
		BaseResult result = new BaseResult();
		result.setCode(successStatus);
		result.setMessage(message);
		result.setData(o);
		return result;
	}
	
	public static BaseResult error(String message) {
		BaseResult result = new BaseResult();
		result.setCode(errorStatus);
		result.setMessage(message);
		return result;
	}
	
}
