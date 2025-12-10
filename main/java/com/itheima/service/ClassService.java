package com.itheima.service;

import com.itheima.pojo.ClassInfo;
import com.itheima.pojo.ClassQueryString;
import com.itheima.pojo.Classlist;
import com.itheima.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {
    PageResult<ClassInfo> page(ClassQueryString param);

    void delete(Integer id);

    void save(ClassInfo classInfo);

    Classlist getInfo(Integer id);

    void update(ClassInfo classInfo);

    List<Classlist> getAllInfo();
}
