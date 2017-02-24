package com.deviser.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.deviser.service.CategoryService;
import com.deviser.shop.model.Category;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport implements RequestAware, SessionAware, ApplicationAware {
	private static final long serialVersionUID = 4879436816107636372L;
	private CategoryService categoryService;
	private Category category;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public String update() {
		System.out.println("----update----");
		System.out.println(categoryService);
		categoryService.update(category);
		return "index";
	}
	
	public String save() {
		System.out.println("----save----");
		System.out.println(categoryService);
		return "index";
	}
	
	public String query() {
        //�������һ��������Ӧ��mapȡ��ԭ�������ö���������jspû�����������Ǵ������Ƚϴ�  
//     ActionContext.getContext().put("categoryList", categoryService.query()); //�ŵ�request����  
//     ActionContext.getContext().getSession().put("categoryList", categoryService.query()); //�ŵ�session����  
//     ActionContext.getContext().getApplication().put("categoryList", categoryService.query()); //�ŵ�application����  
         
       //�����������ʵ����Ӧ�Ľӿ�(RequestAware,SessionAware,ApplicationAware)������Ӧ��mapע��  
		request.put("categoryList", categoryService.query());
		session.put("categoryList", categoryService.query());
		application.put("categoryList", categoryService.query());
		return "index";
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.application = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
}
