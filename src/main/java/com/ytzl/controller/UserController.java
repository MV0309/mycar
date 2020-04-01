package com.ytzl.controller;

import com.ytzl.dto.DataGridResult;
import com.ytzl.dto.QueryDTO;
import com.ytzl.dto.UserDTO;
import com.ytzl.service.SysUserService;
import com.ytzl.utils.R;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class UserController {
    @Autowired
    private SysUserService sysUserService;
    @PostMapping("/sys/login")
    @ResponseBody
    public R login(@RequestBody UserDTO userDTO){
        System.out.println(userDTO.getUsername());
        System.out.println(userDTO.getPassword());
        System.out.println(userDTO.getCaptcha());
        return R.ok();
    }

  /*查询全部用户*/
    @RequestMapping("/sys/user/list")
    @ResponseBody
    public DataGridResult findUser(QueryDTO queryDTO){
        return sysUserService.findUserBypage(queryDTO);
    }
     /*导出*/
    @RequestMapping("/sys/user/export")
    public void exportUser(HttpServletResponse response){
        Workbook workbook = sysUserService.exportUser();
        try {
            //设置响应头
            response.setContentType("application/octet-stream");//所有文件都支持
            String fileName = "员工信息.xls";
            fileName = URLEncoder.encode(fileName,"utf-8");
            response.setHeader("content-disposition","attachment;filename="+fileName);
            //文件下载
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
