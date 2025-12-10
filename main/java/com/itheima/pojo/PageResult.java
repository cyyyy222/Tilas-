package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//分页结果查询的封装类
@Data
@NoArgsConstructor
@AllArgsConstructor
//这几个注解自动帮忙生成了需要的构造方法类
//响应数据的类型实体类
public class PageResult<T> {
    //将结果rows的类型应该是什么，传递进来，直接传递给列表

    private Long total;//考虑接口文档，总共的记录数
    private List<T> rows;//数据列表，接口文档要求是rows命名的
}
