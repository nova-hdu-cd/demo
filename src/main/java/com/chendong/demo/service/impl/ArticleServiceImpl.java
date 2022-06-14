package com.chendong.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendong.demo.domain.entity.Article;
import com.chendong.demo.mapper.ArticleMapper;
import com.chendong.demo.service.IArticleService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
