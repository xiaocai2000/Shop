package com.deviser.service;

import java.util.List;

import com.deviser.shop.model.Category;

public interface BaseService<T> {
	public void save(T t);
	public void update(T t);
	public void delete(int id);
	public T get(int id);
	public List<T> query();
}
