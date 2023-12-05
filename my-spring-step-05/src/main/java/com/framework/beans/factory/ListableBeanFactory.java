package com.framework.beans.factory;

import com.framework.beans.BeansException;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory{

	/**
	 * 按照类型返回bean实例
	 * @param type
	 * @param <T>
	 * @return
	 * @throws BeansException
	 */
	<T> Map<String,T> getBeansOfType(Class<T> type) throws BeansException;

	/**
	 * 返回注册表中的所有bean名称
	 * @return
	 */
	String[] getBeanDefinitionNames();



}
