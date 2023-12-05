package com.framework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.framework.beans.BeansException;
import com.framework.beans.PropertyValue;
import com.framework.beans.PropertyValues;
import com.framework.beans.factory.config.AutowireCapableBeanFactory;
import com.framework.beans.factory.config.BeanDefinition;
import com.framework.beans.factory.config.BeanPostProcessor;
import com.framework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {
	private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
		Object bean = null;
		try {
			bean = createBeanInstance(beanDefinition, beanName, args);
			// 给 Bean 填充属性
			applyPropertyValues(beanName, bean, beanDefinition);
			//执行bean的初始化方法以及执行BeanPostProcessor的前置和后置方法
			bean = initializeBean(beanName,bean,beanDefinition);
		} catch (Exception e) {
			throw new BeansException("Instantiation of bean failed", e);
		}

		registerSingleton(beanName, bean);
		return bean;
	}

	private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
		//执行BeanPostProcessor的Before处理，就是在bean初始化之前进行处理
		Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

		//等待完成内容：执行初始化方法
		invokeInitMethods(beanName,wrappedBean,beanDefinition);

		//执行BeanPostProcessor的After处理，就是在bean初始化之后进行处理
		wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
		return wrappedBean;
	}

	private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

	}

	private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
		try {
			PropertyValues propertyValues = beanDefinition.getPropertyValues();
			for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

				String name = propertyValue.getName();
				Object value = propertyValue.getValue();

				if (value instanceof BeanReference) {
					// A 依赖 B，获取 B 的实例化
					BeanReference beanReference = (BeanReference) value;
					value = getBean(beanReference.getBeanName());
				}
				// 属性填充
				BeanUtil.setFieldValue(bean, name, value);
			}
		} catch (Exception e) {
			throw new BeansException("Error setting property values：" + beanName);
		}
	}

	protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
		Constructor constructorToUse = null;
		Class<?> beanClass = beanDefinition.getBeanClass();
		Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
		for (Constructor ctor : declaredConstructors) {
			if (null != args && ctor.getParameterTypes().length == args.length) {
				constructorToUse = ctor;
				break;
			}
		}
		return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
	}

	public InstantiationStrategy getInstantiationStrategy() {
		return instantiationStrategy;
	}

	public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
		this.instantiationStrategy = instantiationStrategy;
	}

	@Override
	public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
		Object result = existingBean;
		for(BeanPostProcessor beanPostProcessor : getBeanPostProcessors()){
			Object current = beanPostProcessor.postProcessorBeforeInitialization(result,beanName);
			if(null == current) return result;
			result = current;
		}
		return result;
	}
	@Override
	public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
		Object result = existingBean;
		for(BeanPostProcessor beanPostProcessor : getBeanPostProcessors()){
			Object current = beanPostProcessor.postProcessorAfterInitialization(result, beanName);
			if(null == current) return result;
			result = current;
		}
		return result;
	}



}
