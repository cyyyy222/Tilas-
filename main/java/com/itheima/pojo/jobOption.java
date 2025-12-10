package com.itheima.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//数据分析响应的数据格式
@Data
@AllArgsConstructor
@NoArgsConstructor//使用全参构造
public class jobOption {
    private List jobList;
    private List dataList;

}
