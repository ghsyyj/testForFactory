package com.common.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringExclude;

/**
 * 返回。
 * @author Bruce
 * @date 2019年11月11日
 */
/** 
 * lombok 注解使用
 * @Setter 注解在类或字段，注解在类时为所有字段生成setter方法，注解在字段上时只为该字段生成setter方法。
@Getter 使用方法同上，区别在于生成的是getter方法。
@ToString 注解在类，添加toString方法。
@EqualsAndHashCode 注解在类，生成hashCode和equals方法。
@NoArgsConstructor 注解在类，生成无参的构造方法。
@RequiredArgsConstructor 注解在类，为类中需要特殊处理的字段生成构造方法，比如final和被@NonNull注解的字段。
@AllArgsConstructor 注解在类，生成包含类中所有字段的构造方法。
@Data 注解在类，为类的所有字段注解@ToString、@EqualsAndHashCode、@Getter的便捷方法，同时为所有非final字段注解@Setter。
*
*/
//@ToString
public class BaseResult implements Serializable{

	@ToStringExclude	//该注解，跳过该字段的tostring
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
