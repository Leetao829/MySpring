package com.framework.test;

import com.framework.bean.UserService;
import com.framework.factory.support.BeanDefinition;
import com.framework.factory.config.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {
	@Test
	public void testApi(){
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
		factory.registryBeanDefinition("userService",beanDefinition);
		UserService userService = (UserService) factory.getBean("userService");
		userService.query();
		factory.getBean("userService");
		userService.query();
	}

}
