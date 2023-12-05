package com.framework;

/**
 * 定义异常
 */
public class BeansException extends RuntimeException{
	public BeansException(String msg){
		super(msg);
	}
	public BeansException(String msg,Throwable x){
		super(msg,x);
	}

}
