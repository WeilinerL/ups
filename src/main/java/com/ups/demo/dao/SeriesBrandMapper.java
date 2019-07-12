package com.ups.demo.dao;

import com.ups.demo.pojo.SeriesBrandKey;

public interface SeriesBrandMapper {
    int deleteByPrimaryKey(SeriesBrandKey key);

    int insert(SeriesBrandKey record);

    int insertSelective(SeriesBrandKey record);
}