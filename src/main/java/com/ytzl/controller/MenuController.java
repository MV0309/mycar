package com.ytzl.controller;

import com.ytzl.dto.DataGridResult;
import com.ytzl.dto.QueryDTO;
import com.ytzl.pojo.SysMenu;
import com.ytzl.service.MenuService;
import com.ytzl.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping("/sys/menu/list")
    @ResponseBody
    public DataGridResult finndMenu(QueryDTO queryDTO){
        return menuService.findMenu(queryDTO);
    }
    /*批量删除*/
    @PostMapping("/sys/menu/del")
    @ResponseBody
    public R deleteMenu(@RequestBody List<Long> ids){
        return menuService.deleteMenu(ids);
    }
    /*查询菜单*/
    @GetMapping("/sys/menu/select")
    @ResponseBody
    public R selectMenu(){
        return menuService.selectMenu();
    }

    /*新增菜单*/
    @PostMapping("/sys/menu/save")
    @ResponseBody
    public R saveMenu(@RequestBody SysMenu sysMenu){
        return menuService.saveMenu(sysMenu);
    }
    /*查询菜单*/
    @RequestMapping("/sys/menu/info/{menuId}")
    @ResponseBody
    public R findMenuById(@PathVariable("menuId") Long menuId){
        return menuService.findMenuById(menuId);
    }

    /*修改菜单*/
    @PostMapping("/sys/menu/update")
    @ResponseBody
    public R updateMenu(@RequestBody SysMenu sysMenu){
        return menuService.updateMenu(sysMenu);
    }

}
