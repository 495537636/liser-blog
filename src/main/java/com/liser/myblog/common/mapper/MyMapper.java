package com.liser.myblog.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <p>Description 公共Mapper </p>
 * <p>Company: http://www.uinnova.cn/ </p>
 * 此Mapper不能和其他Mapper放在同一目录，否则会出错
 * @author LiMG
 * @Date 2018/3/28 11:34
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}

