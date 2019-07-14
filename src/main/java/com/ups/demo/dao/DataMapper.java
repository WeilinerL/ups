package com.ups.demo.dao;

import com.ups.demo.pojo.Data;
import org.apache.ibatis.annotations.Select;

import static org.apache.el.parser.ELParserConstants.CONCAT;

public interface DataMapper {

    @Select("select * from t_data where str_read_time like #{time} OR str_read_time like #{time1} OR str_read_time like #{time2} OR str_read_time like #{time3} OR str_read_time like #{time4} OR str_read_time like #{time5} OR str_read_time like #{time6} " +
            "or str_read_time like #{time7} OR str_read_time like #{time8} OR str_read_time like #{time9} OR str_read_time like #{time10}")
    public Data selectByTime(String time, String time1, String time2, String time3, String time4, String time5,
                             String time6, String time7, String time8, String time9, String time10);

    int deleteByPrimaryKey(String strReadTime);

    int insert(Data record);

    int insertSelective(Data record);

    Data selectByPrimaryKey(String strReadTime);

    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKey(Data record);
}