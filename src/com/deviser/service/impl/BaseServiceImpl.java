package com.deviser.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.deviser.service.BaseService;

@Service
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {
	private Class clazz;
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public BaseServiceImpl() {
		// ��ӡ��Ϣ
		System.out.println("this������ǵ�ǰ���ù��췽���Ķ���" + this);
		System.out.println("��ȡ��ǰthis����ĸ�����Ϣ" + this.getClass().getSuperclass());  
        System.out.println("��ȡ��ǰthis����ĸ�����Ϣ(����������Ϣ)" + this.getClass().getGenericSuperclass());  
	
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class) type.getActualTypeArguments()[0];
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getSession().update(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println(clazz.getSimpleName());
		String hql = "delete " + clazz.getSimpleName() + "as c where c.id=:id";
		getSession().createQuery(hql)
			.setInteger(1, id)
			.executeUpdate();
	}

	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		// TODO Auto-generated method stub
		String hql = "from " + clazz.getSimpleName();
		System.out.println(hql);
		return getSession().createQuery(hql).list();
	}

}
