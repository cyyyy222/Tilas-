package com.itheima.mapper;

import com.itheima.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    //使用左外连接，查询员工信息的全部
    //json命名规则
   // @Select("select emp.* ,dept.name dept_name from emp left join dept on emp.dept_id=dept.id"+" order by emp.update_time desc")
    //List<Emp> list();

    List<Emp> list(EmpQueryParam param);//参数太多，配置xml同名文件，进行sql查询

    //id被定义成为自增主键，不需要人为设置，就可以直接赋值
    //emp表中的id标识为员工，作为emp_expr表中的外键，需要提取出这个id并赋值给expr的emp_id
    @Options(useGeneratedKeys = true,keyProperty = "id")//自动获取插入数据后的主键,这个key封装到emp的id中
    @Insert("insert into emp(username, name, gender, phone,password, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            " values (#{username}, #{name}, #{gender},#{phone},123456,#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void saveInfo(AddEmp empInfo);


    void deleteInfo(Integer[] ids);

    //根据员工的id删除expr
    void deleteExpr(Integer[] empids);


    @Select("select * from emp where id=#{id}")
    Emp getEmp(Integer id);


    //更新员工的经历
    //配置xml
    void updateEmp(AddEmp empInfo);

    //将结果封装到一个map类型中
    List<Map<String, Object>> getjobOption();

    List<Map<String, Object>> getgenderOption();


    LogInfoData EmpLogIn(LogInfo info);
}
