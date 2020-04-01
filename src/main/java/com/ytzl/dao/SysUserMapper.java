package com.ytzl.dao;

import com.ytzl.dto.QueryDTO;
import com.ytzl.pojo.SysUser;
import com.ytzl.pojo.SysUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> selectAll();

    /*查询全部用户*/
    List<SysUser> findByPage(QueryDTO queryDTO);

    /*导出*/
    List<Map<String,Object>> exportUser();

   /*根据用户名查询用户信息*/
    SysUser findByUsername(String username);


}