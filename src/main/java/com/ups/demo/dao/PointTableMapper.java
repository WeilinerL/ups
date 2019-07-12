package com.ups.demo.dao;

import com.ups.demo.pojo.PointTable;

public interface PointTableMapper {
    int deleteByPrimaryKey(String strTableId);

    int insert(PointTable record);

    int insertSelective(PointTable record);

    PointTable selectByPrimaryKey(String strTableId);

    int updateByPrimaryKeySelective(PointTable record);

    int updateByPrimaryKey(PointTable record);
}