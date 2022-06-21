
package com.chendong.demo.dao;

import org.springframework.stereotype.Repository;

import com.chendong.demo.domain.entity.User;

/**
 * @author dong.chen
 */
@Repository
public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
}