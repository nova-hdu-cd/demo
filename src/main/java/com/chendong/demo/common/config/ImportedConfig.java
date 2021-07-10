package com.chendong.demo.common.config;

import com.chendong.demo.common.pojo.TestA;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({TestA.class})
@Configuration
public class ImportedConfig {
}
