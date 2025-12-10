package com.itheima.controller;

import com.itheima.pojo.LogInfo;
import com.itheima.pojo.LogInfoData;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class EmpLogInController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result emoLogIn(@RequestBody LogInfo info){
        log.info("尝试登陆",info);
        LogInfoData data=empService.EmpLogIn(info);
        if(data==null){
            return Result.error("用户名或密码错误");
        }
        else
            return Result.success(data);
    }

}
