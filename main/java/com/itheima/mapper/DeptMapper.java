package com.itheima.mapper;
//负责数据访问操作，对sql语句进行使用
import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    //查询所有的部门数据
    //mybaits框架根据注解语句进行sql操作，将结果直接返回到方法中
    //还可以在xml文件中配置select
    @Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc;")
    List<Dept> findAll();

    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Select("select id, name, create_time createTime, update_time updateTime from dept where id=#{id}")
    Dept getInfo(Integer id);

    @Update("update dept Set name=#{name},update_time=#{updateTime} where id=#{id}")
    void updateName(Dept dept);
}
