package com.chendong.demo.dao;

import com.chendong.demo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author dong.chen
 */
@Repository
public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}