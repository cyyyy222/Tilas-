package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpExprMapper {


    //批量保存员工的经历
   //配置xml
    void saveExpr(List<EmpExpr> empExpr);

    @Select("select * from emp_expr where emp_id=#{id}")
    List<EmpExpr> getEmpExpr(Integer id);
}
