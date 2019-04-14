package com.soni.service;

import javax.annotation.Resource;

import com.soni.entity.User;
import com.soni.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Resource
    private UserRepository userRepository;
    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
