package com.deviser.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Component;

import com.deviser.shop.model.FileImage;

@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
	private String filePath = "E:\\java\\Eclipse Workspace\\Shop\\WebContent\\files";
	

	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	private String getFileExt(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}
	
	private String newFileName(String fileName) {
		String ext = getFileExt(fileName);
		return UUID.randomUUID() + "." + ext;
	}


	@Override
	public String uploadFile(FileImage fileImage) {
		// TODO Auto-generated method stub
		String pic = newFileName(fileImage.getFileName());
		try {
			FileUtil.copyFile(fileImage.getFile(), new File(filePath, pic));
			return pic;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			fileImage.getFile().delete();
		}
	}

}
