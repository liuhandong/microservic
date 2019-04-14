package com.soni.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soni.entity.User;
import com.soni.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Resource
    private UserRepository userRepository;
    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
