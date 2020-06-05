package com.common.config;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;


@Configuration
@EnableAutoConfiguration
public class RedisCacheConfig extends CachingConfigurerSupport{

	@Value("${spring.redis.host}")
	private String host;
	
	@Value("${spring.redis.port}")
	private int port;
	
	@Value("${spring.redis.timeout}")
	private int timeout;
	
	@Value("${spring.redis.database}")
	private int database;
	
	@Value("${spring.redis.password}")
	private String password;
	
	/**
	 * 链接redis的工厂类.
	 * @return
	 */
	@Bean(name = "jedisConnectionFactory")
	public JedisConnectionFactory jedisConnectionFactory() {
//		JedisConnectionFactory factory = new JedisConnectionFactory(JedisPoolConfig());
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(host);
		factory.setPort(port);
		factory.setTimeout(timeout);
		factory.setPassword(password);
		
		return factory;
	}
	
	/**
	 * 配置RedisTemplate设置添加序列化器key使用string序列化器,value使用json序列化器
	 * 简单的设置方式,改变defaultSerializer对象的实现
	 * @return
	 */
	@Bean("healthJedisTemplate")
	public RedisTemplate<String, Object> redisTemplate() {
		//StringRedisTemplate的构造方法中默认设置了stringSerializer
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		template.setKeySerializer(stringRedisSerializer);
		template.setHashKeySerializer(stringRedisSerializer);
		
		template.setConnectionFactory(jedisConnectionFactory());
		template.afterPropertiesSet();
		return template;
	}
	
	/**
	 *自定义生成redis-key
	 */
	@Override
	public KeyGenerator keyGenerator() {
		
		return new KeyGenerator() {
			
			@Override
			public Object generate(Object o, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName()).append(".");
				sb.append(method.getName()).append(".");
				for(Object object : params) {
					sb.append(object.toString());
				}
				
				return sb.toString();
			}
		};
	}
	
	
//	public JedisPoolConfig jedisPoolConfig() {
//		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//		
//		return jedisPoolConfig;
//		
//	}
}
