package com.itheima.service.impl;

import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.pojo.Dept;

import java.time.LocalDateTime;
import java.util.List;
import com.itheima.mapper.DeptMapper;
//在service中调用mapper的方法
//业务层实现类
//接口的实现类
@Service//交给AOC容器管理

public class Deptserviceimpl implements DeptService {


    //调用mapper中的方法，和control同理，mapper已经放入ioc中了，使用依赖注入，创建对象
    @Autowired
    private DeptMapper deptmapper;
    public List<Dept> findAll(){

        return deptmapper.findAll();
    }
    public void deleteById(Integer id){
        deptmapper.deleteById(id);

    }
    public void addNummber(Dept dept){
        //需要补全数据，要求补全时间和id
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptmapper.insert(dept);
    }
    public Dept getInfo(Integer id){
        return deptmapper.getInfo(id);
    }

    public void updateName(Dept dept){
        //补全更新时间
        dept.setUpdateTime(LocalDateTime.now());
        deptmapper.updateName(dept);
    }

}
