package com.liser.myblog.model.dto;

import java.io.Serializable;

/**
 * @description: 文章查询DTO
 * @author: LiMG
 * @create: 2020-04-06 21:08:57
 **/
public class ArticleQueryDTO implements Serializable {

    private static final long serialVersionUID = -239871672655856178L;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 文章分类
     */
    private String articleType;

}
