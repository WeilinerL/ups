package com.ups.demo.dao;

import com.ups.demo.pojo.SeriesBrandKey;
import org.apache.ibatis.annotations.Select;

public interface SeriesBrandMapper {

    @Select("select * from t_series_brand_relation where str_series_id = #{seriesId}")
    public SeriesBrandKey selectSeriesBrand(String seriesId);

    int deleteByPrimaryKey(SeriesBrandKey key);

    int insert(SeriesBrandKey record);

    int insertSelective(SeriesBrandKey record);
}