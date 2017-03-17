package com.deviser.shop.model;

import java.io.File;

public class FileImage {
	private File file;
	private String contentType;
	private String fileName;
	public File getFile() {
		return file;
	}
	public void setUpload(File file) {
		this.file = file;
	}
	public String getContentType() {
		return contentType;
	}
	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setUploadFileName(String fileName) {
		this.fileName = fileName;
	}
}
