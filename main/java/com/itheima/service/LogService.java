package com.itheima.service;

import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Params;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
    PageResult<OperateLog> page(Params param);
}
