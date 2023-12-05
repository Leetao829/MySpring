package com.framework.beans.factory;

import com.framework.beans.BeansException;

/**
 * 获取bean的接口
 */
public interface BeanFactory {

	/**
	 * 根据无参构造器获取bean对象
	 * @param name bena的名称
	 * @return bean对象
	 * @throws BeansException 获取失败抛出异常
	 */
	Object getBean(String name) throws BeansException;

	/**
	 * 根据有参构造器获取bean对象
	 * @param name bean对象的名称
	 * @param args 构造器参数
	 * @return 返回bean对象
	 * @throws BeansException 获取失败抛出异常
	 */
	Object getBean(String name,Object... args) throws BeansException;

	/**
	 * 获取指定泛型的对象
	 * @param name bean对象名称
	 * @param requiredType 指定的泛型类型
	 * @param <T> 泛型标识
	 * @return 返回bean对向
	 * @throws BeansException 获取失败抛出异常
	 */
	<T> T getBean(String name,Class<T> requiredType) throws BeansException;

}
