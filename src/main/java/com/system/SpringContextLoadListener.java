package com.system;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 自定义spring装载监听
 * @author Bruce
 * @date 2019年11月5日
 */
public class SpringContextLoadListener extends ContextLoaderListener{
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());
		SpringContext.INSTANCE.setContext(ctx);
		//此处应该从配置文件获取
		int minutes = Integer.valueOf("3600");
		event.getServletContext().getSessionCookieConfig().setMaxAge(minutes);
	}
	
}
