package com.itheima.service;

import com.itheima.pojo.*;
import org.springframework.stereotype.Service;

@Service

public interface EmpService {


    //重写page方法，在control中被调用
    PageResult<Emp> page(EmpQueryParam param);


    void save(AddEmp empInfo);

    void delete(Integer[] ids);

    Emp getEmp(Integer id);

    void update(AddEmp empInfo);




    LogInfoData EmpLogIn(LogInfo info);
}
