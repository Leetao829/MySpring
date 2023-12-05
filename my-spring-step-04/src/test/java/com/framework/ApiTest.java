package com.framework;

import com.framework.beans.UserDao;
import com.framework.beans.UserService;
import com.framework.factory.config.BeanDefinition;
import com.framework.factory.config.BeanReference;
import com.framework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {
	@Test
	public void test(){
		//注册UserDao的信息
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.registryBeanDefinition("userDao",new BeanDefinition(UserDao.class));
		//获取注册并获取UserService对象，注册并设置属性值
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("uId","1001"));
		propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
		//将userService注册到bean中
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
		beanFactory.registryBeanDefinition("userService",beanDefinition);
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.query();
	}


}
