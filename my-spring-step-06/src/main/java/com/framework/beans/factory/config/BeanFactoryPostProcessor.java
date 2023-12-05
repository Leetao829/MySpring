package com.framework.beans.factory.config;

import com.framework.beans.BeansException;
import com.framework.beans.factory.ConfigurableListableBeanFactory;

/**
 * 允许自定义修改BeanDefinition信息
 */
public interface BeanFactoryPostProcessor {

	/**
	 * 在所有BeanDefinition加载完毕之后，bean实例化之前，提供修改BeanDefinition的机制
	 * @param beanFactory
	 * @throws BeansException
	 */
	void postProcessorBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
