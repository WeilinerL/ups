package com.ups.demo.dao;

import com.ups.demo.pojo.CorePointTable;
import org.springframework.stereotype.Component;

@Component
public interface CorePointTableMapper {
    int deleteByPrimaryKey(Integer intCoreId);

    int insert(CorePointTable record);

    int insertSelective(CorePointTable record);

    CorePointTable selectByPrimaryKey(Integer intCoreId);

    int updateByPrimaryKeySelective(CorePointTable record);

    int updateByPrimaryKey(CorePointTable record);
}