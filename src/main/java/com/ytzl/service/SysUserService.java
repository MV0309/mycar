package com.ytzl.service;

import com.ytzl.dto.DataGridResult;
import com.ytzl.dto.QueryDTO;
import com.ytzl.pojo.SysUser;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface SysUserService {
  public List<SysUser> findAll();
  /*查询全部用户*/
   DataGridResult findUserBypage(QueryDTO queryDTO);
  /*导出*/
   Workbook exportUser();
  /*根据用户名查询用户信息*/
  SysUser findByUsername(String username);
}
