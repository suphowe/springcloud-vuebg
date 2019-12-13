package com.vuebg.admin.service;

import com.vuebg.admin.model.SysDept;

import java.util.List;


/**
 * 机构管理
 * @author suphowe
 * @date 2018-12-12
 */
public interface ISysDeptService extends CurdService<SysDept> {

    /**
     * 查询机构树
     * @param
     * @return
     */
    List<SysDept> findTree();
}
