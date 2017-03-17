package com.deviser.struts2.action;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.deviser.shop.model.Category;
import com.deviser.shop.model.Product;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	private static final long serialVersionUID = 9161268999456305362L;

	@Override
	public Product getModel() {
		Category category = new Category();
		model = super.getModel();
		model.setCategory(category);
		return model;
	}

	public String queryJoinCategory() {
		pageMap = new HashMap<String, Object>();
		List<Product> productList = productService.queryJoinCategory(model.getName(), page, rows);
		pageMap.put("rows", productList);
		Long total = productService.getCount(model.getName());
		pageMap.put("total", total);
		return "jsonMap";
	}
	
	public String deleteByIds() {
		productService.deleteByIds(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save() {
		String pic = fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		model.setDate(new Date());
		productService.save(model);
	}
	
	public void update() {
		String pic = fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		model.setDate(new Date());
		productService.update(model);
	}
	
	public String get() {
		request.put("product", productService.get(model.getId()));
		return "detail";
	}
}
