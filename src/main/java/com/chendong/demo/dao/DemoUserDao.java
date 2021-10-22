package com.chendong.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendong.demo.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dong.chen
 */
@Mapper
public interface DemoUserDao extends BaseMapper<User> {
}
