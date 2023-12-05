package com.framework.factory.config;

import com.framework.BeansException;
import com.framework.factory.BeanFactory;
import com.framework.factory.support.BeanDefinition;

/**
 * 该抽象类实现BeanFactory接口，定义获取bean的逻辑，
 * 其中getBean中使用模板放法模式，只定义获取bean的逻辑
 * 至于创建bean以及获取beanDefinition交给子类去具体实现
 * 因为这两种实现可能会根据具体子类而不相同
 * 该类还需要有获取单例的功能，因此继承单例的实现类
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

	@Override
	public Object getBean(String beanName) throws BeansException {
		Object bean = getSingleton(beanName);
		if(bean != null) {
			return bean;
		}
		BeanDefinition beanDefinition = getBeanDefinition(beanName);
		return createBean(beanName,beanDefinition);
	}
	protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
	protected abstract Object createBean(String beanName,BeanDefinition beanDefinition) throws BeansException;

}
