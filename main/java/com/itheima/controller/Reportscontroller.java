package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.StudentCountOption;
import com.itheima.pojo.jobOption;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class Reportscontroller {

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result empJobData(){

        log.info("查询员工职位及相关数据统计");
        jobOption joboption=reportService.getjobOption();
        return Result.success(joboption);

    }

    @GetMapping("/empGenderData")
    public Result empGenderData(){
        log.info("查询员工性别相关数据");
        List<Map<String,Object>> genderOption=reportService.getgenderOption();
        return Result.success(genderOption);

    }

    @GetMapping("/studentDegreeData")
    public Result studentDegreeData(){
        log.info("查询学生学历信息");
       List<Map<String,Integer>> data=reportService.getStudentsDegreeData();
        return Result.success(data);
    }

    @GetMapping("/studentCountData")
    public Result studentCountData(){
        log.info("查询班级人数");
       StudentCountOption data= reportService.getstudentCountData();
        return Result.success(data);

    }

}
