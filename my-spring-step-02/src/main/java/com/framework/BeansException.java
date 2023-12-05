package com.framework;

/**
 * 定义bean异常，在获取bean或者其他操作中可能会使用到，
 * 直接继承运行时异常
 */
public class BeansException extends RuntimeException {
	public BeansException(String msg){
		super(msg);
	}
	public BeansException(String msg,Throwable cause){
		super(msg,cause);
	}


}
