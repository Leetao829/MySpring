package com.framework.factory.config;

/**
 * 定义bean的引用
 */
public class BeanReference {
	private final String beanName;
	public BeanReference(String beanName){
		this.beanName = beanName;
	}

	public String getBeanName() {
		return beanName;
	}

}
