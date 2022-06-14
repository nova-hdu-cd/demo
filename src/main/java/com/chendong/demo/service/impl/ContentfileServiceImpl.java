package com.chendong.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendong.demo.domain.entity.Contentfile;
import com.chendong.demo.mapper.ContentfileMapper;
import com.chendong.demo.service.IContentfileService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@Service
public class ContentfileServiceImpl extends ServiceImpl<ContentfileMapper, Contentfile> implements IContentfileService {

}
