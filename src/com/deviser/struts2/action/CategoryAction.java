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
        //解决方案一，采用相应的map取代原来的内置对象，这样与jsp没有依赖，但是代码量比较大  
//     ActionContext.getContext().put("categoryList", categoryService.query()); //放到request域中  
//     ActionContext.getContext().getSession().put("categoryList", categoryService.query()); //放到session域中  
//     ActionContext.getContext().getApplication().put("categoryList", categoryService.query()); //放到application域中  
         
       //解决方案二，实现相应的接口(RequestAware,SessionAware,ApplicationAware)，让相应的map注入  
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
