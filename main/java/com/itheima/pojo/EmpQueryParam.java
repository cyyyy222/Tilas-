package com.itheima.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
//员工条件查询参数，实体类，封装起来
public class EmpQueryParam {
    private Integer page;
    private Integer pageSize;
    private String name ;
    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")private LocalDate end;

}
