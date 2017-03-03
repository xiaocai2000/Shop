package com.deviser.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deviser.service.CategoryService;
import com.deviser.shop.model.Category;

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Override
	public List<Category> queryJoinAccount(String type, int page, int size) {
		// TODO Auto-generated method stub
        String hql = "from Category c left join fetch c.account where c.type like :type";  
        return (List<Category>)getSession().createQuery(hql)  
                .setString("type", "%" + type + "%")  
                .setFirstResult((page-1) * size) //从第几个开始显示  
                .setMaxResults(size) //显示几个  
                .list(); 
	}

	// 根据关键字查询总记录数
	@Override
	public Long queryCount(String type) {
		// TODO Auto-generated method stub
		String hql = "select count(c) from Category c where c.type like :type";
		return(Long) getSession().createQuery(hql)  
	            .setString("type", "%" + type + "%")  
	            .uniqueResult(); //返回一条记录:总记录数 
	}
}
