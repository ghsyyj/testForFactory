package com.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.service.ProvinceService;
import com.common.utils.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	
	@Value("${spring.redis.lockseconds}")
	private int lockseconds;
	
	@Autowired
	public RedisUtil redisUtil;

	@Override
	public PageInfo<String> findAllProvince(int pagNo, int pageSize) {
		
		PageHelper.startPage(pagNo, pageSize);
		List<String> allProvinceList = null;
		
		PageInfo<String> pageInfo = new PageInfo<>(allProvinceList);
		
		return pageInfo;
	}

	@Override
	public String getProvinceByCode(String code) {
		String lockKey = "dsfhisdofsd";
		
		try {
			if(redisUtil.tryLock(lockKey, lockseconds)) {
				//TODO do something
			}
			
		} catch (Exception e) {
			redisUtil.unlock(lockKey);
		}
		
		
		return null;
	}

}
