package com.deviser.service;

import java.util.List;

import com.deviser.shop.model.Category;

public interface CategoryService extends BaseService<Category> {
	// ��������Ա��ѯ�����Ϣ
	public List<Category> queryJoinAccount(String type, int page, int size);

	// ���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long queryCount(String type);
	
	// 根据ids删除多条记录
	public void deleteByIds(String ids);
	/**
	 * 根据hot查询热点或非热点类别
	 */
	public List<Category> queryByHot(boolean hot);
}