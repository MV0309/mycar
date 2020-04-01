package com.ytzl.service;

import com.ytzl.dto.DataGridResult;
import com.ytzl.dto.QueryDTO;
import com.ytzl.pojo.SysMenu;
import com.ytzl.utils.R;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {
    public DataGridResult  findMenu(QueryDTO queryDTO);
    /*批量删除*/
    public R deleteMenu(List<Long> ids);

    /*查询菜单*/
    public R selectMenu();

    /*新增菜单*/
    public R saveMenu(SysMenu sysMenu);

    /*查询菜单*/
    public R findMenuById(Long menuId);

    /*修改菜单*/
    public R updateMenu(SysMenu sysMenu);

    /*根据用户ID查询用户的菜单权限*/
    List<String> findPermsByUserId( Long userId);

}
