package com.framework.beans.factory.support;

import com.framework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用注册表的实现
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	private Map<String,Object> singletonObjects = new HashMap<>();

	@Override
	public Object getSingleton(String beanName) {
		return this.singletonObjects.get(beanName);
	}

	@Override
	public void registerSingleton(String beanName, Object singletonObject) {
		this.singletonObjects.put(beanName,singletonObject);
	}

}
