package com.itheima.service;

import com.itheima.pojo.StudentCountOption;
import com.itheima.pojo.jobOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReportService {


    public jobOption getjobOption();

    public List<Map<String,Object>> getgenderOption();

    List<Map<String,Integer>> getStudentsDegreeData();


    StudentCountOption getstudentCountData();
}
