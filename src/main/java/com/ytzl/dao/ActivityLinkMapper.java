package com.ytzl.dao;

import com.ytzl.pojo.ActivityLink;
import com.ytzl.pojo.ActivityLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityLinkMapper {
    int countByExample(ActivityLinkExample example);

    int deleteByExample(ActivityLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityLink record);

    int insertSelective(ActivityLink record);

    List<ActivityLink> selectByExample(ActivityLinkExample example);

    ActivityLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityLink record, @Param("example") ActivityLinkExample example);

    int updateByExample(@Param("record") ActivityLink record, @Param("example") ActivityLinkExample example);

    int updateByPrimaryKeySelective(ActivityLink record);

    int updateByPrimaryKey(ActivityLink record);
}