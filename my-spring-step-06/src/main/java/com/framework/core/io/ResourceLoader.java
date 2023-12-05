package com.framework.core.io;

/**
 * 资源加载器，将前面的三种资源进行同意封装
 */
public interface ResourceLoader {
	String CLASSPATH_URL_PREFIX = "classpath:";
	/**
	 * 根据路径获取资源
	 * @param location 同一路径
	 * @return 返回资源
	 */
	Resource getResource(String location);
}
