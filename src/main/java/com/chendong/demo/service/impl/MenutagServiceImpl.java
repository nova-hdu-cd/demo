package com.chendong.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendong.demo.domain.entity.Menutag;
import com.chendong.demo.mapper.MenutagMapper;
import com.chendong.demo.service.IMenutagService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@Service
public class MenutagServiceImpl extends ServiceImpl<MenutagMapper, Menutag> implements IMenutagService {

}
