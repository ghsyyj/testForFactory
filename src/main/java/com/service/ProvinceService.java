package com.controller.service;

import com.github.pagehelper.PageInfo;

public interface ProvinceService {

	PageInfo<String> findAllProvince(int pagNo, int pageSize);
}
