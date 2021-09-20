
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