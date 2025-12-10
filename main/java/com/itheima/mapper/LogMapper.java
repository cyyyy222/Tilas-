package com.itheima.mapper;

import com.itheima.pojo.ClassInfo;
import com.itheima.pojo.OperateLog;
import com.itheima.pojo.Params;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("select id,operate_emp_id operateEmpId,operate_time operateTime ," +
            " class_name className,method_name methodName,method_params methodParams," +
            "return_value returnValue,cost_time costTime from operate_log")
    List<OperateLog> page(Params params);

}
