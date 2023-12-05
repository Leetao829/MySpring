package com.framework.factory;

import com.framework.BeansException;

/**
 * 定义bean工厂接口
 */
public interface BeanFactory {

	/**
	 * 获取实例bean对象
	 * @param name 检索bean的名称
	 * @return bean对象
	 * @throws BeansException 无法获取对象就抛出异常
	 */
	Object getBean(String name) throws BeansException;

	/**
	 * 获取含有构造函数的bean对象
	 * @param name 检索的bean对象名称
	 * @param args 构造函数的参数
	 * @return 返回bean对象
	 * @throws BeansException 无法获取对象抛出异常
	 */
	Object getBean(String name,Object... args) throws BeansException;



}
