package com.liser.myblog.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @description: 基础实体类
 * @author: LiMG
 * @create: 2020-04-06 15:53:33
 **/
@Data
@MappedSuperclass
public class BaseEntity {

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    protected String createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    protected String updateTime;


}
