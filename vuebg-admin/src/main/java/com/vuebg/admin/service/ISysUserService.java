package com.vuebg.admin.service;

import com.vuebg.admin.model.SysUser;
import com.vuebg.admin.model.SysUserRole;

import java.util.List;
import java.util.Set;

/**
 * 用户管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface ISysUserService extends CurdService<SysUser> {

    SysUser findByName(String username);

    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    /**
     * 查找用户的角色集合
     * @param userId
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);

}
