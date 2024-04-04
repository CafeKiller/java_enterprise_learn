package com.cafe.killer.cafe_mall.dao;

import com.cafe.killer.cafe_mall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义 dao
 * @author Coffee_Killer
 * */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限
     * */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

}
