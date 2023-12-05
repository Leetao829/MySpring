package com.framework.test;

public class UserService {
	private String name;
	public UserService(String name){
		this.name = name;
	}
	public void query(){
		System.out.println("正在查询用户信息");
	}

	@Override
	public String toString() {
		return "UserService{" +
				"name='" + name + '\'' +
				'}';
	}

}
