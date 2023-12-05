package com.framework.factory.support;

import com.framework.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
	void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
