package com.ups.demo.dao;

import com.ups.demo.pojo.ModelSeriesKey;
import org.apache.ibatis.annotations.Select;

public interface ModelSeriesMapper {

    @Select("select * from t_model_series_relation where str_model_id = #{modelId}")
    public  ModelSeriesKey selectModelSeries(String modelId);

    int deleteByPrimaryKey(ModelSeriesKey key);

    int insert(ModelSeriesKey record);

    int insertSelective(ModelSeriesKey record);
}