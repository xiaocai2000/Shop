package com.deviser.service;

import java.util.List;

import com.deviser.shop.model.Account;
import com.deviser.shop.model.Product;

public interface ProductService extends BaseService<Product> {
	public List<Product> queryJoinCategory(String type, int page, int size);
	public long getCount(String type);
	public void deleteByIds(String ids);
	public void save(Product product);
	public List<Product> queryByCategoryId(int cid);
}
