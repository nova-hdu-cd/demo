package com.chendong.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chendong.demo.domain.entity.User;
import com.chendong.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User selectUserById(Integer id) {

        return null;
    }
}
