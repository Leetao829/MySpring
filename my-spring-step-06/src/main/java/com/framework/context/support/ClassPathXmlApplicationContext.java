package com.framework.context.support;

/**
 * 提供给用户的应用上下文使用类
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
	private String[] configLocations;

	public ClassPathXmlApplicationContext(){}

	public ClassPathXmlApplicationContext(String[] configLocations){
		this.configLocations = configLocations;
		refresh();
	}
	public ClassPathXmlApplicationContext(String configLocation){
		this(new String[]{configLocation});
	}
	@Override
	protected String[] getConfigLocations() {
		return configLocations;
	}



}
