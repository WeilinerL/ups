package com.ups.demo.dao;

import com.ups.demo.pojo.CorePointTable;

public interface CorePointTableMapper {
    int deleteByPrimaryKey(String strCoreId);

    int insert(CorePointTable record);

    int insertSelective(CorePointTable record);

    CorePointTable selectByPrimaryKey(String strCoreId);

    int updateByPrimaryKeySelective(CorePointTable record);

    int updateByPrimaryKey(CorePointTable record);
}