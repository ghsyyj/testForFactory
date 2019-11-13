package com.system.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * myBaties的分页插件。
 * @author Bruce
 * @date 2019年11月13日
 */
@Intercepts({
	@Signature(type = StatementHandler.class, method = "prepare", args = {
			Connection.class, Integer.class
	})
})
public class PageInterceptor implements Interceptor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PageInterceptor.class);
	
	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	private static final ReflectorFactory REFLECTOR_FACTORY = new DefaultReflectorFactory();
	//数据类型，默认mysql.
	private static String defaultDialect = "mysql";
	//需要拦截的规则
	private static String defaultPageSqlId = ".*Page$";
	//数据库类型，默认mysql。
	private static String dialect = "";
	//需要拦截的规则。
	private static String pageSqlId = "";
	private Properties properties;
	
	public PageInterceptor() {
		this.properties = null;
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		long timestamp = System.currentTimeMillis();
		LOGGER.info("pageInterceptor_begin time=>", timestamp);
		
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, 
				DEFAULT_OBJECT_WRAPPER_FACTORY, REFLECTOR_FACTORY);
		//分离代理对象链（由于目标类可能被多个拦截器拦截，从而形成多次代理，通过两次循环可以分离出最原始的目标类）
		while(metaStatementHandler.hasGetter("h")) {
			Object object = metaStatementHandler.getValue("h");
			metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, 
					DEFAULT_OBJECT_WRAPPER_FACTORY, REFLECTOR_FACTORY);
		}
		//分离最后一个代理对象的目标类
		while(metaStatementHandler.hasGetter("target")) {
			Object object = metaStatementHandler.getValue("target");
			metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, 
					DEFAULT_OBJECT_WRAPPER_FACTORY, REFLECTOR_FACTORY);
		}
		/*
		 * 此处取dialect时configuration。xml里的property，dialect = configuration。getVariables().getProperty("dialect");
		 * 这种方法可以直接不用实例化this.properties
		 * <properties> 
		 * <property name = "dialect" value = "mysql"/>
		 * <property name = "pageSqlId" value = ".*Page$" />
		 * </properties>
		 */
//		Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
//		dialect = configuration.getVariables().getProperty("dialect");
		/*
		 * 下面这种写法使用，一定要先将this.properties实例化
		 * <plugin interceptor = "my.com.interceptor.PageInterceptor">
		 * 	<property name = "dialect" value = "mysql" />
		 * 	<property name = "pageSqlId" value = ".*Page$" />
		 * </plugin>	
		 */
		dialect = this.properties.getProperty("dialect");
		if(null == dialect || "".equals(dialect)) {
			LOGGER.warn("PageInterceptor_dialect is not setted,use default 'mysql', time =>{}", timestamp);
			dialect = defaultDialect;
		}
		pageSqlId = this.properties.getProperty("pageSqlId");
		if(null == pageSqlId || "".equals(pageSqlId)) {
			LOGGER.warn("PageInterceptor_pageSqlId is not setted,use default '.*Page$', time =>{}", timestamp);
			pageSqlId = defaultPageSqlId;
		}
		
		return null;
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
