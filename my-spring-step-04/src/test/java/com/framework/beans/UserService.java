package com.framework.beans;

public class UserService {
	private String uId;
	private UserDao userDao;

	public void query(){
		System.out.println("查询用户信息："+userDao.query(uId));
	}
	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuId() {
		return uId;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

}
