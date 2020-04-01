package com.ytzl.controller;

import com.ytzl.pojo.SysUser;
import com.ytzl.service.SysUserService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SysUserController {
    @Autowired

    private SysUserService sysUserService;
    @ApiOperation(value = "findAll",notes = "sysuer表中数据")
    @GetMapping("/findAll")
    @ResponseBody
    public List<SysUser> findAll(){
        return sysUserService.findAll();
    }


}
