package com.framework.beans.factory.config;

import com.framework.beans.BeansException;

/**
 * 提供了修改新实例化bean对象的扩展点
 */
public interface BeanPostProcessor {

	/**
	 * 在bean对象执行初始化方法之前执行此方法
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	Object postProcessorBeforeInitialization(Object bean,String beanName) throws BeansException;

	/**
	 * 在bean对象执行初始化方法之后执行此方法
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	Object postProcessorAfterInitialization(Object bean,String beanName) throws BeansException;

}
