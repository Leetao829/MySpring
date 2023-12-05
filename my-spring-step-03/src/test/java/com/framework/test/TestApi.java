package com.framework.test;

import com.framework.factory.config.BeanDefinition;
import com.framework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class TestApi {
	@Test
	public void test01(){
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
		factory.registryBeanDefinition("userService",beanDefinition);
		UserService userService = (UserService) factory.getBean("userService", "user1");
		userService.query();
	}

}
