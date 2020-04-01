package com.ytzl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ytzl.dao.SysMenuMapper;
import com.ytzl.dto.DataGridResult;
import com.ytzl.dto.QueryDTO;
import com.ytzl.pojo.SysMenu;
import com.ytzl.service.MenuService;
import com.ytzl.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public DataGridResult findMenu(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        if(queryDTO.getSort()!=null&&!queryDTO.getSort().equals("")){
            queryDTO.setSort("menu_id");
        }
        List<SysMenu> menuByPage = sysMenuMapper.findMenuByPage(queryDTO);
        PageInfo<SysMenu> info = new PageInfo<SysMenu>(menuByPage);
        long total = info.getTotal();

        DataGridResult result = new DataGridResult(total,info.getList());
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public R deleteMenu(List<Long> ids) {
        for (Long id : ids) {
            if(id<51){
                return R.error("系统菜单，不支持删除");
            }
        }
      int i=  sysMenuMapper.deleteMenu(ids);
      if (i>0){
          return R.ok();
      }else {
          return R.error(-200,"删除失败");
      }

    }

    @Override
    public R selectMenu() {
        List<SysMenu> menu=sysMenuMapper.findMenu();
        /*添加根目录*/
        SysMenu sysMenu=new SysMenu();
        sysMenu.setMenuId(0L);
        sysMenu.setType(0);
        sysMenu.setParentId(-1L);
        sysMenu.setName("一级菜单");
        menu.add(sysMenu);
        return R.ok().put("menuList",menu);
    }

    @Override
    public R saveMenu(SysMenu sysMenu) {
        int i=sysMenuMapper.insertSelective(sysMenu);
        return i>0?R.ok():R.error("新增失败");
    }

    @Override
    public R findMenuById(Long menuId) {
        SysMenu sysMenu=sysMenuMapper.selectByPrimaryKey(menuId);
        return R.ok().put("menu",sysMenu);
    }

    @Override
    public R updateMenu(SysMenu sysMenu) {
        int i=sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
        return i>0?R.ok():R.error("修改失败");
    }
    /*根据用户ID查询用户的菜单权限*/
    @Override
    public List<String> findPermsByUserId(Long userId) {
        List<String> permsByUserId = sysMenuMapper.findPermsByUserId(userId);
        Set<String> set = new HashSet<String>();
        for (String s : permsByUserId) {
            if(s!=null&&!s.equals("")){
                String[] split = s.split(",");
                for (String s1 : split) {
                    set.add(s1);
                }
            }
        }
        List<String> perms = new ArrayList<>();
        perms.addAll(set);
        return perms;
    }
}
