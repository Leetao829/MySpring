package com.framework.context.support;

import com.framework.beans.BeansException;
import com.framework.beans.factory.ConfigurableListableBeanFactory;
import com.framework.beans.factory.config.BeanFactoryPostProcessor;
import com.framework.beans.factory.config.BeanPostProcessor;
import com.framework.context.ConfigurableApplicationContext;
import com.framework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * 抽象应用上下文，其中定义了模板方法，其中的抽象方法交给子类进行实现
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
	@Override
	public void refresh() throws BeansException {
		//1.创建bean工厂，并加载BeanDefinition
		refreshBeanFactory();
		//获取bean工厂
		ConfigurableListableBeanFactory beanFactory = getBeanFactory();
		//在bean实例化之前，执行BeanFactoryProcessor
		invokeBeanFactoryPostProcessors(beanFactory);

		//BeanPostProcessor需要在其他bean对象实例化之前进行注册
		registerBeanPostProcessors(beanFactory);

		//提前实例化单例对象
		beanFactory.preInstantiateSingletons();

	}



	protected abstract void refreshBeanFactory();
	protected abstract ConfigurableListableBeanFactory getBeanFactory();

	private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
		Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
		for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
			beanFactoryPostProcessor.postProcessorBeanFactory(beanFactory);
		}
	}
	private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
		Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
		for(BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()){
			beanFactory.addBeanPostProcessor(beanPostProcessor);
		}
	}

	@Override
	public Object getBean(String name) throws BeansException {
		return getBeanFactory().getBean(name);
	}

	@Override
	public Object getBean(String name, Object... args) throws BeansException {
		return getBeanFactory().getBean(name,args);
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		return getBeanFactory().getBean(name,requiredType);
	}

	@Override
	public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
		return getBeanFactory().getBeansOfType(type);
	}

	@Override
	public String[] getBeanDefinitionNames() {
		return getBeanFactory().getBeanDefinitionNames();
	}

}
