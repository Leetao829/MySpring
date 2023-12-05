package com.springframwork;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 将bean定义注册在map中,map中存放了bean的定义信息
 */
public class BeanFactory {
	//使用线程安全的map，可能会由多个线程同时操作这个变量
	private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	//根据名称获取bean
	public Object getBean(String name){
		return beanDefinitionMap.get(name).getBean();
	}
	//注册bean
	public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
		beanDefinitionMap.put(name,beanDefinition);
	}
}
