package com.soni.service;

import com.soni.entity.User;

public interface UserService {
	User findByUserName(String userName);
}
