package com.framework.beans.factory.support;

import com.framework.beans.BeansException;
import com.framework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

	/**
	 * 向注册表中注册bean的定义
	 * @param beanName bean的名称
	 * @param beanDefinition bean定义
	 */
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

	/**
	 * 根据bean名称查询beanDefinition
	 * @param beanName
	 * @return
	 */
	BeanDefinition getBeanDefinition(String beanName) throws BeansException;

	/**
	 * 查询是否包含指定的beanDefinition
	 * @param beanName
	 * @return
	 */
	boolean containsBeanDefinition(String beanName);

	/**
	 * 获取注册表中所有的bean名称
	 * @return
	 */
	String[] getBeanDefinitionNames();

}
