package com.deviser.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.deviser.service.CategoryService;
import com.deviser.service.ProductService;
import com.deviser.shop.model.Category;
import com.deviser.shop.model.Product;

@Component
public class ProductTimerTask extends TimerTask {
	private CategoryService categoryService = null;
	private ProductService productService = null;
	private ServletContext application = null;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	@Resource
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public ProductService getProductService() {
		return productService;
	}

	@Resource
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<List<Product>> bigList = new ArrayList<List<Product>>();
		
		for (Category category : categoryService.queryByHot(true)) {
			List<Product> lst = productService.queryByCategoryId(category.getId());
			bigList.add(lst);
		}
		
		application.setAttribute("bigList", bigList);
	}

}
