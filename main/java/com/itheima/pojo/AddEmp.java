package com.itheima.pojo;

import lombok.Data;

import java.util.List;

@Data
public class AddEmp extends Emp{

    private List<EmpExpr> exprList;


}
