package com.framework.beans.factory.config;

/**
 * 单例bean注册表
 */
public interface SingletonBeanRegistry {

	/**
	 * 获取注册表中的单例对象
	 * @param beanName bean对象名称
	 * @return 返回单例对象
	 */
	Object getSingleton(String beanName);

	/**
	 * 将单例对象注册到注册表中
	 * @param beanName bean对象名称
	 * @param singletonObject 单例对象
	 */
	void registerSingleton(String beanName,Object singletonObject);

}
