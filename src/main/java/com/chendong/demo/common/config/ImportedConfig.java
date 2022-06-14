package com.chendong.demo.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.chendong.demo.domain.pojo.TestA;

/**
 * @author dong.chen
 */
@Import({TestA.class})
@Configuration
public class ImportedConfig {}
