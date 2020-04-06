package com.liser.myblog.config;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 缓存配置
 * @author: LiMG
 * @create: 2020-04-07 00:04:51
 **/
@Configuration
@EnableMethodCache(basePackages = "com.liser.myblog")
@EnableCreateCacheAnnotation
public class JetcacheConfig {
}
