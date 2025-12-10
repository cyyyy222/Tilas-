package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.anno.Log;
import com.itheima.mapper.StudentsMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Students;
import com.itheima.pojo.StudentsQureyString;
import com.itheima.service.EmpLogService;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    private StudentsMapper studentsmapper;
    @Autowired
    private EmpLogService empLogService;


    public PageResult<Students> page(StudentsQureyString studentsQureyString){
        PageHelper.startPage(studentsQureyString.getPage(),
                studentsQureyString.getPageSize());
        List<Students> list = studentsmapper.page(studentsQureyString);
        Page<Students> data = (Page<Students>) list;
        return new PageResult<>(data.getTotal(),data.getResult());
    }

    public void delete(Integer id){
        studentsmapper.delete(id);

    }

    public void save(Students students){
        studentsmapper.save(students);

    }

    public Students findById(String id){
        return studentsmapper.findById(id);

    }

    public void update(Students students){

        studentsmapper.update(students);
    }

    @Override
    public void updateViolation(Integer id, Integer score) {
        studentsmapper.updateViolation(id,score);

    }


}
