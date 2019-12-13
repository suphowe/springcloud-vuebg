package com.vuebg.admin.controller;

import com.vuebg.admin.http.HttpResult;
import com.vuebg.admin.page.PageRequest;
import com.vuebg.admin.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 日志控制器
 * @author suphowe
 * @date 2018-12-12
 */
@RestController
@RequestMapping("log")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @PreAuthorize("hasAuthority('sys:log:view')")
    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLogService.findPage(pageRequest));
    }
}
