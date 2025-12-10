package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.StudentsMapper;
import com.itheima.pojo.StudentCountOption;
import com.itheima.pojo.jobOption;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceimpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public jobOption getjobOption(){

        List<Map<String,Object>> list=empMapper.getjobOption();
        //分别提取元素并封装
        List<Object> jobList=list.stream().map(dataMap->dataMap.get("pos")).toList();
        List<Object> dataList=list.stream().map(dataMap->dataMap.get("num")).toList();
        return new jobOption(jobList,dataList);

    }

    @Override
    public List<Map<String,Object>> getgenderOption(){
        return empMapper.getgenderOption();
        //分别提取元素并封装
    }
    @Override
    public List<Map<String,Integer>>getStudentsDegreeData(){
        List<Map<String,Integer>>list=studentsMapper.getStudentsDegreeData();
        return list;
    }

    @Override
    public StudentCountOption getstudentCountData(){
        List<Map<String,Object>>data=studentsMapper.getstudentCountData();
        List<String> clazzList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        // 1. 修正 Map 泛型为 <String, Object>
        for (Map<String, Object> map : data) {
            // 2. 直接从 Object 转 String（因为 clazzName 实际是 String）
            String clazzName = (String) map.get("clazzName");
            // 3. 先转 Long，再转 Integer（因为统计数是 Long 类型）
            Integer studentCount = ((Long) map.get("studentCount")).intValue();

            clazzList.add(clazzName);
            dataList.add(studentCount);

        }
        return new StudentCountOption(clazzList,dataList);
    }
}
