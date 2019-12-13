package com.vuebg.admin.service;

import com.vuebg.admin.model.SysDict;

import java.util.List;

/**
 * 字典管理
 * @author suphowe
 * @date 2018-12-12
 */
public interface ISysDictService extends CurdService<SysDict> {

    /**
     * 根据名称查询
     * @param lable
     * @return
     */
    List<SysDict> findByLable(String lable);
}
