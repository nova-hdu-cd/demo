package com.chendong.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendong.demo.mapper.entity.Content;
import com.chendong.demo.mapper.ContentMapper;
import com.chendong.demo.service.IContentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements IContentService {

}
