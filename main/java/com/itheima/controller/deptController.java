package com.itheima.controller;
//查收请求，调用，返回result
import com.itheima.anno.Log;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.itheima.pojo.Result;
import com.itheima.pojo.Dept;
import java.util.List;

//请求处理类
@RestController
//response body 将返回值直接相应给前端
public class deptController {

    public static final Logger log= LoggerFactory.getLogger(deptController.class);
    //定义一个日志记录器 格式是固定的，只需要替换需要记录的是哪一类的东西


    //让 Spring 自动帮你创建 DeptService 实例并赋值给变量，不用手动 new 对象，依赖注入的方法
    @Autowired
    private DeptService deptService;
    //后续可以直接调用deptservice对象中的方法

    @GetMapping("/depts")
    @Log
    //处理的请求的，路径，符合才可以调用,接口文档中会体现，当前处理查询全部且倒
    public Result list(){
        log.info("查询全部部门数据");
        //日志使用方法
        //调用service 全都交给IOC管理了，注入一个service就可以了
        //list的结构是dept
        List<Dept> deptlist=deptService.findAll();//创建一个集合对象，将查询的返回结果传递到deptlist中，然后返回就可以
        return Result.success(deptlist);

    }

    @DeleteMapping("/depts")
    @Log
    //根据spring提供的requestparam注解，直接转化成int类型的值，必须传递参数（如果默认required参数为true
    //也可以直接Integer id 直接转化就可以，要求参数名必须一致（路径中传入的时候）
    public Result delete(Integer id){

        log.info("删除id号为：{}的部门",id);
        //占位符
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping("/depts")
    @Log
    //参数在请求体中完成
    public Result addNummber(@RequestBody Dept dept){
        deptService.addNummber(dept);
       log.info("添加成功");
        return Result.success();
    }

    //查询回显
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer id){
        log.info("查询id为{}部门",id);
        Dept info=deptService.getInfo(id);
       log.info("查询成功！");
        return Result.success(info);
    }

    //修改部门
    @PutMapping("/depts")
    @Log
    public Result updateName(@RequestBody Dept dept){
        deptService.updateName(dept);
       log.info("修改成功！");
        return Result.success();
    }

}
