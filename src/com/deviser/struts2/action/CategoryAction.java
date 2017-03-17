package com.deviser.struts2.action;

import java.io.ByteArrayInputStream;
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
	
	
	
	public CategoryAction() {
		// TODO Auto-generated constructor stub
		System.out.println("CategoryAction");
	}

	public String update() {
		System.out.println("----update----");
		System.out.println(categoryService);
		categoryService.update(model);
		return "index";
	}
	
	public void save() {
		System.out.println("----save----");
		System.out.println(categoryService);
		categoryService.save(model);
	}
	
	public String query() {
		jsonList = categoryService.query();
		return "jsonList";
	}
	
	public String queryJoinAccount() {
		pageMap = new HashMap<String, Object>();
		
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		Long total = categoryService.queryCount(model.getType());

		pageMap.put("rows", categoryList);
		pageMap.put("total", total);
		
		return "jsonMap";
	}
	
	public String deleteByIds() {
		categoryService.deleteByIds(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
}
