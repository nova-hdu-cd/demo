package com.chendong.demo.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chendong.demo.BaseTest;
import com.chendong.demo.domain.entity.Article;
import com.chendong.demo.service.IArticleService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class ArticleServiceImplTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(ArticleServiceImplTest.class);

    @Resource
    private IArticleService articleService;

    @Test
    public void testArticleService() {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1);
        Article one = articleService.getOne(queryWrapper);
        log.info("[one]->{}", JSONUtil.toJsonStr(one));
    }


}