package com.framework.factory;

import com.framework.BeansException;

/**
 * bean工厂，使用工厂模式，使用bean工厂，在该工厂中能够获取bean
 */
public interface BeanFactory {
	Object getBean(String beanName) throws BeansException;

}
