package com.itheima.mapper;

import com.itheima.pojo.ClassInfo;
import com.itheima.pojo.ClassQueryString;
import com.itheima.pojo.Classlist;
import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static net.sf.jsqlparser.parser.feature.Feature.delete;

@Mapper
public interface ClassMapper {

    List<ClassInfo> list(ClassQueryString param);

    @Delete("delete from clazz where id=#{id}")
    void delete(Integer id);


    @Insert("insert into clazz(name, room,begin_date, end_date,create_time,update_time, master_id,subject)" +
            " values (#{name}, #{room}, #{beginDate},#{endDate},#{createTime},#{updateTime},#{masterId},#{subject})")
    void save(ClassInfo classInfo);

    @Select("select name, room,begin_date beginDate, end_date endDate ,create_time createTime,update_time updateTime, master_id masterId,subject from clazz where id=#{id}")
    Classlist getInfo(Integer id);

    void update(ClassInfo classInfo);

    @Select("select id,name,room,begin_date beginDate,end_date endDate,master_id masterId,subject,create_time createTime," +
            " update_time updateTime from clazz")
    List<Classlist> getAllInfo();
}
