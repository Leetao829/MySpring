package com.framework.factory.config;

import com.framework.BeansException;
import com.framework.factory.support.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 该类实现上面的抽象工厂类，拥有创建bean的功能，同时需要实现bean的注册
 * 将bean注册在缓存map中，
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
	private final Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();
	@Override
	public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if(beanDefinition == null){
			throw new BeansException("No bean named '" + beanName + "' is defined");
		}
		return beanDefinition;
	}

	@Override
	public void registryBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName,beanDefinition);
	}

}
