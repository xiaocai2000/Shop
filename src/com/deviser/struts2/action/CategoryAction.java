package com.deviser.struts2.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.deviser.shop.model.Category;

import net.sf.json.JSONObject;

@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {
	private static final long serialVersionUID = 4879436816107636372L;
	
	public String update() {
		System.out.println("----update----");
		System.out.println(categoryService);
		categoryService.update(model);
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
	
	public String queryJoinAccount() {
		pageMap = new HashMap<String, Object>();
		
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		Long total = categoryService.queryCount(model.getType());

		pageMap.put("rows", categoryList);
		pageMap.put("total", total);
		
		return "jsonMap";
	}
}
