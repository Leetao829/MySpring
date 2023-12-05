package com.framework.beans.factory.support;

import com.framework.beans.BeansException;
import com.framework.core.io.Resource;
import com.framework.core.io.ResourceLoader;

/**
 * bean定义读取接口
 */
public interface BeanDefinitionReader {
	BeanDefinitionRegistry getRegistry();

	ResourceLoader getResourceLoader();

	void loadBeanDefinitions(Resource resource) throws BeansException;

	void loadBeanDefinitions(Resource... resources) throws BeansException;

	void loadBeanDefinitions(String location) throws BeansException;

}
