package com.framework;

/**
 * 在实例化的过程中需要注入属性和依赖对象
 */
public class PropertyValue {
	//属性名称
	private final String name;

	//属性值
	private final Object value;

	public PropertyValue(String name,Object value){
		this.name = name;
		this.value =value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

}
