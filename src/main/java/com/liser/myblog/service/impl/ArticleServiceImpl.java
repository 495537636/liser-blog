package com.liser.myblog.service.impl;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.liser.myblog.mapper.ArticleMapper;
import com.liser.myblog.model.dto.ArticleQueryDTO;
import com.liser.myblog.model.dto.ArticleSaveDTO;
import com.liser.myblog.model.entity.ArticleEntity;
import com.liser.myblog.service.IArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 文章接口实现类
 * @author: LiMG
 * @create: 2020-04-06 21:11:53
 **/
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 保存文章
     * @param articleSaveDTO
     * @return
     */
    @Override
    public Boolean saveArticleInfo(ArticleSaveDTO articleSaveDTO) {
        ArticleEntity article = new ArticleEntity();
        BeanUtils.copyProperties(articleSaveDTO, article);
        int result = articleMapper.insert(article);
        if (result > 0) {
            return true;
        }
        return false;
    }

    /**
     * 删除文章
     * @param id
     * @return
     */
    @Override
    public Boolean deleteArticleById(String id) {
        int result = articleMapper.deleteByPrimaryKey(id);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取文章列表
     * @param articleQueryDTO
     * @return
     */
    @Override
    public List<ArticleEntity> getArticleList(ArticleQueryDTO articleQueryDTO) {
        return null;
    }

    /**
     * 获取文章详情
     * @param id
     * @return
     */
    @Cached(name = "article",key = "#id",expire = 300,cacheType = CacheType.LOCAL)
    @Override
    public ArticleEntity getArticleInfo(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
