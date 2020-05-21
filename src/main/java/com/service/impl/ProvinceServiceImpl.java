package com.controller.service.impl;


import java.util.List;

import com.controller.service.ProvinceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class ProvinceServiceImpl implements ProvinceService {

	@Override
	public PageInfo<String> findAllProvince(int pagNo, int pageSize) {
		
		PageHelper.startPage(pagNo, pageSize);
		List<String> allProvinceList = null;
		
		PageInfo<String> pageInfo = new PageInfo<>(allProvinceList);
		
		return pageInfo;
	}

}
