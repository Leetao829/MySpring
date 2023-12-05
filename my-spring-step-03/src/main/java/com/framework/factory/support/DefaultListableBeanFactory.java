package com.framework.factory.support;

import com.framework.BeansException;
import com.framework.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
	@Override
	protected BeanDefinition getBeanDefinition(String name) {
		BeanDefinition beanDefinition = beanDefinitionMap.get(name);
		if(beanDefinition == null) throw new BeansException("No bean named '" + name + "' is defined");
		return beanDefinition;
	}

	@Override
	public void registryBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName,beanDefinition);
	}

}
