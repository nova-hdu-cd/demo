package com.chendong.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendong.demo.mapper.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoUserMapper extends BaseMapper<User> {
}
