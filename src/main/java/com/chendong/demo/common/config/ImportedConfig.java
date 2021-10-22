package com.chendong.demo.common.config;

import com.chendong.demo.domain.pojo.TestA;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * @author dong.chen
 */
@Import({TestA.class})
@Configuration
public class ImportedConfig {
}
