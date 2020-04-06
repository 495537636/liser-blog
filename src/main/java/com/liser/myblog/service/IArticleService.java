package com.liser.myblog.service;

import com.liser.myblog.model.dto.ArticleQueryDTO;
import com.liser.myblog.model.dto.ArticleSaveDTO;
import com.liser.myblog.model.entity.ArticleEntity;

import java.util.List;

/**
 * @description: 文章相关接口
 * @author: LiMG
 * @create: 2020-04-06 21:02:12
 **/
public interface IArticleService {

    /**
     * 保存文章
     * @param articleSaveDTO
     * @return
     */
    Boolean saveArticleInfo(ArticleSaveDTO articleSaveDTO);

    /**
     * 删除文章
     */
    Boolean deleteArticleById(String id);

    /**
     * 查询文章列表
     */
    List<ArticleEntity> getArticleList(ArticleQueryDTO articleQueryDTO);

    /**
     * 获取文章详细信息
     */
    ArticleEntity getArticleInfo(String id);

}
