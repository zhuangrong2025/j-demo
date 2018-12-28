package com.annotation_demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by user on 2018/12/28.
 */
@Configuration
@Import({ConfigA.class, ConfigB.class})
public class ParentConfig {
}
