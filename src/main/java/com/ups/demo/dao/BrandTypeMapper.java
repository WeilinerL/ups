package com.ups.demo.dao;

import com.ups.demo.pojo.BrandTypeKey;

public interface BrandTypeMapper {
    int deleteByPrimaryKey(BrandTypeKey key);

    int insert(BrandTypeKey record);

    int insertSelective(BrandTypeKey record);
}