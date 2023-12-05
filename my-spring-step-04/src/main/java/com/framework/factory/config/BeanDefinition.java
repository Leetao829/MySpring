package com.framework.factory.config;

import com.framework.PropertyValues;

/**
 * 定义bean的实例信息，添加属性的定义
 */
public class BeanDefinition {
	private Class beanClass;
	private PropertyValues propertyValues;
	public BeanDefinition(Class clazz){
		this.beanClass = clazz;
		this.propertyValues = new PropertyValues();
	}

	public BeanDefinition(Class clazz,PropertyValues propertyValues){
		this.beanClass = clazz;
		this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}

}
