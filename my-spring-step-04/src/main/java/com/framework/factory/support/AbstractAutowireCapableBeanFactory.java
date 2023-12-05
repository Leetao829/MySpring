package com.framework.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.framework.BeansException;
import com.framework.PropertyValue;
import com.framework.PropertyValues;
import com.framework.factory.config.BeanDefinition;
import com.framework.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 实现抽象工厂中的创建bean方法，其中使用cglib创建实例
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
	private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

	@Override
	protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException {
		Object bean = null;
		try {
			bean = createBeanInstance(beanDefinition,name,args);
			//创建bean之后给属性填充
			applyPropertyValues(name,bean,beanDefinition);
		}catch (Exception e){
			throw new BeansException("Instantiation of bean failed", e);
		}
		return bean;
	}

	private void applyPropertyValues(String name, Object bean, BeanDefinition beanDefinition) {
		try {
			PropertyValues propertyValues = beanDefinition.getPropertyValues();
			for (PropertyValue propertyValue : propertyValues.getPropertyValues()){
				String beanName = propertyValue.getName();
				Object value = propertyValue.getValue();
				if(value instanceof BeanReference){
					//依赖，获取另一个对象的实例化
					BeanReference beanReference = (BeanReference) value;
					value = getBean(beanReference.getBeanName());
				}
				BeanUtil.setFieldValue(bean,beanName,value);
			}
		} catch (Exception e) {
			throw new BeansException("Error setting property values：" + name);
		}
	}

	public Object createBeanInstance(BeanDefinition beanDefinition,String name,Object[] args){
		Constructor constructorToUse = null;
		Class<?> beanClass = beanDefinition.getBeanClass();
		Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
		for (Constructor ctor : declaredConstructors) {
			if(null != args && ctor.getParameterTypes().length == args.length){
				constructorToUse = ctor;
				break;
			}
		}
		return getInstantiationStrategy().instantiation(beanDefinition,name,constructorToUse,args);
	}

	public InstantiationStrategy getInstantiationStrategy() {
		return instantiationStrategy;
	}

	public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
		this.instantiationStrategy = instantiationStrategy;
	}

}
