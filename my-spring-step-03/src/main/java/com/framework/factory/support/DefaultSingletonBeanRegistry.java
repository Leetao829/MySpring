package com.framework.factory.support;

import com.framework.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认注册表的实现
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	private Map<String,Object> singletonObjects = new HashMap<>();
	@Override
	public Object getSingleton(String name) {
		return singletonObjects.get(name);
	}

	@Override
	public void registrySingleton(String name, Object singletonBean) {
		singletonObjects.put(name,singletonBean);
	}

}
