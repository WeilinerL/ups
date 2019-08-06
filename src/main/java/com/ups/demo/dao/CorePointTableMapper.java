package com.ups.demo.dao;

import com.ups.demo.pojo.CorePointTable;
import org.springframework.stereotype.Component;

@Component
public interface CorePointTableMapper {
    int insert(CorePointTable record);

    int insertSelective(CorePointTable record);
}