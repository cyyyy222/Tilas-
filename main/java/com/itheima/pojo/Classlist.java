package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor

@AllArgsConstructor
public class Classlist {
    private Integer id;
    private String name;
    private String room;
    private String beginDate;
    private String endDate;
    private Integer masterId;

    private Integer subject;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
