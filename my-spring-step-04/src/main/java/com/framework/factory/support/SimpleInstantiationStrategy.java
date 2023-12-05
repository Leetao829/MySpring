package com.framework.factory.support;

import com.framework.BeansException;
import com.framework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用jdk实现简单的实例化bean接口
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

	@Override
	public Object instantiation(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
		Class clazz = beanDefinition.getBeanClass();
		try {
			if(null != ctor){
				return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
			}else {
				return clazz.getDeclaredConstructor().newInstance();
			}

		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
		}
	}

}
