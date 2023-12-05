package com.framework.context;

import com.framework.beans.BeansException;

/**
 * 接口配置应用上下文
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

	/**
	 * 刷新容器
	 * @throws BeansException
	 */
	void refresh() throws BeansException;
}
