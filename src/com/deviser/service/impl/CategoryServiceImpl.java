package com.deviser.service.impl;

import java.util.List;

import javax.transaction.Transactional;

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
                .setFirstResult((page-1) * size) //�ӵڼ�����ʼ��ʾ  
                .setMaxResults(size) //��ʾ����  
                .list(); 
	}

	// ���ݹؼ��ֲ�ѯ�ܼ�¼��
	@Override
	public Long queryCount(String type) {
		// TODO Auto-generated method stub
		String hql = "select count(c) from Category c where c.type like :type";
		return(Long) getSession().createQuery(hql)  
	            .setString("type", "%" + type + "%")  
	            .uniqueResult(); //����һ����¼:�ܼ�¼�� 
	}
	
	// 根据ids删除多条记录
	public void deleteByIds(String ids) {
		String hql = "delete from Category c where c.id in(" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
	}
	
	/**
	 * 根据hot查询热点或非热点类别
	 */
	public List<Category> queryByHot(boolean hot) {
		String hql = "from Category c where c.hot = :hot";
		return getSession().createQuery(hql)
				.setBoolean("hot", hot)
				.list();
	}
}
