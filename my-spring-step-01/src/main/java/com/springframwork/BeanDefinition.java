package com.springframwork;

/**
 * spring容器要求能够管理bean，在这里管理bean包括三个步骤：定义，注册以及获取
 * 这里的定义就包括bean对象，后面还会向里面添加内容
 */
public class BeanDefinition {
	private Object bean;
	public BeanDefinition(Object bean){
		this.bean = bean;
	}
	public Object getBean(){
		return bean;
	}

}
