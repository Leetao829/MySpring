package com.framework.factory.config;

import com.framework.BeansException;
import com.framework.factory.support.BeanDefinition;

/**
 * 该类是对抽象工厂中创建bean方式的一种默认实现，
 * 该类会将创建的对象放到单例bean的缓存中
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
		Object bean;
		try {
			bean = beanDefinition.getBeanClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new BeansException("Instantiation of bean failed",e);
		}
		addSingleton(beanName,bean);
		return bean;
	}
}
