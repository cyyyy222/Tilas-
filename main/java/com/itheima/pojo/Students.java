package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    private Integer id;
    private String name;
    private String no;
    private Integer gender;
    private String phone;
    private Integer degree;
    private String idCard;
    private Integer isCollege;
    private String address;
    private String graduationDate;
    private Integer violationCount;
    private Integer violationScore;
    private Integer clazzId;
    private String createTime;
    private String updateTime;
    private String clazzName;
}
