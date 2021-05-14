package com.chendong.demo.core;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendong.demo.core.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
