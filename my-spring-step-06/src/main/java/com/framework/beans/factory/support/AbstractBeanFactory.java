package com.framework.beans.factory.support;

import com.framework.beans.BeansException;
import com.framework.beans.factory.BeanFactory;
import com.framework.beans.factory.config.BeanDefinition;
import com.framework.beans.factory.config.BeanPostProcessor;
import com.framework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/*
定义模板方法，实现获取bean的方式
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

	private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
	@Override
	public Object getBean(String name) throws BeansException {
		return doGetBean(name,null);
	}

	@Override
	public Object getBean(String name, Object... args) throws BeansException {
		return doGetBean(name,args);
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		return (T)getBean(name);
	}
	protected  <T> T doGetBean(final String name,final Object[] args){
		Object bean = getSingleton(name);
		if(bean != null) return (T) bean;
		BeanDefinition beanDefinition = getBeanDefinition(name);
		return (T) createBean(name,beanDefinition,args);
	}
	protected abstract BeanDefinition getBeanDefinition(String beanName);
	protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args);

	@Override
	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
		beanPostProcessors.remove(beanPostProcessor);
		beanPostProcessors.add(beanPostProcessor);
	}

	public List<BeanPostProcessor> getBeanPostProcessors() {
		return this.beanPostProcessors;
	}

}
