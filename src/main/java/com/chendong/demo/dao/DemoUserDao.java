package com.chendong.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendong.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoUserDao extends BaseMapper<User> {
}
