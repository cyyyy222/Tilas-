package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassQueryString {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")private LocalDate end;
    private Integer page;
    private Integer pageSize;
}
