package com.framework.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据层，能够访问数据
 */
public class UserDao {
	private static Map<String,String> map = new HashMap<>();
	static {
		map.put("1001","张三");
		map.put("1002","李四");
		map.put("1003","王五");
	}
	public String query(String uId){
		return map.get(uId);
	}

}
