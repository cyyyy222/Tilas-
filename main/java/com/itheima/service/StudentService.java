package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Students;
import com.itheima.pojo.StudentsQureyString;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {
    PageResult<Students> page(StudentsQureyString studentsQureyString);

    void delete(Integer id);

    void save(Students students);

    Object findById(String id);

    void update(Students students);

    void updateViolation(Integer id, Integer score);


}
