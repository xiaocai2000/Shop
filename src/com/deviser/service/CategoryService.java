package com.deviser.service;

import java.util.List;

import com.deviser.shop.model.Category;

public interface CategoryService extends BaseService<Category> {
	// ��������Ա��ѯ�����Ϣ
	public List<Category> queryJoinAccount(String type, int page, int size);

	// ���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long queryCount(String type);
}