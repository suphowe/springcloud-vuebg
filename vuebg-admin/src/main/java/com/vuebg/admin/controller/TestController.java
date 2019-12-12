package com.vuebg.admin.controller;

import com.vuebg.admin.constants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Value("${server.port}")
    public String serverPort;

    @RequestMapping("/findServerPort")
    public String findServerPort() {
        return serverPort;
    }
}
