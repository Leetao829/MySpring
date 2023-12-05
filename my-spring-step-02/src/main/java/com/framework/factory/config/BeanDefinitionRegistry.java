package com.framework.factory.config;

import com.framework.factory.support.BeanDefinition;

/**
 * 注册bean信息
 */
public interface BeanDefinitionRegistry {
	void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
