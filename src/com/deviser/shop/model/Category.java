package com.deviser.shop.model;

public class Category {
	private int id;
	private String type;
	private boolean hot;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getHot() {
		return hot;
	}

	public void setHot(boolean hot) {
		this.hot = hot;
	}
}
