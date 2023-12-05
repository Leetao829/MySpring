package com.framework.factory.config;

import com.framework.factory.support.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现获取单例bean的接口，直接从缓存中读取
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	private Map<String,Object> singletonObjects = new HashMap<>();

	@Override
	public Object getSingleton(String beanName) {
		return singletonObjects.get(beanName);
	}
	protected void addSingleton(String beanName,Object singletonObject){
		singletonObjects.put(beanName,singletonObject);
	}


}
