package com.chendong.demo.service;

import com.chendong.demo.entity.User;

/**
 * @author dong.chen
 */
public interface IUserService {

    User selectUserById(Integer id);

}