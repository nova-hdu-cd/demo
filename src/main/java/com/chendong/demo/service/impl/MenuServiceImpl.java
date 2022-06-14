package com.chendong.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendong.demo.domain.entity.Menu;
import com.chendong.demo.mapper.MenuMapper;
import com.chendong.demo.service.IMenuService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
