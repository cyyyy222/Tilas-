package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;
//接口，只需要定义，在实现类中实现就可以
//业务逻辑方面的操作，需要什么->去做什么，比如查询，就调用mapper中有关于查询的方法
public interface DeptService {


    List<Dept> findAll();
    void deleteById(Integer id);
    void addNummber(Dept dept);
    Dept getInfo(Integer id);
    void updateName(Dept dept);
}
