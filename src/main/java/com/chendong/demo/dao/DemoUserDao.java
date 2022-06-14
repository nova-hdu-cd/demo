package com.chendong.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendong.demo.domain.entity.User;

/**
 * @author dong.chen
 */
@Mapper
public interface DemoUserDao extends BaseMapper<User> {}
