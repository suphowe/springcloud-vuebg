package com.vuebg.admin.service;

import com.vuebg.admin.model.SysMenu;
import com.vuebg.admin.model.SysRole;
import com.vuebg.admin.model.SysRoleMenu;

import java.util.List;

/**
 * 角色管理
 * @author suphowe
 * @date 2018-12-12
 */
public interface ISysRoleService extends CurdService<SysRole> {

    /**
     * 查询全部
     * @return
     */
    List<SysRole> findAll();

    /**
     * 查询角色菜单集合
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 保存角色菜单
     * @param records
     * @return
     */
    int saveRoleMenus(List<SysRoleMenu> records);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    List<SysRole> findByName(String name);

}
