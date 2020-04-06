package com.liser.myblog.model.entity;

import com.liser.myblog.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @description: 文章分类实体类
 * @author: LiMG
 * @create: 2020-04-06 15:53:19
 **/
@Data
@Entity
@Table(name = "article_type_info")
public class ArticleType extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5740803556064442329L;

    /**
     * 文章分类ID
     */
    @Id
    private String id;

    /**
     * 分类名称
     */
    private String name;

}
