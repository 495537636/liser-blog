package com.loving.myblog.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author: LiMG
 * @create: 2019-08-27 17:07:08
 **/
@Data
@Entity
@Table(name = "test_info")
public class TestEntity {

    @Id
    private String id;

    private String name;

    private String description;

}
