package com.ups.demo.dao;

import com.ups.demo.pojo.BrandTypeKey;
import org.apache.ibatis.annotations.Select;

public interface BrandTypeMapper {

    @Select("select * from t_brand_type_relation where str_brand_id = #{brandId}")
    public BrandTypeKey selectBrandType(String brandId);

    int deleteByPrimaryKey(BrandTypeKey key);

    int insert(BrandTypeKey record);

    int insertSelective(BrandTypeKey record);
}