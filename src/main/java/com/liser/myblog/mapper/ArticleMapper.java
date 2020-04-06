package com.liser.myblog.mapper;

import com.liser.myblog.common.mapper.MyMapper;
import com.liser.myblog.model.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 文章mapper
 * @author: LiMG
 * @create: 2020-04-06 15:58:46
 **/
@Mapper
public interface ArticleMapper extends MyMapper<ArticleEntity> {
}
