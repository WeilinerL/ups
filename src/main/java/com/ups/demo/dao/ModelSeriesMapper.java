package com.ups.demo.dao;

import com.ups.demo.pojo.ModelSeriesKey;

public interface ModelSeriesMapper {
    int deleteByPrimaryKey(ModelSeriesKey key);

    int insert(ModelSeriesKey record);

    int insertSelective(ModelSeriesKey record);
}