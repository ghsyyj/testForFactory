package com.system.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 拦截器.
 * @author Bruce
 * @date 2020年4月16日
 */
@Slf4j
public class InnerInvokeInterceptor extends HandlerInterceptorAdapter {

	
	private String ACCESS_KEY = "23232R1313F3F3";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
			
		String accessToken = request.getHeader("accessToken");
		String timestamp = request.getHeader("timestamp");
		log.info("innerInvokeInterceptor_accessToken is =>{}, requestUri =>{}", accessToken, request.getRequestURI());
		
		if(StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(timestamp)) {
			log.info("innerInvokeInterceptor_accessToken is empty");
			return false;
		}
		
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
	}
}
