package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.*;
import com.itheima.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/clazzs")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    @Log
    public Result page(ClassQueryString param){
        log.info("分页查询班级信息：{}",param);
        PageResult<ClassInfo> pageResult = classService.page(param);

        return Result.success(pageResult);
    }

    @DeleteMapping("/{id}")
    @Log
    public Result delete( @PathVariable Integer id) {

        log.info("删除班级信息：{}",id);
        classService.delete(id);
        return Result.success();
    }

    @PostMapping
    @Log
    public Result save(@RequestBody ClassInfo classInfo){
        classService.save(classInfo);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询班级信息：{}",id);
        Classlist info=classService.getInfo(id);
        if(info==null){
            return Result.error("该班级不存在");
        }else {
            return Result.success(info);
        }

    }

    @PutMapping
    @Log
    public Result update(@RequestBody ClassInfo classInfo){
        log.info("修改班级信息：{}",classInfo);
        classService.update(classInfo);

        return Result.success();
    }

    @GetMapping("list")
    @Log
    public Result list(){
        List<Classlist> data=classService.getAllInfo();
        return Result.success(data);
    }
}
