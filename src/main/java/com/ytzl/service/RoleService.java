package com.ytzl.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {


    List<String> findRolsByUserID(Long userId);
}
