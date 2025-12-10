package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudent {
    private String name;
    private String no;
    private Integer gender;
    private String phone;
    private Integer degree;
    private Integer clazzId;
    private  String idCard;
    private Integer isCollege;
    private String address;
    private String graduationDate;


}
