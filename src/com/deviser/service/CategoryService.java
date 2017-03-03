package com.deviser.service;

import java.util.List;

import com.deviser.shop.model.Category;

public interface CategoryService extends BaseService<Category> {
	// 级联管理员查询类别信息
	public List<Category> queryJoinAccount(String type, int page, int size);

	// 根据关键字查询总记录数
	public Long queryCount(String type);
}