package com.framework.test.bean;

public class UserService {

	private String uId;

	private UserDao userDao;

	public String queryUserInfo() {
		return userDao.queryUserName(uId);
	}

	// ...get/set
}
