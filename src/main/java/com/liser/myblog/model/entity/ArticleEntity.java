package com.liser.myblog.model.entity;

import com.liser.myblog.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @description: 文章实体类
 * @author: LiMG
 * @create: 2019-08-27 17:07:08
 **/
@Data
@Entity
@Table(name = "article_info")
public class ArticleEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -8712463946093961293L;

    /**
     * 文章ID
     */
    @Id
    private String id;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章分类
     */
    private String articleType;

    /**
     * 文章内容
     */
    @Column(columnDefinition = "TEXT")
    private String articleContent;

    /**
     * 文章关键字
     */
    private String keyword;

    /**
     * 文章描述
     */
    private String description;

}
