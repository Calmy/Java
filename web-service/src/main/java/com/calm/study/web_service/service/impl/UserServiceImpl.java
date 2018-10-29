package com.calm.study.web_service.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.calm.study.web_service.entity.User;
import com.calm.study.web_service.service.UserService;

@Component
@WebService(serviceName = "userService" ,targetNamespace = "http://service.web_service.study.calm.com/", endpointInterface = "com.calm.study.web_service.service.UserService")
public class UserServiceImpl implements UserService {
	private Map<String, User> userMap = new HashMap<String, User>();

	public UserServiceImpl() {
		System.out.println("向实体类插入数据");
		User user = new User();
		user.setUserId("411001");
		user.setUsername("zhansan");
		user.setAge("20");
		user.setUpdateTime(new Date());
		userMap.put(user.getUserId(), user);

		user = new User();
		user.setUserId("411002");
		user.setUsername("lisi");
		user.setAge("30");
		user.setUpdateTime(new Date());
		userMap.put(user.getUserId(), user);

		user = new User();
		user.setUserId("411003");
		user.setUsername("wangwu");
		user.setAge("40");
		user.setUpdateTime(new Date());
		userMap.put(user.getUserId(), user);
	}

	
	public String getName(String userId) {
		return "calm-" + userId;
	}

	
	public User getUser(String userId) {
		User user = userMap.get(userId);
		return user;
	}

	
	public ArrayList<User> getAlLUser() {
		ArrayList<User> users = new ArrayList<User>();
		userMap.forEach((key, value) -> {
			users.add(value);
		});
		return users;
	}
	
	public static void main(String[] args) {
		String str = "com.calm.study.web_service.service";
		String[] split = str.split("\\.");
		for (int i = split.length - 1; i >= 0; i--) {
			System.out.print(split[i]+".");
		}
	}
}