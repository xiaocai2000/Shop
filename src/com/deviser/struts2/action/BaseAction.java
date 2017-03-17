package com.deviser.struts2.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.deviser.service.AccountService;
import com.deviser.service.CategoryService;
import com.deviser.service.ProductService;
import com.deviser.shop.model.FileImage;
import com.deviser.util.FileUpload;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware, SessionAware, ApplicationAware, ModelDriven<T> {
	private static final long serialVersionUID = 3622861175142205756L;
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	protected T model;
	protected CategoryService categoryService;
	protected AccountService accountService;
	protected ProductService productService;
	protected String ids;
	protected InputStream inputStream;
	protected Integer page;
	protected Integer rows;
	protected Map<String, Object> pageMap = null;
	protected List<T> jsonList;
	protected FileImage fileImage = new FileImage();
	protected FileUpload fileUpload;
	
	public FileImage getFileImage() {
		return fileImage;
	}

	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}

	public FileUpload getFileUpload() {
		return fileUpload;
	}

	@Resource
	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}

	public List<T> getJsonList() {
		return jsonList;
	}

	public void setJsonList(List<T> jsonList) {
		this.jsonList = jsonList;
	}

	public ProductService getProductService() {
		return productService;
	}

	@Resource
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	@JSON(name="root")
	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	@Resource
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	@Resource
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setModel(T model) {
		this.model = model;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		application = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return model;
	}

}
