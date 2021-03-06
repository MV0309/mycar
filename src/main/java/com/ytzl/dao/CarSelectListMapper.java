package com.ytzl.dao;

import com.ytzl.pojo.CarSelectList;
import com.ytzl.pojo.CarSelectListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarSelectListMapper {
    int countByExample(CarSelectListExample example);

    int deleteByExample(CarSelectListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarSelectList record);

    int insertSelective(CarSelectList record);

    List<CarSelectList> selectByExample(CarSelectListExample example);

    CarSelectList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarSelectList record, @Param("example") CarSelectListExample example);

    int updateByExample(@Param("record") CarSelectList record, @Param("example") CarSelectListExample example);

    int updateByPrimaryKeySelective(CarSelectList record);

    int updateByPrimaryKey(CarSelectList record);
}