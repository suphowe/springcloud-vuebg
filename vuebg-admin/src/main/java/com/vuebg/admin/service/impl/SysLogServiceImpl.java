package com.vuebg.admin.service.impl;

import com.vuebg.admin.dao.SysLogMapper;
import com.vuebg.admin.model.SysLog;
import com.vuebg.admin.page.ColumnFilter;
import com.vuebg.admin.page.MybatisPageHelper;
import com.vuebg.admin.page.PageRequest;
import com.vuebg.admin.page.PageResult;
import com.vuebg.admin.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl  implements ISysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int save(SysLog record) {
        if(record.getId() == null || record.getId() == 0) {
            return sysLogMapper.insertSelective(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        for(SysLog record:records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilter("userName");
        if(columnFilter != null) {
            return MybatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", columnFilter.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, sysLogMapper);
    }

}
