package com.cafe.killer.cafe_mall.service;

import com.cafe.killer.cafe_mall.mbg.model.UmsAdmin;
import com.cafe.killer.cafe_mall.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员 Service
 * @author Coffee_Killer
 * */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     * */
    UmsAdmin genAdminByUsername(String username);

    /**
     * 后台管理员 注册功能
     * */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 后台管理员 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的 jwt token
     * */
    String login(String username, String password);

    /**
     * 获取用户所有权限 (包括角色权限 和 增删 权限)
     * */
    List<UmsPermission> getPermissionList(Long adminId);

}
