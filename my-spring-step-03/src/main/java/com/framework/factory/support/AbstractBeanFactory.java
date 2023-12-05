package com.framework.factory.support;

import com.framework.BeansException;
import com.framework.factory.BeanFactory;
import com.framework.factory.config.BeanDefinition;

/**
 * 定义工厂基类，抽象类
 * 定义模板方法，创建bean的方式由子类进行实现
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

	@Override
	public Object getBean(String name) throws BeansException  {
		return doGetBean(name,null);
	}

	@Override
	public Object getBean(String name, Object... args) throws BeansException {
		return doGetBean(name,args);
	}

	/**
	 * 获取bean的模板方法
	 * 单例注册表中如果存在，直接从注册表中获取，不存在再创建
	 * 创建bean的过程交给子类进行实现
	 * @param name bean的名称
	 * @param args 构造器参数
	 * @param <T>
	 * @return
	 */
	protected <T> T doGetBean(final String name, final Object[] args) {
		Object bean = getSingleton(name);
		if(bean != null){
			return (T) bean;
		}
		BeanDefinition beanDefinition = getBeanDefinition(name);
		return (T) createBean(name,beanDefinition,args);

	}

	protected abstract BeanDefinition getBeanDefinition(String name);
	protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args);



}
