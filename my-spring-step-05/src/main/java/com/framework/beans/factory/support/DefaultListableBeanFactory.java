package com.framework.beans.factory.support;

import com.framework.beans.BeansException;
import com.framework.beans.factory.ConfigurableListableBeanFactory;
import com.framework.beans.factory.config.BeanDefinition;
import java.util.*;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

	private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();
	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName,beanDefinition);
	}

	@Override
	public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if(beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
		return beanDefinition;
	}

	@Override
	public boolean containsBeanDefinition(String beanName) {
		return beanDefinitionMap.containsKey(beanName);
	}

	@Override
	public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
		Map<String,T> res = new HashMap<>();
		beanDefinitionMap.forEach((beanName,beanDefinition)->{
			Class beanClass = beanDefinition.getBeanClass();
			if(type.isAssignableFrom(beanClass)){
				res.put(beanName,(T)getBean(beanName));
			}
		});
		return res;
	}

	@Override
	public String[] getBeanDefinitionNames() {
		return beanDefinitionMap.keySet().toArray(new String[0]);
	}

}
