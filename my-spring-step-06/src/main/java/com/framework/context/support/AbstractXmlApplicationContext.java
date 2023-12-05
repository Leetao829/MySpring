package com.framework.context.support;

import com.framework.beans.factory.support.DefaultListableBeanFactory;
import com.framework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 使用XmlBeanDefinitionReader加载bean定义
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

	@Override
	protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
		String[] configLocations = getConfigLocations();
		if(null != configLocations){
			beanDefinitionReader.loadBeanDefinitions(configLocations);
		}
	}

	protected abstract String[] getConfigLocations();

}
