package com.deviser.shop.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.deviser.service.CategoryService;
import com.deviser.service.ProductService;
import com.deviser.shop.model.Category;
import com.deviser.shop.model.Product;
import com.deviser.util.ProductTimerTask;

public class InitDataListener implements ServletContextListener {
	private ProductTimerTask productTimerTask = null;
	private ApplicationContext context = null;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		productTimerTask = (ProductTimerTask) context.getBean("productTimerTask");
		
		productTimerTask.setApplication(sce.getServletContext());
		
		new Timer(true).schedule(productTimerTask, 0, 3600 * 1000);
	}
}
