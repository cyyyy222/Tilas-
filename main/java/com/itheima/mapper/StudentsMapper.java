package com.itheima.mapper;

import com.itheima.pojo.StudentCountOption;
import com.itheima.pojo.Students;
import com.itheima.pojo.StudentsQureyString;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper

public interface StudentsMapper {

    List<Students> page(StudentsQureyString studentsQureyString);

    @Delete("delete  from student where id=#{id}")
    void delete(Integer id);


    void save(Students students);

    @Select("select id, name, no, gender, phone, id_card idCard, " +
            "is_college, address, degree, graduation_date graduationDate" +
            ", clazz_id clazzId, violation_count violationCount," +
            " violation_score violationScore , create_time creatTime, update_time updateTime" +
            " from student where id=#{id}")
    Students findById(String id);

    void update(Students students);

    @Update("update student" +
            " set violation_score = violation_score+#{score}" +
            " where id=#{id}")
    void updateViolation(Integer id, Integer score);

    List<Map<String,Integer>> getStudentsDegreeData();

    List<Map<String,Object>> getstudentCountData();
}
