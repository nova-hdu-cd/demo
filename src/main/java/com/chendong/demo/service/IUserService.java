package com.chendong.demo.service;

import com.chendong.demo.domain.entity.User;

/**
 * @author dong.chen
 */
public interface IUserService {

    User selectUserById(Integer id);

}
