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
	
	public String queryJoinAccount() {
		pageMap = new HashMap<String, Object>();
		
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		Long total = categoryService.queryCount(model.getType());

		pageMap.put("rows", categoryList);
		pageMap.put("total", total);
		
		return "jsonMap";
	}
}
