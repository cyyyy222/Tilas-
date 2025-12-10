package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Students;
import com.itheima.pojo.StudentsQureyString;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceimpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    @Log
    public Result page( StudentsQureyString studentsQureyString){

        log.info("分页查询学生信息：{}",studentsQureyString);
        PageResult<Students> data=studentService.page(studentsQureyString);
        return Result.success(data);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable String id){
        return Result.success(studentService.findById(id));
    }

    @DeleteMapping("/{id}")
    @Log
    public Result delete(@PathVariable Integer id){
        log.info("删除学员：{}",id);
        studentService.delete(id);
        return Result.success();
    }

    @PostMapping
    @Log
    public Result save(@RequestBody Students students){
        studentService.save(students);
        return Result.success();
    }

    @PutMapping
    @Log
    public Result update(@RequestBody Students students){
        studentService.update(students);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    @Log
    public Result updateViolation(@PathVariable Integer id,@PathVariable Integer score){
        studentService.updateViolation(id,score);
        return Result.success();

    }

}
