package com.deviser.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.deviser.service.ProductService;
import com.deviser.shop.model.Product;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		// TODO Auto-generated method stub
		String hql = "from Product p left join fetch p.category where p.name like :name";
		return getSession().createQuery(hql)
				.setString("name", "%" + name + "%")
				.setFirstResult((page - 1) * size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public long getCount(String name) {
		// TODO Auto-generated method stub
		String hql = "select count(p) from Product p where p.name like :name";
		return (long) getSession().createQuery(hql)
				.setString("name", "%" + name + "%")
				.uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		String hql = "delete from Product p where p.id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public List<Product> queryByCategoryId(int cid) {
		// TODO Auto-generated method stub
		String hql = "from Product p join fetch p.category where p.commend=true and p.open=true and p.category.id=:cid order by p.date desc";
		
		return getSession().createQuery(hql)
				.setInteger("cid", cid)
				.setFirstResult(0)
				.setMaxResults(4)
				.list();
	}
}
