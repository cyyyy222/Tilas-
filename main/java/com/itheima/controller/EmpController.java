package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.*;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    @Log
    public Result page(EmpQueryParam param) {
        log.info("分页查询，{}", param);
        //调用ser 层的方法进行查询，之后将结果封装到pageresult里，返回，里面包括
        //emp信息和对应的total
        PageResult<Emp> pageResult = empService.page(param);
        return Result.success(pageResult);

    }

    //新增操作
    @PostMapping
    @Log
    public Result save(@RequestBody AddEmp empInfo) {

        log.info("新增员工：{}", empInfo);
        empService.save(empInfo);
        return Result.success();
    }

    @DeleteMapping
    @Log
    public Result delete(@RequestParam Integer[] ids) {
        log.info("删除员工，id：{}",ids);
        empService.delete(ids);
        return Result.success();

    }

    @GetMapping("/{id}")
    public Result getEmp( @PathVariable Integer id) {

        log.info("查询员工，id号为{}",id);
        AddEmp empInfo= (AddEmp) empService.getEmp(id);
        return Result.success(empInfo);
    }

    @PutMapping
    @Log
    //json格式的数据如果想要封装到对应的实例中，需要加上注解
    public Result update(@RequestBody AddEmp empInfo) {
        log.info("修改员工{}",empInfo.getName());
        empService.update(empInfo);
        return Result.success();
    }
}

