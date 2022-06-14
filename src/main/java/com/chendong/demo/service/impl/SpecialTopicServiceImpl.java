package com.chendong.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendong.demo.domain.entity.SpecialTopic;
import com.chendong.demo.mapper.SpecialTopicMapper;
import com.chendong.demo.service.ISpecialTopicService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@Service
public class SpecialTopicServiceImpl extends ServiceImpl<SpecialTopicMapper, SpecialTopic>
    implements ISpecialTopicService {

}
