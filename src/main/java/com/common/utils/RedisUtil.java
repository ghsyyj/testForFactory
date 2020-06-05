package com.common.utils;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedisUtil {
	
	public static final long MILLISECOND = 1000L;
	public static final long DEFAULT_TRY_INTERVAL = 50L;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public RedisTemplate<String, Object> getRedisTemplate(String key){
		return redisTemplate;
	}
	
	
	/**
	 * 分布式锁.
	 * @param key
	 * @param exptime
	 * @return
	 */
	public boolean tryLock(String lockKey, int timeout) {
		for(long tryTime = System.currentTimeMillis() + timeout * MILLISECOND; System.currentTimeMillis() < tryTime;) {
			if(this.lock(lockKey, 1, timeout)) {
				
				return true;
			}
			try {
				TimeUnit.MILLISECONDS.sleep(DEFAULT_TRY_INTERVAL);
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
		}
		return false;
	}
	
	/**
	 * 解锁.
	 * @param lockKey
	 */
	public void unlock(String lockKey) {
		if(StringUtils.isEmpty(lockKey)) {
			log.info("set to redis error, key is empty.");
			return ;
		}
		getRedisTemplate(lockKey).delete(lockKey);
	}
	
	/**
	 * 原子操作的分布式锁.
	 * @param key
	 * @param value
	 * @param exptime
	 * @return
	 */
	private boolean lock(final String key, final Serializable value, final long exptime) {
		Boolean result = (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
			
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException{
				RedisSerializer valueSerializer = redisTemplate.getValueSerializer();
				RedisSerializer keySerializer = redisTemplate.getKeySerializer();
				
				Object obj = connection.execute("set", keySerializer.serialize(key), valueSerializer.serialize(value),
						"NX".getBytes(Charset.forName("UTF-8")), "EX".getBytes(Charset.forName("UTF-8")),
								String.valueOf(exptime).getBytes(Charset.forName("UTF-8")));
				return obj != null;
			}
			
		});
		
		return result;
		
	}

}
