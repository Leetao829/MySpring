package com.framework.factory.support;

/**
 * 单例注册接口
 * 由于beanfactory中可能需要获取单例bean，
 * 该功能由该接口的实现类进行实现
 * 工厂只需要继承该实现类，想要获取单例bean，直接从该实现类的缓存中获取即可
 */
public interface SingletonBeanRegistry {
	Object getSingleton(String beanName);

}
