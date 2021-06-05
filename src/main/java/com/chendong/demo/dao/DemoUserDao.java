package com.chendong.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendong.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoUserDao extends BaseMapper<User> {
}
