package com.framework.beans.factory.config;

import com.framework.beans.BeansException;
import com.framework.beans.factory.BeanFactory;

/**
 * 实现自动装配的bean工厂
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

	/**
	 * 执行BeanPostProcessor的before方法
	 *
	 * @param existingBean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

	/**
	 * 执行BeanPostProcessor的after方法
	 * @param existingBean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	Object applyBeanPostProcessorsAfterInitialization(Object existingBean,String beanName) throws BeansException;
}
