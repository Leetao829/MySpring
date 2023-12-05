package com.framework.context.support;

import com.framework.beans.BeansException;
import com.framework.beans.factory.support.DefaultListableBeanFactory;

/**
 * 实现对ListableBeanFactory的实例化以及对BeanDefinition的资源配置的加载
 * 在加载完成之后就可以完成对spring.xml中bean对象的定义和注册
 * 同时也实现BeanFactoryPostProcessor和BeanPostProcessor的配置bean信息
 * 其中loadBeanDefinitions定义成为抽象方法
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

	private DefaultListableBeanFactory beanFactory;
	@Override
	protected void refreshBeanFactory() throws BeansException {
		//创建bean工厂
		DefaultListableBeanFactory beanFactory = createBeanFactory();
		//加载beanDefinitions
		loadBeanDefinitions(beanFactory);
		this.beanFactory = beanFactory;

	}

	protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

	private DefaultListableBeanFactory createBeanFactory() {
		return new DefaultListableBeanFactory();
	}

	@Override
	public DefaultListableBeanFactory getBeanFactory() {
		return beanFactory;
	}

}
