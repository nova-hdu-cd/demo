package com.chendong.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendong.demo.domain.entity.Journal;
import com.chendong.demo.mapper.JournalMapper;
import com.chendong.demo.service.IJournalService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@Service
public class JournalServiceImpl extends ServiceImpl<JournalMapper, Journal> implements IJournalService {

}
