package com.chendong.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendong.demo.domain.entity.Section;
import com.chendong.demo.mapper.SectionMapper;
import com.chendong.demo.service.ISectionService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@Service
public class SectionServiceImpl extends ServiceImpl<SectionMapper, Section> implements ISectionService {

}
