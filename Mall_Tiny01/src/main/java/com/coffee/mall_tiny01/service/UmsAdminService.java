package com.coffee.mall_tiny01.service;

import com.coffee.mall_tiny01.mbg.model.UmsAdmin;
import com.coffee.mall_tiny01.mbg.model.UmsAdminExample;
import com.coffee.mall_tiny01.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员service
 * */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     * */
    UmsAdmin getAnimeByUsername(String username);

    /**
     * 注册功能
     **/
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     * */
    String login(String username, String password);
    
    /**
     * 获取所有用户的权限(包含角色权限和+-权限)
     * */
    List<UmsPermission> getPermissionList(Long adminId);
}
