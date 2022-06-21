package com.chendong.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendong.demo.domain.entity.User;

@Mapper
public interface DemoUserMapper extends BaseMapper<User> {}
