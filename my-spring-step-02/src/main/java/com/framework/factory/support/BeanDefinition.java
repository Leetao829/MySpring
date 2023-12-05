package com.framework.factory.support;

/**
 * 前面的bean定义中使用的是对象信息
 * 由于对象的创建需要交给容器
 * 因此在这里只需要注册类信息
 */
public class BeanDefinition {
	private Class beanClass;
	public BeanDefinition(Class beanClass){
		this.beanClass = beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public Class getBeanClass() {
		return beanClass;
	}

}
