package com.system;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * 自定义spring装载监听
 * @author Bruce
 * @date 2019年11月5日
 */
//@Log4j2
public class SpringContextLoadListener extends ContextLoaderListener{
	
	private static Logger LOGGER = LoggerFactory.getLogger(SpringContextLoadListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());
		SpringContext.INSTANCE.setContext(ctx);
		//此处应该从配置文件获取
		int minutes = Integer.valueOf("3600");
		event.getServletContext().getSessionCookieConfig().setMaxAge(minutes);
		LOGGER.info("SpringContextLoadListener_start =====>");
	}
	
}
