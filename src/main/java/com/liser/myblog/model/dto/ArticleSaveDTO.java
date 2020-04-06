package com.liser.myblog.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 文章保存DTO
 * @author: LiMG
 * @create: 2020-04-06 21:03:20
 **/
@Data
@ApiModel("文章保存DTO")
public class ArticleSaveDTO implements Serializable {

    private static final long serialVersionUID = -7703014895090978186L;

    /**
     * 文章ID
     */
    @ApiModelProperty("文章ID")
    private String id;

    /**
     * 文章分类
     */
    @ApiModelProperty("文章分类")
    private String articleType;

    /**
     * 文章内容
     */
    @ApiModelProperty("文章内容")
    private String articleContent;

    /**
     * 文章关键字
     */
    @ApiModelProperty("文章关键字")
    private String keyword;

    /**
     * 文章描述
     */
    @ApiModelProperty("文章描述")
    private String description;

}
