package com.framework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 加载文件资源
 */
public class FileSystemResource implements Resource{
	private final File file;
	private final String path;
	public FileSystemResource(File file){
		this.file = file;
		this.path = file.getPath();
	}
	public FileSystemResource(String path){
		this.path = path;
		this.file = new File(path);
	}

	public final String getPath() {
		return path;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(this.file);
	}

}
