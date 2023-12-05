package com.framework.factory.support;

import com.framework.BeansException;
import com.framework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实现抽象工厂中的创建bean方法，其中使用cglib创建实例
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
	private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

	@Override
	protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException {
		Object bean = null;
		try {
			bean = createBeanInstance(beanDefinition,name,args);
		}catch (Exception e){
			throw new BeansException("Instantiation of bean failed", e);
		}
		return bean;
	}

	public Object createBeanInstance(BeanDefinition beanDefinition,String name,Object[] args){
		Constructor constructorToUse = null;
		Class<?> beanClass = beanDefinition.getBeanClass();
		Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
		for (Constructor ctor : declaredConstructors) {
			if(null != args && ctor.getParameterTypes().length == args.length){
				constructorToUse = ctor;
				break;
			}
		}
		return getInstantiationStrategy().instantiation(beanDefinition,name,constructorToUse,args);
	}

	public InstantiationStrategy getInstantiationStrategy() {
		return instantiationStrategy;
	}

	public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
		this.instantiationStrategy = instantiationStrategy;
	}

}
