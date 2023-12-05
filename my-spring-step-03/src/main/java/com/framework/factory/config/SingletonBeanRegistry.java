package com.framework.factory.config;

/**
 * 单例bean注册表
 */
public interface SingletonBeanRegistry {

	/**
	 * 获取注册表中的单例对象
	 * @param name 原始单例bean的名称
	 * @return 单例bean对象
	 */
	Object getSingleton(String name);

	/**
	 * 向注册表中注册单例bean
	 * @param name bean的名称
	 * @param singletonBean bean对象
	 */
	void registrySingleton(String name,Object singletonBean);
}
