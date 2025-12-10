package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.LogMapper;
import com.itheima.pojo.ClassInfo;
import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Params;
import com.itheima.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class LogServiceimpl  implements LogService {
    @Autowired
    private LogMapper logMapper;

    public PageResult<OperateLog> page(Params params) {
        PageHelper.startPage(params.getPage(),params.getPageSize());
        List<OperateLog> list=logMapper.page(params);
        //封装，强制转化成page类型
        Page<OperateLog> p=(Page<OperateLog>)list;
        return new PageResult<>(p.getTotal(),p.getResult());
    }
}
