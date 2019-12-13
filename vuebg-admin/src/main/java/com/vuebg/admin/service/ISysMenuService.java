package com.vuebg.admin.service;

import com.vuebg.admin.model.SysMenu;

import java.util.List;


/**
 * 菜单管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface ISysMenuService extends CurdService<SysMenu> {

	/**
	 * 查询菜单树,用户ID和用户名为空则查询全部
	 * @param userName
	 * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
	 * @return
	 */
	List<SysMenu> findTree(String userName, int menuType);

	/**
	 * 根据用户名查找菜单列表
	 * @param userName
	 * @return
	 */
	List<SysMenu> findByUser(String userName);
}
