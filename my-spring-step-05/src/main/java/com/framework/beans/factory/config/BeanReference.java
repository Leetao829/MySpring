package com.framework.beans.factory.config;

/**
 * bean的引用，用于给对象属性赋值
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
