package com.coffee.mall_tiny01.dto;

import com.coffee.mall_tiny01.mbg.model.UmsAdmin;
import com.coffee.mall_tiny01.mbg.model.UmsPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


/**
 * SpringSecurity需要的用户详情
 * */
public class AdminUserDetails implements UserDetails {
    private UmsAdmin umsAdmin;
    private List<UmsPermission> permissionsList;

    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsPermission> permissionsList){
        this.umsAdmin = umsAdmin;
        this.permissionsList = permissionsList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
