package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClassMapper;
import com.itheima.pojo.ClassInfo;
import com.itheima.pojo.ClassQueryString;
import com.itheima.pojo.Classlist;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClassServiceimpl implements ClassService {
    @Autowired
    ClassMapper classMapper;


    @Override
    public PageResult<ClassInfo> page(ClassQueryString param){
        PageHelper.startPage(param.getPage(),param.getPageSize());
        List<ClassInfo> classlist=classMapper.list(param);
        //封装，强制转化成page类型
        Page<ClassInfo> p=(Page<ClassInfo>)classlist;
        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(Integer id) {
        classMapper.delete(id);
    }

    @Override
    public void save(ClassInfo classInfo) {
        classInfo.setCreateTime(LocalDateTime.now());
        classInfo.setUpdateTime(LocalDateTime.now());
        classMapper.save(classInfo);
    }

    @Override
    public Classlist getInfo(Integer id) {
        return classMapper.getInfo(id);
    }

    @Override
    public void update(ClassInfo classInfo) {
        classInfo.setUpdateTime(LocalDateTime.now());
        classMapper.update(classInfo);

    }

    @Override
    public List<Classlist> getAllInfo(){
        return classMapper.getAllInfo();

    }
}
