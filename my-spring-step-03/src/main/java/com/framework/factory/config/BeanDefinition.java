package com.framework.factory.config;

/**
 * 定义bean
 */
public class BeanDefinition {
	private Class beanClass;
	public BeanDefinition(Class clazz){
		this.beanClass = clazz;
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

}
